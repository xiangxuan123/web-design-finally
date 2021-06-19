package com.example.designgateway.controller;

import com.example.designgateway.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/")
public class MyController {

    @Bean
    @LoadBalanced
    public RestTemplate getRest(){
        return new RestTemplate();
    }
    @GetMapping("user")
    public User getUser(){
        return new User(1L,"BO");
    }
}
