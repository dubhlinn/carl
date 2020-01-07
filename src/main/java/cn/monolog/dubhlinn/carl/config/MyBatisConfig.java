package cn.monolog.dubhlinn.carl.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis的配置类
 * @author dubhlinn
 * @date 2020-01-06
 */
@Configuration
@MapperScan("cn.monolog.dubhlinn.carl.dao")
public class MyBatisConfig {
}
