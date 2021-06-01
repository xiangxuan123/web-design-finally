package com.example.design.service;

import com.example.design.entity.Lab;
import com.example.design.mapper.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LabService {
    @Autowired
    private LabMapper labMapper;
    public List<Lab> getLabByNumber(long number){
        return labMapper.getLab(number);
    }
}
