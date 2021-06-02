package com.example.design.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.design.entity.Course;
import com.example.design.entity.Lab;
import com.example.design.entity.User;
import com.example.design.mapper.CourseMapper;
import com.example.design.mapper.LabMapper;
import com.example.design.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class InitService implements InitializingBean {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LabMapper labMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        // id字段必然存在，数量为0表示用户名表为空。
        // 初始化管理员用户，赋权限值
        int count = userMapper.selectCount(new QueryWrapper<User>().select("id"));
        if (count == 0) {
            User user = User.builder()
                    .name("admin")
                    .userName("admin")
                    .password(encoder.encode("admin"))
                    .role(9)
                    .build();
            userMapper.insert(user);
        }
        //初始化实验室
        count = labMapper.selectCount(new QueryWrapper<Lab>().select("number"));
        if(count == 0){
            Lab lab = Lab.builder()
                    .id("901")
                    .number(50)
                    .build();
            Lab lab1 = Lab.builder()
                    .id("902")
                    .number(20)
                    .build();
            labMapper.insert(lab);
            labMapper.insert(lab1);
        }
        //初始化教师和课程
        count = userMapper.selectCount(new QueryWrapper<User>().select("id"));
        if (count == 1) {
            User user = User.builder()
                    .name("BO")
                    .userName("BO")
                    .password(encoder.encode("BO"))
                    .role(5)
                    .build();
            userMapper.insert(user);
        }
        count = courseMapper.selectCount(new QueryWrapper<Course>().select("id"));
        if(count == 0 ){
            Course course = Course.builder()
                    .courseName("WEB")
                    .period(32)
                    .start(1)
                    .end(10)
                    .teacherName("BO")
                    .build();
            Course course1 = Course.builder()
                    .courseName("JAVA")
                    .period(48)
                    .start(5)
                    .end(15)
                    .teacherName("BO")
                    .build();
            courseMapper.insert(course);
            courseMapper.insert(course1);
        }
    }
}
