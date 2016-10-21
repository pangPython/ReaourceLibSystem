/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : libdb

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-10-21 11:03:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `type` int(10) NOT NULL DEFAULT '1',
  `telephone` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `status` int(10) NOT NULL,
  `area_id` int(255) NOT NULL,
  `auth` int(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `adminname` (`name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '4501195721962DCDADBFC33F8C0DD6E3', 'admin@qq.com', '0', '', '2016-10-12 15:13:12', '1', '0', '0');
INSERT INTO `admin` VALUES ('2', 'test', 'AA410543E9D4E202A4F7389FEDA883BE', '123973173@qq.com', '1', '15757575757', '2016-10-16 20:31:35', '1', '0', '1');
INSERT INTO `admin` VALUES ('3', 'test2', 'F040A579C756C49FCF84588246A9D102', '123973173@qq.com', '0', '15757575757', '2016-10-16 20:33:10', '1', '0', '0');
INSERT INTO `admin` VALUES ('4', 'test3', '7C7F0CAC0FC15349D7E4211935EB555C', '1111@qq.com', '0', '15761211111', '2016-10-17 08:12:26', '1', '0', '1');
INSERT INTO `admin` VALUES ('5', 'test11', '33E59BE11652DE5FF2DFA83FEF7AA0C0', '123973173@qq.com', '1', '15757575757', '2016-10-17 08:31:54', '1', '1', '1');

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
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '0:0:0:0:0:0:0:1', 'admin', '2016-10-16 20:29:23');
INSERT INTO `log` VALUES ('2', '127.0.0.1', 'admin', '2016-10-16 20:30:23');
INSERT INTO `log` VALUES ('3', '192.168.1.100', 'admin', '2016-10-16 20:31:01');
INSERT INTO `log` VALUES ('4', '192.168.1.100', 'admin', '2016-10-16 20:32:46');
INSERT INTO `log` VALUES ('5', '192.168.1.100', 'admin', '2016-10-16 20:36:04');
INSERT INTO `log` VALUES ('6', '192.168.1.100', 'admin', '2016-10-16 22:24:11');
INSERT INTO `log` VALUES ('7', '192.168.1.100', 'admin', '2016-10-16 22:54:25');
INSERT INTO `log` VALUES ('8', '192.168.1.100', 'admin', '2016-10-16 23:19:42');
INSERT INTO `log` VALUES ('9', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 08:11:49');
INSERT INTO `log` VALUES ('10', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 08:31:29');
INSERT INTO `log` VALUES ('11', '0:0:0:0:0:0:0:1', 'test11', '2016-10-17 08:32:09');
INSERT INTO `log` VALUES ('12', '0:0:0:0:0:0:0:1', 'test11', '2016-10-17 08:34:17');
INSERT INTO `log` VALUES ('13', '0:0:0:0:0:0:0:1', 'test11', '2016-10-17 08:34:55');
INSERT INTO `log` VALUES ('14', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 09:04:46');
INSERT INTO `log` VALUES ('15', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 09:57:43');
INSERT INTO `log` VALUES ('16', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 10:21:57');
INSERT INTO `log` VALUES ('17', '0:0:0:0:0:0:0:1', 'test11', '2016-10-17 10:23:25');
INSERT INTO `log` VALUES ('18', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 11:23:03');
INSERT INTO `log` VALUES ('19', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 13:46:26');
INSERT INTO `log` VALUES ('20', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 14:08:42');
INSERT INTO `log` VALUES ('21', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 14:49:19');
INSERT INTO `log` VALUES ('22', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 15:32:49');
INSERT INTO `log` VALUES ('23', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 15:44:54');
INSERT INTO `log` VALUES ('24', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 16:17:13');
INSERT INTO `log` VALUES ('25', '0:0:0:0:0:0:0:1', 'admin', '2016-10-17 16:32:29');
INSERT INTO `log` VALUES ('26', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 16:47:59');
INSERT INTO `log` VALUES ('27', '0:0:0:0:0:0:0:1', 'test11', '2016-10-18 17:27:57');
INSERT INTO `log` VALUES ('28', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 19:08:44');
INSERT INTO `log` VALUES ('29', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 19:13:21');
INSERT INTO `log` VALUES ('30', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 20:14:01');
INSERT INTO `log` VALUES ('31', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 20:28:00');
INSERT INTO `log` VALUES ('32', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 20:32:20');
INSERT INTO `log` VALUES ('33', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 21:03:52');
INSERT INTO `log` VALUES ('34', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 21:04:05');
INSERT INTO `log` VALUES ('35', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 22:12:52');
INSERT INTO `log` VALUES ('36', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 22:20:30');
INSERT INTO `log` VALUES ('37', '0:0:0:0:0:0:0:1', 'admin', '2016-10-18 23:00:40');
INSERT INTO `log` VALUES ('38', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 08:03:08');
INSERT INTO `log` VALUES ('39', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 10:33:24');
INSERT INTO `log` VALUES ('40', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 10:48:44');
INSERT INTO `log` VALUES ('41', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 10:59:53');
INSERT INTO `log` VALUES ('42', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 11:02:46');
INSERT INTO `log` VALUES ('43', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 11:13:07');
INSERT INTO `log` VALUES ('44', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 12:46:56');
INSERT INTO `log` VALUES ('45', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 12:57:52');
INSERT INTO `log` VALUES ('46', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 13:56:47');
INSERT INTO `log` VALUES ('47', '0:0:0:0:0:0:0:1', 'test11', '2016-10-19 14:01:25');
INSERT INTO `log` VALUES ('48', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 14:07:17');
INSERT INTO `log` VALUES ('49', '0:0:0:0:0:0:0:1', 'admin', '2016-10-19 14:32:34');
INSERT INTO `log` VALUES ('50', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 16:53:58');
INSERT INTO `log` VALUES ('51', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 17:10:27');
INSERT INTO `log` VALUES ('52', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 17:26:29');
INSERT INTO `log` VALUES ('53', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 19:02:09');
INSERT INTO `log` VALUES ('54', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 19:38:17');
INSERT INTO `log` VALUES ('55', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 19:48:52');
INSERT INTO `log` VALUES ('56', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 19:59:19');
INSERT INTO `log` VALUES ('57', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 20:10:59');
INSERT INTO `log` VALUES ('58', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 20:21:26');
INSERT INTO `log` VALUES ('59', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 20:40:01');
INSERT INTO `log` VALUES ('60', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 20:50:33');
INSERT INTO `log` VALUES ('61', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 21:00:57');
INSERT INTO `log` VALUES ('62', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 21:16:06');
INSERT INTO `log` VALUES ('63', '0:0:0:0:0:0:0:1', 'admin', '2016-10-20 21:24:59');
INSERT INTO `log` VALUES ('64', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 08:22:03');
INSERT INTO `log` VALUES ('65', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 08:35:42');
INSERT INTO `log` VALUES ('66', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 09:13:04');
INSERT INTO `log` VALUES ('67', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 09:35:17');
INSERT INTO `log` VALUES ('68', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 09:52:56');
INSERT INTO `log` VALUES ('69', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 10:03:12');
INSERT INTO `log` VALUES ('70', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 10:13:58');
INSERT INTO `log` VALUES ('71', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 10:36:37');
INSERT INTO `log` VALUES ('72', '0:0:0:0:0:0:0:1', 'admin', '2016-10-21 11:00:26');

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
  `title` varchar(255) DEFAULT NULL,
  `keywords` text,
  `description` text,
  `copyright` varchar(255) DEFAULT NULL,
  `record` varchar(255) DEFAULT NULL,
  `statistics_code` text,
  `open` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system
-- ----------------------------
INSERT INTO `system` VALUES ('1', '东营市社会文艺人才信息资源库', '关键词设置2', '网站描述设置', '山东汇佳软件科技有限公司版权所有', '鲁ICP备00000000001号', ' 统计代码设置', '0');

-- ----------------------------
-- Table structure for `uploads`
-- ----------------------------
DROP TABLE IF EXISTS `uploads`;
CREATE TABLE `uploads` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NOT NULL,
  `type` varchar(100) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uploads
-- ----------------------------
INSERT INTO `uploads` VALUES ('1', '37', '1', '20160822020450_207881.png', '2016-10-16 12:37:05', null);
INSERT INTO `uploads` VALUES ('2', '37', '1', '20160822020450_207882.png', '2016-10-16 13:36:51', null);
INSERT INTO `uploads` VALUES ('3', '37', '1', '20160822020450_207884.png', '2016-10-17 13:47:06', null);
INSERT INTO `uploads` VALUES ('4', '37', '1', '20160822020450_207885.png', '2016-10-17 16:37:35', null);
INSERT INTO `uploads` VALUES ('5', '47', '1', '20130201170240514529.jpg', '2016-10-19 12:18:50', null);
INSERT INTO `uploads` VALUES ('6', '47', '1', '201302011702405145291.jpg', '2016-10-19 12:20:17', null);
INSERT INTO `uploads` VALUES ('7', '47', '1', '201302011702405145292.jpg', '2016-10-19 12:20:38', null);

-- ----------------------------
-- Table structure for `upload_audio`
-- ----------------------------
DROP TABLE IF EXISTS `upload_audio`;
CREATE TABLE `upload_audio` (
  `id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload_audio
-- ----------------------------

-- ----------------------------
-- Table structure for `upload_photo`
-- ----------------------------
DROP TABLE IF EXISTS `upload_photo`;
CREATE TABLE `upload_photo` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload_photo
-- ----------------------------
INSERT INTO `upload_photo` VALUES ('2', '47', '1111111', '11111', '11111');
INSERT INTO `upload_photo` VALUES ('1', '47', '22222', '22222', '22222');
INSERT INTO `upload_photo` VALUES ('3', '47', '201302011702405145293.jpg', '2016-10-19 12:26:15', '庞勇');
INSERT INTO `upload_photo` VALUES ('4', '47', '649830154.jpg', '2016-10-19 12:28:00', '庞勇');

-- ----------------------------
-- Table structure for `upload_video`
-- ----------------------------
DROP TABLE IF EXISTS `upload_video`;
CREATE TABLE `upload_video` (
  `id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload_video
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `true_name` varchar(255) DEFAULT NULL,
  `age` int(255) unsigned zerofill DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `dec_id` int(11) unsigned zerofill DEFAULT NULL,
  `join_work` varchar(30) DEFAULT NULL,
  `usersex` int(11) unsigned zerofill DEFAULT NULL,
  `mz_id` int(10) unsigned zerofill DEFAULT NULL,
  `zzmm_id` int(10) unsigned zerofill DEFAULT NULL,
  `degree_id` int(11) unsigned zerofill DEFAULT NULL,
  `edu_id` int(11) unsigned zerofill DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL,
  `area_id` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `edu__full_time` int(10) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `specialty` varchar(255) DEFAULT NULL,
  `zywork` varchar(20) DEFAULT NULL,
  `ysjj` varchar(255) DEFAULT NULL,
  `health` varchar(255) DEFAULT NULL,
  `reg_date` varchar(255) NOT NULL,
  `status` int(10) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `photo_path` varchar(255) DEFAULT NULL,
  `technical_position` varchar(255) DEFAULT NULL,
  `degree_full_time` int(10) unsigned zerofill DEFAULT NULL,
  `company_tel` varchar(255) DEFAULT NULL,
  `socio_part_time` varchar(255) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `awards` varchar(255) DEFAULT NULL,
  `opinion` varchar(255) DEFAULT NULL,
  `business_achievement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`uname`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('31', 'py', '张三', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', '5D23494D3D93A7EF5BDA2FCE1091C7A4', '00000000001', '111', '00000000001', '0000000018', '0000000001', '00000000001', '00000000000', '372321199999999999', '1', '山东省东营市', null, '山东汇佳', '唱歌舞蹈', null, '呵呵呵呵呵', '健康', '2016-10-08 16:05:55', '1', '11111', 'defaultheadpic.jpg', '青年志愿者', null, '8086998', '社会兼职', '15762188888', '表演一等奖', '希望申请通过', '销售实习');
INSERT INTO `user` VALUES ('33', 'pangyong', '张三', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', '7B7047748C146671550A41036E2333EC', '00000000002', '111', '00000000000', '0000000006', '0000000004', '00000000003', '00000000000', '372321199999999999', '0', '山东省东营市', null, '山东汇佳', '唱歌舞蹈', null, '中央戏剧表演', '健康', '2016-10-11 08:24:51', '1', '1111', 'defaultheadpic.jpg', '红年志愿者', null, '8086998', '社会兼职', '15762188888', ' 表演二等奖', '希望申请通过', '销售实习');
INSERT INTO `user` VALUES ('35', '汇佳软件', '张三3', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', '9A42B2FDE562AD64942EE3058498251D', '00000000001', '111', '00000000001', '0000000001', '0000000001', '00000000001', '00000000000', '372321199999999999', '1', '山东省东营市', null, '山东汇佳', '唱歌舞蹈', null, '艺术简介艺术简介', '健康', '2016-10-11 08:29:21', '1', '1111', 'defaultheadpic.jpg', '中年志愿者', null, '8086998', '社会兼职', '15762188888', '表演三等奖', '希望申请通过', '销售实习');
INSERT INTO `user` VALUES ('36', '山东汇佳软件', '张三4', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', '3501B4E771BA5C7A744E8B6E8CEF916E', '00000000001', '111', '00000000001', '0000000001', '0000000001', '00000000001', '00000000000', '372321199999999999', '1', '山东省东营市', null, '山东汇佳', '唱歌舞蹈', null, '艺术简介艺术简介', '健康', '2016-10-11 15:45:06', '1', '1111', 'defaultheadpic.jpg', '老年志愿者', null, '8086998', '社会兼职', '15762188888', ' 表演四等奖', '希望申请通过', '销售实习');
INSERT INTO `user` VALUES ('37', '张三5', '张三5', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', '4501195721962DCDADBFC33F8C0DD6E3', '00000000001', '111', '00000000000', '0000000001', '0000000001', '00000000001', '00000000000', '372321199999999999', '1', '山东省东营市', null, '山东汇佳', '唱歌舞蹈', null, '呵呵呵呵呵', '健康', '2016-10-12 15:13:12', '0', '1111', 'c908593ded2e3450cd6656e64b95526c.png', '青年志愿', null, '8086998', '社会兼职', '15762188888', ' 表演五等奖', '希望申请通过', '销售实习');
INSERT INTO `user` VALUES ('38', '庞勇', '张三6', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', '9D46A6083C6EBDDCFB898DAB58EAFD7F', '00000000001', '111', '00000000001', '0000000001', '0000000001', '00000000001', '00000000000', '372321199999999999', '1', '山东省东营市', null, '山东汇佳', '唱歌舞蹈', null, '艺术简介艺术简介', '健康', '2016-10-13 22:47:39', '0', '1111', 'defaultheadpic.jpg', '青年者远着', null, '8086998', '社会兼职', '15762188888', ' 表演特等奖', '希望申请通过', '销售实习');
INSERT INTO `user` VALUES ('39', 'admin', '张三7', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', '6E0F084E2078D7E28093027420CDD776', '00000000001', '111', '00000000000', '0000000006', '0000000004', '00000000002', '00000000000', '372321199999999999', '0', '山东省东营市', null, '山东汇佳', '唱歌舞蹈', null, ' 中国表演大学', '健康', '2016-10-14 09:49:17', '1', '1111', 'defaultheadpic.jpg', '志愿者', null, '8086998', '社会兼职', '15762188888', ' 表演奖', '希望申请通过', '销售实习');
INSERT INTO `user` VALUES ('40', '庞永', '张三8', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', 'DD015661785A22BDED41F84D206AF94E', '00000000003', '111', '00000000000', '0000000006', '0000000004', '00000000003', '00000000000', '372321199999999999', '0', '山东省东营市', null, '山东汇佳', '唱歌舞蹈', null, '中央戏剧学院', '健康', '2016-10-14 09:49:59', '1', '1111', 'defaultheadpic.jpg', ' 山区只教1111', null, '8086998', '社会兼职', '15762188888', ' 参与奖', '希望申请通过', '销售实习');
INSERT INTO `user` VALUES ('41', 'hjsoft', '李毅', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', 'D3D8CB79B6CF54CB37B49E9A33D64F7B', '00000000001', '111', '00000000001', '0000000001', '0000000001', '00000000001', '00000000000', '372321199999999999', '1', '山东省滨州市', null, '山东汇佳', '1111', null, '呵呵呵呵呵', '111', '2016-10-16 09:24:42', '0', '1111', 'defaultheadpic.jpg', '11111', null, '8086998', '社会兼职', null, null, null, null);
INSERT INTO `user` VALUES ('42', 'py1', '李毅', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', 'C8CDCB4D499B4586FD0204CAF0F02550', '00000000001', '111', '00000000001', '0000000001', '0000000001', '00000000001', '00000000000', '372321199999999999', '1', '山东省滨州市', null, '山东汇佳', null, null, '艺术简介', null, '2016-10-16 13:55:02', '0', null, null, null, null, '8088098', '兼职', '15762182222', '获奖情况', '申请意见', '业务成就');
INSERT INTO `user` VALUES ('43', 'py2', '庞勇', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022', '2CEAF68A3D72AC13E036C18334B0EFE6', '00000000001', '1111', '00000000001', '0000000001', '0000000001', '00000000001', '00000000000', '372321199999999999', '1', '山东省滨州市', null, '山东汇佳', '开发', null, '呵呵呵呵呵', '健康', '2016-10-16 15:13:52', '0', '1111', '20160822020450_207883.png', '计算机', null, '8088098', '兼职', '15762182222', '获奖情况', '申请意见', '业务成就');
INSERT INTO `user` VALUES ('47', 'huijia1', '庞勇', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000020', '87EA6E762AE0A8C9D325E6A006AE98B2', null, null, '00000000000', null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-10-19 09:55:21', '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('48', 'huijia3', null, '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000020', 'E2F866EC03D4BE035CED93CABC4CB1B3', null, null, '00000000001', null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-10-19 10:22:20', '0', null, '21.png', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('49', 'huijiaruanjian', '李毅', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000020', '61821777D6C4DCCFE12B17537B4CD67A', null, null, '00000000000', null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-10-19 13:54:05', '0', null, '1.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('50', 'pangyong11', '庞勇', null, '123456', null, '2016-10-04', '00000000000', null, null, null, null, '372321199999999999', null, '山东省滨州市', null, '山东汇佳', null, null, '11111', '健康', '1476969405000', null, '2016-09-26', null, null, null, '8088098', '11111', '15762182222', '11111', '11111', '11111');

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
