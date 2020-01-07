package cn.monolog.dubhlinn.carl.util;

import cn.monolog.dubhlinn.carl.constant.SecurityConstant;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 安全工具类
 * @author dubhlinn
 * @date 2020-01-07
 */
public class SecurityUtil {

    /**
     * 对密码进行加密
     * @param username 用户名
     * @param originalPassword 原始密码
     * @return 加密后的密码
     */
    public static String encrypt(String username, String originalPassword) {
        ByteSource salt = ByteSource.Util.bytes(username);
        SimpleHash simpleHash = new SimpleHash(SecurityConstant.hashAlgorithm, originalPassword, salt, SecurityConstant.hashIterations);
        String encryptedPassword = simpleHash.toHex();
        return encryptedPassword;
    }
}
