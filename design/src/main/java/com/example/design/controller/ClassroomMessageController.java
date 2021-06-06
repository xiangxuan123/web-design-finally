package com.example.design.controller;

import com.example.design.VO.ResultVO;
import com.example.design.entity.ClassroomMessage;
import com.example.design.entity.Course;
import com.example.design.service.ClassroomMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@Api(value = "操作预约信息",tags = {"预约信息操作"})
@RestController
@RequestMapping("/api/classMessage/")
public class ClassroomMessageController {
    @Autowired
    private ClassroomMessageService classroomMessageService;

    @ApiOperation(value = "基于实验室ID查询预约信息")
    @GetMapping("{cid}")
    public ResultVO getClassroomMessageById(@PathVariable String cid){
        return ResultVO.success(Map.of("message",classroomMessageService.getMessageById(cid)));
    }
    //预约是否合法
    @ApiOperation(value = "插入预约记录")
    @PostMapping("insert")
    public ResultVO insert(@RequestBody ClassroomMessage message, @RequestAttribute("uid") long uid){
        message.setTeacherId(uid);
        List<ClassroomMessage> messages = classroomMessageService.getFilterMessage(message);
        if(messages.size() != 0){
            return ResultVO.error(400,"与其他预约时间冲突");
        }
        classroomMessageService.insert(message);
        return ResultVO.success(Map.of("message",classroomMessageService.getMessageByMid(message.getId())));
    }
}
