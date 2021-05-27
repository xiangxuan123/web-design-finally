package com.example.springexamples.example05;

import com.example.springexamples.example05.Mapper.UserMapper05;
import com.example.springexamples.example05.Service.UserService05;
import com.example.springexamples.example05.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserMapper05Test {
    @Autowired
    private UserService05 userService05;

    @Test
    public void test(){
        User u = User.builder().id(79L).name("SUN").build();
        userService05.addUser(u);
    }
}
