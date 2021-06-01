package com.example.design.controller;


import com.example.design.VO.ResultVO;
import com.example.design.entity.Course;
import com.example.design.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/course/")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("getCourseByTeacher")
    public ResultVO getCourseByName(@RequestBody String name){
        log.debug("{}",name);
        return ResultVO.success(Map.of("courses",courseService.getCoursesByName(name)));
    }

    @PostMapping("insertCourse")
    public ResultVO insertCourse(@RequestBody Course course){
        courseService.insertCourse(course);
        return ResultVO.success(Map.of());
    }
}
