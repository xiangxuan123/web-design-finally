package com.example.springexamples.example01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ScopeTest {
    @Autowired
    private PrototypeBean prototypeBean;
    @Autowired
    private SingletonBean singletonBean;
    @Test
    public void Test(){
        log.debug("prototype in test: {}",prototypeBean);
        log.debug("singleton in test: {}",singletonBean);
        prototypeBean.getSingle();
        singletonBean.getProto();
    }
}
