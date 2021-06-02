package com.example.design.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.design.entity.Lab;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LabMapper extends BaseMapper<Lab> {
    default List<Lab> getLab(long number){
        return selectList(new LambdaQueryWrapper<Lab>()
                .ge(Lab::getNumber,number));
    };
    @Select("select * from lab")
    List<Lab> getAllLab();
    @Delete("delete from lab where id = #{lab}")
    void deleteLab(@Param("lab")String lab);
    @Update("update lab set number = #{number},detail = #{detail} where id=#{labID}")
    void updateLab(@Param("number") int number,@Param("detail") String detail,@Param("labID") String labID);
}
