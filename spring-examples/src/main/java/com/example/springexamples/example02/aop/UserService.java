package com.example.springexamples.example02.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    public void buyCar(){
        System.out.println("buyCar()");
    }

    @MyInterceptor(value = MyInterceptor.MyAuthorityType.ADMIN)
    public void addUser(){
    }
    public void getUser(){
    }
}
