package com.example.design.controller;

import com.example.design.VO.ResultVO;
import com.example.design.common.EncryptComponent;
import com.example.design.entity.Lab;
import com.example.design.entity.User;
import com.example.design.service.LabService;
import com.example.design.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value = "处理登录/未登录操作请求",tags = {"登录以及用户操作"})
@Slf4j
@RestController
@RequestMapping("/api/")
public class LoginController {
    @Autowired
    private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;
    @Autowired
    private LabService labService;

    @ApiOperation(value = "登录")
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response){
        User u = userService.getUser(user.getUserName());
        if(u == null || !encoder.matches(user.getPassword(),u.getPassword())){
            return ResultVO.error(401,"用户名密码错误");
        }
        String token = encryptComponent.encrypt(Map.of("uid",u.getId(),"role",u.getRole()));
        response.addHeader("token",token);
        log.debug("{}",token);
        return ResultVO.success(Map.of("user",u));
    }

    @ApiOperation(value = "登录后查询某一实验室的预约情况")
    @PostMapping("getLab")
    public ResultVO getLabId(@RequestBody long number){
        return ResultVO.success(Map.of("id",
                labService.getLabByNumber(number).stream()
                .map(Lab::getId)
                .collect(Collectors.toList())));
    }
}
