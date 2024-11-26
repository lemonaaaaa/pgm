package com.totemdb.pgm.controller;


import com.totemdb.pgm.entity.ResponseMessage;
import com.totemdb.pgm.entity.User;
import com.totemdb.pgm.service.IAccountService;
import com.totemdb.pgm.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/register")
    public ResponseMessage<User> register(@RequestParam String username, @RequestParam String password) {
        //查询用户判断是否已经存在相同用户名
        User u = accountService.getByUsername(username);

        if (u == null) {
            //用户名未被占用，将信息写入数据库
            accountService.register(username,password);
            return ResponseMessage.success();
        }else{
            return ResponseMessage.error("用户名已存在");
        }

    }

    @PostMapping("/login")
    public ResponseMessage<String> login(@RequestParam String username, @RequestParam String password){
        log.info("登录");
        User u = accountService.getByUsername(username);

        if (u == null){
            return ResponseMessage.error("用户名不存在");
        }

        if(u.getPassword().equals(password)){
            //成功登录
            Map<String,Object> claims = new HashMap<>();
            claims.put("username",username);
            String token = JwtUtil.genToken(claims);
            return ResponseMessage.success(token);
        }
        else
            return ResponseMessage.error("用户名或密码错误");
    }
}
