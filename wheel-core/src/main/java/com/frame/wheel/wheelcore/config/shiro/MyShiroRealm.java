package com.frame.wheel.wheelcore.config.shiro;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frame.wheel.wheelbase.service.ShiroService;
import com.frame.wheel.wheelsystem.dao.SysUserMapper;
import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelsystem.util.ShiroUtil;
import com.frame.wheel.wheelutil.base.exception.WheelException;
import com.frame.wheel.wheelutil.base.util.PasswordUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
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
    protected AuthenticationInfo doGetAuthenticationInfo (
            AuthenticationToken authcToken) {
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

        // 当前登录用户
        SysUser currentUser = (SysUser) principals.getPrimaryPrincipal();

        // 由于修改用户角色或者修改角色权限导致权限变动,所以每次授权都要重新查询
        SysUser sysUser = shiroService.getUserPermissions(currentUser);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        // 赋予权限
//        simpleAuthorizationInfo.addStringPermissions(sysUser.getPermissionList());
//        // 赋予角色
//        simpleAuthorizationInfo.addRoles(sysUser.getRoleList());
        ShiroUtil.setCurrentUser(sysUser);
        return simpleAuthorizationInfo;
    }
}

