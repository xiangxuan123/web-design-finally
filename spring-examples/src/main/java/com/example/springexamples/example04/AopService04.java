package com.example.springexamples.example04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@MyAuthority
public class AopService04 {
    public void getUser(){
        log.debug("普通用户权限");
    }
    @MyAuthority(value = MyAuthority.MyAuthorityType.ADMIN)
    public void getAdmin(){
        log.debug("管理员权限");
    }

}
