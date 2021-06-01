package com.example.design.controller;

import com.example.design.VO.ResultVO;
import com.example.design.entity.User;
import com.example.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public ResultVO addUser(User user){
        User u = User.builder()
                .name(user.getName())
                .password(user.getPassword())
                .userName(user.getUserName())
                .role(5)
                . build();
        userService.insertUser(u);
        return ResultVO.success(Map.of("msg","插入成功"));
    }

    @GetMapping("getUsers")
    public ResultVO getAllUser(){
        return ResultVO.success(Map.of("teachers",userService.selectAll()));
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody long uid){
        userService.delete(uid);
        return ResultVO.success(Map.of("msg","删除成功"));
    }
}
