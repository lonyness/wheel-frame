package com.frame.wheel.wheelsystem.controller;

import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelsystem.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/getUserByName")
    public SysUser getUserByName(String account) throws Exception {
        return sysUserService.getOneByName(account);
    }

}
