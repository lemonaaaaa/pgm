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
    public ResponseMessage<User> updateUser(@Validated @RequestBody UserDto user) {
        User userNew=userService.updateUser(user);
        return ResponseMessage.success(userNew);
    }

    @DeleteMapping("/{userId}")
    public ResponseMessage<User> deleteUser(@PathVariable Integer userId) {
        User userNew=userService.deleteUser(userId);
        return ResponseMessage.success(userNew);
    }
}
