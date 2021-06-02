package com.example.design.DTO;

import com.example.design.entity.ClassroomMessage;
import com.example.design.entity.Course;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.List;

@ApiModel
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String userName;
    private String password;
    private Integer role;
    private List<Course> courses;
}
