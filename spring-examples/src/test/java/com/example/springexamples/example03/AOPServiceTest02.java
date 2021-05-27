package com.example.springexamples.example03;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AOPServiceTest02 {
    @Autowired
    private AOPService2 aopService2;
    @Test
    public void test(){
        log.debug(aopService2.welcome("XX"));
        log.debug(aopService2.getNumber("100"));
    }
}
