package com.example.mybatisexamples.example05;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisexamples.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper05 extends BaseMapper<User> {
    UserDTO05 getByXML2(long id);
}
