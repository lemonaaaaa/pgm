package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.User;
import com.totemdb.pgm.entity.dto.UserDto;

import java.util.List;

public interface IUserService {
    /**
     * 插入用户
     * @param user
     */
    User addUser(UserDto user);

    /**
     * 查询用户
     * @param userId 用户id
     * @return
     */
    User getUser(Integer userId);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    void updateUser(Integer userId, String name, String phone, String email);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    User deleteUser(Integer userId);

    void updatePasswd(Integer userId, String password);

    List<User> getAllUser();
}
