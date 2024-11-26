package com.totemdb.pgm.service;
import com.totemdb.pgm.entity.User;

public interface IAccountService {

    void register(String username, String password);

    User getByUsername(String username);

}
