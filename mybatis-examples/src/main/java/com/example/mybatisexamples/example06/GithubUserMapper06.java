package com.example.mybatisexamples.example06;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisexamples.entity.GithubUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GithubUserMapper06 extends BaseMapper<GithubUser> {
    default List<GithubUser> listByOptionals(QueryOptional optionals){
        LambdaQueryWrapper<GithubUser> qw = new QueryWrapper<GithubUser>().lambda();

        qw.ge(optionals.getStars()!=null,
                GithubUser::getStars,
                optionals.getStars());

        qw.ge(optionals.getRepos()!=null,
                GithubUser::getRepos,
                optionals.getRepos());

        qw.ge(optionals.getFollowers()!=null,
                GithubUser::getFollowers,
                optionals.getFollowers());

        qw.lt(optionals.getBeforeCreateTime()!=null,
                GithubUser::getCreateTime,
                optionals.getBeforeCreateTime());

        qw.eq(optionals.getGender()!=null,
                GithubUser::getGender,
                optionals.getGender());

        return selectList(qw);
    }

    List<GithubUser> listByOptional2(QueryOptional queryOptional);
}
