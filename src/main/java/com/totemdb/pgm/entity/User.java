package com.totemdb.pgm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

@Entity
public class User implements RowMapper<User>{
    @Id
    private Long id;
    private String username;
    private String password;
    private Long type;
    private OffsetDateTime regtime;
    private String name;
    private String phone;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public OffsetDateTime getRegtime() {
        return regtime;
    }

    public void setRegtime(OffsetDateTime regtime) {
        this.regtime = regtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId((long) resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setType(resultSet.getLong("type"));
        user.setPhone(resultSet.getString("phone"));
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name"));
        String regtimeString = resultSet.getString("regtime");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSX");
        OffsetDateTime regtime = OffsetDateTime.parse(regtimeString, formatter);
        user.setRegtime(regtime);
        return user;
    }
}