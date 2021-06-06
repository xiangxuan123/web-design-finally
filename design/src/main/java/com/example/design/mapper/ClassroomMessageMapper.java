package com.example.design.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    @Select("select * from classroom_message where lab_id = #{labid}")
    List<ClassroomMessage> getMessage(@Param("labid") String labid);
    @Delete("delete from classroom_message where lab_id = #{labid}")
    void deleteMessageByLabID(@Param("labid")String labid);
    @Delete("delete from classroom_message where id = #{mid}")
    void deleteMessageByID(@Param("mid")long mid);
    @Select("select * from classroom_message where teacher_id = #{uid}")
    List<ClassroomMessage> getMessageByTeacher(@Param("uid") long uid);
    @Delete("delete from classroom_message where teacher_id = #{uid}")
    void deleteMessageByTeacher(@Param("uid")long uid);
    @Select("select * from classroom_message where id=#{mid}")
    ClassroomMessage getMessageByMId(@Param("mid")long mid);
    default List<ClassroomMessage> getContradictMessage(ClassroomMessage message){
        return selectList(new LambdaQueryWrapper<ClassroomMessage>()
                .eq(ClassroomMessage::getLesson,message.getLesson())
                .ge(ClassroomMessage::getStart,message.getStart())
                .le(ClassroomMessage::getEnd,message.getEnd())
        );
    }
}
