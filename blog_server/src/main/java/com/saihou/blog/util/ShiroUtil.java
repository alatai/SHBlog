package com.saihou.blog.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Shiroパスワードを暗号化するツールクラス
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/15 10:52
 */
public class ShiroUtil {

    public static String encrypt(String password, String salt) {
        String algorithm = "md5";
        int times = 2;

        return new SimpleHash(algorithm, password, salt, times).toString();
    }
}
