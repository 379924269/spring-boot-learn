# --------------------------------------------------------
# Host:                         localhost
# Server version:               5.1.28-rc-community
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2018-04-10 17:00:13
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for adaption-test
DROP DATABASE IF EXISTS `adaption-test`;
CREATE DATABASE IF NOT EXISTS `adaption-test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `adaption-test`;


# Dumping structure for table adaption-test.application
DROP TABLE IF EXISTS `application`;
CREATE TABLE IF NOT EXISTS `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) NOT NULL COMMENT '应用名称',
  `version_name` varchar(100) NOT NULL DEFAULT '' COMMENT '应用版本名称',
  `version_code` int(10) NOT NULL COMMENT '应用版本号',
  `package_name` varchar(200) NOT NULL DEFAULT '' COMMENT '应用报名',
  `system` varchar(100) NOT NULL DEFAULT '' COMMENT '应用版本：如：华为、中心等（包名相同不同版本）',
  `md5` varchar(256) DEFAULT '' COMMENT '应用MD5',
  `size` int(11) DEFAULT '0' COMMENT '应用大小',
  `url` text NOT NULL COMMENT '应用地址',
  `created_date` bigint(13) NOT NULL COMMENT '创建时间',
  `description` varchar(200) NOT NULL COMMENT '应用描述',
  `force_update` int(1) NOT NULL DEFAULT '0' COMMENT '强制更新，0：不强制更新，1：强制更新',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='应用信息';

