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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fr
 * @since 2019-01-24
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/pageList")
    public IPage pageList(@ModelAttribute Page page) {
//        System.out.println("----- baseMapper 自带分页 ------");
//        Page<SysUser> page = new Page<>(1, 5);
//        IPage<SysUser> userIPage = sysUserMapper.selectPage(page, new QueryWrapper<SysUser>());
////        Assert.assertSame(page, userIPage);
//        System.out.println("总条数 ------> " + userIPage.getTotal());
//        System.out.println("当前页数 ------> " + userIPage.getCurrent());
//        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
//        print(userIPage.getRecords());
//        System.out.println("----- baseMapper 自带分页 ------");
//        return userIPage;
//        System.out.println("json 正反序列化 begin");
//        String json = JSON.toJSONString(page);
//        Page<SysUser> page1 = JSON.parseObject(json, TypeBuilder.newInstance(Page.class).addTypeParam(SysUser.class).build());
//        print(page1.getRecords());
//        System.out.println("json 正反序列化 end");
        long date1 = System.currentTimeMillis();
        IPage<SysUser> userPage = sysUserService.selectUserPage(page);
        System.out.println("总条数 ------> " + userPage.getTotal());
        System.out.println("当前页数 ------> " + userPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userPage.getSize());
        print(userPage.getRecords());
        System.out.println("----- 自定义 XML 分页 ------");
        long date2 = System.currentTimeMillis();
        return userPage;
    }
    private <T> void print(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(System.out::println);
        }
    }
}