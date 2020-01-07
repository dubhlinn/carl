package cn.monolog.dubhlinn.carl.security;

import cn.monolog.dubhlinn.carl.constant.SecurityConstant;
import cn.monolog.dubhlinn.carl.model.User;
import cn.monolog.dubhlinn.carl.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义安全组件
 * @author dubhlinn
 * @date 2020-01-06
 */
public class CustomedRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从token中获取用户名
        String username = (String) token.getPrincipal();

        //根据用户名查询用户
        User user = this.userService.getByUsername(username);

        //判空
        if (user == null) {
            return null;
        }

        //认证
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
            username,
            user.getPassword(),
            ByteSource.Util.bytes(username),
            this.getName()
        );

        //将用户信息保存到session中
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SecurityConstant.USER_KEY, user);

        //返回认证信息
        return authenticationInfo;
    }
}
