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
    public void insert(Lab lab){
        labMapper.insert(lab);
    }
    public List<Lab> getAllLab(){
        return labMapper.getAllLab();
    }
    public void deleteLab(String labID){
        labMapper.deleteLab(labID);
    }
    public void updateLab(int number,String detail,String labID){
        labMapper.updateLab(number,detail,labID);
    }
}
