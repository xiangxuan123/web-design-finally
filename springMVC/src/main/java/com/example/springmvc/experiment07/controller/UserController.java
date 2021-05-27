package com.example.springmvc.experiment07.controller;


import com.example.springmvc.experiment07.DTO.User;
import com.example.springmvc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/experiment07/")
public class UserController {

    @GetMapping("users")
    public ResultVO getUser(){
        return ResultVO.success(Map.of("User",USER));
    }
    @GetMapping("users/{uid}")
    public ResultVO getUser1(@PathVariable String uid){
        User user = USER.stream()
                .filter(u->u.getId().equals(uid))
                .findFirst()
                .orElse(null);
        if(user!=null)return ResultVO.success(Map.of("User",user));
        else return ResultVO.error(400,"用户不存在");
    }

    @PostMapping("users1")
    public ResultVO addUser(@RequestBody User user){
        USER.add(user);
        return ResultVO.success(Map.of("User",user));
    }

    private List<User> USER=create();

    private List<User> create(){
        User user1 = new User("123456","psw1");
        User user2 = new User("999999","password2");
        return List.of(user1,user2);
    }
}
