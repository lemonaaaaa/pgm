package com.totemdb.pgm.service;

import com.totemdb.pgm.entity.User;
import com.totemdb.pgm.repository.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public User getByUsername(String username){
        return accountMapper.getByUsername(username);
    }

    @Override
    public void register(String username, String password) {
        Timestamp reg_time = new Timestamp(System.currentTimeMillis());
        accountMapper.register(username, password,reg_time);
    }
}
