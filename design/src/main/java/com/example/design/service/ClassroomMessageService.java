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
}
