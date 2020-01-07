-- 新建数据库
DROP D
CREATE DATABASE `carl`;

-- 新建用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `carl`.`user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增长',
  `username` varchar(20) NOT NULL COMMENT '用户名，唯一',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `real_name` varchar(10) NULL COMMENT '真实姓名',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除标识，0-未删除，1-已删除'
  PRIMARY KEY (`id`)
);

-- 用户表加索引
ALTER TABLE `carl`.`user`
ADD UNIQUE INDEX `idx1`(`username`) USING BTREE COMMENT '关于用户名的唯一索引';

-- 向用户表中插入数据
INSERT INTO `carl`.`user`
(`username`, `password`, `real_name`)
VALUES
('zhangsan', '654407ac2e454fe560337510aa6adb97', '张三'),
('lisi', '42bd4e7685cb11d3ba02716c313cb04b', '李四'),
('wangwu', '4d6a8546c786edaed7ec4858bee8975c', '王五'),
('zhaoliu', 'a33005a4ff1f4890efaee6f754259839', '赵六'),
('jiangqi', '8ddfdbe468c978fa38de976b2dff322f', '蒋七'),
('wangba', 'f17ebd3344649c4ca33eceee27780b05', '王八'),
('cuijiu', 'b0af5a7f63535e446f99dae6fe535186', '崔九');