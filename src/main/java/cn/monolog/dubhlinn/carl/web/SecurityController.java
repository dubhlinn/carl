package cn.monolog.dubhlinn.carl.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层组件
 * 安全模块
 * @author dubhlinn
 * @date 2020-01-07
 */
@RestController(value = "/security")
public class SecurityController {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    public String login(String username, String password) {
        //构建token
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        //获取认证主体
        Subject subject = SecurityUtils.getSubject();

        //执行登录
        try {
            subject.login(token);
            return "登录成功";
        } catch (AuthenticationException authenticationException) {
            return "登录失败";
        }
    }

    /**
     * 未登录提示
     * @return
     */
    @GetMapping("/unauthentic")
    public String unauthentic() {
        return "请登录";
    }
}
