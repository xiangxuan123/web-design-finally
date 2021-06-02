package com.example.design.service;

import com.example.design.entity.User;
import com.example.design.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(String number){
        return userMapper.getByUserName(number);
    }

    public void insertUser(User user){
        userMapper.insert(user);
    }

    public void delete(long uid){
        userMapper.delete(uid);
    }
    public List<User> selectAll(){
        return userMapper.selectAll();
    }
    public void setPassword(String password,long uid){
        userMapper.setPassword(password,uid);
    }
    public User getUserByID(long uid){
        return userMapper.selectById(uid);
    }
}
