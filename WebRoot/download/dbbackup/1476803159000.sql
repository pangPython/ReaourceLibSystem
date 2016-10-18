-- MySQL dump 10.13  Distrib 5.5.47, for Win32 (x86)
--
-- Host: localhost    Database: libdb
-- ------------------------------------------------------
-- Server version	5.5.47

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','4501195721962DCDADBFC33F8C0DD6E3','admin@qq.com',0,'','2016-10-12 15:13:12',1,0,0),(2,'test','AA410543E9D4E202A4F7389FEDA883BE','123973173@qq.com',1,'15757575757','2016-10-16 20:31:35',1,0,1),(3,'test2','F040A579C756C49FCF84588246A9D102','123973173@qq.com',0,'15757575757','2016-10-16 20:33:10',1,0,0),(4,'test3','7C7F0CAC0FC15349D7E4211935EB555C','1111@qq.com',0,'15761211111','2016-10-17 08:12:26',1,0,1),(5,'test11','33E59BE11652DE5FF2DFA83FEF7AA0C0','123973173@qq.com',1,'15757575757','2016-10-17 08:31:54',1,1,1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(50) NOT NULL,
  `area_type` int(20) NOT NULL COMMENT '使用0代表市,1代表县区',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'东营市',0),(2,'东营区',1),(3,' 河口区',1),(4,'广饶县',1),(5,' 垦利县',1),(6,'利津县',1);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `declare_type`
--

DROP TABLE IF EXISTS `declare_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `declare_type` (
  `dec_id` int(11) NOT NULL AUTO_INCREMENT,
  `decname` varchar(20) NOT NULL,
  PRIMARY KEY (`dec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `declare_type`
--

