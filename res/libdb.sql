/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : libdb

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-09-27 08:53:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(20) NOT NULL,
  `adminpassword` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_1` varchar(20) NOT NULL,
  `jibie` varchar(20) NOT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '河口区', '县/区');

-- ----------------------------
-- Table structure for `country_user`
-- ----------------------------
DROP TABLE IF EXISTS `country_user`;
CREATE TABLE `country_user` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` varchar(20) NOT NULL,
  `countrypassword` varchar(20) NOT NULL,
  `area_id` int(10) NOT NULL,
  `jibie` varchar(10) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country_user
-- ----------------------------
INSERT INTO `country_user` VALUES ('1', '王长官', '123456', '1', '县/区');

-- ----------------------------
-- Table structure for `declare_type`
-- ----------------------------
DROP TABLE IF EXISTS `declare_type`;
CREATE TABLE `declare_type` (
  `dec_id` int(11) NOT NULL AUTO_INCREMENT,
  `decname` varchar(20) NOT NULL,
  PRIMARY KEY (`dec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of declare_type
-- ----------------------------
INSERT INTO `declare_type` VALUES ('1', '音乐');
INSERT INTO `declare_type` VALUES ('2', '舞蹈');
INSERT INTO `declare_type` VALUES ('3', '戏剧曲艺');
INSERT INTO `declare_type` VALUES ('4', '朗诵主持');
INSERT INTO `declare_type` VALUES ('5', ' 文学创作');
INSERT INTO `declare_type` VALUES ('6', ' 书画');
INSERT INTO `declare_type` VALUES ('7', ' 摄影');
INSERT INTO `declare_type` VALUES ('8', ' 杂技');
INSERT INTO `declare_type` VALUES ('9', ' 民间文艺');
INSERT INTO `declare_type` VALUES ('10', '电影电视');

-- ----------------------------
-- Table structure for `degree`
-- ----------------------------
DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree` (
  `degree_id` int(11) NOT NULL AUTO_INCREMENT,
  `degreename` varchar(20) NOT NULL,
  PRIMARY KEY (`degree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of degree
-- ----------------------------

-- ----------------------------
-- Table structure for `edu`
-- ----------------------------
DROP TABLE IF EXISTS `edu`;
CREATE TABLE `edu` (
  `edu_id` int(11) NOT NULL,
  `eduname` varchar(20) NOT NULL,
  PRIMARY KEY (`edu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu
-- ----------------------------

-- ----------------------------
-- Table structure for `mz`
-- ----------------------------
DROP TABLE IF EXISTS `mz`;
CREATE TABLE `mz` (
  `mz_id` int(11) NOT NULL AUTO_INCREMENT,
  `mzname` varchar(20) NOT NULL,
  PRIMARY KEY (`mz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mz
-- ----------------------------

-- ----------------------------
-- Table structure for `system`
-- ----------------------------
DROP TABLE IF EXISTS `system`;
CREATE TABLE `system` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system
-- ----------------------------
INSERT INTO `system` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `uploads`
-- ----------------------------
DROP TABLE IF EXISTS `uploads`;
CREATE TABLE `uploads` (
  `upload_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `add` varchar(30) NOT NULL,
  PRIMARY KEY (`upload_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uploads
-- ----------------------------
INSERT INTO `uploads` VALUES ('1', '视频', 'D:\\1汇佳');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `age` int(255) NOT NULL,
  `art_type` int(255) NOT NULL,
  `password` varchar(20) NOT NULL,
  `dec_id` int(11) NOT NULL,
  `sbdate` varchar(30) NOT NULL,
  `usersex` int(11) NOT NULL,
  `mz_id` int(10) NOT NULL,
  `zzmm_id` int(10) NOT NULL,
  `degree_id` int(11) DEFAULT NULL,
  `edu_id` int(11) DEFAULT NULL,
  `gzdate` varchar(30) NOT NULL,
  `person` varchar(50) NOT NULL,
  `card` varchar(25) NOT NULL,
  `area_id` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `company` varchar(20) NOT NULL,
  `tc` varchar(20) NOT NULL,
  `zywork` varchar(20) NOT NULL,
  `ysjj` varchar(50) NOT NULL,
  `status` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '22', '0', '12345', '1', '123213', '1', '1', '1', '0', '0', '工作时间', '个人信息', '身份证', '1', '家庭住址', '工作单位信息', '特长', '主要工作', '艺术简介', '0');
INSERT INTO `user` VALUES ('2', '李华', '15', '0', '111111', '2', '122323', '0', '0', '0', '1', '1', '31231231', '是否发生大幅度', '21313213123', '1', '234234', '水电费是否', '萨芬的', '萨芬的', '啥地方都是', '0');
INSERT INTO `user` VALUES ('3', '王五', '65', '0', '123456', '1', '11', '1', '1', '1', '0', '0', '111', '111', '111', '1', '11111', '1111', '111', '111', '111', '0');
INSERT INTO `user` VALUES ('4', '赵四', '22', '0', '000000', '2', '131231', '1', '11', '111', '1', '3', '123', '13', '123', '123', '12', '123', '1234', '12321', '1231', '0');
INSERT INTO `user` VALUES ('5', '花花', '17', '0', '111111', '1', '', '0', '0', '0', '0', '1', '111111', '区1', '123213', '11', '123123', '123123', '123123', '12321', '32123', '0');
INSERT INTO `user` VALUES ('6', '二和', '18', '0', '101010', '1', '1111', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `user` VALUES ('7', '庞勇', '18', '0', '12333', '111', '111', '1', '1', '1', '1', '1', '1', '', '', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `user` VALUES ('8', '黑黑', '25', '0', 'admin', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `user` VALUES ('9', '于丽', '33', '0', '123', '11', '1', '0', '23', '3', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '0');
INSERT INTO `user` VALUES ('10', '常和', '19', '0', '111', '111', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `user` VALUES ('11', '李白', '20', '0', '12345678', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `user` VALUES ('12', '薛之谦', '20', '0', '123456', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `user` VALUES ('13', '周杰伦', '20', '0', '54321', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for `zzmm`
-- ----------------------------
DROP TABLE IF EXISTS `zzmm`;
CREATE TABLE `zzmm` (
  `zzmm_id` int(11) NOT NULL AUTO_INCREMENT,
  `zzmmname` varchar(20) NOT NULL,
  PRIMARY KEY (`zzmm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zzmm
-- ----------------------------
INSERT INTO `zzmm` VALUES ('1', '团员');
