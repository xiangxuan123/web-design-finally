package com.example.design.controller;

import com.example.design.entity.User;
import com.example.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public void addUser(User user){
        User u = User.builder()
                .name(user.getName())
                .password(user.getPassword())
                .userName(user.getUserName())
                .role(5)
                . build();
        userService.insertUser(u);
    }
}
