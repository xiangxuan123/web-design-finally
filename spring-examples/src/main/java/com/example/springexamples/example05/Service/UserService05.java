package com.example.springexamples.example05.Service;

import com.example.springexamples.example05.Mapper.UserMapper05;
import com.example.springexamples.example05.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Transactional
public class UserService05 {
    @Autowired
    private UserMapper05 userMapper05;
    public void addUser(User user){
        userMapper05.insert(user);
        try {
            Files.readString(Path.of("A/aa.aa"));
        } catch (IOException e){
            throw new RuntimeException("操作错误");
        }
    }
}