# Dumping data for table adaption-test.application: ~11 rows (approximately)
DELETE FROM `application`;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` (`id`, `name`, `version_name`, `version_code`, `package_name`, `system`, `md5`, `size`, `url`, `created_date`, `description`, `force_update`) VALUES
	(5, 'dfs', 'asdf', 1, 'asdfasdf', '1', 'asdfasdf', 666666, 'adf', 1509591300855, 'dsfagad', 0),
	(6, '66666666', '66666666', 66666667, '66666666', '', '66666666', 66666666, '66666666', 1509591439878, '66666666', 0),
	(7, '66666666', '66666666', 66666666, '66666666', '', '66666666', 66666666, '66666666', 1509591757857, '66666666', 0),
	(8, '66666666', '66666666', 66666668, '66666666', '', '66666666', 66666666, '66666666', 1509591857009, '66666666', 0),
	(13, 'BBB', '3.3.1.72', 190, 'com.mxspt.dnp', 'z', 'FEA5AF68921BEE81BC6D1ED0223D6448', 9650232, 'apk/FEA5AF68921BEE81BC6D1ED0223D6448.apk', 1509931946368, 'BBB', 0),
	(14, 'BBB', '3.3.1.72', 191, 'com.mxspt.dnp', 'z', 'FEA5AF68921BEE81BC6D1ED0223D6448', 9650232, 'apk/FEA5AF68921BEE81BC6D1ED0223D6448.apk', 1509933593124, 'BBB', 1),
	(15, 'BBB', '3.3.1.72', 193, 'com.mxspt.dnp', 'z', 'FEA5AF68921BEE81BC6D1ED0223D6448', 9650232, 'apk/FEA5AF68921BEE81BC6D1ED0223D6448.apk', 1509933746176, 'BBB', 0),
	(16, 'BBB', '3.3.1.72', 192, 'com.mxspt.dnp', 'z', 'FEA5AF68921BEE81BC6D1ED0223D6448', 9650232, 'apk/FEA5AF68921BEE81BC6D1ED0223D6448.apk', 1509933593124, 'BBB', 1),
	(17, 'BBB', '3.3.1.72', 194, 'com.mxspt.dnp', 'z', 'FEA5AF68921BEE81BC6D1ED0223D6448', 9650232, 'apk/FEA5AF68921BEE81BC6D1ED0223D6448.apk', 1509933915470, 'BBB', 0),
	(19, 'BBB', '3.3.1.72', 200, 'com.mxspt.dnp', 'z', 'FEA5AF68921BEE81BC6D1ED0223D6448', 9650232, 'apk/FEA5AF68921BEE81BC6D1ED0223D6448.apk', 1509935520043, 'BBB', 0),
	(20, 'ddd', '3.3.1.72', 200, 'com.mxspt.dnp', 'huawei', 'FEA5AF68921BEE81BC6D1ED0223D6448', 9650232, 'apk/FEA5AF68921BEE81BC6D1ED0223D6448.apk', 1509935652339, 'ddd', 1);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;


# Dumping structure for table adaption-test.config
DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置id',
  `name` varchar(50) NOT NULL COMMENT '配置名称',
  `content` text NOT NULL COMMENT '配置内容,JSON字符串',
  `created_date` bigint(13) NOT NULL COMMENT '配置创建时间',
  `location_id` int(11) DEFAULT NULL COMMENT '归属地id',
  `model_id` int(11) DEFAULT NULL COMMENT '型号id',
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`),
  KEY `model_id` (`model_id`),
  CONSTRAINT `FK_config_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE SET NULL,
  CONSTRAINT `FK_config_model` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='配置信息';

# Dumping data for table adaption-test.config: ~12 rows (approximately)
DELETE FROM `config`;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` (`id`, `name`, `content`, `created_date`, `location_id`, `model_id`) VALUES
	(1, '华仔配置', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":80,"domain":"127.0.0.1","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 1497597907600, 1, 1),
	(2, '华仔配置1', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 1497597907600, 1, 1),
	(3, '测试3', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 1497597907600, NULL, 2),
	(4, 'asd', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 1497948950287, 1, 1),
	(5, '测试5', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 1498006086493, NULL, NULL),
	(6, '测试5', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 1498006100826, NULL, NULL),
	(7, '啊啊', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 125865656555, NULL, NULL),
	(8, '啊啊', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 125865656555, NULL, NULL),
	(9, '啊啊', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 125865656555, NULL, NULL),
	(10, '啊啊', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 125865656555, NULL, NULL),
	(11, 'aaqq', '{"isEMM":true,"multipleIcon":false,"useAPN":true,"APNParam":{"name":"testAPN","apn":"test.apn.com","type":"","numeric":"","mcc":"","mnc":"","proxy":"","port":"","mmsporxy":"","mmsport":"","user":"test","server":"","password":"123456","mmsc":"","authtype":"","protocol":"","roaming_protocol":"","bearer":"","mvno_type":""},"useVPN":false,"VPNParam":{"userName":"","userPassword":"","ip":"","port":"","type":"","useCertificate":true},"server":{"ptt":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"emm":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"video":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"push":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"solr":{"port":8001,"domain":"test.delinp.cn","protocol":"http"},"gis":{"port":8001,"domain":"test.delinp.cn","protocol":"http"}}}', 125865656555, NULL, NULL),
	(12, 'fdsafdsa海信 配置', '{  "isEMM": false,  "server": {    "emm": {      "domain": "",      "port": ""    },    "ptt": {      "value": "ptt",      "name": "PTT服务器",      "port": 80,      "domain": "11.011.11",      "protocol": "http"    },    "video": {      "domain": "",      "port": ""    },    "push": {      "domain": "",      "port": ""    },    "solr": {      "domain": "",      "port": ""    },    "gis": {      "domain": "",      "port": ""    }  },  "useAPN": false,  "APNParam": {    "name": "",    "apn": "",    "type": "",    "numeric": "",    "mcc": "",    "mnc": "",    "proxy": "",    "port": "",    "mmsporxy": "",    "mmsport": "",    "user": "",    "server": "",    "password": "",    "mmsc": "",    "authtype": "",    "protocol": "",    "roaming_protocol": "",    "bearer": "",    "mvno_type": ""  },  "useVPN": false,  "VPNParam": {    "VPNParam": {      "userName": "",      "userPassword": "",      "ip": "",      "useCertificate": false    }  }}', 1504160639462, 5, 2);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;


