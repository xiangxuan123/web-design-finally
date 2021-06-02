package com.example.design.service;

import com.example.design.entity.ClassroomMessage;
import com.example.design.mapper.ClassroomMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassroomMessageService {
    @Autowired
    private ClassroomMessageMapper classroomMessageMapper;

    public List<ClassroomMessage> getMessageById(String id){
        return classroomMessageMapper.getMessage(id);
    }

    public void insert(ClassroomMessage message){
        classroomMessageMapper.insert(message);
    }
//    //删除实验室取消实验室所有预约
//    public void deleteMessageByLabID(String id){
//        classroomMessageMapper.deleteMessageByLabID(id);
//    }
    //teacher取消预约
    public void deleteMessageByMID(long mid){
        classroomMessageMapper.deleteMessageByID(mid);
    }

    public List<ClassroomMessage> getMessageByTeacher(long uid){
        return classroomMessageMapper.getMessageByTeacher(uid);
    }
}
