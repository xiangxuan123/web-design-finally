package com.example.springbootmybatis.example01;

import com.example.springbootmybatis.enity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class UserMapper01Test {
    @Autowired
    private UserMapper01 userMapper01;

    @Test
    public void addUser_test() {
        User user = new User();
        user.setId(3L);
        user.setName("BO");
        user.setCompany("facebook");
        userMapper01.insert(user);
    }
}