package com.example.springmvc.example02.controller;

import com.example.springmvc.example02.exception.MyException;
import com.example.springmvc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class exceptionController02 {
    @ExceptionHandler(MyException.class)
    public ResultVO handleValidException(MyException exception){
        return ResultVO.error(exception.getCode(), exception.getMessage());
    }
}
