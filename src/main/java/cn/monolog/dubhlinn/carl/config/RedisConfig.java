package cn.monolog.dubhlinn.carl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * redis配置类
 * @author dubhlinn
 * @date
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {
    /*
     * 主机
     */
    private String host;

    /*
     * 端口
     */
    private int port;

    /*
     * 密码
     */
    private String password;

    /**
     * 连接等待时间
     */
    private int timeout;

    /*
     * 缓存过期时间
     */
    private int expire;
}
