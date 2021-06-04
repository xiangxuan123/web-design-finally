package com.example.design.service;

import com.example.design.entity.Lab;
import com.example.design.mapper.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
    @CacheEvict(value = "allLab",allEntries = true)
    public void insert(Lab lab){
        labMapper.insert(lab);
    }

    @Cacheable(value = "allLab")
    public List<Lab> getAllLab(){
        return labMapper.getAllLab();
    }
    @CacheEvict(value = "allLab",allEntries = true)
    public void deleteLab(String labID){
        labMapper.deleteLab(labID);
    }
    public Lab getLab(String labID){
        return labMapper.getLabById(labID);
    }
    @CacheEvict(value = "allLab",allEntries = true)
    public void updateLab(int number,String detail,String labID){
        labMapper.updateLab(number,detail,labID);
    }
}
