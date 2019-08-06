/*
 Navicat Premium Data Transfer

 Source Server         : docker_percona_3306
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : leetcode

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 05/08/2019 21:24:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES (1, 'A', 'a');
INSERT INTO `customer` VALUES (2, 'B', 'b');
INSERT INTO `customer` VALUES (3, 'C', 'c');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
