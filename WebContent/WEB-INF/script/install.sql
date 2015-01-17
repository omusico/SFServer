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
  `content` varchar(300) DEFAULT '' COMMENT '操作内容',
  `user_department` varchar(50) DEFAULT '' COMMENT '用户部门',
  `extra_string` varchar(50) DEFAULT '' COMMENT '备用字段',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `pkgenerator`;
CREATE TABLE `pkgenerator` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `targetTable` varchar(50) DEFAULT NULL COMMENT '目标表',
  `pkColumnName` varchar(50) DEFAULT NULL COMMENT '主键字段名',
  `initialValue` BIGINT DEFAULT '1' COMMENT '初始化主键值',
  `allocationSize` BIGINT DEFAULT '1' COMMENT '每次递增值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `appparamtb`;
CREATE TABLE `appparamtb` (
  `appparam_id` int(20) NOT NULL COMMENT '系统参数id',
  `appparam_type` varchar(50) DEFAULT NULL COMMENT '参数类型',
  `appparam_name` varchar(50) DEFAULT NULL COMMENT '参数名',
  `appparam_pid` int(20) DEFAULT NULL COMMENT '父参数',
  `appparam_desc` varchar(200) DEFAULT NULL COMMENT '参数描述',
  `systemparam` int(11) DEFAULT '0' COMMENT '是否是系统参数,0:是，1:用户定义的参数',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  PRIMARY KEY (`appparam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `roletb`;
CREATE TABLE `roletb` (
  `role_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_type` varchar(50) DEFAULT '' COMMENT '角色类型',
  `role_name` varchar(50) DEFAULT '' COMMENT '角色名',
  `role_scope` varchar(200) DEFAULT '' COMMENT '角色所拥有的角色范围',
  `role_desc` varchar(200) DEFAULT '' COMMENT '角色描述',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
   PRIMARY KEY (`role_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `departmenttb`;
CREATE TABLE `departmenttb` (
  `department_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '科室编号',
  `department_name` varchar(50) NOT NULL COMMENT '科室名称',
  `tel` varchar(50) DEFAULT '' COMMENT '科室电话',
  `sftel` varchar(50) DEFAULT '' COMMENT '随访电话',
  `department_remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
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
  `user_phone` varchar(30) DEFAULT '' COMMENT '电话',
  `department_id` int(20) NOT NULL COMMENT '所属部门',
  `user_email` varchar(50) DEFAULT '' COMMENT 'email',
  `user_position` varchar(50) DEFAULT '' COMMENT '位置',
  `user_remark` varchar(500) DEFAULT '' COMMENT '备注',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `diagnosistb`;
CREATE TABLE `diagnosistb` (
  `diagnosis_id` BIGINT NOT NULL COMMENT '诊断ID',
  `diagnosis_name` varchar(50) NOT NULL COMMENT '诊断名',
  `suitabledp` varchar(200) DEFAULT '' COMMENT '部门列表',
  `department_remark` varchar(500) DEFAULT NULL COMMENT '诊断描述',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`diagnosis_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `patienttb`;
CREATE TABLE `patienttb` (
  `patientid` BIGINT NOT NULL COMMENT '病患ID',
  `name` varchar(50) NOT NULL COMMENT '病人姓名',
  `nianling` varchar(50) DEFAULT '' COMMENT '病人年龄',
  `xingbie` varchar(4) DEFAULT '男' COMMENT '病人性别',
  `zhengjianhaoma` varchar(100) DEFAULT '' COMMENT '证件号码',
  `telphone` varchar(50) DEFAULT '' COMMENT '座机',
  `address` varchar(50) DEFAULT '' COMMENT '地址',
  `phone` varchar(50) DEFAULT '' COMMENT '移动电话',
  `ophone` varchar(50) DEFAULT '' COMMENT '其他电话号码',
  `oname` varchar(50) DEFAULT '' COMMENT '其他电话号码主人',
  `orelationship` varchar(50) DEFAULT '' COMMENT '与病人的关系',
  `zhuyuancishu` varchar(50) DEFAULT '' COMMENT '住院次数',
  `menzhencishu` varchar(50) DEFAULT '' COMMENT '门诊次数',
  `suifangbeizhu` varchar(1000)  COMMENT '随访备注',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`patientid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `recordcasetb`;
CREATE TABLE `recordcasetb` (
  `recordcaseid` BIGINT NOT NULL COMMENT '病案ID',
  `patientid` BIGINT NOT NULL COMMENT '病患ID',
  `keshi` varchar(50) DEFAULT '' COMMENT '科室',
  `zhuyuanhao` varchar(100) DEFAULT '' COMMENT '住院号',
  `ruyuanriqi` DATE  COMMENT '住院日期',
  `chuyuanzhengduan` varchar(100) DEFAULT '' COMMENT '出院诊断',
  `chuyuanriqi` datetime COMMENT '出院日期',
  `zhurenyisheng` varchar(50) DEFAULT '' COMMENT '主任医生',
  `zhuzhiyisheng` varchar(50) DEFAULT '' COMMENT '主治医生',
  `zhuyuanyisheng` varchar(50) DEFAULT '' COMMENT '住院医生',
  `shoushumingcheng` varchar(200) DEFAULT '' COMMENT '手术明细',
  `zhudaoyisheng` varchar(50) DEFAULT '' COMMENT '主要医生',
  `shoushuriqi` datetime COMMENT '手术日期',
  `zhuyuantianshu` varchar(20) DEFAULT '' COMMENT '住院天数',
  `zhiyuqingkuang` TEXT  COMMENT '治愈情况',
  `chuyuanxiaojie` TEXT  COMMENT '出院小结',
  `chuyuanyizhu` TEXT  COMMENT '出院遗嘱',
  `bingliezhuangtai` varchar(20) DEFAULT '' COMMENT '病历状态',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`recordcaseid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `recordcaseopdtb`;
CREATE TABLE `recordcaseopdtb` (
  `recordcaseid` BIGINT NOT NULL COMMENT '门诊病案ID',
  `patientid` BIGINT NOT NULL COMMENT '病患ID',
  `keshi` varchar(50) DEFAULT '' COMMENT '科室',
  `menzhenhao` varchar(100) DEFAULT '' COMMENT '门诊号',
  `menzhenriqi` DATE  COMMENT '门诊日期',
  `menzhenzhengduan` varchar(100) DEFAULT '' COMMENT '门诊诊断',
  `chuyuanriqi` datetime COMMENT '出院日期',
  `menzhenyisheng` varchar(50) DEFAULT '' COMMENT '门诊医生',
  `zhushu` TEXT  COMMENT '主诉',
  `bingshi` TEXT  COMMENT '病史',
  `chati` TEXT  COMMENT '查体',
  `jiancha` TEXT  COMMENT '检查',  
  `yizhu` TEXT  COMMENT '医嘱',
  `guoqushi` TEXT  COMMENT '过去史',
  `yaowuguominshi` TEXT  COMMENT '药物过敏史',
  `bingliezhuangtai` varchar(20) DEFAULT '' COMMENT '病历状态',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`recordcaseid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `surveytb`;
CREATE TABLE `surveytb` (
  `survery_id` BIGINT NOT NULL COMMENT '问卷ID',
  `survery_name` varchar(100) NOT NULL COMMENT '问卷名',
  `survery_remark` varchar(500) DEFAULT NULL COMMENT '问卷描述',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`survery_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `surveydetailtb`;
CREATE TABLE `surveydetailtb` (
  `surverydetail_id` BIGINT NOT NULL COMMENT '详细问卷内容ID',
  `surverydetail_name` varchar(500) NOT NULL COMMENT '详细问卷内容',
  `surverydetail_remark` varchar(500) DEFAULT NULL COMMENT '问卷备注',
  `surverydetail_answer` varchar(100) DEFAULT NULL COMMENT '默认问卷答案,#号分割',
  `zujima` varchar(500) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`surverydetail_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rs_sv_svd`;
CREATE TABLE `rs_sv_svd` (
  `survery_id` BIGINT NOT NULL COMMENT '问卷ID',
  `surverydetail_id` BIGINT NOT NULL COMMENT '诊断ID',
  PRIMARY KEY (`survery_id`,`surverydetail_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `rs_dns_sv`;
CREATE TABLE `rs_dns_sv` (
  `diagnosis_id` BIGINT NOT NULL COMMENT '诊断ID',
  `survery_id` BIGINT NOT NULL COMMENT '问卷ID',
   PRIMARY KEY (`diagnosis_id`,`survery_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rs_dns_sv_add`;
CREATE TABLE `rs_dns_sv_add` (
  `diagnosis_id` BIGINT NOT NULL COMMENT '诊断ID',
  `department_id` int(20) NOT NULL COMMENT '科室编号',
  `survery_id` BIGINT NOT NULL COMMENT '问卷ID',
  `surverydetail_id` BIGINT default NULL COMMENT '增加的问题'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rs_plan_tel_sv`;
CREATE TABLE `rs_plan_tel_sv` (
  `plan_id` BIGINT NOT NULL COMMENT '计划ID',
  `survery_id` BIGINT NOT NULL COMMENT '问卷ID',
   PRIMARY KEY (`plan_id`,`survery_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sfplantb`;
CREATE TABLE `sfplantb` (
  `plan_id` BIGINT NOT NULL COMMENT '计划ID',
  `patientid` BIGINT NOT NULL COMMENT '病案D',
  `planname` varchar(500) NOT NULL  COMMENT '计划名',
  `plantype` int(2) DEFAULT 0 COMMENT '计划类型  1.短信，0。电话',
  `status` int(2) DEFAULT 0 COMMENT '状态，3.自动过期。2.手动作废。  1.已经完成，0。计划中',
  `planfreq` int(5) DEFAULT 0 COMMENT '计划执行的频率',
  `plannumber` int(5) DEFAULT 0 COMMENT '计划执行的次数',
  `plannexttime` datetime COMMENT '下一次计划开始的时间',
  `user_id` int(20) DEFAULT 0 COMMENT '医生ID',
  `remark` varchar(500) DEFAULT '' COMMENT '描述',
  `zujima` varchar(500) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1.已经删除，0.没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `patientsurveytb`;
CREATE TABLE `patientsurveytb` (
  `patientsurvey_id` BIGINT NOT NULL COMMENT '调查ID',
  `survery_name` varchar(100) DEFAULT '' COMMENT '问卷名',
  `survery_id` BIGINT DEFAULT 0 COMMENT '问卷ID',
  `patientid` BIGINT  DEFAULT 0 COMMENT '病案ID',
  `calltime` BIGINT  DEFAULT 0 COMMENT '通话时长',
  `dialphone` varchar(30) DEFAULT ''  COMMENT '随访电话',
  `recordfile` varchar(100) DEFAULT ''  COMMENT '录音文件',
  `status` int(2) DEFAULT 0 COMMENT '状态，3.自动过期,2.手动作废,1:随访完成，0:随访中，-1:异常',
  `plan_id` BIGINT DEFAULT 0  COMMENT '计划ID',
  `department_id` int(20) DEFAULT 0 COMMENT '科室编号',
  `user_id` int(20) DEFAULT 0 COMMENT '创建人ID',
  `remark` varchar(500) DEFAULT '' COMMENT '描述',
  `zujima` varchar(500) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1.已经删除，0.没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`patientsurvey_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rs_patient_survey_sv`;
CREATE TABLE `rs_patient_survey_sv` (
  `patientsurvey_id` BIGINT NOT NULL COMMENT '调查ID',
  `surverydetail_name` varchar(500) NOT NULL COMMENT '详细问卷内容',
  `surverydetail_answer` varchar(100) DEFAULT NULL COMMENT '问卷答案'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rs_keshi_dns`;
CREATE TABLE `rs_keshi_dns` (
  `department_id` int(20) NOT NULL COMMENT '科室编号',
  `diagnosis_id` BIGINT NOT NULL COMMENT '诊断ID'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `rs_patient_dp_dns`;
CREATE TABLE `rs_patient_dp_dns` (
  `patientid` BIGINT NOT NULL COMMENT '病患ID',
  `department_id` int(20) NOT NULL COMMENT '科室编号',
  `diagnosis_id` BIGINT NOT NULL COMMENT '诊断ID'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `smstypetb`;
CREATE TABLE `smstypetb` (
  `smstype_id` BIGINT NOT NULL COMMENT '短消息类型ID',
  `smstype_name` varchar(30) NOT NULL COMMENT '短消息类型名',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  PRIMARY KEY (`smstype_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `smstb`;
CREATE TABLE `smstb` (
  `sms_id` BIGINT NOT NULL COMMENT '短消息ID',
  `smstype_id` BIGINT NOT NULL COMMENT '短消息类型ID',
  `sms_name` varchar(500) NOT NULL COMMENT '短消息',
  `zujima` varchar(100) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1，已经删除，0：没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`sms_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `rs_dns_sms_add`;
CREATE TABLE `rs_dns_sms_add` (
  `diagnosis_id` BIGINT NOT NULL COMMENT '诊断ID',
  `department_id` int(20) NOT NULL COMMENT '科室编号',
  `sms_name` varchar(500) NOT NULL COMMENT '短消息',
  `smstype_name` varchar(30) NOT NULL COMMENT '短消息类型名'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sfplansmstb`;
CREATE TABLE `sfplansmstb` (
  `smsplan_id` BIGINT NOT NULL COMMENT '计划ID',
  `patientid` BIGINT NOT NULL COMMENT '病案D',
  `smscontext` varchar(500) NOT NULL  COMMENT '短信内容',
  `smstype_name` varchar(30) DEFAULT '' COMMENT '短消息类型名',
  `plantype` int(2) DEFAULT 1 COMMENT '计划类型  1.短信，0。电话',
  `status` int(2) DEFAULT 0 COMMENT '状态，3.自动过期。2.手动作废。  1.已经完成，0。计划中',
  `planfreq` int(5) DEFAULT 0 COMMENT '计划执行的频率',
  `plannumber` int(5) DEFAULT 0 COMMENT '计划执行的次数',
  `plannexttime` datetime COMMENT '下一次计划开始的时间',
  `user_id` int(20) DEFAULT 0 COMMENT '医生ID',
  `remark` varchar(500) DEFAULT '' COMMENT '描述',
  `zujima` varchar(500) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1.已经删除，0.没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`smsplan_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sfplansms_historytb`;
CREATE TABLE `sfplansms_historytb` (
  `smsplan_id` BIGINT NOT NULL COMMENT '计划ID',
  `patientid` BIGINT NOT NULL COMMENT '病案D',
  `smscontext` varchar(500) NOT NULL  COMMENT '短信内容',
  `smstype_name` varchar(30) DEFAULT '' COMMENT '短消息类型名',
  `plantype` int(2) DEFAULT 1 COMMENT '计划类型  1.短信，0。电话',
  `status` int(2) DEFAULT 0 COMMENT '状态，3.自动过期。2.手动作废。  1.已经完成，0。计划中',
  `planfreq` int(5) DEFAULT 0 COMMENT '计划执行的频率',
  `plannumber` int(5) DEFAULT 0 COMMENT '计划执行的次数',
  `plannexttime` datetime COMMENT '下一次计划开始的时间',
  `user_id` int(20) DEFAULT 0 COMMENT '医生ID',
  `remark` varchar(500) DEFAULT '' COMMENT '描述',
  `zujima` varchar(500) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1.已经删除，0.没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`smsplan_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sfplan_historytb`;
CREATE TABLE `sfplan_historytb` (
  `plan_id` BIGINT NOT NULL COMMENT '计划ID',
  `patientid` BIGINT NOT NULL COMMENT '病案D',
  `planname` varchar(500) NOT NULL  COMMENT '计划名',
  `plantype` int(2) DEFAULT 0 COMMENT '计划类型  1.短信，0。电话',
  `status` int(2) DEFAULT 0 COMMENT '状态，3.自动过期。2.手动作废。  1.已经完成，0。计划中',
  `planfreq` int(5) DEFAULT 0 COMMENT '计划执行的频率',
  `plannumber` int(5) DEFAULT 0 COMMENT '计划执行的次数',
  `plannexttime` datetime COMMENT '下一次计划开始的时间',
  `user_id` int(20) DEFAULT 0 COMMENT '医生ID',
  `remark` varchar(500) DEFAULT '' COMMENT '描述',
  `zujima` varchar(500) DEFAULT '' COMMENT '助记码',
  `delete_flag` int(2) DEFAULT 0 COMMENT '是否删除标志，1.已经删除，0.没有删除',
  `createdate` datetime COMMENT '创建时间',
  `createperson` varchar(50) COMMENT '创建时间',
  `updatedate` datetime COMMENT '创建时间',
  `updateperson` varchar(50) COMMENT '创建时间',
  `ext1` varchar(1000) DEFAULT '' COMMENT '扩展字段1',
  `ext2` varchar(1000) DEFAULT '' COMMENT '扩展字段2',
  `ext3` varchar(500) DEFAULT '' COMMENT '扩展字段3',
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rs_plan_tel_sv_history`;
CREATE TABLE `rs_plan_tel_sv_history` (
  `plan_id` BIGINT NOT NULL COMMENT '计划ID',
  `survery_id` BIGINT NOT NULL COMMENT '问卷ID',
   PRIMARY KEY (`plan_id`,`survery_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

/*init value*/
insert  into `roletb`(`role_id`,`role_type`,`role_name`,`role_scope`,`zujima`,`role_desc`)
values
('1','软件用户','系统管理员','系统维护','xtgly','系统初始化');

insert  into `departmenttb`(`department_id`,`department_name`,`department_remark`,`zujima`)
values
(1,'信息科','系统初始化','xxk');

insert  into `usertb`(`user_id`,`user_name`,`user_password`,`user_roles`,`user_sex`,`user_entryDate`,`user_phone`,`department_id`,`user_email`,`user_position`,`user_remark`,`zujima`) 
values 
('1','make','MTIzNDU2','1','男',NULL,'',1,'','','系统初始化','make');

