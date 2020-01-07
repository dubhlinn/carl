package cn.monolog.dubhlinn.carl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模型——用户
 * @author dubhlinn
 * @date 2020-01-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    /*
     * 主键
     */
    private int id;

    /*
     * 用户名
     */
    private String username;

    /*
     * 密码
     */
    private String password;

    /*
     * 真实姓名
     */
    private String realName;
}