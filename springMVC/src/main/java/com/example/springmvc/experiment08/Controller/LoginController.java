package com.example.springmvc.experiment08.Controller;

import com.example.springmvc.experiment08.DTO.User;
import com.example.springmvc.experiment08.component.EncryptorComponent;
import com.example.springmvc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/experiment08/")
public class LoginController {
    @Autowired
    private EncryptorComponent encryptorComponent;
    @Autowired
    private PasswordEncoder encoder;

    private Map<String,User> map = new HashMap<String,User>();
    @PostMapping("register")
    public ResultVO register(@RequestBody User user){
        map.put(user.getUserName(),user);
        return ResultVO.success(Map.of("user",user));
    }
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response){
        User user1 = map.get(user.getUserName());
        if(user1 == null||!user1.getPassword().equals(user.getPassword())){
            return ResultVO.error(401,"账号密码错误");
        }
        String result = encryptorComponent.encrypt(Map.of("userName",user.getUserName()));
        log.debug(result);
        response.addHeader("token",result);
        return ResultVO.success(Map.of("user",user));
    }
    @GetMapping("index")
    public ResultVO getIndex(@RequestAttribute("userName") String userName){
        return ResultVO.success(Map.of("msg",userName+"欢迎回来"));
    }
}
