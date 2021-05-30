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
public class User {
    private Long id;
    private String name;
    private String number;
    private String password;
    private Integer role;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createTime;

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime updateTime;
}
