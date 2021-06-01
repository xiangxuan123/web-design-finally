package com.example.design.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomMessage {
    private String id;//labID
    private String lesson;
    private String courseName;
    private Long start;
    private Long end;
    private String teacherName;
    private String title;
}
