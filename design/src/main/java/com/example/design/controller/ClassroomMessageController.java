package com.example.design.controller;

import com.example.design.VO.ResultVO;
import com.example.design.service.ClassroomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/classMessage/")
public class ClassroomMessageController {
    @Autowired
    private ClassroomMessageService classroomMessageService;

    @GetMapping("{cid}")
    public ResultVO getClassroomMessageById(@PathVariable String cid){
        return ResultVO.success(Map.of("message",classroomMessageService.getMessageById(cid)));
    }
}
