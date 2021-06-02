package com.example.design;

import com.example.design.service.CourseService;
import com.example.design.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CourseTest {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;


    @Test
    public void getUser(){
        userService.selectAll().forEach(
                user -> System.out.println(user.getUserName())
        );
    }
}
