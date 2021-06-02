package com.example.design.service;

import com.example.design.DTO.UserDTO;
import com.example.design.entity.Course;
import com.example.design.entity.User;
import com.example.design.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public void insertCourse(Course course1){
        courseMapper.insert(course1);
    }

    public UserDTO getCourses(long uid){
        return courseMapper.getCourses(uid);
    }
    public List<Course> getCourseByUid(long uid){
        return courseMapper.getCourseByUid(uid);
    }

    public void delete(long cid){
        courseMapper.delete(cid);
    }
    public void update(long cid,Course course){
        courseMapper.delete(cid);
        courseMapper.insert(course);
    }
}
