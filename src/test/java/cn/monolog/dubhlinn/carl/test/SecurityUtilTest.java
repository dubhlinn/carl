package cn.monolog.dubhlinn.carl.test;

import cn.monolog.dubhlinn.carl.util.SecurityUtil;
import org.junit.Test;

/**
 * 安全工具测试类
 * @author dubhlinn
 * @date 2020-01-07
 */
public class SecurityUtilTest {

    /**
     * 测试加密方法
     */
    @Test
    public void testEncrypt() {
        String username = "cuijiu";
        String password = "123456";
        String encryptedPassword = SecurityUtil.encrypt(username, password);
        System.out.println(encryptedPassword);
    }
}
