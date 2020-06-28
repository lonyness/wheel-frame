package com.frame.wheel.wheelsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.frame.wheel.wheelsystem.entity.SysUser;

public interface SysUserService  extends IService<SysUser> {
    public IPage<SysUser> selectUserPage(Page<SysUser> page,SysUser sysUser);

    public SysUser validate(Page<SysUser> page,SysUser sysUser);
}
