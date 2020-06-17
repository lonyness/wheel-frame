package com.frame.wheel.wheelsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frame.wheel.wheelsystem.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "sysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser getOneByName(String account);
}
