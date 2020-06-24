package com.frame.wheel.wheelsystem.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frame.wheel.wheelsystem.dao.SysUserMapper;
import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelsystem.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl  extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Resource
    private RedisTemplate<String, IPage> redisTemplate;

    @Override
    public IPage<SysUser> selectUserPage(@RequestParam(name = "page") Page<SysUser> page,@RequestParam(name = "sysUser")SysUser sysUser) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (sysUser != null) {
            if (Validator.isNotEmpty(sysUser.getAccount())) {
                queryWrapper.like("account", sysUser.getAccount());
            }
        }
        return sysUserMapper.selectPageVo(page,queryWrapper);
    }

}
