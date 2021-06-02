package com.example.design.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomMessage {
    private Long messageId;
    private String id;//labID
    private String lesson;
    private String courseName;
    private Integer start;
    private Integer end;
    private Long teacherId;
    private String teacherName;
    private String title;
}
