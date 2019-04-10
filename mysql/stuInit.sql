/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Host           : localhost:3306
Source Database       : stu

Date: 2019-4-9
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` int(7) NOT NULL ,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8888888', '123456','学生');
INSERT INTO `user` VALUES ('8888889', '123456','学生');
INSERT INTO `user` VALUES ('8888890', '123456','学生');
INSERT INTO `user` VALUES ('8888891', '123456','学生');
INSERT INTO `user` VALUES ('16012', '123456', '教师');
INSERT INTO `user` VALUES ('16358', '123456', '教师');
INSERT INTO `user` VALUES ('15985', '123456', '教师');
INSERT INTO `user` VALUES ('10603', '123456', '教师');

-- ----------------------------
-- Table structure for `stuAll`
-- ----------------------------
DROP TABLE IF EXISTS `stuAll`;
CREATE TABLE `stuAll` (
  `id` int(7) NOT NULL ,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `school` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stuAll
-- ----------------------------
INSERT INTO `stuAll` VALUES ('8888888', '刘一', '电子与信息工程学院');
INSERT INTO `stuAll` VALUES ('8888889', '王二', '汽车学院');
INSERT INTO `stuAll` VALUES ('8888890', '张三', '建筑与城市规划学院');
INSERT INTO `stuAll` VALUES ('8888891', '李四', '电子与信息工程学院');


-- ----------------------------
-- Table structure for `teaAll`
-- ----------------------------
DROP TABLE IF EXISTS `teaAll`;
CREATE TABLE `teaAll` (
  `id` int(5) NOT NULL ,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `school` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of teaAll
-- ----------------------------
INSERT INTO `teaAll` VALUES ('16012', '赵一', '电子与信息工程学院');
INSERT INTO `teaAll` VALUES ('16358', '马二', '汽车学院');
INSERT INTO `teaAll` VALUES ('15985', '于三', '建筑与城市规划学院');
INSERT INTO `teaAll` VALUES ('10603', '郭四', '电子与信息工程学院');

-- ----------------------------
-- Table structure for `classAll`
-- ----------------------------
DROP TABLE IF EXISTS `classAll`;
CREATE TABLE `classAll` (
  `classid` int(8) NOT NULL ,
  `classname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `teacherid` int(5) NOT NULL,
  `teachername` varchar(50) NOT NULL,
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of classAll
-- ----------------------------
INSERT INTO `classAll` VALUES ('12345678','数据结构','16012', '赵一');
INSERT INTO `classAll` VALUES ('12345679','数据分析','16012', '赵一');
INSERT INTO `classAll` VALUES ('98745632','程序设计','10603', '郭四');
INSERT INTO `classAll` VALUES ('56321489','算法','15985', '于三');

-- ----------------------------
-- Table structure for `classSin`
-- ----------------------------
DROP TABLE IF EXISTS `c12345678`;
CREATE TABLE `c12345678` (
  `classname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `teacherid` int(5) NOT NULL,
  `teachername` varchar(50) NOT NULL,
  `stuid` int(7) NOT NULL ,
  `stuname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `school` varchar(100) NOT NULL,
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c12345678
-- ----------------------------
INSERT INTO `c12345678` VALUES ('数据结构','16012', '赵一','8888888','刘一','电子与信息工程学院');
