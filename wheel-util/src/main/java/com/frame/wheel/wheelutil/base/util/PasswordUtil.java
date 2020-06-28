package com.frame.wheel.wheelutil.base.util;

import cn.hutool.crypto.SecureUtil;
import com.frame.wheel.wheelutil.base.constant.key.Key;

public class PasswordUtil {

    private PasswordUtil() {}

    /**
     * 加密密码 用于登录/重置密码
     *
     * @param password 密码(经过一次md5)
     * @param salt     盐
     * @return 加密后密码
     */
    public static String encryptedPasswords(String password, String salt) {
        return SecureUtil.md5((SecureUtil.md5(salt + Key.PASSWORD) + password));
    }

    /**
     * 生成密码 用于用户注册/新增用户
     *
     * @param password 密码 未加密
     * @param salt     密码盐
     * @return 加密后密码
     */
    public static String generatingPasswords(String password, String salt) {
        return SecureUtil.md5((SecureUtil.md5(salt + Key.PASSWORD) + SecureUtil.md5(password)));
    }
}
