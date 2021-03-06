package com.frame.wheel.wheelbase.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frame.wheel.wheelbase.service.ShiroService;
import com.frame.wheel.wheelsystem.dao.SysUserMapper;
import com.frame.wheel.wheelsystem.entity.SysUser;
import com.frame.wheel.wheelsystem.service.SysUserService;
import com.frame.wheel.wheelsystem.util.ShiroUtil;
import com.frame.wheel.wheelutil.base.exception.WheelException;
import com.frame.wheel.wheelutil.base.util.PasswordUtil;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroServiceImpl  extends ServiceImpl<SysUserMapper, SysUser> implements ShiroService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser validate(SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (sysUser != null) {
            if (Validator.isNotEmpty(sysUser.getAccount())) {
                queryWrapper.eq("account", sysUser.getAccount());
            }
            SysUser getUser = sysUserMapper.validate(queryWrapper);

            if (null == getUser) {
                throw new WheelException("账号不存在！");
            }else{
                //根据获取的密码盐对传输过来的密码内容进行解密
                String password = PasswordUtil.encryptedPasswords(sysUser.getPassword(), getUser.getSalt());
                if(password==null||password==""){
                    throw new WheelException("请输入账户密码！");
                }//对获取到的密码和解密后密码进行比较
                else if (!password.equals(getUser.getPassword())) {
                    throw new WheelException("密码不正确！");
                }
            }
            ShiroUtil.setCurrentUser(getUser);
            return getUser;
        }else{
            throw new WheelException("未能准确获取用户信息！");
        }

    }

    @Override
    public SysUser getUserPermissions(SysUser sysUser) {

        return null;
    }
}
