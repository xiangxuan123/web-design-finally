package com.example.design.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Lab {
    private Long id;
    private Long number;
    private String detail;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createTime;

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime updateTime;
}
