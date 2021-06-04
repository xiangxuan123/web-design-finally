package com.example.design.service;

import com.example.design.entity.ClassroomMessage;
import com.example.design.mapper.ClassroomMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassroomMessageService {
    @Autowired
    private ClassroomMessageMapper classroomMessageMapper;

    @Cacheable(value = "labIdMessage", key = "#id")
    public List<ClassroomMessage> getMessageById(String id){
        return classroomMessageMapper.getMessage(id);
    }

    @Caching(evict = {
            @CacheEvict(value = "labIdMessage",key = "#message.id"),
            @CacheEvict(value = "uidMessage",key = "#message.teacherId")
    })
    public void insert(ClassroomMessage message){
        classroomMessageMapper.insert(message);
    }
//    //删除实验室取消实验室所有预约
//    public void deleteMessageByLabID(String id){
//        classroomMessageMapper.deleteMessageByLabID(id);
//    }

    //teacher取消预约
    @Caching(evict = {
            @CacheEvict(value = "uidMessage",key = "#uid"),
            @CacheEvict(value = "labIdMessage",allEntries = true)
    })
    public void deleteMessageByMID(long mid,long uid){
        classroomMessageMapper.deleteMessageByID(mid);
    }
    @CacheEvict(value = "labIdMessage",key = "#labID")
    public void deleteMessageByLabID(String labID){
        classroomMessageMapper.deleteMessageByLabID(labID);
    }
    @Caching(evict = {
            @CacheEvict(value = "uidMessage",key = "#uid"),
            @CacheEvict(value = "labIdMessage",allEntries = true)
    })
    public void deleteMessageByTeacher(long uid){
        classroomMessageMapper.deleteMessageByTeacher(uid);
    }

    @Cacheable(value = "uidMessage", key = "#uid")
    public List<ClassroomMessage> getMessageByTeacher(long uid){
        return classroomMessageMapper.getMessageByTeacher(uid);
    }

    public ClassroomMessage getMessageByMid(long mid){
        return classroomMessageMapper.getMessageByMId(mid);
    }
    public List<ClassroomMessage> getFilterMessage(ClassroomMessage message){
        return classroomMessageMapper.getContradictMessage(message);
    }
}
