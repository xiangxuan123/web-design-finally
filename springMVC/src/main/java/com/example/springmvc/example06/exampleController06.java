package com.example.springmvc.example06;

import com.example.springmvc.example05.EncryptComponent05;
import com.example.springmvc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example06/")
public class exampleController06 {
    @Autowired
    private UserService06 userService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EncryptComponent05 encryptComponent;

    @PostMapping("login")
    public ResultVO login(@RequestBody User06 user, HttpServletResponse response){
        User06 u = userService.getUser(user.getUserName());
        if(u == null || !encoder.matches(user.getPassword(),u.getPassword())){
            return ResultVO.error(401,"账号密码错误");
        }
        String result = encryptComponent.encrypt(Map.of("uid",u.getId(),"role",u.getRole()));
        log.debug(result);
        response.addHeader("token",result);
        return ResultVO.success(Map.of("user",u));
    }
    @GetMapping("admin/welcome")
    public ResultVO getWelcome(@RequestAttribute("role") String role){
        log.debug(role);
        return ResultVO.success(Map.of("msg","欢迎回来"));
    }
}
