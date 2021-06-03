package com.example.design.controller;


import com.example.design.DTO.UserDTO;
import com.example.design.VO.ResultVO;
import com.example.design.entity.ClassroomMessage;
import com.example.design.entity.Course;
import com.example.design.entity.Teacher;
import com.example.design.service.ClassroomMessageService;
import com.example.design.service.CourseService;
import com.example.design.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@Api(value = "处理老师操作", tags = {"老师操作"})
@Slf4j
@RestController
@RequestMapping("/api/teacher/")
public class TeacherController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassroomMessageService classroomMessageService;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "基于登录的教师账号查询教授课程")
    @GetMapping("getCourse")
    public ResultVO getCourse(@RequestAttribute("uid") long uid){
        return ResultVO.success(Map.of("courses",courseService.getCourseByUid(uid)));
    }

    @ApiOperation(value = "添加课程信息")
    @PostMapping("insertCourse")
    public ResultVO insertCourse(@RequestBody Course course,@RequestAttribute("uid") long uid){
        course.setTeacherId(uid);
        course.setTeacherName(userService.getUserByID(uid).getName());
        courseService.insertCourse(course);

        return ResultVO.success(Map.of("courses",courseService.getCourseByUid(uid)));
    }

    @ApiOperation(value = "基于cid删除课程")
    @DeleteMapping("deleteCourse/{cid}")
    public ResultVO delete(@PathVariable long cid,@RequestAttribute("uid") long uid){
        Course course = courseService.getCourseByCid(cid);
        if(course==null||course.getTeacherId()!=uid){
            return ResultVO.error(400,"该课程不存在");
        }
        courseService.delete(cid,uid);
        return ResultVO.success(Map.of("courses",courseService.getCourseByUid(uid)));
    }

    @ApiOperation(value = "基于cid更新课程信息")
    @PatchMapping("update")
    public ResultVO update(@RequestBody long cid,Course course,@RequestAttribute("uid") long uid){
        courseService.update(cid,course);
        return ResultVO.success(Map.of("courses",courseService.getCourseByUid(uid)));
    }
    @ApiOperation(value = "基于预约id取消预约")
    @DeleteMapping("deleteMessage/{mid}")
    public ResultVO deleteTeacher(@PathVariable long mid,@RequestAttribute("uid") long uid){
        ClassroomMessage message = classroomMessageService.getMessageByMid(mid);
        if(message==null||message.getTeacherId()!=uid){
            return ResultVO.error(400,"预约记录不存在");
        }
        classroomMessageService.deleteMessageByMID(mid,uid);
        return ResultVO.success(Map.of("msg","取消预约成功"));
    }
    @ApiOperation(value = "获取自己所有实验课的课表")
    @GetMapping("getMyMessage")
    public ResultVO getMyMessage(@RequestAttribute("uid") long uid){
        return ResultVO.success(Map.of("message",classroomMessageService.getMessageByTeacher(uid)));
    }

}
