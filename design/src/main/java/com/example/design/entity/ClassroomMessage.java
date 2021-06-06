package com.example.design.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomMessage {
    private Long id;
    private String labId;
    private String lesson;
    private String courseName;
    private int start;
    private int end;
    private Long teacherId;
    private String teacherName;
    private String title;
}
