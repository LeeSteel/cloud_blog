/*
 Navicat Premium Data Transfer

 Source Server         : localhost_root
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : cloud_blog_plat

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 22/10/2019 15:55:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cb_plat_sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_dict`;
CREATE TABLE `cb_plat_sys_dict`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `group_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属分组id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `value` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典值',
  `parent_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级编号',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态码',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-数据字典' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_dict_group
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_dict_group`;
CREATE TABLE `cb_plat_sys_dict_group`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分组编码',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分组名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`, `code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-数据字典分组' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_log`;
CREATE TABLE `cb_plat_sys_log`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_menu`;
CREATE TABLE `cb_plat_sys_menu`  (
  `menu_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `parent_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父菜单id，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `perms` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_org
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_org`;
CREATE TABLE `cb_plat_sys_org`  (
  `org_no` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构编码',
  `org_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `parent_no` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上级机构id，一级机构为0',
  `org_type` int(11) NULL DEFAULT NULL COMMENT '级别',
  `status` int(11) NULL DEFAULT 1 COMMENT '状态  0：无效   1：有效',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`org_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-组织机构' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_role`;
CREATE TABLE `cb_plat_sys_role`  (
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者id',
  `create_user_org_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者所属机构',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_role_menu`;
CREATE TABLE `cb_plat_sys_role_menu`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_role_org
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_role_org`;
CREATE TABLE `cb_plat_sys_role_org`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `org_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '机构id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-角色与机构对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_user`;
CREATE TABLE `cb_plat_sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `real_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sex` tinyint(4) NOT NULL COMMENT '性别',
  `org_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '机构编码',
  `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email_host` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮件服务器地址',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `email_pw` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱密码',
  `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者id',
  `create_user_org_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人所属机构',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `cbpsu_uname_idx`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_user_role`;
CREATE TABLE `cb_plat_sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cb_plat_sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `cb_plat_sys_user_token`;
CREATE TABLE `cb_plat_sys_user_token`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台-系统-用户token' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
