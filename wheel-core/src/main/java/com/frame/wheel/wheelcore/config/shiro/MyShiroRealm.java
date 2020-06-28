package com.frame.wheel.wheelcore.config.shiro;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frame.wheel.wheelbase.service.ShiroService;
import com.frame.wheel.wheelsystem.dao.SysUserMapper;
import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelutil.base.util.PasswordUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lonyness
 * @Date 2020年6月25日
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    public MyShiroRealm() {
        super();
    }

    /**
     * 认证信息，主要针对用户登录，
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) authcToken;
        SysUser sysUser = new SysUser();
        sysUser.setAccount(utoken.getUsername());
        sysUser.setPassword(new String(utoken.getPassword()));
        //根据账号密码查用户信息并进行验证操作
        SysUser user = shiroService.validate(sysUser);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getAccount(),// 用户名
                new String(utoken.getPassword()), // 密码
                getName());
        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String account = principals.getPrimaryPrincipal().toString().split(":")[0];
        //根据用户userName查询权限（permission) 此处省略sql写固定权限
        Set<String> permissions = new HashSet<>();
        permissions.add("shiro:all");
        info.setStringPermissions(permissions);
        return info;
    }
}

