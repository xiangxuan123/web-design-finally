package com.example.springmvc.example02.controller;

import com.example.springmvc.example02.entity.User;
import com.example.springmvc.example02.service.UserService02;
import com.example.springmvc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example02/")
public class exampleController02 {
    @Autowired
    private UserService02 userService02;

    @GetMapping("exception")
    public void getException() {
        userService02.readFile();
    }


    @PostMapping("login")
    public ResultVO login(@RequestBody User user){
        if(!("BO".equals(user.getUserName()))&&"123456".equals(user.getPassword())){
            return ResultVO.error(401,"密码错误");
        }
        return ResultVO.success(Map.of("User",user));
    }
}
