package com.frame.wheel.wheelsystem.controller;

import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelsystem.util.ShiroUtil;
import com.frame.wheel.wheelutil.base.controller.BaseController;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
            String account = ShiroUtil.getCurrentUser().getAccount();
            return account;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
