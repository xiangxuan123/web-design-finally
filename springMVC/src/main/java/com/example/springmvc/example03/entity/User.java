package com.example.springmvc.example03.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    private int id;
    @Size(min = 2,max = 6,message = "您输入的值为${validatedValue},用户名必须大于{min},小于{max}")
    private String name;
    @Min(value = 18)
    @Max(value = 60)
    private int age;
    @Email(message = "email不合法")
    private String email;
}
