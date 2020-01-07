package cn.monolog.dubhlinn.carl.config;

import cn.monolog.dubhlinn.carl.constant.SecurityConstant;
import cn.monolog.dubhlinn.carl.security.CustomedRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * shiro配置类
 * @author dubhlinn
 * @date 2020-01-06
 */
@Configuration
public class ShiroConfig {

    /**
     * 配置过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        //声明拦截器链
        Map<String, String> filterChainDefinitionMap = new HashMap<>();

        //以下url退出
        filterChainDefinitionMap.put("/security/logout", "logout");

        //以下url放行
        filterChainDefinitionMap.put("/security/login", "anon");
        filterChainDefinitionMap.put("*.html", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");

        //以下url需要身份校验
        filterChainDefinitionMap.put("/**", "authc");

        //新建过滤器实例
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //注入安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //注入拦截器链
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //注入登录失败接口
        shiroFilterFactoryBean.setLoginUrl("/security/unauthentic");

        //返回过滤器实例
        return shiroFilterFactoryBean;
    }

    /**
     * 配置加密器
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        //新建加密器实例
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //注入加密算法
        hashedCredentialsMatcher.setHashAlgorithmName(SecurityConstant.hashAlgorithm);
        //注入加密散列次数
        hashedCredentialsMatcher.setHashIterations(SecurityConstant.hashIterations);
        //返回加密器实例
        return hashedCredentialsMatcher;
    }

    /**
     * 配置安全组件
     * @return
     */
    @Bean
    public AuthorizingRealm authorizingRealm() {
        //新建安全组件实例
        AuthorizingRealm authorizingRealm = new CustomedRealm();
        //注入加密器
        authorizingRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        //返回安全组件实例
        return authorizingRealm;
    }

    /**
     * 配置redis管理器
     * @return
     */
    @Bean
    public RedisManager redisManager(RedisConfig redisConfig) {
        //新建redis管理器实例
        RedisManager redisManager = new RedisManager();
        //注入redis连接属性
        redisManager.setHost(redisConfig.getHost());
        redisManager.setPort(redisConfig.getPort());
        redisManager.setPassword(redisConfig.getPassword());
        redisManager.setTimeout(redisConfig.getTimeout());
        redisManager.setExpire(redisConfig.getExpire());
        //返回redis管理器
        return redisManager;
    }

    /**
     * 配置redis数据库访问层插件
     * @return
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        //新建redis数据库访问层插件实例
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        //注入redis管理器
        redisSessionDAO.setRedisManager(redisManager);
        //返回
        return redisSessionDAO;
    }

    /**
     * 配置缓存管理器
     * @param redisManager
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisManager redisManager) {
        //新建缓存管理器实例
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        //注入redis管理器
        redisCacheManager.setRedisManager(redisManager);
        //返回
        return redisCacheManager;
    }

    /**
     * 配置session管理器
     * @return
     */
    @Bean
    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
        //新建session管理器实例
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //注入redis数据库访问插件
        sessionManager.setSessionDAO(redisSessionDAO);
        //返回
        return sessionManager;
    }

    /**
     * 配置安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(SessionManager sessionManager, CacheManager cacheManager) {
        //新建安全管理器实例
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //注入安全组件
        securityManager.setRealm(authorizingRealm());
        //注入session管理器
        securityManager.setSessionManager(sessionManager);
        //注入缓存管理器
        securityManager.setCacheManager(cacheManager);
        //返回
        return securityManager;
    }

    /**
     * 开启shiro对aop注解的支持
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 开启权限注解
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }
}
