/*
Navicat MySQL Data Transfer

Source Server         : zs
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : excle

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-07-11 13:15:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `in_dx`
-- ----------------------------
DROP TABLE IF EXISTS `in_dx`;
CREATE TABLE `in_dx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_number` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `cost_package` double DEFAULT NULL,
  `cost_base` double DEFAULT NULL,
  `cost_local` double DEFAULT NULL,
  `cost_long` double DEFAULT NULL,
  `cost_data` double DEFAULT NULL,
  `cost_short` double DEFAULT NULL,
  `cost_complex` double DEFAULT NULL,
  `cost_other` double DEFAULT NULL,
  `cost_instead` double DEFAULT NULL,
  `cost_preferential` double DEFAULT NULL,
  `cost_advance_pay` double DEFAULT NULL,
  `cost_paid` double DEFAULT NULL,
  `cost_group_pay` double DEFAULT NULL,
  `cost_must_pay` double DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17225 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of in_dx
-- ----------------------------

-- ----------------------------
-- Table structure for `out_dx_detail`
-- ----------------------------
DROP TABLE IF EXISTS `out_dx_detail`;
CREATE TABLE `out_dx_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `equipment_number` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `month_monry` varchar(255) DEFAULT NULL,
  `first_department` varchar(255) DEFAULT NULL,
  `invoice` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=867 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of out_dx_detail
-- ----------------------------
