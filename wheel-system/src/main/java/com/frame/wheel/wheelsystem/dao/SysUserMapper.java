package com.frame.wheel.wheelsystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frame.wheel.wheelsystem.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.Wrapper;
import java.util.List;

@Mapper
@Component(value = "sysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取用户列表
     * @return
     */
    public IPage<SysUser> selectPageVo(@Param("page") Page page,@Param(Constants.WRAPPER) QueryWrapper query);
}
