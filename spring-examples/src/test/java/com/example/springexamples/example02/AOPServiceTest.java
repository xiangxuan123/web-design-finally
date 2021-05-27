package com.example.springexamples.example02;

import com.example.springexamples.example02.aop.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AOPServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void getTest(){
        userService.buyCar();
        userService.addUser();
    }
}
