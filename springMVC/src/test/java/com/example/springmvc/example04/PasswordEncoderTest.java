package com.example.springmvc.example04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
public class PasswordEncoderTest {
    @Test
    public void test_password(){
        PasswordEncoder p = new BCryptPasswordEncoder();
        String pwd = "123456";
        log.debug(p.encode(pwd));
        log.debug(p.encode(pwd));
        String result = p.encode(pwd);
        log.debug("{}",p.matches("123456",result));
        log.debug("{}",p.matches("123457",result));
    }
}
