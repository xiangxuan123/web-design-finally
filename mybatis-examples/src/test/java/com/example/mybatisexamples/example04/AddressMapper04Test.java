package com.example.mybatisexamples.example04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class AddressMapper04Test {
    @Autowired
    private AddressMapper04 addressMapper04;

    @Test
    public void list_test(){
        for (AddressDTO04 a : addressMapper04.list("1201")) {
            log.debug("{}",a);
        }
    }
}
