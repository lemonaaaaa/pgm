package com.totemdb.pgm.service;
import com.totemdb.pgm.entity.User;

public interface AccountService {

    void register(String username, String password);

    User getByUsername(String username);

}
