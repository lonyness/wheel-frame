package com.frame.wheel.wheelsystem.controller;

import com.frame.wheel.wheelsystem.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户登录注销模块")
public class LoginController {


    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    public SysUser login(Model model)   {


        return null;
    }

}
