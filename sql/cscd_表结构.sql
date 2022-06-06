/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : cscd

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 06/06/2022 12:44:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `uid` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `companyname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司名称',
  `regionid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司所在地区编号',
  `equipmentnum` int NULL DEFAULT 0 COMMENT '公司设备数量',
  `describes` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '公司描述',
  `updatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `regionid`(`regionid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for companydaily
-- ----------------------------
DROP TABLE IF EXISTS `companydaily`;
CREATE TABLE `companydaily`  (
  `uid` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `companyuid` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属公司uid',
  `boom` bit(1) NULL DEFAULT NULL COMMENT '是否爆炸 1:爆炸，0:没爆炸',
  `fire` bit(1) NULL DEFAULT NULL COMMENT '是否火警 1:火警，0:没火警',
  `updatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间, 每天一更新',
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `companyuid`(`companyuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `uid` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `devicename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备名称/设备编号',
  `companyuid` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属公司uid',
  `temperaturemin` float NULL DEFAULT NULL COMMENT '温度允许的最低值',
  `temperaturemax` float NULL DEFAULT NULL COMMENT '温度允许的最高值',
  `humiditymin` float NULL DEFAULT NULL COMMENT '湿度允许的最低值',
  `humiditymax` float NULL DEFAULT NULL COMMENT '湿度允许的最高值',
  `naturalgasmin` float NULL DEFAULT NULL COMMENT '天然气允许的最低值',
  `naturalgasmax` float NULL DEFAULT NULL COMMENT '天然气允许的最高值',
  `alcoholmin` float NULL DEFAULT NULL COMMENT '酒精允许的最低值',
  `alcoholmax` float NULL DEFAULT NULL COMMENT '酒精允许的最高值',
  `illuminationmin` float NULL DEFAULT NULL COMMENT '光照允许的最低值',
  `illuminationmax` float NULL DEFAULT NULL COMMENT '光照允许的最高值',
  `handle` bit(1) NULL DEFAULT b'0' COMMENT '是否处置\r\n0：没处置或无需处置\r\n1：已处置',
  `states` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '设备标志\r\n1. 设备在线\r\n2. 设备离线\r\n3. 设备告警',
  `updatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for devicedata
-- ----------------------------
DROP TABLE IF EXISTS `devicedata`;
CREATE TABLE `devicedata`  (
  `uid` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `companyuid` char(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属公司uid',
  `deviceuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属设备uid',
  `temperature` float NULL DEFAULT NULL COMMENT '温度值',
  `humidity` float NULL DEFAULT NULL COMMENT '湿度值',
  `naturalgas` float NULL DEFAULT NULL COMMENT '天然气值',
  `alcohol` float NULL DEFAULT NULL COMMENT '酒精值',
  `illumination` float NULL DEFAULT NULL COMMENT '光照值',
  `temperaturewarn` bit(1) NULL DEFAULT NULL COMMENT '温度告警标志 1:告警 0:不告警',
  `humiditywarn` bit(1) NULL DEFAULT NULL COMMENT '湿度告警标志 1:告警 0:不告警',
  `naturalgaswarn` bit(1) NULL DEFAULT NULL COMMENT '天然气告警标志 1:告警 0:不告警',
  `alcoholwarn` bit(1) NULL DEFAULT NULL COMMENT '酒精告警标志 1:告警 0:不告警',
  `illuminationwarn` bit(1) NULL DEFAULT NULL COMMENT '光照告警标志 1:告警 0:不告警',
  `updatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间（每3分钟更新一次）',
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `deviceuid`(`deviceuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`  (
  `regionid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地区主键编号',
  `regionname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地区名称',
  `regionshortname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区缩写',
  `regioncode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政地区编号',
  `regionparentid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区父id',
  `regionlevel` int NULL DEFAULT NULL COMMENT '地区级别 1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县',
  PRIMARY KEY (`regionid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地区表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
