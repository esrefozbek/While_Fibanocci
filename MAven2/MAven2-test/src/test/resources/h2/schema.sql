CREATE TABLE `junit_demo`
(
    `ID`         bigint                          NOT NULL AUTO_INCREMENT COMMENT '主键',
    `ID_CODE`    varchar(32) NOT NULL COMMENT '主键-系统间交互使用',
    `GMT_CREATE` timestamp                       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `GMT_MODIFY` timestamp                       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `UNI_ID_CODE` (`ID_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=1;