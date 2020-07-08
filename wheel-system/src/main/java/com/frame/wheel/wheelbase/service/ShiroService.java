package com.frame.wheel.wheelbase.service;

import com.frame.wheel.wheelsystem.entity.SysUser;

public interface ShiroService {

    /**
     * 用户登录
     */
    public SysUser validate(SysUser sysUser);
    /**
     * 权限查询
     */
    public SysUser getUserPermissions(SysUser sysUser);
}
