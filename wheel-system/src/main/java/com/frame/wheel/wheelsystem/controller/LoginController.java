package com.frame.wheel.wheelsystem.controller;

import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelsystem.util.ShiroUtil;
import com.frame.wheel.wheelutil.base.controller.BaseController;
import com.frame.wheel.wheelutil.base.vo.BaseResult;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api(tags = "用户登录、注销")
public class LoginController extends BaseController {

    /**
     * 访问登录页面
     * @return String
     */
    @GetMapping("/login")
    public String login() {
//        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//        System.out.println(SecurityUtils.getSubject().isRemembered());
//        System.out.println(SecurityUtils.getSubject().isAuthenticated());
        // 正常访问登录
        if (SecurityUtils.getSubject().isAuthenticated() || SecurityUtils.getSubject().isRemembered()) {
            return "views/index.html";
        }else{
//            return REDIRECT + "/";
            return "views/user/login.html";
        }
    }

    /**
     * 账户登录
     * @param sysUser
     * @param rememberMe
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public BaseResult login(SysUser sysUser, boolean rememberMe) {
        //验证用户信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getAccount(), sysUser.getPassword());
        usernamePasswordToken.setRememberMe(rememberMe);
        Subject subject = SecurityUtils.getSubject();
        Map<String, Object> map = new HashMap<>();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            SysUser account = ShiroUtil.getCurrentUser();
            return BaseResult.successMessage(account);
        } catch (Exception e) {
            return BaseResult.faileMessage(e.getMessage());
        }
    }

}
