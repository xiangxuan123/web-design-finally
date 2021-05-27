package com.example.springmvc.example08;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
public class JWTTest {
    @Autowired
    private JWTComponent jwtComponent;

    @Test
    public void test() throws InterruptedException {
        String token = jwtComponent.encode(Map.of("uid",1345L,"role",9));
        log.debug(token);
        log.debug("{}",token.length());
        long uid = jwtComponent.decode(token).getClaim("uid").asLong();
        log.debug("{}",uid);

        Thread.sleep(11000);
        long uid2 = jwtComponent.decode(token).getClaim("uid").asLong();
        log.debug("{}",uid2);
    }
}
