package com.frame.wheel.wheelsystem.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frame.wheel.wheelsystem.dao.SysUserMapper;
import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelsystem.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "sysUser", description = "用户管理")
@RequestMapping("/sysUser")
public class SysUserController {
//    @Autowired
//    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/pageList")
    @ApiOperation("用户查询")
    public IPage pageList(@ModelAttribute Page page,@ModelAttribute SysUser sysUser) {

        return sysUserService.selectUserPage(page,sysUser);
    }
//    private <T> void print(List<T> list) {
//        if (!CollectionUtils.isEmpty(list)) {
//            list.forEach(System.out::println);
//        }
//    }
}