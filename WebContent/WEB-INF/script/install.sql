/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hpsf` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hpsf`;

DROP TABLE IF EXISTS `logtb`;
CREATE TABLE `logtb` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id自动增长类型',
  `operate_name` varchar(30) DEFAULT NULL COMMENT '操作人',
  `operate_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `content` varchar(300) DEFAULT NULL COMMENT '操作内容',
  `user_department` varchar(50) DEFAULT NULL COMMENT '用户部门',
  `extra_string` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `pkgenerator`;
CREATE TABLE `pkgenerator` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `targetTable` varchar(50) DEFAULT NULL COMMENT '目标表',
  `pkColumnName` varchar(50) DEFAULT NULL COMMENT '主键字段名',
  `initialValue` int(11) DEFAULT '1' COMMENT '初始化主键值',
  `allocationSize` int(11) DEFAULT '1' COMMENT '每次递增值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `appparamtb`;
CREATE TABLE `appparamtb` (
  `appparam_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '系统参数id',
  `appparam_type` varchar(50) DEFAULT NULL COMMENT '参数类型',
  `appparam_name` varchar(50) DEFAULT NULL COMMENT '参数名',
  `appparam_pid` int(20) DEFAULT NULL COMMENT '父参数',
  `appparam_desc` varchar(200) DEFAULT NULL COMMENT '参数描述',
  `systemparam` int(11) DEFAULT '0' COMMENT '是否是系统参数,0:是，1:用户定义的参数',
  PRIMARY KEY (`appparam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `roletb`;
CREATE TABLE `roletb` (
  `role_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_type` varchar(50) DEFAULT NULL COMMENT '角色类型',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_scope` varchar(200) DEFAULT NULL COMMENT '角色所拥有的角色范围',
  `role_desc` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `zujima` varchar(100) DEFAULT NULL COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
   PRIMARY KEY (`role_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `departmenttb`;
CREATE TABLE `departmenttb` (
  `department_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '科室编号',
  `department_name` varchar(50) NOT NULL COMMENT '科室名称',
  `tel` varchar(50) DEFAULT NULL COMMENT '科室电话',
  `sftel` varchar(50) DEFAULT NULL COMMENT '随访电话',
  `department_remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `zujima` varchar(100) DEFAULT NULL COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `usertb`;
CREATE TABLE `usertb` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '职员ID',
  `user_name` varchar(50) NOT NULL DEFAULT 'null' COMMENT '名字',
  `user_password` varchar(50) NOT NULL DEFAULT 'null' COMMENT '密码',
  `user_roles` int(20) NOT NULL COMMENT '角色',
  `user_sex` char(2) NOT NULL COMMENT '性别',
  `user_entryDate` datetime DEFAULT NULL COMMENT '入职时间',
  `user_phone` varchar(30) DEFAULT 'null' COMMENT '电话',
  `department_id` int(20) NOT NULL COMMENT '所属部门',
  `user_email` varchar(50) DEFAULT 'null' COMMENT 'email',
  `user_position` varchar(50) DEFAULT 'null' COMMENT '位置',
  `user_remark` varchar(500) DEFAULT 'null' COMMENT '备注',
  `zujima` varchar(100) DEFAULT NULL COMMENT '助记码',
  `ext1` varchar(1000) DEFAULT NULL COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT NULL COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT NULL COMMENT '扩展字段3',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


