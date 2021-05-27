package com.example.springmvc.example04.service;

import com.example.springmvc.example04.entity.User04;
import org.springframework.stereotype.Service;

@Service
public class UserService04 {
    public User04 getUser(String userName){
        return "BO".equals(userName)
                ?User04.builder()
                .username("BO")
                .password("$2a$10$vbic.eN8nCmnzExjVIUUwOKsIAz0.NGEYC/IGwjWJHSCC8s37Kn9G")
                .build()
                : null;
    }
}