LOCK TABLES `declare_type` WRITE;
/*!40000 ALTER TABLE `declare_type` DISABLE KEYS */;
INSERT INTO `declare_type` VALUES (1,'音乐2'),(2,'舞蹈'),(3,'戏剧曲艺'),(4,'朗诵主持'),(5,' 文学创作'),(6,' 书画'),(7,' 摄影'),(8,' 杂技'),(9,' 民间文艺'),(10,'电影电视');
/*!40000 ALTER TABLE `declare_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degree`
--

DROP TABLE IF EXISTS `degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `degree` (
  `degree_id` int(11) NOT NULL AUTO_INCREMENT,
  `degreename` varchar(20) NOT NULL,
  PRIMARY KEY (`degree_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree`
--

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` VALUES (1,'学士'),(2,'硕士'),(3,' 博士');
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu`
--

DROP TABLE IF EXISTS `edu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edu` (
  `edu_id` int(11) NOT NULL,
  `eduname` varchar(20) NOT NULL,
  PRIMARY KEY (`edu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu`
--

LOCK TABLES `edu` WRITE;
/*!40000 ALTER TABLE `edu` DISABLE KEYS */;
INSERT INTO `edu` VALUES (0,' 小学'),(1,' 初中'),(2,' 中专'),(3,' 高中'),(4,' 专科'),(5,' 本科'),(6,' 硕士研究生'),(7,' 博士研究生');
/*!40000 ALTER TABLE `edu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'0:0:0:0:0:0:0:1','admin','2016-10-16 20:29:23'),(2,'127.0.0.1','admin','2016-10-16 20:30:23'),(3,'192.168.1.100','admin','2016-10-16 20:31:01'),(4,'192.168.1.100','admin','2016-10-16 20:32:46'),(5,'192.168.1.100','admin','2016-10-16 20:36:04'),(6,'192.168.1.100','admin','2016-10-16 22:24:11'),(7,'192.168.1.100','admin','2016-10-16 22:54:25'),(8,'192.168.1.100','admin','2016-10-16 23:19:42'),(9,'0:0:0:0:0:0:0:1','admin','2016-10-17 08:11:49'),(10,'0:0:0:0:0:0:0:1','admin','2016-10-17 08:31:29'),(11,'0:0:0:0:0:0:0:1','test11','2016-10-17 08:32:09'),(12,'0:0:0:0:0:0:0:1','test11','2016-10-17 08:34:17'),(13,'0:0:0:0:0:0:0:1','test11','2016-10-17 08:34:55'),(14,'0:0:0:0:0:0:0:1','admin','2016-10-17 09:04:46'),(15,'0:0:0:0:0:0:0:1','admin','2016-10-17 09:57:43'),(16,'0:0:0:0:0:0:0:1','admin','2016-10-17 10:21:57'),(17,'0:0:0:0:0:0:0:1','test11','2016-10-17 10:23:25'),(18,'0:0:0:0:0:0:0:1','admin','2016-10-17 11:23:03'),(19,'0:0:0:0:0:0:0:1','admin','2016-10-17 13:46:26'),(20,'0:0:0:0:0:0:0:1','admin','2016-10-17 14:08:42'),(21,'0:0:0:0:0:0:0:1','admin','2016-10-17 14:49:19'),(22,'0:0:0:0:0:0:0:1','admin','2016-10-17 15:32:49'),(23,'0:0:0:0:0:0:0:1','admin','2016-10-17 15:44:54'),(24,'0:0:0:0:0:0:0:1','admin','2016-10-17 16:17:13'),(25,'0:0:0:0:0:0:0:1','admin','2016-10-17 16:32:29'),(26,'0:0:0:0:0:0:0:1','admin','2016-10-18 16:47:59'),(27,'0:0:0:0:0:0:0:1','test11','2016-10-18 17:27:57'),(28,'0:0:0:0:0:0:0:1','admin','2016-10-18 19:08:44'),(29,'0:0:0:0:0:0:0:1','admin','2016-10-18 19:13:21'),(30,'0:0:0:0:0:0:0:1','admin','2016-10-18 20:14:01'),(31,'0:0:0:0:0:0:0:1','admin','2016-10-18 20:28:00'),(32,'0:0:0:0:0:0:0:1','admin','2016-10-18 20:32:20'),(33,'0:0:0:0:0:0:0:1','admin','2016-10-18 21:03:52'),(34,'0:0:0:0:0:0:0:1','admin','2016-10-18 21:04:05'),(35,'0:0:0:0:0:0:0:1','admin','2016-10-18 22:12:52'),(36,'0:0:0:0:0:0:0:1','admin','2016-10-18 22:20:30'),(37,'0:0:0:0:0:0:0:1','admin','2016-10-18 23:00:40');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mz`
--

DROP TABLE IF EXISTS `mz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mz` (
  `mz_id` int(11) NOT NULL AUTO_INCREMENT,
  `mzname` varchar(20) NOT NULL,
  PRIMARY KEY (`mz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mz`
--

LOCK TABLES `mz` WRITE;
/*!40000 ALTER TABLE `mz` DISABLE KEYS */;
INSERT INTO `mz` VALUES (1,'汉族'),(2,'蒙古族'),(3,'回族'),(4,'藏族'),(5,'维吾尔族'),(6,'苗族'),(7,'彝族'),(8,'壮族'),(9,'布依族'),(10,'朝鲜族'),(11,'满族'),(12,'侗族'),(13,'瑶族'),(14,'白族'),(15,'土家族'),(16,'哈尼族'),(17,'哈萨克族'),(18,'傣族'),(19,'黎族'),(20,'傈僳族'),(21,'佤族'),(22,'畲族'),(23,'高山族'),(24,'拉祜族'),(25,'水族'),(26,'东乡族'),(27,'纳西族'),(28,'景颇族'),(29,'柯尔克孜族'),(30,'土族'),(31,'达斡尔族'),(32,'仫佬族'),(33,'羌族'),(34,' 布朗族'),(35,' 撒拉族'),(36,' 毛难族'),(37,' 仡佬族'),(38,' 锡伯族'),(39,' 阿昌族'),(40,' 普米族'),(41,' 塔吉克族'),(42,' 怒族'),(43,' 乌孜别克族'),(44,' 俄罗斯族'),(45,' 鄂温克族'),(46,' 崩龙族'),(47,' 保安族'),(48,' 裕固族'),(49,' 京族'),(50,' 塔塔尔族'),(51,' 独龙族'),(52,' 鄂伦春族'),(53,' 赫哲族'),(54,' 门巴族'),(55,' 珞巴族'),(56,' 基诺族'),(57,' 其他');
/*!40000 ALTER TABLE `mz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system`
--

DROP TABLE IF EXISTS `system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system`
--

LOCK TABLES `system` WRITE;
/*!40000 ALTER TABLE `system` DISABLE KEYS */;
INSERT INTO `system` VALUES (1,'东营市社会文艺人才信息资源库','关键词设置2','网站描述设置','山东汇佳软件科技有限公司版权所有','鲁ICP备00000000001号',' 统计代码设置',0);
/*!40000 ALTER TABLE `system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload_audio`
--

DROP TABLE IF EXISTS `upload_audio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upload_audio` (
  `id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload_audio`
--

LOCK TABLES `upload_audio` WRITE;
/*!40000 ALTER TABLE `upload_audio` DISABLE KEYS */;
/*!40000 ALTER TABLE `upload_audio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload_photo`
--

DROP TABLE IF EXISTS `upload_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upload_photo` (
  `id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload_photo`
--

LOCK TABLES `upload_photo` WRITE;
/*!40000 ALTER TABLE `upload_photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `upload_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload_video`
--

DROP TABLE IF EXISTS `upload_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upload_video` (
  `id` int(255) NOT NULL,
  `user_id` int(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload_video`
--

LOCK TABLES `upload_video` WRITE;
/*!40000 ALTER TABLE `upload_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `upload_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uploads`
--

DROP TABLE IF EXISTS `uploads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uploads` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NOT NULL,
  `type` varchar(100) NOT NULL,
  `path` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uploads`
--

LOCK TABLES `uploads` WRITE;
/*!40000 ALTER TABLE `uploads` DISABLE KEYS */;
INSERT INTO `uploads` VALUES (1,37,'1','20160822020450_207881.png','2016-10-16 12:37:05',NULL),(2,37,'1','20160822020450_207882.png','2016-10-16 13:36:51',NULL),(3,37,'1','20160822020450_207884.png','2016-10-17 13:47:06',NULL),(4,37,'1','20160822020450_207885.png','2016-10-17 16:37:35',NULL);
/*!40000 ALTER TABLE `uploads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `true_name` varchar(255) DEFAULT NULL,
  `age` int(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `dec_id` int(11) DEFAULT NULL,
  `join_work` varchar(30) DEFAULT NULL,
  `usersex` int(11) DEFAULT NULL,
  `mz_id` int(10) DEFAULT NULL,
  `zzmm_id` int(10) DEFAULT NULL,
  `degree_id` int(11) DEFAULT NULL,
  `edu_id` int(11) DEFAULT NULL,
  `gzdate` varchar(30) DEFAULT NULL,
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
  `degree_full_time` int(10) DEFAULT NULL,
  `company_tel` varchar(255) DEFAULT NULL,
  `socio_part_time` varchar(255) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `awards` varchar(255) DEFAULT NULL,
  `opinion` varchar(255) DEFAULT NULL,
  `business_achievement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`uname`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (31,'py','张三',22,'5D23494D3D93A7EF5BDA2FCE1091C7A4',1,'111',1,18,1,1,0,'122','372321199999999999','1','山东省东营市',NULL,'山东汇佳','唱歌舞蹈',NULL,'呵呵呵呵呵','健康','2016-10-08 16:05:55',1,'11111','defaultheadpic.jpg','青年志愿者',NULL,'8086998','社会兼职','15762188888','表演一等奖','希望申请通过','销售实习'),(33,'pangyong','张三',22,'7B7047748C146671550A41036E2333EC',2,'111',0,6,4,3,0,'111','372321199999999999','0','山东省东营市',NULL,'山东汇佳','唱歌舞蹈',NULL,'中央戏剧表演','健康','2016-10-11 08:24:51',1,'1111','defaultheadpic.jpg','红年志愿者',NULL,'8086998','社会兼职','15762188888',' 表演二等奖','希望申请通过','销售实习'),(35,'汇佳软件','张三3',22,'9A42B2FDE562AD64942EE3058498251D',1,'111',1,1,1,1,0,'232','372321199999999999','1','山东省东营市',NULL,'山东汇佳','唱歌舞蹈',NULL,'艺术简介艺术简介','健康','2016-10-11 08:29:21',1,'1111','defaultheadpic.jpg','中年志愿者',NULL,'8086998','社会兼职','15762188888','表演三等奖','希望申请通过','销售实习'),(36,'山东汇佳软件','张三4',22,'3501B4E771BA5C7A744E8B6E8CEF916E',1,'111',1,1,1,1,0,'33','372321199999999999','1','山东省东营市',NULL,'山东汇佳','唱歌舞蹈',NULL,'艺术简介艺术简介','健康','2016-10-11 15:45:06',1,'1111','defaultheadpic.jpg','老年志愿者',NULL,'8086998','社会兼职','15762188888',' 表演四等奖','希望申请通过','销售实习'),(37,'huijia','张三5',22,'4501195721962DCDADBFC33F8C0DD6E3',1,'111',1,1,1,1,0,'44','372321199999999999','1','山东省东营市',NULL,'山东汇佳','唱歌舞蹈',NULL,'呵呵呵呵呵','健康','2016-10-12 15:13:12',0,'1111','c908593ded2e3450cd6656e64b95526c.png','青年志愿',NULL,'8086998','社会兼职','15762188888',' 表演五等奖','希望申请通过','销售实习'),(38,'庞勇','张三6',22,'9D46A6083C6EBDDCFB898DAB58EAFD7F',1,'111',1,1,1,1,0,'55','372321199999999999','1','山东省东营市',NULL,'山东汇佳','唱歌舞蹈',NULL,'艺术简介艺术简介','健康','2016-10-13 22:47:39',0,'1111','defaultheadpic.jpg','青年者远着',NULL,'8086998','社会兼职','15762188888',' 表演特等奖','希望申请通过','销售实习'),(39,'admin','张三7',22,'6E0F084E2078D7E28093027420CDD776',1,'111',0,6,4,2,0,'66','372321199999999999','0','山东省东营市',NULL,'山东汇佳','唱歌舞蹈',NULL,' 中国表演大学','健康','2016-10-14 09:49:17',1,'1111','defaultheadpic.jpg','志愿者',NULL,'8086998','社会兼职','15762188888',' 表演奖','希望申请通过','销售实习'),(40,'庞永','张三8',22,'DD015661785A22BDED41F84D206AF94E',3,'111',0,6,4,3,0,'77','372321199999999999','0','山东省东营市',NULL,'山东汇佳','唱歌舞蹈',NULL,'中央戏剧学院','健康','2016-10-14 09:49:59',1,'1111','defaultheadpic.jpg',' 山区只教1111',NULL,'8086998','社会兼职','15762188888',' 参与奖','希望申请通过','销售实习'),(41,'hjsoft','李毅',22,'D3D8CB79B6CF54CB37B49E9A33D64F7B',1,'111',1,1,1,1,0,'111','372321199999999999','1','山东省滨州市',NULL,'山东汇佳','1111',NULL,'呵呵呵呵呵','111','2016-10-16 09:24:42',0,'1111','defaultheadpic.jpg','11111',NULL,'8086998','社会兼职',NULL,NULL,NULL,NULL),(42,'py1','李毅',22,'C8CDCB4D499B4586FD0204CAF0F02550',1,'111',1,1,1,1,0,NULL,'372321199999999999','1','山东省滨州市',NULL,'山东汇佳',NULL,NULL,'艺术简介',NULL,'2016-10-16 13:55:02',0,NULL,NULL,NULL,NULL,'8088098','兼职','15762182222','获奖情况','申请意见','业务成就'),(43,'py2','庞勇',22,'2CEAF68A3D72AC13E036C18334B0EFE6',1,'1111',1,1,1,1,0,NULL,'372321199999999999','1','山东省滨州市',NULL,'山东汇佳','开发',NULL,'呵呵呵呵呵','健康','2016-10-16 15:13:52',0,'1111','20160822020450_207883.png','计算机',NULL,'8088098','兼职','15762182222','获奖情况','申请意见','业务成就');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zzmm`
--

DROP TABLE IF EXISTS `zzmm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zzmm` (
  `zzmm_id` int(11) NOT NULL AUTO_INCREMENT,
  `zzmmname` varchar(20) NOT NULL,
  PRIMARY KEY (`zzmm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zzmm`
--

LOCK TABLES `zzmm` WRITE;
/*!40000 ALTER TABLE `zzmm` DISABLE KEYS */;
INSERT INTO `zzmm` VALUES (1,'中共党员'),(2,' 中共预备党员'),(3,' 共青团员'),(4,' 民革党员'),(5,' 民盟盟员'),(6,' 民建会员'),(7,' 民进会员'),(8,' 农工党党员'),(9,' 致公党党员'),(10,' 九三学社社员'),(11,' 台盟盟员'),(12,' 无党派民族人士'),(13,' 普通公民(群众)');
/*!40000 ALTER TABLE `zzmm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-18 23:06:01
