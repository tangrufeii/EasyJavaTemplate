/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 07/10/2022 23:50:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_shop
-- ----------------------------
DROP TABLE IF EXISTS `sys_shop`;
CREATE TABLE `sys_shop`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `shop_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `price` decimal(65, 0) NULL DEFAULT NULL COMMENT '价格',
  `stock` bigint(255) NULL DEFAULT NULL COMMENT '库存',
  `describee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `shop_name`(`shop_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_shop
-- ----------------------------
INSERT INTO `sys_shop` VALUES (1, 'IphoneXR', 9999, 11, '128G,土豪金');
INSERT INTO `sys_shop` VALUES (2, '小米手机', 2000, 11, '64G,白色版本');
INSERT INTO `sys_shop` VALUES (3, 'java成神之路', 10000, 11, '学了就成神');
INSERT INTO `sys_shop` VALUES (4, '龙井茶叶', 4000, 11, '茶里茶气');
INSERT INTO `sys_shop` VALUES (5, '华为GT手表', 177, 11, '高端奢华上档次');

SET FOREIGN_KEY_CHECKS = 1;
