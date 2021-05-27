package com.example.mybatisexamples.example02;

import com.example.mybatisexamples.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class UserMapper02Test {
    @Autowired
    private  UserMapper02 userMapper02;

    @Test
    public void addUser_test(){
        User user = new User();
        user.setName("XX");
        user.setCompany("AAA");
        userMapper02.insert(user);
    }

    @Test
    public void list_test(){
        List<User> users = userMapper02.selectByMap(Map.of("company","AAA"));
        for (User user : users) {
            log.debug(user.getName());
        }
    }
}
