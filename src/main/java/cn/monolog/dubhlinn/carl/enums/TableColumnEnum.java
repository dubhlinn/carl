package cn.monolog.dubhlinn.carl.enums;

/**
 * 表字段枚举
 * @author dubhlinn
 * @date 2020-01-06
 */
public enum TableColumnEnum {

    /**
     * 枚举项
     */
    USERNAME("username", "用户名"),
    IS_DELETE("is_delete", "逻辑删除标识");

    /*
     * 字段名
     */
    private String columnName;

    /*
     * 描述
     */
    private String description;

    /**
     * 构造方法
     * @param columnName
     * @param description
     */
    TableColumnEnum(String columnName, String description) {
        this.columnName = columnName;
        this.description = description;
    }

    /**
     * getter and setters
     * @return
     */
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
