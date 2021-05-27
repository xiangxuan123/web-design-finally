package com.example.springexamples.example02.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AOPService {
    public void get(){
        log.debug("AOPService.get()");
    }
}
