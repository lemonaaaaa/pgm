package com.totemdb.pgm.controller;

import com.totemdb.pgm.entity.ResponseMessage;
import com.totemdb.pgm.entity.User;
import com.totemdb.pgm.entity.dto.UserDto;
import com.totemdb.pgm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")    //localhost:8080/user
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseMessage<User> addUser(@Validated @RequestBody UserDto user) {  //localhost:8080/user   method:post
        User userNew = userService.addUser(user);
        return ResponseMessage.success(userNew);
    }

    @GetMapping("/{userId}")
    public ResponseMessage<User> getUser(@PathVariable Integer userId) {   //localhost:8080/user/1
        User userNew=userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }

    @PutMapping
    public ResponseMessage<User> updateUser(@RequestParam Integer userId,@RequestParam String name, @RequestParam String phone, @RequestParam String email) {
        userService.updateUser(userId, name, phone, email);
        return ResponseMessage.success();
    }
    @PutMapping("/passwd")
    public ResponseMessage<User> updatePasswd(@RequestParam Integer userId,@RequestParam String password) {
        userService.updatePasswd(userId, password);
        return ResponseMessage.success();
    }

    @DeleteMapping("/{userId}")
    public ResponseMessage<User> deleteUser(@PathVariable Integer userId) {
        User userNew=userService.deleteUser(userId);
        return ResponseMessage.success(userNew);
    }
}
