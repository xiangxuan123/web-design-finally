package com.example.design.controller;

import com.example.design.VO.ResultVO;
import com.example.design.entity.Lab;
import com.example.design.entity.User;
import com.example.design.service.ClassroomMessageService;
import com.example.design.service.LabService;
import com.example.design.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "处理超管操作请求", tags = {"管理员操作"})
@Slf4j
@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;
    @Autowired
    private LabService labService;
    @Autowired
    private ClassroomMessageService classroomMessageService;

    @ApiOperation(value = "添加用户")
    @PostMapping("add")
    public ResultVO addUser(User user){
        User u = User.builder()
                .name(user.getName())
                .password(encoder.encode(user.getPassword()))
                .userName(user.getUserName())
                .role(5)
                . build();
        userService.insertUser(u);
        return ResultVO.success(Map.of("teachers",userService.selectAll()));
    }

    @ApiOperation(value = "查询所有用户")
    @GetMapping("getUsers")
    public ResultVO getAllUser(){
        return ResultVO.success(Map.of("teachers",userService.selectAll()));
    }

    @ApiOperation(value = "基于id删除用户")
    @DeleteMapping("delete/{uid}")
    public ResultVO delete(@PathVariable long uid){
        User user = userService.getUserByID(uid);
        if(user == null){
            return ResultVO.error(400,"该用户不存在");
        }
        userService.delete(uid);
        return ResultVO.success(Map.of("teachers",userService.selectAll()));
    }

    //lab
    @ApiOperation(value = "添加实验室")
    @PostMapping("insertLab")
    public ResultVO insertLab(@RequestBody Lab lab){
        labService.insert(lab);
        return ResultVO.success(Map.of("labs",labService.getAllLab()));
    }

    @ApiOperation(value = "查询所有实验室")
    @GetMapping("allLab")
    public ResultVO getAllLab(){
        return  ResultVO.success(Map.of("lab",labService.getAllLab()));
    }

    @ApiOperation(value = "基于实验室id删除实验室")
    @DeleteMapping("deleteLab/{labID}")
    public ResultVO deleteLab(@PathVariable String labID){
        Lab lab = labService.getLab(labID);
        if(lab == null || lab.getId()!=labID){
            return ResultVO.error(400,"该实验室不存在");
        }
        labService.deleteLab(labID);
        return ResultVO.success(Map.of("msg","删除成功"));
    }
//    @PostMapping("updateLab")
//    public ResultVO updateLab(@RequestBody Lab lab){
//        labService.updateLab(lab.getNumber(),lab.getDetail(),lab.getId());
//        return ResultVO.success(Map.of("msg","更新成功"));
//    }
}
