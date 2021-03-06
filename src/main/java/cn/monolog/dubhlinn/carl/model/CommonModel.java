package cn.monolog.dubhlinn.carl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有模型类的基类
 * @author dubhlinn
 * @date 2020-01-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonModel implements Serializable {
    /**
     * 逻辑删除标识
     * 0-未删除，1-已删除
     */
    private int isDelete;

    /**
     * 创建时间
     * 格式为 yyyy-MM-dd HH:mm:ss
     */
    private Date createTime;
}
