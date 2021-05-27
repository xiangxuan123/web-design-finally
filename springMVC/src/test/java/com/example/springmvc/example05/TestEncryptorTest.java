package com.example.springmvc.example05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class TestEncryptorTest {
    @Autowired
    private EncryptComponent05 encrypt;
    @Test
    public void test_encrypt(){
        Map<String,Object> map = Map.of("uid",1326L,"role",9);
        String r = encrypt.encrypt(map);
        log.debug(r);
        log.debug("{}",r.length());
        log.debug(encrypt.encrypt(map));
    }
    @Test
    public void test_decrypt(){
        String auth = "dc38163d12e46e395ba20b2ea252353502fd9cd192d9ad7b9b6dc905653062c33e8d0818f277bc5454767454e2509e3d";
        Map<String,Object> token = encrypt.decrypt(auth);
        log.debug("{}",token.get("uid"));
        log.debug("{}",token.get("role"));
    }
}
