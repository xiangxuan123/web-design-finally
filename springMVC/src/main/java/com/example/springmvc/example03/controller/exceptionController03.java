package com.example.springmvc.example03.controller;

import com.example.springmvc.vo.ResultVO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;


@Slf4j
@RestControllerAdvice
public class exceptionController03 {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleValidException(MethodArgumentNotValidException exception){
        StringBuilder strBuilder = new StringBuilder();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(e ->{
                    strBuilder.append(e.getField());
                    strBuilder.append(": ");
                    strBuilder.append(e.getDefaultMessage());
                    strBuilder.append("; ");
                });
        return ResultVO.error(400,strBuilder.toString());
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultVO handleValidException(
            MethodArgumentTypeMismatchException exception,
            HttpServletRequest request){
        String msg = request.getRequestURI()+": "
                +"请求地址参数"+exception.getValue()+"错误";
        return ResultVO.error(400,msg);
    }
    @ExceptionHandler(InvalidFormatException.class)
    public ResultVO handleInvalidFormatException(InvalidFormatException exception){
        StringBuilder stringBuilder = new StringBuilder();
        exception.getPath()
                .forEach(p -> {
                    stringBuilder.append("属性");
                    stringBuilder.append(p.getFieldName());
                    stringBuilder.append(",您输入的值：").append(exception.getValue());
                    stringBuilder.append(",类型错误！");
                });
        return ResultVO.error(400,stringBuilder.toString());
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO handleConstraintViolationException(ConstraintViolationException exception){
        StringBuilder stringBuilder = new StringBuilder();
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        violations.forEach(v -> {
            stringBuilder.append(v.getMessage()).append(";");
        });
        return ResultVO.error(400,stringBuilder.toString());
    }
}
