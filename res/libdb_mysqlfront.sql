# Host: localhost  (Version: 5.5.47)
# Date: 2016-10-27 21:12:39
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

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

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (1,'whg_admin','6E27C2CB46F6A4A06B9F3A40FCE42C84','123973173@qq.com',0,'15757575757','2016-10-12 15:13:12',1,0,0),(2,'hjadmintest','E8D315D81A2866D6BE5C9D598906F984','123973173@qq.com',1,'15757575757','2016-10-16 20:31:35',1,0,1),(3,'test2','F040A579C756C49FCF84588246A9D102','123973173@qq.com',0,'15757575757','2016-10-16 20:33:10',1,0,0),(4,'test3','ECBD164E8F0CCA20AAC3D89481F3D5CD','1111@qq.com',0,'15761211111','2016-10-17 08:12:26',1,0,1),(5,'test11','33E59BE11652DE5FF2DFA83FEF7AA0C0','123973173@qq.com',1,'15757575757','2016-10-17 08:31:54',1,1,1);

#
# Structure for table "area"
#

DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(50) NOT NULL,
  `area_type` int(20) NOT NULL COMMENT '使用0代表市,1代表县区',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "area"
#

INSERT INTO `area` VALUES (1,'东营市',0),(2,'东营区',1),(3,' 河口区',1),(4,'广饶县',1),(5,' 垦利县',1),(6,'利津县',1);

#
# Structure for table "config"
#

DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `upload_size` int(255) NOT NULL,
  `examine_month` int(255) NOT NULL,
  `examine_times` int(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "config"
#

/*!40000 ALTER TABLE `config` DISABLE KEYS */;
/*!40000 ALTER TABLE `config` ENABLE KEYS */;

#
# Structure for table "declare_type"
#

DROP TABLE IF EXISTS `declare_type`;
CREATE TABLE `declare_type` (
  `dec_id` int(11) NOT NULL AUTO_INCREMENT,
  `decname` varchar(20) NOT NULL,
  PRIMARY KEY (`dec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "declare_type"
#

INSERT INTO `declare_type` VALUES (1,'音乐'),(2,'舞蹈'),(3,'戏剧曲艺'),(4,'朗诵主持'),(5,' 文学创作'),(6,' 书画'),(7,' 摄影'),(8,' 杂技'),(9,' 民间文艺'),(10,'电影电视');

#
# Structure for table "degree"
#

DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree` (
  `degree_id` int(11) NOT NULL AUTO_INCREMENT,
  `degreename` varchar(20) NOT NULL,
  PRIMARY KEY (`degree_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "degree"
#

INSERT INTO `degree` VALUES (1,'学士'),(2,'硕士'),(3,' 博士');

#
# Structure for table "edu"
#

DROP TABLE IF EXISTS `edu`;
CREATE TABLE `edu` (
  `edu_id` int(11) NOT NULL,
  `eduname` varchar(20) NOT NULL,
  PRIMARY KEY (`edu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "edu"
#

INSERT INTO `edu` VALUES (0,' 小学'),(1,' 初中'),(2,' 中专'),(3,' 高中'),(4,' 专科'),(5,' 本科'),(6,' 硕士研究生'),(7,' 博士研究生');

#
# Structure for table "log"
#

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

#
# Data for table "log"
#

/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'0:0:0:0:0:0:0:1','admin','2016-10-16 20:29:23'),(2,'127.0.0.1','admin','2016-10-16 20:30:23'),(3,'192.168.1.100','admin','2016-10-16 20:31:01'),(4,'192.168.1.100','admin','2016-10-16 20:32:46'),(5,'192.168.1.100','admin','2016-10-16 20:36:04'),(6,'192.168.1.100','admin','2016-10-16 22:24:11'),(7,'192.168.1.100','admin','2016-10-16 22:54:25'),(8,'192.168.1.100','admin','2016-10-16 23:19:42'),(9,'0:0:0:0:0:0:0:1','admin','2016-10-17 08:11:49'),(10,'0:0:0:0:0:0:0:1','admin','2016-10-17 08:31:29'),(11,'0:0:0:0:0:0:0:1','test11','2016-10-17 08:32:09'),(12,'0:0:0:0:0:0:0:1','test11','2016-10-17 08:34:17'),(13,'0:0:0:0:0:0:0:1','test11','2016-10-17 08:34:55'),(14,'0:0:0:0:0:0:0:1','admin','2016-10-17 09:04:46'),(15,'0:0:0:0:0:0:0:1','admin','2016-10-17 09:57:43'),(16,'0:0:0:0:0:0:0:1','admin','2016-10-17 10:21:57'),(17,'0:0:0:0:0:0:0:1','test11','2016-10-17 10:23:25'),(18,'0:0:0:0:0:0:0:1','admin','2016-10-17 11:23:03'),(19,'0:0:0:0:0:0:0:1','admin','2016-10-17 13:46:26'),(20,'0:0:0:0:0:0:0:1','admin','2016-10-17 14:08:42'),(21,'0:0:0:0:0:0:0:1','admin','2016-10-17 14:49:19'),(22,'0:0:0:0:0:0:0:1','admin','2016-10-17 15:32:49'),(23,'0:0:0:0:0:0:0:1','admin','2016-10-17 15:44:54'),(24,'0:0:0:0:0:0:0:1','admin','2016-10-17 16:17:13'),(25,'0:0:0:0:0:0:0:1','admin','2016-10-17 16:32:29'),(26,'0:0:0:0:0:0:0:1','admin','2016-10-18 16:47:59'),(27,'0:0:0:0:0:0:0:1','test11','2016-10-18 17:27:57'),(28,'0:0:0:0:0:0:0:1','admin','2016-10-18 19:08:44'),(29,'0:0:0:0:0:0:0:1','admin','2016-10-18 19:13:21'),(30,'0:0:0:0:0:0:0:1','admin','2016-10-18 20:14:01'),(31,'0:0:0:0:0:0:0:1','admin','2016-10-18 20:28:00'),(32,'0:0:0:0:0:0:0:1','admin','2016-10-18 20:32:20'),(33,'0:0:0:0:0:0:0:1','admin','2016-10-18 21:03:52'),(34,'0:0:0:0:0:0:0:1','admin','2016-10-18 21:04:05'),(35,'0:0:0:0:0:0:0:1','admin','2016-10-18 22:12:52'),(36,'0:0:0:0:0:0:0:1','admin','2016-10-18 22:20:30'),(37,'0:0:0:0:0:0:0:1','admin','2016-10-18 23:00:40'),(38,'0:0:0:0:0:0:0:1','admin','2016-10-19 08:03:08'),(39,'0:0:0:0:0:0:0:1','admin','2016-10-19 10:33:24'),(40,'0:0:0:0:0:0:0:1','admin','2016-10-19 10:48:44'),(41,'0:0:0:0:0:0:0:1','admin','2016-10-19 10:59:53'),(42,'0:0:0:0:0:0:0:1','admin','2016-10-19 11:02:46'),(43,'0:0:0:0:0:0:0:1','admin','2016-10-19 11:13:07'),(44,'0:0:0:0:0:0:0:1','admin','2016-10-19 12:46:56'),(45,'0:0:0:0:0:0:0:1','admin','2016-10-19 12:57:52'),(46,'0:0:0:0:0:0:0:1','admin','2016-10-19 13:56:47'),(47,'0:0:0:0:0:0:0:1','test11','2016-10-19 14:01:25'),(48,'0:0:0:0:0:0:0:1','admin','2016-10-19 14:07:17'),(49,'0:0:0:0:0:0:0:1','admin','2016-10-19 14:32:34'),(50,'0:0:0:0:0:0:0:1','admin','2016-10-20 16:53:58'),(51,'0:0:0:0:0:0:0:1','admin','2016-10-20 17:10:27'),(52,'0:0:0:0:0:0:0:1','admin','2016-10-20 17:26:29'),(53,'0:0:0:0:0:0:0:1','admin','2016-10-20 19:02:09'),(54,'0:0:0:0:0:0:0:1','admin','2016-10-20 19:38:17'),(55,'0:0:0:0:0:0:0:1','admin','2016-10-20 19:48:52'),(56,'0:0:0:0:0:0:0:1','admin','2016-10-20 19:59:19'),(57,'0:0:0:0:0:0:0:1','admin','2016-10-20 20:10:59'),(58,'0:0:0:0:0:0:0:1','admin','2016-10-20 20:21:26'),(59,'0:0:0:0:0:0:0:1','admin','2016-10-20 20:40:01'),(60,'0:0:0:0:0:0:0:1','admin','2016-10-20 20:50:33'),(61,'0:0:0:0:0:0:0:1','admin','2016-10-20 21:00:57'),(62,'0:0:0:0:0:0:0:1','admin','2016-10-20 21:16:06'),(63,'0:0:0:0:0:0:0:1','admin','2016-10-20 21:24:59'),(64,'0:0:0:0:0:0:0:1','admin','2016-10-21 08:22:03'),(65,'0:0:0:0:0:0:0:1','admin','2016-10-21 08:35:42'),(66,'0:0:0:0:0:0:0:1','admin','2016-10-21 09:13:04'),(67,'0:0:0:0:0:0:0:1','admin','2016-10-21 09:35:17'),(68,'0:0:0:0:0:0:0:1','admin','2016-10-21 09:52:56'),(69,'0:0:0:0:0:0:0:1','admin','2016-10-21 10:03:12'),(70,'0:0:0:0:0:0:0:1','admin','2016-10-21 10:13:58'),(71,'0:0:0:0:0:0:0:1','admin','2016-10-21 10:36:37'),(72,'0:0:0:0:0:0:0:1','admin','2016-10-21 11:00:26'),(73,'0:0:0:0:0:0:0:1','admin','2016-10-21 11:32:23'),(74,'0:0:0:0:0:0:0:1','admin','2016-10-21 14:09:23'),(75,'0:0:0:0:0:0:0:1','admin','2016-10-21 14:46:24'),(76,'0:0:0:0:0:0:0:1','admin','2016-10-23 09:24:59'),(77,'0:0:0:0:0:0:0:1','admin','2016-10-23 15:56:26'),(78,'0:0:0:0:0:0:0:1','admin','2016-10-23 20:36:47'),(79,'0:0:0:0:0:0:0:1','admin','2016-10-23 20:52:49'),(80,'0:0:0:0:0:0:0:1','admin','2016-10-23 22:07:32'),(81,'0:0:0:0:0:0:0:1','admin','2016-10-23 22:17:54'),(82,'0:0:0:0:0:0:0:1','admin','2016-10-23 22:32:18'),(83,'0:0:0:0:0:0:0:1','admin','2016-10-23 23:32:01'),(84,'0:0:0:0:0:0:0:1','admin','2016-10-24 00:13:27'),(85,'0:0:0:0:0:0:0:1','admin','2016-10-24 08:48:19'),(86,'127.0.0.1','admin','2016-10-24 14:17:48'),(87,'0:0:0:0:0:0:0:1','admin','2016-10-24 16:30:14'),(88,'0:0:0:0:0:0:0:1','whg_admin','2016-10-26 09:57:47'),(89,'0:0:0:0:0:0:0:1','whg_admin','2016-10-26 10:56:29'),(90,'0:0:0:0:0:0:0:1','whg_admin','2016-10-27 00:36:21'),(91,'0:0:0:0:0:0:0:1','test11','2016-10-27 08:18:38'),(92,'0:0:0:0:0:0:0:1','whg_admin','2016-10-27 08:45:16'),(93,'0:0:0:0:0:0:0:1','test11','2016-10-27 09:25:20'),(94,'0:0:0:0:0:0:0:1','whg_admin','2016-10-27 09:29:33'),(95,'0:0:0:0:0:0:0:1','test3','2016-10-27 09:31:52'),(96,'0:0:0:0:0:0:0:1','whg_admin','2016-10-27 09:34:17'),(97,'0:0:0:0:0:0:0:1','whg_admin','2016-10-27 09:35:05'),(98,'0:0:0:0:0:0:0:1','hjadmintest','2016-10-27 09:38:49'),(99,'0:0:0:0:0:0:0:1','whg_admin','2016-10-27 15:22:22'),(100,'0:0:0:0:0:0:0:1','whg_admin','2016-10-27 20:54:42');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;

#
# Structure for table "msg"
#

DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `admin_id` int(255) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "msg"
#

/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `msg` ENABLE KEYS */;

#
# Structure for table "mz"
#

DROP TABLE IF EXISTS `mz`;
CREATE TABLE `mz` (
  `mz_id` int(11) NOT NULL AUTO_INCREMENT,
  `mzname` varchar(20) NOT NULL,
  PRIMARY KEY (`mz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

#
# Data for table "mz"
#

INSERT INTO `mz` VALUES (1,'汉族'),(2,'蒙古族'),(3,'回族'),(4,'藏族'),(5,'维吾尔族'),(6,'苗族'),(7,'彝族'),(8,'壮族'),(9,'布依族'),(10,'朝鲜族'),(11,'满族'),(12,'侗族'),(13,'瑶族'),(14,'白族'),(15,'土家族'),(16,'哈尼族'),(17,'哈萨克族'),(18,'傣族'),(19,'黎族'),(20,'傈僳族'),(21,'佤族'),(22,'畲族'),(23,'高山族'),(24,'拉祜族'),(25,'水族'),(26,'东乡族'),(27,'纳西族'),(28,'景颇族'),(29,'柯尔克孜族'),(30,'土族'),(31,'达斡尔族'),(32,'仫佬族'),(33,'羌族'),(34,' 布朗族'),(35,' 撒拉族'),(36,' 毛难族'),(37,' 仡佬族'),(38,' 锡伯族'),(39,' 阿昌族'),(40,' 普米族'),(41,' 塔吉克族'),(42,' 怒族'),(43,' 乌孜别克族'),(44,' 俄罗斯族'),(45,' 鄂温克族'),(46,' 崩龙族'),(47,' 保安族'),(48,' 裕固族'),(49,' 京族'),(50,' 塔塔尔族'),(51,' 独龙族'),(52,' 鄂伦春族'),(53,' 赫哲族'),(54,' 门巴族'),(55,' 珞巴族'),(56,' 基诺族'),(57,' 其他');

#
# Structure for table "system"
#

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

#
# Data for table "system"
#

INSERT INTO `system` VALUES (1,'东营市社会文艺人才信息资源库','关键词设置2','网站描述设置','东营市文化馆版权所有','鲁ICP备00000000001号',' 统计代码设置',0);

#
# Structure for table "upload_audio"
#

DROP TABLE IF EXISTS `upload_audio`;
CREATE TABLE `upload_audio` (
  `id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `size` int(255) NOT NULL DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "upload_audio"
#

/*!40000 ALTER TABLE `upload_audio` DISABLE KEYS */;
/*!40000 ALTER TABLE `upload_audio` ENABLE KEYS */;

#
# Structure for table "upload_photo"
#

DROP TABLE IF EXISTS `upload_photo`;
CREATE TABLE `upload_photo` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `size` int(255) NOT NULL DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "upload_photo"
#

/*!40000 ALTER TABLE `upload_photo` DISABLE KEYS */;
INSERT INTO `upload_photo` VALUES (1,47,'22222','22222','22222',100),(2,47,'1111111','11111','11111',100),(3,47,'201302011702405145293.jpg','2016-10-19 12:26:15','庞勇',100),(4,47,'649830154.jpg','2016-10-19 12:28:00','庞勇',100),(5,47,'60-130220143607.jpg','2016-10-24 00:33:34','庞勇',100),(6,47,'60-1302201436072.jpg','2016-10-24 09:11:13','庞勇',100),(7,47,'file','2016-10-24 10:53:30','庞勇',100),(8,47,'60-130220143607.jpg','2016-10-24 11:08:19','庞勇',100),(9,47,'60-130220143607.jpg','2016-10-24 11:09:05','庞勇',100),(10,47,'jbg.jpg','2016-10-24 11:12:13','庞勇',100),(11,47,'ec8d5256bc06f18449980ed7cca921f6.png','2016-10-24 11:30:14','庞勇',100);
/*!40000 ALTER TABLE `upload_photo` ENABLE KEYS */;

#
# Structure for table "upload_video"
#

DROP TABLE IF EXISTS `upload_video`;
CREATE TABLE `upload_video` (
  `id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `size` int(255) NOT NULL DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "upload_video"
#

/*!40000 ALTER TABLE `upload_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `upload_video` ENABLE KEYS */;

#
# Structure for table "uploads"
#

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

#
# Data for table "uploads"
#

INSERT INTO `uploads` VALUES (1,37,'1','20160822020450_207881.png','2016-10-16 12:37:05',NULL),(2,37,'1','20160822020450_207882.png','2016-10-16 13:36:51',NULL),(3,37,'1','20160822020450_207884.png','2016-10-17 13:47:06',NULL),(4,37,'1','20160822020450_207885.png','2016-10-17 16:37:35',NULL),(5,47,'1','20130201170240514529.jpg','2016-10-19 12:18:50',NULL),(6,47,'1','201302011702405145291.jpg','2016-10-19 12:20:17',NULL),(7,47,'1','201302011702405145292.jpg','2016-10-19 12:20:38',NULL);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `true_name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `dec_id` int(11) unsigned zerofill DEFAULT NULL,
  `media_path` varchar(255) DEFAULT NULL,
  `join_work` varchar(30) DEFAULT NULL,
  `usersex` enum('1','0') DEFAULT '1',
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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (31,'py','张三','5D23494D3D93A7EF5BDA2FCE1091C7A41',00000000001,NULL,'111','1',0000000018,0000000001,00000000001,00000000000,'372321199999999999','1','山东省东营市',0,'山东汇佳','唱歌舞蹈','呵呵呵呵呵','健康','2016-10-08 16:05:55',1,'11111','defaultheadpic.jpg','青年志愿者',0000000001,'8086998','社会兼职','15762188888','表演一等奖','希望申请通过','销售实习'),(33,'pangyong','张三','7B7047748C146671550A41036E2333EC1',00000000002,NULL,'111','0',0000000006,0000000004,00000000003,00000000000,'372321199999999999','0','山东省东营市',0,'山东汇佳','唱歌舞蹈','中央戏剧表演','健康','2016-10-11 08:24:51',1,'1111','defaultheadpic.jpg','红年志愿者',0000000001,'8086998','社会兼职','15762188888',' 表演二等奖','希望申请通过','销售实习'),(35,'汇佳软件','张三3','9A42B2FDE562AD64942EE3058498251D1',00000000001,NULL,'111','0',0000000001,0000000001,00000000001,00000000000,'372321199999999999','1','山东省东营市',0,'山东汇佳','唱歌舞蹈','艺术简介艺术简介','健康','2016-10-11 08:29:21',1,'1111','defaultheadpic.jpg','中年志愿者',0000000001,'8086998','社会兼职','15762188888','表演三等奖','希望申请通过','销售实习'),(36,'山东汇佳软件','张三4','3501B4E771BA5C7A744E8B16E8CEF916E1',00000000001,NULL,'111','1',0000000001,0000000001,00000000001,00000000000,'372321199999999999','1','山东省东营市',0,'山东汇佳','唱歌舞蹈','艺术简介艺术简介','健康','2016-10-11 15:45:06',1,'1111','defaultheadpic.jpg','老年志愿者',0000000001,'8086998','社会兼职','15762188888',' 表演四等奖','希望申请通过','销售实习'),(37,'张三5','张三5','4501195721962DCDADBFC33F8C0DD6E31',00000000001,NULL,'111','1',0000000001,0000000001,00000000001,00000000000,'372321199999999999','1','山东省东营市',0,'山东汇佳','唱歌舞蹈','呵呵呵呵呵','健康','2016-10-12 15:13:12',0,'1111','c908593ded2e3450cd6656e64b95526c.png','青年志愿',0000000001,'8086998','社会兼职','15762188888',' 表演五等奖','希望申请通过','销售实习'),(38,'庞庞','张三6','9D46A6083C6EBDDCFB898DAB58EAFD7F1',00000000001,NULL,'111','0',0000000001,0000000001,00000000001,00000000000,'372321199999999999','1','山东省东营市',0,'山东汇佳','唱歌舞蹈','艺术简介艺术简介','健康','2016-10-13 22:47:39',0,'1111','defaultheadpic.jpg','青年者远着',0000000001,'8086998','社会兼职','15762188888',' 表演特等奖','希望申请通过','销售实习'),(39,'admin','张三7','6E0F084E2078D7E28093027420CDD7761',00000000001,NULL,'111','1',0000000006,0000000004,00000000002,00000000000,'372321199999999999','0','山东省东营市',0,'山东汇佳','唱歌舞蹈',' 中国表演大学','健康','2016-10-14 09:49:17',1,'1111','defaultheadpic.jpg','志愿者',0000000001,'8086998','社会兼职','15762188888',' 表演奖','希望申请通过','销售实习'),(40,'庞永','张三8','DD015661785A22BDED41F84D206AF94E1',00000000003,NULL,'111','0',0000000006,0000000004,00000000003,00000000000,'372321199999999999','0','山东省东营市',0,'山东汇佳','唱歌舞蹈','中央戏剧学院','健康','2016-10-14 09:49:59',1,'1111','defaultheadpic.jpg',' 山区只教1111',0000000001,'8086998','社会兼职','15762188888',' 参与奖','希望申请通过','销售实习'),(41,'hjsoft','李毅','D3D8CB79B6CF54CB37B49E9A33D64F7B1',00000000001,NULL,'111','1',0000000001,0000000001,00000000001,00000000000,'372321199999999999','1','山东省滨州市',0,'山东汇佳','1111','呵呵呵呵呵','111','2016-10-16 09:24:42',0,'1111','defaultheadpic.jpg','11111',0000000001,'8086998','社会兼职','15762188888',' 参与奖','希望申请通过','销售实习'),(42,'py1','李毅','C8CDCB4D499B4586FD0204CAF0F025501',00000000001,NULL,'111','0',0000000001,0000000001,00000000001,00000000000,'372321199999999999','1','山东省滨州市',0,'山东汇佳',NULL,'艺术简介',NULL,'2016-10-16 13:55:02',0,NULL,NULL,NULL,0000000001,'8088098','兼职','15762182222','获奖情况','申请意见','业务成就'),(43,'py2','庞庞','2CEAF68A3D72AC13E036C18334B0EFE61',00000000001,NULL,'1111','1',0000000001,0000000001,00000000001,00000000000,'372321199999999999','1','山东省滨州市',0,'山东汇佳','开发','呵呵呵呵呵','健康','2016-10-16 15:13:52',0,'1111','20160822020450_207883.png','计算机',0000000001,'8088098','兼职','15762182222','获奖情况','申请意见','业务成就'),(47,'huijia1','庞庞','3F88F8754440E99D904120FD9D706EB31',00000000001,NULL,NULL,'1',0000000002,0000000004,00000000001,00000000001,'372321199999999999','2','山东省东营市',0,NULL,NULL,NULL,NULL,'2016-10-19 09:55:21',0,NULL,'2.png',NULL,0000000001,NULL,NULL,NULL,NULL,NULL,NULL),(48,'huijia3','李慧','E2F866EC03D4BE035CED93CABC4CB1B31',00000000001,NULL,NULL,'1',0000000003,0000000001,00000000001,00000000001,'372321199999999999','3','山东省东营市',0,NULL,NULL,NULL,NULL,'2016-10-19 10:22:20',0,NULL,'21.png',NULL,0000000001,NULL,NULL,NULL,NULL,NULL,NULL),(49,'huijiaruanjian','李毅','61821777D6C4DCCFE12B17537B4CD67A1',00000000007,NULL,NULL,'1',0000000004,0000000002,00000000001,00000000001,'372321199999999999','4','山东省东营市',0,NULL,NULL,NULL,NULL,'2016-10-19 13:54:05',0,NULL,'1.jpg',NULL,0000000001,NULL,NULL,NULL,NULL,NULL,NULL),(51,'汇佳软件123','赵六','D3934F91D32DB7D01525110DAA700B021',00000000002,NULL,NULL,'1',0000000005,0000000003,00000000001,00000000001,'372321199999999999','2','山东省东营市',0,NULL,NULL,NULL,NULL,'2016-10-21 14:19:14',0,NULL,NULL,NULL,0000000001,NULL,NULL,NULL,NULL,NULL,NULL),(56,'test111','王五','6BE59AE979C90B444984AD796D30EEDF1',00000000003,NULL,NULL,'1',0000000006,0000000004,00000000001,00000000001,'372321199999999999','1','山东省东营市',0,NULL,NULL,NULL,NULL,'2016-10-23 21:59:55',NULL,NULL,'test7.jpg',NULL,0000000001,NULL,NULL,NULL,NULL,NULL,NULL),(57,'test121','李四','12B406E2D13873E684EAD9E7B4832DC01',00000000004,NULL,NULL,'1',0000000007,0000000003,00000000001,00000000001,'372321199999999999','3','山东省东营市',NULL,NULL,NULL,NULL,NULL,'2016-10-23 22:08:24',NULL,NULL,'test8.jpg',NULL,0000000001,NULL,NULL,NULL,NULL,NULL,NULL),(58,'test122','张三','AE938DA2B3434577647CB4985A7FBCAA1',00000000005,NULL,NULL,'1',0000000011,0000000003,00000000001,00000000001,'372321199999999999','4','山东省东营市',0,NULL,NULL,NULL,NULL,'2016-10-23 22:15:06',NULL,NULL,'test9.jpg',NULL,0000000001,NULL,NULL,NULL,NULL,NULL,NULL),(60,'test222','庞庞','6B5ED554EBFF2FC7A0BAB042F4894D6C1',00000000006,NULL,'2016-10-20','0',0000000016,0000000001,00000000001,00000000001,'372321199999999999','2','山东省滨州市',NULL,'山东汇佳',NULL,'1111111111111','健康','2016-10-24 09:27:38',1,'2016-10-04','test11.jpg',NULL,NULL,'8088098','1111111111111','15762182222','1111111111111','1111111111111','1111111111111'),(61,'whg_u_test','冯晓','541D8E7669A0D6433CB656564A9CABCA',00000000008,'1busn9y9ac92y1ap9j4khzaej8','2016-10-20','0',0000000001,0000000001,00000000001,00000000001,'372321199999999999','1','山东省东营市',NULL,'山东汇佳',NULL,'测试数据','健康','2016-10-26 17:27:55',0,'2016-10-04',NULL,NULL,NULL,'8088098','测试数据','15762182222','测试数据','测试数据  ','测试数据'),(64,'pytest',NULL,'C736A8DF053397048AC28B7E4BDBD973',NULL,'287ssrv804griql9x79wcvyw',NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-10-27 15:06:39',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

#
# Structure for table "zzmm"
#

DROP TABLE IF EXISTS `zzmm`;
CREATE TABLE `zzmm` (
  `zzmm_id` int(11) NOT NULL AUTO_INCREMENT,
  `zzmmname` varchar(20) NOT NULL,
  PRIMARY KEY (`zzmm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

#
# Data for table "zzmm"
#

INSERT INTO `zzmm` VALUES (1,'中共党员'),(2,' 中共预备党员'),(3,' 共青团员'),(4,' 民革党员'),(5,' 民盟盟员'),(6,' 民建会员'),(7,' 民进会员'),(8,' 农工党党员'),(9,' 致公党党员'),(10,' 九三学社社员'),(11,' 台盟盟员'),(12,' 无党派民族人士'),(13,' 普通公民(群众)');
