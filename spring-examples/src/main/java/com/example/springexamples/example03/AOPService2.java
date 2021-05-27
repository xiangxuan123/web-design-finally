package com.example.springexamples.example03;

import org.springframework.stereotype.Service;

@Service
public class AOPService2 {
    public String welcome(String name){
        return "welcome "+name;
    }
    public String getNumber(String num){
        return num;
    }
}
