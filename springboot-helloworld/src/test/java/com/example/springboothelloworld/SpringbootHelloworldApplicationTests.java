package com.example.springboothelloworld;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootHelloworldApplicationTests {
    Logger logger = LoggerFactory.getLogger(SpringbootHelloworldApplicationTests.class);
    @Test
    void contextLoads() {
        logger.debug("slf4j");
        logger.debug(logger.getClass().getName());
    }

}
