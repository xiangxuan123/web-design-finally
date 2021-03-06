package com.example.design.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.design.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    default User getByUserName(String userName){
        return selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName,userName));
    }
    @Delete("delete from user where id=#{uid}")
    void delete(@Param("uid") long uid);

    @Select("select * from user where role!=9")
    List<User> selectAll();
    @Update("update user set password=#{password} where id=#{uid}")
    void setPassword(@Param("password") String password,@Param("uid")long uid);
    @Select("select * from user where id = #{uid}")
    User getUserById(@Param("uid") long uid);
    @Update("update user set password=#{password},user_name=#{userName},name=#{name},detail=#{detail},graduation_school=#{school},title=#{title} where id=#{uid}")
    void updateUser(@Param("password") String password,@Param("userName")String userName,@Param("name") String name,@Param("detail") String detail,@Param("school") String school,@Param("title") String title,@Param("uid") long uid);
}
