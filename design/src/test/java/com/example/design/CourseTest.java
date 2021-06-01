package com.example.design;

import com.example.design.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CourseTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void getCourse(){
        courseService.getCoursesByName("BO")
                .forEach(course -> System.out.println(course.getCourseName()));
    }
}
