package com.example.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.design.entity.ClassroomMessage;
import org.apache.ibatis.annotations.Delete;
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
    @Delete("delete from classroomMessage where id = #{labid}")
    void deleteMessageByLabID(@Param("labid")String labid);
    @Delete("delete from classroomMessage where message_id = #{mid}")
    void deleteMessageByID(@Param("mid")long mid);
    @Select("select * from classroomMessage where teacher_id = #{uid}")
    List<ClassroomMessage> getMessageByTeacher(@Param("uid") long uid);
    @Delete("delete from classroomMessage where teacher_id = #{uid}")
    void deleteMessageByTeacher(@Param("uid")long uid);
}
