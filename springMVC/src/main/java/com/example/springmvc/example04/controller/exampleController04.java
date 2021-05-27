package com.example.springmvc.example04.controller;

import com.example.springmvc.example04.entity.User04;
import com.example.springmvc.example04.service.UserService04;
import com.example.springmvc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/example04/")
public class exampleController04 {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService04 userService;
    @PostMapping("login")
    public ResultVO login(@RequestBody User04 user){
        User04 u = userService.getUser(user.getUsername());
        if(u==null || !passwordEncoder.matches(user.getPassword(), u.getPassword())){
            log.debug("登录失败");
            return ResultVO.error(401,"用户名密码错误");
        }
        log.debug("登陆成功");
        return ResultVO.success(Map.of("user",user));
    }
}
