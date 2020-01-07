package cn.monolog.dubhlinn.carl.enums;

/**
 * 逻辑删除标识枚举
 * @author dubhlinn
 * @date 2020-01-06
 */
public enum DeleteFlagEnum {
    /**
     * 枚举项
     */
    NO(0, "未删除"),
    YES(1, "已删除");

    /*
     * 值
     */
    private int code;

    /*
     * 描述
     */
    private String description;

    /**
     * 构造方法
     * @param code
     * @param description
     */
    DeleteFlagEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * getter and setters
     * @return
     */
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
