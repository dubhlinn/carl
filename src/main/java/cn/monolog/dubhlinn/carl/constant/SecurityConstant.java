package cn.monolog.dubhlinn.carl.constant;

/**
 * 安全模块的常量
 * @author dubhlinn
 * @date 2020-01-06
 */
public class SecurityConstant {
    /*
     * 加密算法名称
     */
    public static final String hashAlgorithm = "md5";

    /*
     * 加密散列次数
     */
    public static final int hashIterations = 2;

    /**
     * 用户保存在session中的key
     */
    public static final String USER_KEY = "user_in_session";
}
