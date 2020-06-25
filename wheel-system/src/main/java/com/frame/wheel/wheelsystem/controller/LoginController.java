package com.frame.wheel.wheelsystem.controller;

import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelutil.base.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "用户登录、注销")
public class LoginController extends BaseController {


    @GetMapping("/login")
    public String login(SysUser sysUser) {
        //验证用户信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getAccount(), sysUser.getPassword());
        Subject subject = SecurityUtils.getSubject();
        Map<String, Object> map = new HashMap<>();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            return subject.getSession().getId().toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
