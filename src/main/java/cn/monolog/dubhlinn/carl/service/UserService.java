package cn.monolog.dubhlinn.carl.service;

import cn.monolog.dubhlinn.carl.model.User;

/**
 * 业务逻辑层接口
 * 用户模块
 * @author dubhlinn
 * @date 2020-01-06
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getByUsername(String username);
}
