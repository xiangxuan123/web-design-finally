package com.example.mybatisexamples.example06;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class QueryOptional {
    private String gender;
    private Integer followers;
    private Integer stars;
    private Integer repos;
    private LocalDateTime beforeCreateTime;
}
