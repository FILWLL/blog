package com.hjljy.blog.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/24 0024 11:30
 * @Description: MD5加密工具类
 */
public class MD5Util {

    private static final String SALT = "hjljy";

    private static final int HASH_ITERATIONS = 500;

    /**
     * 加密加盐加次数  根据用户名和固定salt组成新的salt
     * @param username
     * @param pswd
     * @return
     */
    public static String encrypt(String username, String pswd) {
        String newPassword = new SimpleHash("md5", pswd, ByteSource.Util.bytes(username + SALT),
                HASH_ITERATIONS).toHex();
        return newPassword;
    }

/*    public static void main(String[] args) {
        System.out.println(encrypt("admin", "123456"));
    }*/
}
