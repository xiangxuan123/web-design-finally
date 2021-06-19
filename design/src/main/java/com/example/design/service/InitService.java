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
    }
}