# Dumping structure for table adaption-test.device
DROP TABLE IF EXISTS `device`;
CREATE TABLE IF NOT EXISTS `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `serial_number` varchar(200) NOT NULL COMMENT '设备的SN（序列号）',
  `downloads` int(11) DEFAULT '0' COMMENT '下载次数',
  `config_id` int(11) DEFAULT NULL COMMENT '配置id',
  `application_id` int(11) DEFAULT NULL COMMENT '应用id',
  `location_id` int(11) DEFAULT NULL COMMENT '归属地id',
  `model_id` int(11) DEFAULT NULL COMMENT '型号id',
  `tfcard_id` int(11) DEFAULT NULL COMMENT 'TF卡id',
  `token` varchar(50) DEFAULT NULL COMMENT '设备口令',
  `expiration_time` bigint(13) DEFAULT '0' COMMENT '口令过期过期时间',
  `created_date` bigint(13) NOT NULL COMMENT '创建时间',
  `adaption_date` bigint(13) DEFAULT '0' COMMENT '适配（激活）时间',
  `use_tfcard` int(1) DEFAULT '1' COMMENT '使用tfcard， 1：使用， 0：不用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serial_number` (`serial_number`),
  KEY `FK_Reference_1` (`config_id`),
  KEY `FK_Reference_2` (`application_id`),
  KEY `FK_Reference_4` (`model_id`),
  KEY `FK_Reference_5` (`tfcard_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `FK_device_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE SET NULL,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`config_id`) REFERENCES `config` (`id`) ON DELETE SET NULL,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE SET NULL,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`) ON DELETE SET NULL,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`tfcard_id`) REFERENCES `tfcard` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='设备信息';

# Dumping data for table adaption-test.device: ~30 rows (approximately)
DELETE FROM `device`;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` (`id`, `serial_number`, `downloads`, `config_id`, `application_id`, `location_id`, `model_id`, `tfcard_id`, `token`, `expiration_time`, `created_date`, `adaption_date`, `use_tfcard`) VALUES
	(2, '222', 0, NULL, 19, NULL, NULL, NULL, NULL, 0, 1504161827292, 0, 1),
	(3, '3333', 0, NULL, 19, 1, 1, 11, NULL, 0, 1504161827306, 0, 1),
	(4, '444', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827325, 0, 1),
	(7, '7877', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827381, 0, 1),
	(8, '888', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827400, 0, 1),
	(9, '999', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827415, 0, 1),
	(10, '0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827442, 0, 1),
	(11, '234', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827457, 0, 1),
	(12, '345345', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827475, 0, 1),
	(13, '34535677', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827490, 0, 1),
	(14, '789ghj', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827509, 0, 1),
	(15, '5354h', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827523, 0, 1),
	(16, '6578vg', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827558, 0, 1),
	(17, '789l', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827573, 0, 1),
	(18, 'fgj6', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827592, 0, 1),
	(19, '666kkg', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827606, 0, 1),
	(20, '1111hh', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827625, 0, 1),
	(21, 'gg', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1504161827647, 0, 1),
	(22, '123456', 0, 10, 20, 7, 2, NULL, NULL, 0, 1514189816323, 0, 1),
	(23, 'sdfasd', 0, 10, 20, 7, 2, NULL, NULL, 0, 1514190159242, 0, 1),
	(24, 'ddddd', 0, 10, 20, 7, 2, NULL, NULL, 0, 1514190186539, 0, 1),
	(25, 'dfdfdfdfdss', 0, 12, 19, 1, 2, NULL, NULL, 0, 1514190471611, 0, 1),
	(26, 'asdfasdf', 0, 12, 20, 7, 2, NULL, NULL, 0, 1514190966513, 0, 1),
	(27, '666333555', 0, 11, 20, 7, 2, NULL, NULL, 0, 1514190996890, 0, 1),
	(28, '1111111111111111', 0, 11, 20, 7, 2, NULL, NULL, 0, 1514191070507, 0, 1),
	(29, '22222222222', 0, 10, 20, 5, 1, NULL, NULL, 0, 1514191201191, 0, 1),
	(30, '33333333', 0, 9, 20, 5, 2, NULL, NULL, 0, 1514191227336, 0, 1),
	(31, '9999999999', 0, 11, 20, 7, 2, NULL, NULL, 0, 1514192018913, 0, 1),
	(32, '25252', 0, 12, 20, 4, 2, NULL, NULL, 0, 1514251276374, 0, 1),
	(33, '66666666666666', 0, 11, 20, 5, 2, NULL, NULL, 0, 1514255107725, 1514255182910, 1);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;


# Dumping structure for table adaption-test.local
DROP TABLE IF EXISTS `local`;
CREATE TABLE IF NOT EXISTS `local` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

# Dumping data for table adaption-test.local: ~1 rows (approximately)
DELETE FROM `local`;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` (`id`, `name`) VALUES
	(1, '广东');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;


# Dumping structure for table adaption-test.location
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '归属地id',
  `name` varchar(200) NOT NULL COMMENT '归属地名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='归属地信息';

# Dumping data for table adaption-test.location: ~4 rows (approximately)
DELETE FROM `location`;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`id`, `name`) VALUES
	(1, '北京'),
	(4, 'fdasfdsa'),
	(5, 'fdsafdsa'),
	(7, 'asdf');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;


# Dumping structure for table adaption-test.model
DROP TABLE IF EXISTS `model`;
CREATE TABLE IF NOT EXISTS `model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '型号id',
  `name` varchar(200) NOT NULL COMMENT '型号名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='型号信息';

# Dumping data for table adaption-test.model: ~2 rows (approximately)
DELETE FROM `model`;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` (`id`, `name`) VALUES
	(1, '华为'),
	(2, '海信');
/*!40000 ALTER TABLE `model` ENABLE KEYS */;


# Dumping structure for table adaption-test.resource
DROP TABLE IF EXISTS `resource`;
CREATE TABLE IF NOT EXISTS `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `res_url` varchar(50) DEFAULT NULL,
  `res_key` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

# Dumping data for table adaption-test.resource: ~56 rows (approximately)
DELETE FROM `resource`;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` (`id`, `name`, `parent_id`, `res_url`, `res_key`) VALUES
	(1, 'DMS配置', 0, '', NULL),
	(2, '管理员', 1, '', ''),
	(3, '管理员添加', 2, '/manager', 'manager:create'),
	(4, '管理员修改', 2, '/manager', 'manager:update'),
	(5, '管理员删除', 2, '/manager/*', 'manager:delete'),
	(6, '管理员查看详情', 2, '/manager/*', 'manager:read'),
	(7, '管理员查询所有', 2, '/manager', 'manager:read'),
	(8, '角色', 1, '', ''),
	(9, '角色添加', 8, '/role', 'role:create'),
	(10, '角色修改', 8, '/role', 'role:update'),
	(11, '角色删除', 8, '/role/*', 'role:delete'),
	(12, '角色查看详情', 8, '/role/*', 'role:read'),
	(13, '角色查询所有', 8, '/role', 'role:read'),
	(14, '资源', 1, '', ''),
	(15, '资源添加', 14, '/resource', 'resource:create'),
	(16, '资源修改', 14, '/resource', 'resource:update'),
	(17, '资源删除', 14, '/resource/*', 'resource:delete'),
	(18, '资源查看详情', 14, '/resource/*', 'resource:read'),
	(19, '资源查询所有', 14, '/resource', 'resource:read'),
	(20, '设备管理', 10000, '', NULL),
	(21, '配置', 20, '', ''),
	(22, '配置添加', 21, '/config', 'config:ceate'),
	(23, '配置修改', 21, '/config', 'config:update'),
	(24, '配置删除', 21, '/config/*', 'config:delete'),
	(25, '配置查看详情', 21, '/config/*', 'config:read'),
	(26, '配置查询所有', 21, '/config', 'config:read'),
	(27, '设备', 20, '', ''),
	(28, '设备添加', 27, '/device', 'device:create'),
	(29, '设备修改', 27, '/device', 'device:update'),
	(30, '设备删除', 27, '/device/*', 'device:delete'),
	(31, '设备查看详情', 27, '/device/*', 'device:read'),
	(32, '设备查询所有', 27, '/device', 'device:read'),
	(33, 'TF卡', 20, '', ''),
	(34, 'TF卡添加', 23, '/tfcard', 'tfcard:create'),
	(35, 'TF卡修改', 23, '/tfcard', 'tfcard:update'),
	(36, 'TF卡删除', 23, '/tfcard/*', 'tfcard:delete'),
	(37, 'TF卡查看详情', 23, '/tfcard/*', 'tfcard:read'),
	(38, 'TF卡查询所有', 23, '/tfcard', 'tfcard:read'),
	(39, '归属地', 20, '', ''),
	(40, '归属地添加', 39, '/location', 'location:create'),
	(41, '归属地修改', 39, '/location', 'location:update'),
	(42, '归属地删除', 39, '/location/*', 'location:delete'),
	(43, '归属地查看详情', 39, '/location/*', 'location:read'),
	(44, '归属地查询所有', 39, '/location', 'location:read'),
	(45, '型号', 20, '', ''),
	(46, '型号添加', 45, '/model', 'model:create'),
	(47, '型号修改', 45, '/model', 'model:update'),
	(48, '型号删除', 45, '/model/*', 'model:delete'),
	(49, '型号查看详情', 45, '/model/*', 'model:read'),
	(50, '型号查询所有', 45, '/model', 'model:read'),
	(51, 'APK管理', 20, '', ''),
	(52, 'APK添加', 51, '/application', 'application:create'),
	(53, 'APK修改', 51, '/application', 'application:update'),
	(54, 'APK删除', 51, '/application/*', 'application:delete'),
	(55, 'APK查看详情', 51, '/application/*', 'application:read'),
	(56, 'APK查询所有', 51, '/application', 'application:read');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;


# Dumping structure for table adaption-test.res_role
DROP TABLE IF EXISTS `res_role`;
CREATE TABLE IF NOT EXISTS `res_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源角色关系id',
  `resource_id` int(11) NOT NULL COMMENT '资源id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`role_id`),
  KEY `resource_id` (`resource_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源角色关系信息';

# Dumping data for table adaption-test.res_role: ~0 rows (approximately)
DELETE FROM `res_role`;
/*!40000 ALTER TABLE `res_role` DISABLE KEYS */;
INSERT INTO `res_role` (`id`, `resource_id`, `role_id`) VALUES
	(1, 56, 2),
	(2, 1, 2);
/*!40000 ALTER TABLE `res_role` ENABLE KEYS */;


# Dumping structure for table adaption-test.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(50) DEFAULT '' COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色信息';

# Dumping data for table adaption-test.role: ~3 rows (approximately)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `description`) VALUES
	(1, '管理员', NULL),
	(2, '超级管理员', NULL),
	(3, '普通用户', NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


# Dumping structure for table adaption-test.tfcard
DROP TABLE IF EXISTS `tfcard`;
CREATE TABLE IF NOT EXISTS `tfcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键代理id',
  `tf_id` varchar(64) NOT NULL COMMENT 'tf卡id',
  `tf_sn` varchar(64) NOT NULL COMMENT 'tf卡的序列号',
  `status` int(1) DEFAULT '0' COMMENT '-1:停用,0:未使用,1:使用',
  `location_id` int(11) DEFAULT NULL COMMENT '归属地id',
  `created_date` bigint(13) NOT NULL COMMENT 'tf卡创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tf_sn` (`tf_sn`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `FK_tfcard_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='TF卡信息';

# Dumping data for table adaption-test.tfcard: ~4 rows (approximately)
DELETE FROM `tfcard`;
/*!40000 ALTER TABLE `tfcard` DISABLE KEYS */;
INSERT INTO `tfcard` (`id`, `tf_id`, `tf_sn`, `status`, `location_id`, `created_date`) VALUES
	(1, '1', '1', 1, NULL, 1497599770577),
	(2, '1', '2', 0, NULL, 1497599770577),
	(10, 'gg', 'gg', 0, 1, 1497599770577),
	(11, '11', '11', -1, 1, 1497599770577);
/*!40000 ALTER TABLE `tfcard` ENABLE KEYS */;


# Dumping structure for table adaption-test.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(200) NOT NULL COMMENT '用户名称',
  `email` varchar(200) NOT NULL COMMENT '用户email',
  `password` varchar(200) NOT NULL COMMENT '用户密码',
  `created_date` bigint(13) NOT NULL COMMENT '用户创建日期',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='用户信息';

# Dumping data for table adaption-test.user: ~31 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `email`, `password`, `created_date`, `role_id`) VALUES
	(1, 'aa', 'huazai@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 1111, 2),
	(2, 'admin', 'admin@delinp.cn', 'e10adc3949ba59abbe56e057f20f883e', 1497580679731, 1),
	(3, '1111', '1111@qq.com', '1111', 1504513900009, 1),
	(4, 'huazai', 'admin', '123456', 1222211, 1),
	(5, '66666', '66666', '66666', 1509608461038, 1),
	(6, '1', '1@qq.com', '123456', 1521529560545, 1),
	(7, '123456', '11@qq.com', '123456', 1521530328098, 1),
	(9, '1', '2@qq.com', '123456', 1521530685191, 1),
	(11, '11', '5@qq.com', '123456', 1521531117907, 1),
	(12, '111', '111@qq.com', '123456', 1521612817121, 1),
	(13, '1', '11111@qq.com', '123456', 1521620651847, 1),
	(14, '1', 'a@qq.com', '123456', 1521688495833, 1),
	(15, '1', 'b@qq.com', '123456', 1521689335196, 1),
	(16, 'lala', 'lala@qq.com', '123456', 1522659034432, 1),
	(18, 'lala1546879238', 'lala@qq.com1074030190', '123456', 1522659597454, 1),
	(19, 'lala1466375809', 'lala@qq.com-719231899', '123456', 1522718171639, 1),
	(20, 'lala-674074039', 'lala@qq.com-439409253', '123456', 1522718522771, 1),
	(21, 'lala-1925864296', 'lala@qq.com-1124142839', '123456', 1522719235490, 1),
	(22, 'lala-817791591', 'lala@qq.com-447635522', '123456', 1522719322642, 1),
	(23, 'lala1006016633', 'lala@qq.com555927576', '123456', 1522719553938, 1),
	(24, 'lala1150045104', 'lala@qq.com931557387', '123456', 1522719676641, 1),
	(25, 'lala1038055228', 'lala@qq.com-1396275490', '123456', 1522719948565, 1),
	(26, 'lala1493860306', 'lala@qq.com-1013275029', '123456', 1522720580088, 1),
	(27, 'lala1126233893', 'lala@qq.com478990577', '123456', 1522720758618, 1),
	(28, 'lala-1833858882', 'lala@qq.com740408821', '123456', 1522720956673, 1),
	(29, 'lala-1806038151', 'lala@qq.com-293553666', '123456', 1522722074660, 1),
	(30, 'lala799363329', 'lala@qq.com370703871', '123456', 1522722159615, 1),
	(31, 'lala-1946082829', 'lala@qq.com-304953855', '123456', 1522722610448, 1),
	(32, 'lala1722021629', 'lala@qq.com-703489176', '123456', 1522724230949, 1),
	(33, 'lala-1922901119', 'lala@qq.com1178731285', '123456', 1522724669115, 1),
	(34, 'lala-1406565631', 'lala@qq.com1755248414', '123456', 1522742025120, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
