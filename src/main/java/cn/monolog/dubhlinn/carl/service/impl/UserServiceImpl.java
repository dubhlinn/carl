package cn.monolog.dubhlinn.carl.service.impl;

import cn.monolog.dubhlinn.carl.dao.UserDao;
import cn.monolog.dubhlinn.carl.enums.DeleteFlagEnum;
import cn.monolog.dubhlinn.carl.enums.TableColumnEnum;
import cn.monolog.dubhlinn.carl.model.User;
import cn.monolog.dubhlinn.carl.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务逻辑层组件
 * @author dubhlinn
 * @date 2020-01-06
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 自动装配
     */
    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public User getByUsername(String username) {
        //构造查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(TableColumnEnum.USERNAME.getColumnName(), username);
        queryWrapper.eq(TableColumnEnum.IS_DELETE.getColumnName(), DeleteFlagEnum.NO.getCode());

        //查询用户
        User user = this.userDao.selectOne(queryWrapper);

        //返回用户实例
        return user;
    }
}
