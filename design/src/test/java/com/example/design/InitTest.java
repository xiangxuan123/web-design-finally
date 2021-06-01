package com.example.design;

import com.example.design.common.EncryptComponent;
import com.example.design.controller.LoginController;
import com.example.design.entity.User;
import com.example.design.service.InitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class InitTest {
    @Autowired
    private InitService initService;
    @Autowired
    private PasswordEncoder encoder;
    @Test
    public void initTest() throws Exception {
        initService.afterPropertiesSet();
    }

}
