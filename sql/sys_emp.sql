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

 Date: 07/10/2022 23:50:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_emp
-- ----------------------------
DROP TABLE IF EXISTS `sys_emp`;
CREATE TABLE `sys_emp`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `age` int(3) NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `un_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_emp
-- ----------------------------
INSERT INTO `sys_emp` VALUES (1, '张三', '1123600000@qq.com', '18011113330', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (2, '李四', '1123600001@qq.com', '18011113331', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (3, '王五', '1123600002@qq.com', '18011113332', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (4, '赵六', '1123600003@qq.com', '18011113333', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (5, '吴刚', '1123600004@qq.com', '18011113334', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (6, '李俊', '1123600005@qq.com', '18011113335', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (7, '肖亮', '1123600006@qq.com', '18011113336', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (8, '张在军', '1123600007@qq.com', '18011113337', '测试账号', 25);

SET FOREIGN_KEY_CHECKS = 1;
