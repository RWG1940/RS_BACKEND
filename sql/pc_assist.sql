/*
Navicat MySQL Data Transfer

Source Server         : 192.168.24.6
Source Server Version : 80042
Source Host           : 192.168.24.6:3306
Source Database       : pc_assist

Target Server Type    : MYSQL
Target Server Version : 80042
File Encoding         : 65001

Date: 2025-07-20 21:30:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_version
-- ----------------------------
DROP TABLE IF EXISTS `app_version`;
CREATE TABLE `app_version` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `version_code` int NOT NULL,
  `version_name` varchar(50) NOT NULL,
  `update_title` varchar(100) DEFAULT NULL,
  `update_content` text,
  `platform` varchar(20) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `file_size` bigint DEFAULT NULL,
  `force_update` tinyint DEFAULT '0',
  `published` tinyint DEFAULT '0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of app_version
-- ----------------------------
INSERT INTO `app_version` VALUES ('17', '6', 'test6', '123', 't6', 'win', '/code/RS_BACKEND/upload/a58f3dcca33b45fc97ff03c73f56eee7_update.zip', '33', '1', '0', '2025-07-15 18:35:14', '2025-07-16 09:51:24');
INSERT INTO `app_version` VALUES ('18', '7', 'test7', null, '测试7', null, '/code/RS_BACKEND/upload/5e17ec11e980444c8ccc0de765d7825f_update.zip', null, '0', '0', '2025-07-16 13:59:11', '2025-07-16 13:59:11');
INSERT INTO `app_version` VALUES ('19', '8', 'test8', null, '测试8', null, '/code/RS_BACKEND/upload/cd2361c04d954be39986f412d7501a06_update.zip', null, '1', '0', '2025-07-16 14:24:44', '2025-07-16 14:24:44');
INSERT INTO `app_version` VALUES ('20', '9', 'test9', null, 'test9', null, '/code/RS_BACKEND/upload/05691bb675ea4f0789e608b3ff42bb50_update.zip', null, '1', '0', '2025-07-16 14:37:49', '2025-07-16 14:37:49');
INSERT INTO `app_version` VALUES ('21', '10', 'test10', null, 'test10', null, '/code/RS_BACKEND/upload/1048e2438fdd47fa911129ee340b9a8f_update.zip', null, '1', '0', '2025-07-16 14:48:02', '2025-07-16 14:48:02');
INSERT INTO `app_version` VALUES ('22', '11', 'test11', null, 'test11', null, '/code/RS_BACKEND/upload/68d2d1dec162445f826144514a3c99ed_update.zip', null, '1', '0', '2025-07-17 16:43:46', '2025-07-17 16:43:46');
INSERT INTO `app_version` VALUES ('23', '12', 'test12', null, 'test12', null, '/code/RS_BACKEND/upload/4c9c048dc4c54d5f8c95c0ce841db106_update.zip', null, '1', '0', '2025-07-18 11:11:09', '2025-07-18 11:11:09');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int NOT NULL AUTO_INCREMENT,
  `d_total` int NOT NULL,
  `d_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_avatarpath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `d_createtime` date DEFAULT NULL,
  `d_updatetime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `d_name` (`d_name`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('46', '0', '管理部', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/c0ed6671-0234-4610-b975-3f5241fce8be.jpg', '2024-08-12', '2025-07-09');
INSERT INTO `dept` VALUES ('49', '0', '临时部', 'https://efps-sys.oss-cn-hangzhou.aliyuncs.com/7f40cf95-7b92-4890-8f14-71c6ffdad8c2.jpeg', null, '2025-07-09');

-- ----------------------------
-- Table structure for dynamic_routes
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_routes`;
CREATE TABLE `dynamic_routes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parentRouteId` int DEFAULT NULL COMMENT '父路由id',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组件名',
  `icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
  `alias` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '别名',
  `state` int DEFAULT NULL COMMENT '“1”启用，“0”禁用',
  `sort` int DEFAULT NULL COMMENT '排序顺序，数字越小越靠前',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址值',
  `redirect` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '类型',
  `discription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `createUserId` int DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=238 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of dynamic_routes
-- ----------------------------
INSERT INTO `dynamic_routes` VALUES ('1', '0', 'homePage', 'home', '首页', '1', '0', '/home', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('9', '1', 'noticesPage', 'chat', '公告通知', '1', '6', 'notices', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('10', '1', '', 'control-platform', '系统管理', '1', '7', 'system-manage', '', 'MENU', '', null);
INSERT INTO `dynamic_routes` VALUES ('11', '10', 'userManage', '', '用户管理', '1', '1', 'user-manage', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('12', '10', 'deptManage', '', '部门管理', '1', '2', 'dept-manage', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('13', '1', 'settingsPage', 'setting-1', '系统设置', '1', '10', 'system-settings', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('14', '1', 'dashboard', 'dashboard', '概览', '1', '1', 'dashboard', '', 'LINK', '', null);
INSERT INTO `dynamic_routes` VALUES ('15', '1', 'updatePage', 'arrow-up-circle', '更新管理', '1', '8', 'update-manage', null, 'LINK', null, null);
INSERT INTO `dynamic_routes` VALUES ('237', '1', 'pcInfoPage', 'logo-windows', '电脑管理', '1', '9', 'pcInfoPage', '', 'LINK', '', '1954676743');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `e_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '身份证号',
  `e_username` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '账号',
  `e_password` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `e_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `e_gender` int DEFAULT NULL COMMENT '性别：0-女1-男',
  `e_age` int DEFAULT NULL COMMENT '年龄',
  `e_phone` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  `e_telephone` varchar(25) DEFAULT NULL COMMENT '电话',
  `e_avatarpath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `e_birthday` datetime(6) DEFAULT NULL COMMENT '生日',
  `e_createtime` datetime(6) NOT NULL COMMENT '字段创建时间',
  `e_updatetime` datetime(6) NOT NULL COMMENT '字段更新时间',
  `e_isEnabled` int DEFAULT '0' COMMENT '是否启用该账户：0-禁用1-启用',
  `e_description` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `e_qywx_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '企微id',
  `e_Deptid` int DEFAULT NULL COMMENT '本系统的用户部门',
  PRIMARY KEY (`id`,`e_qywx_id`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `e_username` (`e_username`),
  UNIQUE KEY `e_id` (`e_id`),
  KEY `e_name` (`e_name`) USING BTREE,
  KEY `e_Deptid` (`e_Deptid`),
  KEY `e_qywx_id` (`e_qywx_id`),
  CONSTRAINT `empdept` FOREIGN KEY (`e_Deptid`) REFERENCES `dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1954676745 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1954676738', null, '88435858', '$2a$10$Ud8jeMutpLcffCppcUNEGeheZMyriDGyx4ebpyNHJrbd.LZTUQl5.', '李明阳', '1', null, null, null, null, null, '2025-07-02 16:48:28.438000', '2025-07-02 16:48:28.438000', '1', null, '11145', '46');
INSERT INTO `emp` VALUES ('1954676739', null, '56524457', '$2a$10$Wn62ya.LLuPlaJp4f6SyL.tamTNGyJ9dlWTGKQFJc6O/0b5cc74dS', '陈永根', '1', null, null, null, null, null, '2025-07-02 16:48:28.567000', '2025-07-02 16:48:28.567000', '1', null, '11146', '49');
INSERT INTO `emp` VALUES ('1954676740', null, '69197927', '$2a$10$OUUo9J4rwXPso64MTM9G0eIGTXDI/hp76XlnJqtGHP7yZzahfXE6C', '罗斌', '1', null, null, null, null, null, '2025-07-02 16:48:28.684000', '2025-07-02 16:48:28.684000', '1', null, '4017', '49');
INSERT INTO `emp` VALUES ('1954676741', null, '53605009', '$2a$10$prwqTsr2b5AOobIzbwsszO4vNm70RSlRDnR59aOLlnM4qxSJ.kMMO', '陈齐梁', '1', null, null, null, null, null, '2025-07-02 16:48:28.802000', '2025-07-02 16:48:28.802000', '1', null, '4335', '49');
INSERT INTO `emp` VALUES ('1954676743', null, '73342292', '$2a$10$yW91h2.DPh4Jd7tQkQjn3OPyh29V5eEHTnxx64USEc75QQJ1yNIdS', '任卫国', '1', null, null, null, null, null, '2025-07-02 16:48:29.038000', '2025-07-02 16:48:29.038000', '1', null, '4805', '49');
INSERT INTO `emp` VALUES ('1954676744', null, '74363830', '$2a$10$Td3UfX/UZuDpbCneuekkj.zjBRV1VO8GCOoGb3X9PTFfFbMuKqABK', '魏谢伟', null, null, null, null, null, null, '2025-07-09 14:38:31.173000', '2025-07-09 14:38:31.173000', '1', null, '4721', '49');

-- ----------------------------
-- Table structure for emp_menu
-- ----------------------------
DROP TABLE IF EXISTS `emp_menu`;
CREATE TABLE `emp_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_id` int NOT NULL,
  `m_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of emp_menu
-- ----------------------------
INSERT INTO `emp_menu` VALUES ('17', '1954676738', '1');
INSERT INTO `emp_menu` VALUES ('18', '1954676738', '5');
INSERT INTO `emp_menu` VALUES ('19', '1954676743', '1');
INSERT INTO `emp_menu` VALUES ('20', '1954676743', '5');
INSERT INTO `emp_menu` VALUES ('21', '1954676740', '1');
INSERT INTO `emp_menu` VALUES ('22', '1954676740', '5');

-- ----------------------------
-- Table structure for emp_role
-- ----------------------------
DROP TABLE IF EXISTS `emp_role`;
CREATE TABLE `emp_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `e_id` int DEFAULT NULL,
  `r_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `r_id` (`r_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `e_id` FOREIGN KEY (`e_id`) REFERENCES `emp` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `r_id` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of emp_role
-- ----------------------------
INSERT INTO `emp_role` VALUES ('51', '1954676738', '1');
INSERT INTO `emp_role` VALUES ('52', '1954676743', '2');
INSERT INTO `emp_role` VALUES ('53', '1954676740', '2');

-- ----------------------------
-- Table structure for important_msg
-- ----------------------------
DROP TABLE IF EXISTS `important_msg`;
CREATE TABLE `important_msg` (
  `id` int NOT NULL AUTO_INCREMENT,
  `header` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `author` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of important_msg
-- ----------------------------
INSERT INTO `important_msg` VALUES ('16', 'EFPS-SYSTEM使用概要', '指挥控制中的页面受限于用户的角色', '2025-02-11 10:51:42', '2025-02-11 10:51:42', 'RWG', '1');
INSERT INTO `important_msg` VALUES ('17', '添加用户说明', '当创建新用户时管理员或者超级管理员需赋予用户可访问的路由页面', '2025-02-11 10:53:37', '2025-02-11 10:53:37', 'RENWEIGUO', '1');
INSERT INTO `important_msg` VALUES ('18', '周末愉快0000', '111', '2025-07-04 10:18:54', '2025-07-04 17:45:15', 'RWG', '1');
INSERT INTO `important_msg` VALUES ('19', '2025', '00', '2025-07-11 16:15:14', '2025-07-11 16:15:14', 'rwg', '1');
INSERT INTO `important_msg` VALUES ('20', '2026', '1', '2025-07-11 16:17:53', '2025-07-11 16:17:53', '1', '1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `m_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `m_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `m_sign` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '', '用户个人的基本操作', 'emp');
INSERT INTO `menu` VALUES ('5', '', '超级管理员的基本操作', 'admin');

-- ----------------------------
-- Table structure for pc_info
-- ----------------------------
DROP TABLE IF EXISTS `pc_info`;
CREATE TABLE `pc_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `memory_total` varchar(255) DEFAULT NULL,
  `memory_usage` varchar(255) DEFAULT NULL,
  `disk_list` varchar(255) DEFAULT NULL,
  `emp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`ip`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of pc_info
-- ----------------------------
INSERT INTO `pc_info` VALUES ('6', '192.168.24.77', '32', '72', '[{\"mount\":\"C:\",\"usage\":85,\"total\":233,\"used\":199},{\"mount\":\"D:\",\"usage\":9,\"total\":1863,\"used\":161}]', '任卫国', null, '2025-07-18 14:03:35');

-- ----------------------------
-- Table structure for qywx_department
-- ----------------------------
DROP TABLE IF EXISTS `qywx_department`;
CREATE TABLE `qywx_department` (
  `id` bigint NOT NULL,
  `name` varchar(100) NOT NULL,
  `parent_id` bigint DEFAULT NULL,
  `order_num` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of qywx_department
-- ----------------------------
INSERT INTO `qywx_department` VALUES ('1910', '义乌服务组', '1908', '99999000');

-- ----------------------------
-- Table structure for qywx_user
-- ----------------------------
DROP TABLE IF EXISTS `qywx_user`;
CREATE TABLE `qywx_user` (
  `userid` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `department_id` bigint DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of qywx_user
-- ----------------------------
INSERT INTO `qywx_user` VALUES ('11145', '李明阳', '1910');
INSERT INTO `qywx_user` VALUES ('11146', '陈永根', '1910');
INSERT INTO `qywx_user` VALUES ('4017', '罗斌', '1910');
INSERT INTO `qywx_user` VALUES ('4335', '陈齐梁', '1910');
INSERT INTO `qywx_user` VALUES ('4721', '魏谢伟', '1910');
INSERT INTO `qywx_user` VALUES ('4805', '任卫国', '1910');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `r_id` int NOT NULL AUTO_INCREMENT,
  `r_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `r_info` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'super_admin', '超级管理员');
INSERT INTO `role` VALUES ('2', 'admin', '管理员');
INSERT INTO `role` VALUES ('3', 'user', '普通用户');

-- ----------------------------
-- Table structure for role_routes
-- ----------------------------
DROP TABLE IF EXISTS `role_routes`;
CREATE TABLE `role_routes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `r_id` int NOT NULL,
  `ro_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ro_id` (`ro_id`),
  KEY `r_id` (`r_id`),
  CONSTRAINT `role_routes_ibfk_1` FOREIGN KEY (`ro_id`) REFERENCES `dynamic_routes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_routes_ibfk_2` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_routes
-- ----------------------------
INSERT INTO `role_routes` VALUES ('1', '1', '1');
INSERT INTO `role_routes` VALUES ('9', '1', '9');
INSERT INTO `role_routes` VALUES ('10', '1', '10');
INSERT INTO `role_routes` VALUES ('11', '1', '11');
INSERT INTO `role_routes` VALUES ('12', '1', '12');
INSERT INTO `role_routes` VALUES ('13', '1', '13');
INSERT INTO `role_routes` VALUES ('14', '1', '14');
INSERT INTO `role_routes` VALUES ('16', '2', '1');
INSERT INTO `role_routes` VALUES ('24', '2', '9');
INSERT INTO `role_routes` VALUES ('25', '2', '10');
INSERT INTO `role_routes` VALUES ('26', '2', '11');
INSERT INTO `role_routes` VALUES ('27', '2', '12');
INSERT INTO `role_routes` VALUES ('28', '2', '13');
INSERT INTO `role_routes` VALUES ('29', '2', '14');
INSERT INTO `role_routes` VALUES ('101', '1', '15');
INSERT INTO `role_routes` VALUES ('102', '2', '15');
INSERT INTO `role_routes` VALUES ('103', '1', '237');
INSERT INTO `role_routes` VALUES ('104', '2', '237');

-- ----------------------------
-- Table structure for ym_domains
-- ----------------------------
DROP TABLE IF EXISTS `ym_domains`;
CREATE TABLE `ym_domains` (
  `id` int NOT NULL AUTO_INCREMENT,
  `domain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `registrar` varchar(255) DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `remaining_days` varchar(255) DEFAULT NULL,
  `dns_records` varchar(255) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ym_domains
-- ----------------------------
INSERT INTO `ym_domains` VALUES ('1', 'yiwutoptime.com', 'ok https://icann.org/epp#ok', 'Alibaba Cloud Computing (Beijing) Co., Ltd.', '2026-02-22 00:00:00', '219', 'mxw.mxhichina.com.,mxn.mxhichina.com.', '2025-07-18 14:11:20', '2025-07-17 13:41:13');
INSERT INTO `ym_domains` VALUES ('2', 'u-pathfinder.com', 'ok https://icann.org/epp#ok', 'Alibaba Cloud Computing Ltd. d/b/a HiChina (www.net.cn)', '2025-10-14 00:00:00', '88', 'mxw.mxhichina.com.,mxn.mxhichina.com.', '2025-07-18 14:11:20', '2025-07-17 13:41:15');
INSERT INTO `ym_domains` VALUES ('4', 'vesna.cn', 'ok', '阿里云计算有限公司（万网）', '2025-11-07 00:00:00', '112', 'mxn.mxhichina.com.,mxw.mxhichina.com.', '2025-07-18 14:11:21', '2025-07-17 13:41:15');
INSERT INTO `ym_domains` VALUES ('5', 'unionservice.com.cn', 'ok', '阿里云计算有限公司（万网）', '2025-12-20 00:00:00', '155', 'mxw.263.net.,mx.263.net.', '2025-07-18 14:11:21', '2025-07-17 13:41:15');
