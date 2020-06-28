package com.frame.wheel.wheelcore.config.shiro;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frame.wheel.wheelsystem.dao.SysUserMapper;
import com.frame.wheel.wheelsystem.entity.SysUser;
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
    SysUserMapper sysUserMapper;

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
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (Validator.isNotEmpty(sysUser.getAccount())) {
            queryWrapper.like("account", sysUser.getAccount());
        }
        //根据账号密码查用户信息
        SysUser user = sysUserMapper.validate(queryWrapper);
        if (null == user) {
            throw new AccountException("账号不存在！");
        } else if (!StringUtils.equals(user.getPassword(), sysUser.getPassword())) {
            throw new AccountException("密码不正确！");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getAccount(),// 用户名
                user.getPassword(), // 密码
                getName());
        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String userName = principals.getPrimaryPrincipal().toString().split(":")[0];
        //根据用户userName查询权限（permission) 此处省略sql写固定权限
        Set<String> permissions = new HashSet<>();
        permissions.add("shiro:all");
        info.setStringPermissions(permissions);
        return info;
    }
}

