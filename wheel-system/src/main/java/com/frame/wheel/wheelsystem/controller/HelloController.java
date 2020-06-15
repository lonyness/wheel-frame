package com.frame.wheel.wheelsystem.controller;

import com.frame.wheel.wheelsystem.entity.User;
import com.frame.wheel.wheelsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserByName")
    public User getUserByName(String name) throws Exception {
        return userService.getOneByName(name);
    }

}
