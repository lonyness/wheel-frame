package com.frame.wheel.wheelsystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frame.wheel.wheelsystem.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "sysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> select(Page page, @Param("ew") QueryWrapper<SysUser> queryWrapper);
}
