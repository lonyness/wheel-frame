package com.frame.wheel.wheelsystem.controller;

import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelutil.base.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags = "用户登录、注销")
public class LoginController extends BaseController {


    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    public SysUser login(String account, String password, boolean rememberMe, HttpServletRequest request,
                         HttpServletResponse response)   {


        return null;
    }

}
