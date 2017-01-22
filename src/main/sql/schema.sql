-- 连接数据库控制台
-- mysql -uroot -p123456

USE test;
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id`           INT(10) NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(30)      DEFAULT NULL,
  `opreate_time` DATETIME         DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = 'SSM测试Demo表';

-- 手写ddl，记录每次sql修改
