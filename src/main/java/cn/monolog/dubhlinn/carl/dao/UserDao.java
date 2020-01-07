package cn.monolog.dubhlinn.carl.dao;

import cn.monolog.dubhlinn.carl.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 数据库访问层组件
 * 用户模块
 * @author dubhlinn
 * @date 2020-01-06
 */
@Repository
public interface UserDao extends BaseMapper<User> {
}
