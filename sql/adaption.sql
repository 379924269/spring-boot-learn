# --------------------------------------------------------
# Host:                         localhost
# Server version:               5.1.28-rc-community
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2018-03-29 15:19:31
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for adaption
DROP DATABASE IF EXISTS `adaption`;
CREATE DATABASE IF NOT EXISTS `adaption` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `adaption`;


# Dumping structure for table adaption.application
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用信息';

# Data exporting was unselected.


# Dumping structure for table adaption.config
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置信息';

# Data exporting was unselected.


# Dumping structure for table adaption.device
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备信息';

# Data exporting was unselected.


# Dumping structure for table adaption.location
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '归属地id',
  `name` varchar(200) NOT NULL COMMENT '归属地名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='归属地信息';

# Data exporting was unselected.


# Dumping structure for table adaption.model
DROP TABLE IF EXISTS `model`;
CREATE TABLE IF NOT EXISTS `model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '型号id',
  `name` varchar(200) NOT NULL COMMENT '型号名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='型号信息';

# Data exporting was unselected.


# Dumping structure for table adaption.resource
DROP TABLE IF EXISTS `resource`;
CREATE TABLE IF NOT EXISTS `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `name` varchar(50) NOT NULL COMMENT '资源名称',
  `parent_id` int(11) NOT NULL COMMENT '资源父节点',
  `res_key` varchar(50) NOT NULL COMMENT '资源key',
  `res_url` varchar(200) DEFAULT '' COMMENT '资源value',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源权限信息';

# Data exporting was unselected.


# Dumping structure for table adaption.res_role
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

# Data exporting was unselected.


# Dumping structure for table adaption.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(50) DEFAULT '' COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息';

# Data exporting was unselected.


# Dumping structure for table adaption.tfcard
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TF卡信息';

# Data exporting was unselected.


# Dumping structure for table adaption.user
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
