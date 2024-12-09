package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.User;
import com.totemdb.pgm.entity.dto.UserDto;
import com.totemdb.pgm.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Integer userId) {
        User ret= userRepository.getUserById(userId);
        return ret;
    }

    @Override
    public User addUser(UserDto user) {
        User userPojo=new User();
        BeanUtils.copyProperties(user,userPojo);
        OffsetDateTime currentTime  = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSX");
        String formattedTime = currentTime.format(formatter);
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(formattedTime, formatter);
        userPojo.setRegtime(offsetDateTime);
        userRepository.add(userPojo);
        return userPojo;
    }

    @Override
    public void updateUser(Integer id, String name ,String phone, String email) {
        userRepository.update(id, name, phone, email);
    }

    @Override
    public List<User> getAllUser() {
        List<User> ret= userRepository.getAllUser();
        return ret;
    }

    @Override
    public User deleteUser(Integer userId) {
        User ret= userRepository.deleteUserById(userId);
        return ret;
    }

    @Override
    public void updatePasswd(Integer userId, String password) {
        userRepository.updatePasswd(userId, password);
    }
}
