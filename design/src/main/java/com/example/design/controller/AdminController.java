package com.example.design.controller;

import com.example.design.VO.ResultVO;
import com.example.design.entity.User;
import com.example.design.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
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
        List<User> users = userService.selectAll();
        log.debug(users.toString());
        return ResultVO.success(Map.of("teachers",userService.selectAll()));
    }

    @PostMapping("delete")
    public ResultVO delete(@RequestBody long uid){
        userService.delete(uid);
        return ResultVO.success(Map.of("msg","删除成功"));
    }
}
