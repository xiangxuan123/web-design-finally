package com.example.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.design.entity.ClassroomMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassroomMessageMapper extends BaseMapper<ClassroomMessage> {
    @Select("select * from classroomMessage where id = #{labid}")
    List<ClassroomMessage> getMessage(@Param("labid") String labid);
}
