package com.frame.wheel.wheelsystem.service.impl;

import com.frame.wheel.wheelsystem.dao.UserMapper;
import com.frame.wheel.wheelsystem.entity.User;
import com.frame.wheel.wheelsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getOneByName(String name) {
        return userMapper.getOneByName(name);
    }
}
