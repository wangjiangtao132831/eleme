package com.example.demo.mapper;

import com.example.demo.domain.Users;
import com.example.demo.po.UsersPo;

public interface UsersMapper {

    public int checkLogin(UsersPo users);

    public void save(Users users);
}
