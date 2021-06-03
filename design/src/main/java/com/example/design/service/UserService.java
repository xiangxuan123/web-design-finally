package com.example.design.service;

import com.example.design.entity.User;
import com.example.design.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
    @Cacheable(value = "user",key = "#uid")
    public void UserCache(long uid){}

    @CacheEvict(value= "users",allEntries = true)
    public void insertUser(User user){
        userMapper.insert(user);
    }

    @Caching(evict = {
            @CacheEvict(value = "users",allEntries = true),
            @CacheEvict(value = "user",key = "#uid")
    })
    public void delete(long uid){
        userMapper.delete(uid);
    }
    @Cacheable(value = "users")
    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    @CacheEvict(value = "user",key = "#uid")
    public void setPassword(String password,long uid){
        userMapper.setPassword(password,uid);
    }
    @Cacheable(value = "user",key = "#uid")
    public User getUserByID(long uid){
        return userMapper.selectById(uid);
    }
}
