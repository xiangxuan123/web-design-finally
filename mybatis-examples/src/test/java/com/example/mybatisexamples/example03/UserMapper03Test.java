package com.example.mybatisexamples.example03;

import com.example.mybatisexamples.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class UserMapper03Test {
    @Autowired
    private UserMapper03 userMapper03;

    @Test
    public void listByDetail_test(){
        List<User> users = userMapper03.listByDetail("211");
        for (User user : users) {
            log.debug("{}/{}/{}",user.getId(),user.getName(),user.getCreateTime());
        }
    }
}
