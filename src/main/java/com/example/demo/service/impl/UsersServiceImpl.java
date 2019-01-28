package com.example.demo.service.impl;

import com.example.demo.domain.Users;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.po.UsersPo;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public int checkLogin(UsersPo users) {


        return usersMapper.checkLogin(users);
    }

    @Override
    public void save(Users users) {
        usersMapper.save(users);
    }

}
