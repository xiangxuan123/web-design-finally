package com.example.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.design.DTO.UserDTO;
import com.example.design.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    UserDTO getCourses(long uid);
    @Delete("delete from course where id=#{cid}")
    void delete(@Param("cid") long cid);
    @Select("select * from course where teacher_id=#{uid}")
    List<Course> getCourseByUid(@Param("uid") long uid);
}
