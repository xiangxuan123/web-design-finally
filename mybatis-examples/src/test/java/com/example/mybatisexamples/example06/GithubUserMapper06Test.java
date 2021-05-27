package com.example.mybatisexamples.example06;

import com.example.mybatisexamples.entity.GithubUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
@Rollback(value = false)
public class GithubUserMapper06Test {
    @Autowired
    private GithubUserMapper06 githubUserMapper06;

    @Test
    public void listByOptional_Test(){
        QueryOptional optional = QueryOptional.builder()
                .stars(10)
                .repos(10)
                .followers(20)
                .beforeCreateTime(LocalDateTime.of(2018,1,1,0,0))
                .build();
        for (GithubUser op : githubUserMapper06.listByOptionals(optional)) {
            log.debug("{}",op.getName());
        }
    }

    @Test
    public void listByOptional2_Test(){
        QueryOptional optional = QueryOptional.builder()
                .stars(10)
                .repos(10)
                .followers(20)
                .beforeCreateTime(LocalDateTime.of(2018,1,1,0,0))
                .build();
        for (GithubUser u : githubUserMapper06.listByOptional2(optional)) {
            log.debug("{}",u.getName());
        }
    }
}
