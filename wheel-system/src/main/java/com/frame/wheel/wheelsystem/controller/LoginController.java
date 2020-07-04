package com.frame.wheel.wheelsystem.controller;

import cn.hutool.core.lang.Validator;
import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelsystem.util.ShiroUtil;
import com.frame.wheel.wheelutil.base.controller.BaseController;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@Api(tags = "用户登录、注销")
public class LoginController extends BaseController {


    /**
     * 登录页面
     *
     * @return String
     */
    @GetMapping("/login")
    public String login() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // 正常访问登录
        if (SecurityUtils.getSubject().isAuthenticated() || SecurityUtils.getSubject().isRemembered()) {
            return ShiroUtil.getCurrentUser().getAccount();
        }else{
            return "production/login.html";
        }
    }



    @PostMapping("/login")
    public String login(SysUser sysUser,boolean rememberMe) {
        //验证用户信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getAccount(), sysUser.getPassword());
        usernamePasswordToken.setRememberMe(rememberMe);
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
