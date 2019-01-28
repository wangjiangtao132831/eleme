package com.example.demo.service;

import com.example.demo.domain.Users;
import com.example.demo.po.UsersPo;

public interface UsersService {

    int checkLogin(UsersPo users);

    public void save(Users users);
}
