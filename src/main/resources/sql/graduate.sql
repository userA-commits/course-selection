/*
 Navicat Premium Data Transfer

 Source Server         : mySQL
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : graduate

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 27/04/2022 02:42:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xk_admin
-- ----------------------------
DROP TABLE IF EXISTS `xk_admin`;
CREATE TABLE `xk_admin`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `admin_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员编号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字',
  `user_type` int NOT NULL COMMENT '用户类别',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `admin_no`(`admin_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_admin
-- ----------------------------
INSERT INTO `xk_admin` VALUES ('1', 'admin1', '123456', 'hero', 1, '123@qq.com');
INSERT INTO `xk_admin` VALUES ('60f74c1749fe7bbbfc49371dc0b48c10', 'hello', '1234567', 'myName', 1, '');
INSERT INTO `xk_admin` VALUES ('63b8ae3e1a0f4567bc345f21f88f1a28', 'WA2000', '123456', '诺马多', 1, '1441@qq.com');

-- ----------------------------
-- Table structure for xk_classroom
-- ----------------------------
DROP TABLE IF EXISTS `xk_classroom`;
CREATE TABLE `xk_classroom`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `classroom_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教室编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教室名称',
  `classroom_type` int NOT NULL COMMENT '教室类别，0为普通，1为特殊',
  `build` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在教学楼',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `classroom_no`(`classroom_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_classroom
-- ----------------------------
INSERT INTO `xk_classroom` VALUES ('1', 'H4001', 'H4001', 0, '第四教学楼', '一个普通教室，适合上课');
INSERT INTO `xk_classroom` VALUES ('c48bd9a64807313dbdac4cc1b0b2289b', 'H4002', 'H4002', 0, '第四教学楼', '第二个普通教室');

-- ----------------------------
-- Table structure for xk_clazz
-- ----------------------------
DROP TABLE IF EXISTS `xk_clazz`;
CREATE TABLE `xk_clazz`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `clazz_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级编号',
  `major_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业编号',
  `grade` int NULL DEFAULT NULL COMMENT '年级',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称',
  `student_num` int NOT NULL COMMENT '学生人数',
  `clazz_type` int NOT NULL COMMENT '班级类别，0为普通，1为特殊',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `clazz_no`(`clazz_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_clazz
-- ----------------------------
INSERT INTO `xk_clazz` VALUES ('1', 'CS181', 'CS', 2018, '软工181班', 2, 0, '第一个班');
INSERT INTO `xk_clazz` VALUES ('17b8d3691e961b08a3b5c671de122048', 'CS182', 'CS', 2018, '软工182班', 0, 0, '');
INSERT INTO `xk_clazz` VALUES ('5c8517bb681cb8482cf8aedac56a8c49', 'TA001', '', 2018, '恋爱心理学一班', 0, 1, '');

-- ----------------------------
-- Table structure for xk_course
-- ----------------------------
DROP TABLE IF EXISTS `xk_course`;
CREATE TABLE `xk_course`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `course_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程编号',
  `dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `credit` float NOT NULL COMMENT '学分',
  `classroom_type` int NOT NULL COMMENT '需要教室类型，0为普通，1为特殊',
  `is_required` int NOT NULL COMMENT '课程类别，0选修，1必修',
  `test_type` int NOT NULL COMMENT '考核方式',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `course_no`(`course_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_course
-- ----------------------------
INSERT INTO `xk_course` VALUES ('1', 'CS0001', 'CS', '软件工程导论', 2, 0, 1, 1, '第一门专业课');
INSERT INTO `xk_course` VALUES ('2', 'CS0002', 'CS', 'C语言程序设计', 2, 0, 1, 1, '第二门专业课');
INSERT INTO `xk_course` VALUES ('3', 'MS0001', 'MS', '高等数学1', 2, 0, 1, 1, '第一门通识课');
INSERT INTO `xk_course` VALUES ('4', 'MS0002', 'MS', '高等数学2', 2, 0, 1, 1, '第二门通识课');
INSERT INTO `xk_course` VALUES ('5', 'MS0003', 'MS', '线性代数', 2, 0, 1, 1, '第三门通识课');
INSERT INTO `xk_course` VALUES ('6', 'MS0004', 'MS', '概率论与数理统计', 2, 0, 1, 1, '第四门通识课');
INSERT INTO `xk_course` VALUES ('7', 'FL0001', 'FL', '大学英语1', 2, 0, 1, 1, '第五门通识课');
INSERT INTO `xk_course` VALUES ('9f567e6425e162dd5c59c1e5ea7d7a53', 'TA0001', 'TA', '恋爱心理学', 2, 0, 0, 0, '');

-- ----------------------------
-- Table structure for xk_course_arrange
-- ----------------------------
DROP TABLE IF EXISTS `xk_course_arrange`;
CREATE TABLE `xk_course_arrange`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `teach_course_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '授课编号',
  `classroom_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教室编号',
  `week` int NOT NULL COMMENT '星期，1到7代表周一到周天',
  `period` int NOT NULL COMMENT '使用时间段',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_course_arrange
-- ----------------------------
INSERT INTO `xk_course_arrange` VALUES ('1', 'SE0001.teacher1.SE181', 'H4001', 1, 1, '第一周的第一节课');
INSERT INTO `xk_course_arrange` VALUES ('2', 'SE0001.teacher1.SE181', 'H4001', 1, 2, '第一周的第二节课');
INSERT INTO `xk_course_arrange` VALUES ('3a8bb70f6ab82f95a532eefbf3691535', 'MS0001.teacher2.CS181', 'H4001', 1, 3, NULL);
INSERT INTO `xk_course_arrange` VALUES ('a9eb5066966f54ce5efa1d7be3feec01', 'TA0001.teacher4.TA001', 'H4001', 4, 3, '');

-- ----------------------------
-- Table structure for xk_course_plan
-- ----------------------------
DROP TABLE IF EXISTS `xk_course_plan`;
CREATE TABLE `xk_course_plan`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系编号',
  `major_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业编号',
  `course_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程编号',
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  `semester` int NULL DEFAULT NULL COMMENT '建议修读学期',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_course_plan
-- ----------------------------
INSERT INTO `xk_course_plan` VALUES ('1', 'CS', 'CS', 'CS0001', '2018', 1, '第一门专业课，当然要在第一学期');
INSERT INTO `xk_course_plan` VALUES ('4a568f714ab670fb958e3dc892ebb47f', 'CS', 'CS', 'CS0002', '2018', 1, '');
INSERT INTO `xk_course_plan` VALUES ('4e1b0fb5c11f34f1f0b95e213e8e74c5', 'FL', 'EL', 'MS0003', '2222', 2, '');
INSERT INTO `xk_course_plan` VALUES ('95e2cd26c1e1037fdff3a964ef1e1ec9', 'MA', 'MA', 'MS0003', '2222', 2, '');

-- ----------------------------
-- Table structure for xk_dept
-- ----------------------------
DROP TABLE IF EXISTS `xk_dept`;
CREATE TABLE `xk_dept`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dept_no`(`dept_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_dept
-- ----------------------------
INSERT INTO `xk_dept` VALUES ('1', 'CS', '软件工程学院', '');
INSERT INTO `xk_dept` VALUES ('2', 'MS', '应用数学学院', '');
INSERT INTO `xk_dept` VALUES ('3', 'MA', '马克思主义学院', NULL);
INSERT INTO `xk_dept` VALUES ('4', 'FL', '外国语学院', NULL);
INSERT INTO `xk_dept` VALUES ('5', 'SP', '体育部', NULL);
INSERT INTO `xk_dept` VALUES ('e95edb2e788ac87780537c687a62fb53', 'TA', '恋爱学院', '这是学习恋爱技巧的地方');

-- ----------------------------
-- Table structure for xk_major
-- ----------------------------
DROP TABLE IF EXISTS `xk_major`;
CREATE TABLE `xk_major`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `major_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业编号',
  `dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `major_no`(`major_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_major
-- ----------------------------
INSERT INTO `xk_major` VALUES ('0fb84a6dab7fe01f3121f90a81b34dfa', 'MA', 'MA', '马克思主义哲学', '');
INSERT INTO `xk_major` VALUES ('1', 'CS', 'CS', '软件工程专业', '软件工程专业');
INSERT INTO `xk_major` VALUES ('b75a1d440e04a635dd84b2a1a41a2cec', 'EL', 'FL', '应用英语专业', '');

-- ----------------------------
-- Table structure for xk_menu
-- ----------------------------
DROP TABLE IF EXISTS `xk_menu`;
CREATE TABLE `xk_menu`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `menu_no` bigint NOT NULL COMMENT '菜单编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_no` bigint NOT NULL COMMENT '父菜单编号',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标编号',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单类型',
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权柄',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `menu_no`(`menu_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_menu
-- ----------------------------
INSERT INTO `xk_menu` VALUES ('1', 1, '选课系统', 0, '&#xe68e', NULL, 'M', NULL, '选课系统目录');
INSERT INTO `xk_menu` VALUES ('10', 108, '学生管理', 2, NULL, '/sys/toStudent', 'C', 'student:index', '学生管理模块');
INSERT INTO `xk_menu` VALUES ('11', 109, '教师管理', 2, NULL, '/sys/toTeacher', 'C', 'teacher:index', '教师管理模块');
INSERT INTO `xk_menu` VALUES ('12', 110, '教室管理', 2, NULL, '/sys/toClassroom', 'C', 'classroom:index', '教室管理模块');
INSERT INTO `xk_menu` VALUES ('13', 111, '课程管理', 2, NULL, '/sys/toCourse', 'C', 'course:index', '课程管理模块');
INSERT INTO `xk_menu` VALUES ('14', 112, '学院管理', 2, NULL, '/sys/toDept', 'C', 'dept:index', '学院管理模块');
INSERT INTO `xk_menu` VALUES ('15', 113, '专业管理', 2, NULL, '/sys/toMajor', 'C', 'major:index', '专业管理模块');
INSERT INTO `xk_menu` VALUES ('16', 114, '班级管理', 2, NULL, '/sys/toClazz', 'C', 'clazz:index', '班级管理模块');
INSERT INTO `xk_menu` VALUES ('1a', 2, '基础管理模块', 1, '&#xe60a', NULL, 'M', NULL, '基础管理目录');
INSERT INTO `xk_menu` VALUES ('1b', 3, '课务管理模块', 1, '&#xe63c', NULL, 'M', NULL, '课务管理目录');
INSERT INTO `xk_menu` VALUES ('1c', 4, '系统管理模块', 1, '&#xe716', NULL, 'M', NULL, '系统管理目录');
INSERT INTO `xk_menu` VALUES ('2', 100, '公告管理', 4, '&#xe629', '/sys/toNotice', 'C', 'notice:index', '公告管理模块');
INSERT INTO `xk_menu` VALUES ('3', 101, '培养计划', 3, '&#xe670', '/sys/toCoursePlan', 'C', 'course-plan:index', '培养计划管理模块');
INSERT INTO `xk_menu` VALUES ('4', 102, '授课管理', 3, '&#xe674', '/sys/toTeachCourse', 'C', 'teach-course:index', '授课管理模块');
INSERT INTO `xk_menu` VALUES ('5', 103, '排课管理', 3, '&#xe610', '/sys/toCourseArrange', 'C', 'course-arrange:index', '排课管理模块');
INSERT INTO `xk_menu` VALUES ('6', 104, '选课管理', 3, '&#xe66c', '/sys/toSelectCourse', 'C', 'select-course:index', '选课管理模块');
INSERT INTO `xk_menu` VALUES ('8', 106, '课程成绩', 3, '&#xe655', '/sys/toCourseScore', 'C', 'course-score:index', '成绩管理模块');
INSERT INTO `xk_menu` VALUES ('9', 107, '管理员管理', 2, NULL, '/sys/toAdmin', 'C', 'admin:index', '管理员管理模块');

-- ----------------------------
-- Table structure for xk_notice
-- ----------------------------
DROP TABLE IF EXISTS `xk_notice`;
CREATE TABLE `xk_notice`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `notice_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告编号',
  `notice_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `notice_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布者',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `notice_no`(`notice_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_notice
-- ----------------------------
INSERT INTO `xk_notice` VALUES ('1', 'notice1', '标题', '内容1内容2', 'hero', '是备注');
INSERT INTO `xk_notice` VALUES ('2', 'notice2', '这是一条公告', '这是公告内a', 'hero', '');
INSERT INTO `xk_notice` VALUES ('baa318ea670ae6493bb4a86b0f4ea2c4', 'notice3', '公告3', '看好了，我只表演一次', 'hero', '');

-- ----------------------------
-- Table structure for xk_role
-- ----------------------------
DROP TABLE IF EXISTS `xk_role`;
CREATE TABLE `xk_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `role_no` bigint NOT NULL COMMENT '角色编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色键',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_no`(`role_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_role
-- ----------------------------
INSERT INTO `xk_role` VALUES ('1', 1, 'admin', 'admin', '管理员角色');

-- ----------------------------
-- Table structure for xk_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `xk_role_menu`;
CREATE TABLE `xk_role_menu`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `role_no` bigint NOT NULL COMMENT '角色编号',
  `menu_no` bigint NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_role_menu
-- ----------------------------
INSERT INTO `xk_role_menu` VALUES ('0e6befb523189db7a07843074a4b9a1c', 1, 110);
INSERT INTO `xk_role_menu` VALUES ('21027d470af8b2bf07f6e1b2744dfd93', 3, 104);
INSERT INTO `xk_role_menu` VALUES ('262a5de28fa1ab744f45a6bac8b64e19', 1, 107);
INSERT INTO `xk_role_menu` VALUES ('2a75fcea3523d13cda9594e68a841a85', 3, 106);
INSERT INTO `xk_role_menu` VALUES ('2f26498f9a529a64d1ec6db2c442507f', 3, 1);
INSERT INTO `xk_role_menu` VALUES ('34984828af600a612f17ee32077ba2c4', 1, 109);
INSERT INTO `xk_role_menu` VALUES ('36fd1a38ff7e62ac88dbc1c11af8ce28', 1, 102);
INSERT INTO `xk_role_menu` VALUES ('44507e218616dab9773d4663bad163f0', 3, 3);
INSERT INTO `xk_role_menu` VALUES ('472afbe954eb68bb4ddbf78d98ee842c', 1, 113);
INSERT INTO `xk_role_menu` VALUES ('4c521e15851146f38f837894b8eb44d0', 1, 106);
INSERT INTO `xk_role_menu` VALUES ('4dd49388fa1ce9e51e4001f23a056f4d', 1, 103);
INSERT INTO `xk_role_menu` VALUES ('4e297c34977bb696120b040ff377cffd', 1, 3);
INSERT INTO `xk_role_menu` VALUES ('5c1487f4f7aaeb7d4b59da85dab379ad', 1, 111);
INSERT INTO `xk_role_menu` VALUES ('5ebe362813a09ecf8a131ce74d8e0e9f', 2, 106);
INSERT INTO `xk_role_menu` VALUES ('63bf3647ecac7a4cb20fb4c71ddc69f9', 2, 1);
INSERT INTO `xk_role_menu` VALUES ('6418392a5472679e3d8bd9a1b67fb0cb', 1, 114);
INSERT INTO `xk_role_menu` VALUES ('6a9fd8adc0fb101346e7a755c277c19c', 1, 112);
INSERT INTO `xk_role_menu` VALUES ('716cb0e7568390793f833c417eb67a6d', 1, 2);
INSERT INTO `xk_role_menu` VALUES ('81c886af8523c1259510c03f617ee6b9', 1, 101);
INSERT INTO `xk_role_menu` VALUES ('a01a10f705147d19825cee0caa98a907', 3, 101);
INSERT INTO `xk_role_menu` VALUES ('a8d9743fd4fa80bbddfb932708aad2cf', 1, 1);
INSERT INTO `xk_role_menu` VALUES ('b49f7462b2826c489412c4758efef63b', 1, 108);
INSERT INTO `xk_role_menu` VALUES ('ba97d75cefa9e1d768c8f5daaa5af535', 2, 102);
INSERT INTO `xk_role_menu` VALUES ('c19942d6bcb520fce6c30dd83ffe05a5', 1, 4);
INSERT INTO `xk_role_menu` VALUES ('de7070bd03a4f8ca927b78403af4ec6b', 2, 3);
INSERT INTO `xk_role_menu` VALUES ('e08248788dead45b1ce82680f7cc3155', 1, 104);
INSERT INTO `xk_role_menu` VALUES ('ef59cca269f20f53f379c3c221ad65e2', 1, 100);

-- ----------------------------
-- Table structure for xk_select_course
-- ----------------------------
DROP TABLE IF EXISTS `xk_select_course`;
CREATE TABLE `xk_select_course`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `teach_course_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '授课编号',
  `clazz_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级编号',
  `student_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生编号',
  `semester` int NOT NULL COMMENT '修课学期',
  `normal_score` int NULL DEFAULT NULL COMMENT '平时成绩',
  `exam_score` int NULL DEFAULT NULL COMMENT '考试成绩',
  `total_score` int NULL DEFAULT NULL COMMENT '总成绩',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_select_course
-- ----------------------------
INSERT INTO `xk_select_course` VALUES ('1', 'SE0001.teacher1.CS181', 'SE0001', '2018010001', 0, NULL, NULL, NULL, '第一条选课信息');
INSERT INTO `xk_select_course` VALUES ('1966b00bc92ec1f8142367ee6ba9d315', 'MS0001.teacher2.CS181', 'MS0001', '2018010001', 0, NULL, NULL, NULL, NULL);
INSERT INTO `xk_select_course` VALUES ('6b186793c7db774b3eb9681e60515f22', 'MS0001.teacher2.CS181', 'MS0001', '2018010002', 0, 67, NULL, NULL, '');

-- ----------------------------
-- Table structure for xk_student
-- ----------------------------
DROP TABLE IF EXISTS `xk_student`;
CREATE TABLE `xk_student`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `student_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生编号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` int NOT NULL COMMENT '性别',
  `user_type` int NOT NULL COMMENT '用户类别',
  `grade` int NOT NULL COMMENT '年级',
  `dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系编号',
  `major_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业编号',
  `clazz_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `student_no`(`student_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_student
-- ----------------------------
INSERT INTO `xk_student` VALUES ('1', '2018010001', '123456', '郑也', 1, 1, 2018, 'CS', 'CS', 'CS181');
INSERT INTO `xk_student` VALUES ('2', '2018010002', '123456', '张衡', 1, 1, 2018, 'CS', 'CS', 'CS181');
INSERT INTO `xk_student` VALUES ('a28838397a612c9ef6a01cd202318d4f', '1', '1', '测试用学生', 0, 3, 2018, 'CS', 'CS', 'CS181');

-- ----------------------------
-- Table structure for xk_teach_course
-- ----------------------------
DROP TABLE IF EXISTS `xk_teach_course`;
CREATE TABLE `xk_teach_course`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `teach_course_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '授课编号',
  `teacher_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师编号',
  `course_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程编号',
  `state` int NOT NULL COMMENT '授课状态，0代表正使用，1代表已结束',
  `student_num` int NULL DEFAULT NULL COMMENT '学生人数',
  `upper_num` int NULL DEFAULT NULL COMMENT '人数上限',
  `clazz_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级编号',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `teach_course_no`(`teach_course_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_teach_course
-- ----------------------------
INSERT INTO `xk_teach_course` VALUES ('1', 'CS0001.teacher1.CS181', 'teacher1', 'CS0001', 0, 1, 1, 'CS181', '第一条授课信息');
INSERT INTO `xk_teach_course` VALUES ('1097665d6f00cd9beabb782b803f617f', 'teacher2.MS0002.软工182班', 'teacher2', 'MS0002', 0, 1, 0, '软工182班', '');
INSERT INTO `xk_teach_course` VALUES ('80d54fbe909388c85548a4de16dcadc9', 'MS0001.teacher2.CS181', 'teacher2', 'MS0001', 0, 1, 0, 'CS181', NULL);
INSERT INTO `xk_teach_course` VALUES ('a5f901b1ccfa2334afc5cb6d222970c7', 'teacher1.CS0002.CS182', 'teacher1', 'CS0002', 0, 1, 0, 'CS182', '');
INSERT INTO `xk_teach_course` VALUES ('f59800040a14f7ede796d8c74a24eb2f', 'TA0001.teacher4.TA001', 'teacher4', 'TA0001', 0, 1, 50, 'TA001', '');

-- ----------------------------
-- Table structure for xk_teacher
-- ----------------------------
DROP TABLE IF EXISTS `xk_teacher`;
CREATE TABLE `xk_teacher`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `teacher_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` int NULL DEFAULT NULL COMMENT '性别',
  `user_type` int NULL DEFAULT NULL COMMENT '用户类别',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系编号',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `teacher_no`(`teacher_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk_teacher
-- ----------------------------
INSERT INTO `xk_teacher` VALUES ('1', 'teacher1', '唐振', '123456', 1, 1, '教授', 'CS', '123', '123@qq.com');
INSERT INTO `xk_teacher` VALUES ('2', 'teacher2', '曼昆', '123456', 1, 1, '讲师', 'MS', '1231', '123@163.com');
INSERT INTO `xk_teacher` VALUES ('6508053d7b57f82ff9e3967a778173e9', 'teacher4', '慕容云海', '123456', 1, 2, '教授', 'TA', '123123', '123');
INSERT INTO `xk_teacher` VALUES ('d63c06c7e2f5de58cd9a791d84d7dde0', 'teacher3', '阿葛硫斯', NULL, 1, 2, '教授', 'MA', '123123', 'dadada@mail.com');

SET FOREIGN_KEY_CHECKS = 1;
