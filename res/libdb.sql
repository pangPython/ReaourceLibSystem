/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : libdb

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-09-27 15:11:32
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
  `area_name` varchar(50) NOT NULL,
  `area_type` int(20) NOT NULL COMMENT '使用0代表市,1代表县区',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '东营市', '0');
INSERT INTO `area` VALUES ('2', '东营区', '1');
INSERT INTO `area` VALUES ('3', ' 河口区', '1');
INSERT INTO `area` VALUES ('4', '广饶县', '1');
INSERT INTO `area` VALUES ('5', ' 垦利县', '1');
INSERT INTO `area` VALUES ('6', '利津县', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of degree
-- ----------------------------
INSERT INTO `degree` VALUES ('1', '学士');
INSERT INTO `degree` VALUES ('2', '硕士');
INSERT INTO `degree` VALUES ('3', ' 博士');

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
INSERT INTO `edu` VALUES ('0', ' 小学');
INSERT INTO `edu` VALUES ('1', ' 初中');
INSERT INTO `edu` VALUES ('2', ' 中专');
INSERT INTO `edu` VALUES ('3', ' 高中');
INSERT INTO `edu` VALUES ('4', ' 专科');
INSERT INTO `edu` VALUES ('5', ' 本科');
INSERT INTO `edu` VALUES ('6', ' 硕士研究生');
INSERT INTO `edu` VALUES ('7', ' 博士研究生');

-- ----------------------------
-- Table structure for `mz`
-- ----------------------------
DROP TABLE IF EXISTS `mz`;
CREATE TABLE `mz` (
  `mz_id` int(11) NOT NULL AUTO_INCREMENT,
  `mzname` varchar(20) NOT NULL,
  PRIMARY KEY (`mz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mz
-- ----------------------------
INSERT INTO `mz` VALUES ('1', '汉族');
INSERT INTO `mz` VALUES ('2', '蒙古族');
INSERT INTO `mz` VALUES ('3', '回族');
INSERT INTO `mz` VALUES ('4', '藏族');
INSERT INTO `mz` VALUES ('5', '维吾尔族');
INSERT INTO `mz` VALUES ('6', '苗族');
INSERT INTO `mz` VALUES ('7', '彝族');
INSERT INTO `mz` VALUES ('8', '壮族');
INSERT INTO `mz` VALUES ('9', '布依族');
INSERT INTO `mz` VALUES ('10', '朝鲜族');
INSERT INTO `mz` VALUES ('11', '满族');
INSERT INTO `mz` VALUES ('12', '侗族');
INSERT INTO `mz` VALUES ('13', '瑶族');
INSERT INTO `mz` VALUES ('14', '白族');
INSERT INTO `mz` VALUES ('15', '土家族');
INSERT INTO `mz` VALUES ('16', '哈尼族');
INSERT INTO `mz` VALUES ('17', '哈萨克族');
INSERT INTO `mz` VALUES ('18', '傣族');
INSERT INTO `mz` VALUES ('19', '黎族');
INSERT INTO `mz` VALUES ('20', '傈僳族');
INSERT INTO `mz` VALUES ('21', '佤族');
INSERT INTO `mz` VALUES ('22', '畲族');
INSERT INTO `mz` VALUES ('23', '高山族');
INSERT INTO `mz` VALUES ('24', '拉祜族');
INSERT INTO `mz` VALUES ('25', '水族');
INSERT INTO `mz` VALUES ('26', '东乡族');
INSERT INTO `mz` VALUES ('27', '纳西族');
INSERT INTO `mz` VALUES ('28', '景颇族');
INSERT INTO `mz` VALUES ('29', '柯尔克孜族');
INSERT INTO `mz` VALUES ('30', '土族');
INSERT INTO `mz` VALUES ('31', '达斡尔族');
INSERT INTO `mz` VALUES ('32', '仫佬族');
INSERT INTO `mz` VALUES ('33', '羌族');
INSERT INTO `mz` VALUES ('34', ' 布朗族');
INSERT INTO `mz` VALUES ('35', ' 撒拉族');
INSERT INTO `mz` VALUES ('36', ' 毛难族');
INSERT INTO `mz` VALUES ('37', ' 仡佬族');
INSERT INTO `mz` VALUES ('38', ' 锡伯族');
INSERT INTO `mz` VALUES ('39', ' 阿昌族');
INSERT INTO `mz` VALUES ('40', ' 普米族');
INSERT INTO `mz` VALUES ('41', ' 塔吉克族');
INSERT INTO `mz` VALUES ('42', ' 怒族');
INSERT INTO `mz` VALUES ('43', ' 乌孜别克族');
INSERT INTO `mz` VALUES ('44', ' 俄罗斯族');
INSERT INTO `mz` VALUES ('45', ' 鄂温克族');
INSERT INTO `mz` VALUES ('46', ' 崩龙族');
INSERT INTO `mz` VALUES ('47', ' 保安族');
INSERT INTO `mz` VALUES ('48', ' 裕固族');
INSERT INTO `mz` VALUES ('49', ' 京族');
INSERT INTO `mz` VALUES ('50', ' 塔塔尔族');
INSERT INTO `mz` VALUES ('51', ' 独龙族');
INSERT INTO `mz` VALUES ('52', ' 鄂伦春族');
INSERT INTO `mz` VALUES ('53', ' 赫哲族');
INSERT INTO `mz` VALUES ('54', ' 门巴族');
INSERT INTO `mz` VALUES ('55', ' 珞巴族');
INSERT INTO `mz` VALUES ('56', ' 基诺族');
INSERT INTO `mz` VALUES ('57', ' 其他');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zzmm
-- ----------------------------
INSERT INTO `zzmm` VALUES ('1', '中共党员');
INSERT INTO `zzmm` VALUES ('2', ' 中共预备党员');
INSERT INTO `zzmm` VALUES ('3', ' 共青团员');
INSERT INTO `zzmm` VALUES ('4', ' 民革党员');
INSERT INTO `zzmm` VALUES ('5', ' 民盟盟员');
INSERT INTO `zzmm` VALUES ('6', ' 民建会员');
INSERT INTO `zzmm` VALUES ('7', ' 民进会员');
INSERT INTO `zzmm` VALUES ('8', ' 农工党党员');
INSERT INTO `zzmm` VALUES ('9', ' 致公党党员');
INSERT INTO `zzmm` VALUES ('10', ' 九三学社社员');
INSERT INTO `zzmm` VALUES ('11', ' 台盟盟员');
INSERT INTO `zzmm` VALUES ('12', ' 无党派民族人士');
INSERT INTO `zzmm` VALUES ('13', ' 普通公民(群众)');
