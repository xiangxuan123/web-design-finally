package com.example.design.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.design.entity.Lab;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LabMapper extends BaseMapper<Lab> {
    default List<Lab> getLab(long number){
        return selectList(new LambdaQueryWrapper<Lab>()
                .ge(Lab::getNumber,number));
    };
}
