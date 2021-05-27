package com.example.springmvc.experiment08.interceptor;

import com.example.springmvc.example02.exception.MyException;
import com.example.springmvc.experiment08.component.EncryptorComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private EncryptorComponent encryptorComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token == null) {
            throw new MyException(400,"未登录");
        }
        Map<String,Object> result = encryptorComponent.decrypt(token);
        request.setAttribute("userName",result.get("userName"));
        return true;
    }
}
