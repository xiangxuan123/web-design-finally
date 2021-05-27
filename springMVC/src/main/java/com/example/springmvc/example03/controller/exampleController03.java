package com.example.springmvc.example03.controller;

import com.example.springmvc.example03.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Slf4j
@RestController
@RequestMapping("/api/example03/")
@Validated
public class exampleController03 {
    @PostMapping("users")
    public void postUser(@Valid @RequestBody User user){
    }
    @GetMapping("users/{uid}/file")
    public void get(@PathVariable int uid){
    }
    @GetMapping("/users/{owner}")
    public void getViolationException(
            @Size(min = 2,max = 6,message = "用户信息错误")
            @PathVariable String owner){
    }
}
