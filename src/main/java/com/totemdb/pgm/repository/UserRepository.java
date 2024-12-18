package com.totemdb.pgm.repository;

import com.totemdb.pgm.exception.DatabaseException;
import com.totemdb.pgm.entity.User;
import com.totemdb.pgm.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User add(User user) {
        String sql="insert into usertest(username,password,type,regtime,phone,email,name) values(?,?,?,?,?,?,?)";
        int row=jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getType(),user.getRegtime(),user.getPhone(),user.getEmail(),user.getName());
        return user;
    }

    public User getUserById(Integer userId) {
        String sql="select * from usertest where id=?";
        List<User> row=jdbcTemplate.query(sql,new User(), userId);
        if (row.isEmpty()) {
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
        return row.get(0);
    }

    public void update(Integer id, String name, String phone, String email) {
        try {
            String sql = "update usertest set "
                    + "phone = coalesce(?, phone), "
                    + "email = coalesce(?, email), "
                    + "name = coalesce(?, name) "
                    + "where id = ?";

            jdbcTemplate.update(sql, phone, email, name, id);
        } catch (Exception e) {
            throw new DatabaseException("Failed to update user", e);
        }
    }

    public User deleteUserById(Integer userId) {
        String sqlSelect = "select * from usertest where id=?";
        List<User> row = jdbcTemplate.query(sqlSelect, new User(), userId);
        if (row.isEmpty()) {
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
        User userToDelete = row.get(0);

        String sqlDelete = "delete from usertest where id=?";
        jdbcTemplate.update(sqlDelete, userId);
        return userToDelete;
    }

    public void updatePasswd(Integer userId, String password) {
        String sqlUpdate = "update usertest set password=? where id=?";
        jdbcTemplate.update(sqlUpdate, password, userId);
    }

    public List<User> getAllUser() {
        String sql="select * from usertest";
        List<User> row=jdbcTemplate.query(sql,new User());
        return row;
    }

    public void updateType(Integer userId, Long type) {
        String sqlUpdate = "update usertest set type=? where id=?";
        jdbcTemplate.update(sqlUpdate, type, userId);
    }
}
