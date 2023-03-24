/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50734
Source Host           : localhost:3306
Source Database       : jwsystem

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2023-03-24 13:04:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classno` varchar(255) DEFAULT NULL COMMENT '期班号',
  `stunum` int(11) DEFAULT NULL COMMENT '期班学员人数',
  `termid` int(11) DEFAULT NULL COMMENT '开课学期',
  `trainlevelid` int(11) DEFAULT NULL COMMENT '培训类别',
  `tasktypeid` int(11) DEFAULT NULL COMMENT '任务类别',
  `majorid` int(11) DEFAULT NULL COMMENT '专业名称',
  `deptid` int(11) DEFAULT NULL COMMENT '管理机构',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', '223123456', '32', '12', '1', '7', '10', '26', '2023-03-21 15:32:27');

-- ----------------------------
-- Table structure for t_classroom
-- ----------------------------
DROP TABLE IF EXISTS `t_classroom`;
CREATE TABLE `t_classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomno` varchar(255) DEFAULT NULL COMMENT '门牌号',
  `locationid` int(11) DEFAULT NULL COMMENT '对应教室位置类别中的序列号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classroom
-- ----------------------------
INSERT INTO `t_classroom` VALUES ('1', '教室01', '2');
INSERT INTO `t_classroom` VALUES ('2', '教室02', '3');
INSERT INTO `t_classroom` VALUES ('3', '教室03', '4');
INSERT INTO `t_classroom` VALUES ('4', '教室04', '5');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classid` int(11) DEFAULT NULL COMMENT '关联期班序列号，可获取期班号、开课学期、培训层次、任务类别、专业名称、学员人数',
  `coursename` varchar(255) DEFAULT NULL,
  `practicetype` int(11) DEFAULT NULL,
  `theroyhour` int(11) DEFAULT NULL,
  `practicehour` int(11) DEFAULT NULL,
  `prime` int(4) DEFAULT NULL COMMENT '主辅讲,1-主讲，0-辅讲，2-主讲和辅讲',
  `batchcoeff` varchar(4) DEFAULT NULL COMMENT '批次系数',
  `teacherid` varchar(11) DEFAULT NULL COMMENT '任课教员',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('1', '1', '12', '15', '12', '12', '2', '12', '2,5', '2023-03-23 13:09:02');

-- ----------------------------
-- Table structure for t_course_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_course_detail`;
CREATE TABLE `t_course_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) DEFAULT NULL COMMENT '所属课程序列号',
  `teacherid` int(11) DEFAULT NULL,
  `prime` int(255) DEFAULT NULL COMMENT '主/辅讲，1—主讲，0—辅讲',
  `teachtypeid` int(255) DEFAULT NULL COMMENT '教学类型',
  `teachdate` varchar(255) DEFAULT NULL,
  `teachlocid` int(255) DEFAULT NULL COMMENT '教学场所',
  `teachsessid` int(11) DEFAULT NULL COMMENT '授课节次',
  `teachcontent` varchar(255) DEFAULT NULL COMMENT '教学内容',
  `createrid` int(11) DEFAULT NULL COMMENT '细化课表添加人',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course_detail
-- ----------------------------
INSERT INTO `t_course_detail` VALUES ('1', '1', '2', '1', '17', '2023-03-24', '2', '20', '123', '2', '2023-03-24 12:59:31');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `charger` varchar(255) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '0', '顶级部门', 'admin', '13265498711');
INSERT INTO `t_department` VALUES ('19', '1', '1', '', '');
INSERT INTO `t_department` VALUES ('20', '1', '2', '', '');
INSERT INTO `t_department` VALUES ('21', '1', '3', '', '');
INSERT INTO `t_department` VALUES ('22', '19', '11', '', '');
INSERT INTO `t_department` VALUES ('23', '20', '21', '', '');
INSERT INTO `t_department` VALUES ('24', '21', '31', '', '');
INSERT INTO `t_department` VALUES ('25', '19', '12', '', '');
INSERT INTO `t_department` VALUES ('26', '20', '22', '', '');
INSERT INTO `t_department` VALUES ('27', '21', '32', '', '');
INSERT INTO `t_department` VALUES ('28', '22', '111', '', '');
INSERT INTO `t_department` VALUES ('29', '22', '112', '', '');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `key` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `hidden` tinyint(1) DEFAULT '0',
  `type` tinyint(1) DEFAULT '0' COMMENT '0-目录，1-菜单，2-按钮',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '0', '系统管理', 'system', '/system', null, 'Layout', '0', '0');
INSERT INTO `t_permission` VALUES ('2', '1', '用户管理', 'user', 'user', null, 'system/user/index', '0', '1');
INSERT INTO `t_permission` VALUES ('3', '1', '角色管理', 'role', 'role', null, 'system/role/index', '0', '1');
INSERT INTO `t_permission` VALUES ('4', '1', '权限管理', 'permission', 'permission', null, 'system/permission/index', '0', '1');
INSERT INTO `t_permission` VALUES ('5', '1', '部门管理', 'dept', 'department', null, 'system/department/index', '0', '1');
INSERT INTO `t_permission` VALUES ('8', '2', '用户新增', null, null, 'system:user:add', null, '0', '2');
INSERT INTO `t_permission` VALUES ('9', '2', '用户修改', null, null, 'system:user:edit', null, '0', '2');
INSERT INTO `t_permission` VALUES ('10', '2', '用户删除', null, null, 'system:user:delete', null, '0', '2');
INSERT INTO `t_permission` VALUES ('11', '2', '用户导入', null, null, 'system:user:import', null, '0', '2');
INSERT INTO `t_permission` VALUES ('12', '2', '用户导出', null, null, 'system:user:export', null, '0', '2');
INSERT INTO `t_permission` VALUES ('14', '3', '角色新增', null, null, 'system:role:add', null, '0', '2');
INSERT INTO `t_permission` VALUES ('15', '3', '角色删除', null, null, 'system:role:delete', null, '0', '2');
INSERT INTO `t_permission` VALUES ('16', '3', '角色修改', null, null, 'system:role:edit', null, '0', '2');
INSERT INTO `t_permission` VALUES ('18', '4', '新增权限', '', '', 'system:permission:add', '', '0', '2');
INSERT INTO `t_permission` VALUES ('25', '4', '权限修改', '', '', 'system:permission:edit', '', '1', '2');
INSERT INTO `t_permission` VALUES ('26', '4', '权限删除', '', '', 'system:permission:delete', '', '0', '2');
INSERT INTO `t_permission` VALUES ('27', '5', '部门新增', '', '', 'system:dept:add', '', '1', '2');
INSERT INTO `t_permission` VALUES ('28', '5', '部门修改', '', '', 'system:dept:edit', '', '1', '2');
INSERT INTO `t_permission` VALUES ('29', '5', '删除部门', '', '', 'system:dept:delete', '', '1', '2');
INSERT INTO `t_permission` VALUES ('31', '0', '基础数据维护', 'database', '/basicdata', '', 'Layout', '0', '0');
INSERT INTO `t_permission` VALUES ('32', '31', '类别管理', 'zujian', 'type/manager', '', 'basicdata/type/index', '0', '1');
INSERT INTO `t_permission` VALUES ('34', '32', '修改类别', '', '', 'basicdata:type:edit', '', '1', '2');
INSERT INTO `t_permission` VALUES ('35', '32', '删除类别', '', '', 'basicdata:type:delete', '', '1', '2');
INSERT INTO `t_permission` VALUES ('36', '31', '教室管理', 'server', 'classroom', '', 'basicdata/classroom/index', '0', '1');
INSERT INTO `t_permission` VALUES ('37', '31', '期班管理', 'list', 'class', '', 'basicdata/class/index', '0', '1');
INSERT INTO `t_permission` VALUES ('40', '0', '课程管理', 'app', '/course', '', 'Layout', '0', '0');
INSERT INTO `t_permission` VALUES ('41', '40', '课程信息', 'education', 'index', '', 'course/index', '0', '1');
INSERT INTO `t_permission` VALUES ('42', '40', '细化课表', 'icon', 'schedule', '', 'course/schedule', '0', '1');
INSERT INTO `t_permission` VALUES ('43', '0', '教学归档', 'dictionary', '/archive', '', 'Layout', '0', '0');
INSERT INTO `t_permission` VALUES ('44', '43', '培养方案', 'doc', 'trainprogram', '', 'archive/trainprogram', '0', '1');
INSERT INTO `t_permission` VALUES ('45', '43', '教学计划', 'menu', 'teachplan', '', 'archive/teachplan', '0', '1');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `key` varchar(255) DEFAULT NULL,
  `sort` int(16) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', 'admin', '1', '1', '1', null, '2023-02-12 21:05:58');
INSERT INTO `t_role` VALUES ('2', '普通角色1', 'common', '2', '1', '0', '备注123', '2022-12-29 09:07:30');
INSERT INTO `t_role` VALUES ('18', 'asd', 'asd', '3', '1', '0', null, '2022-12-27 14:59:48');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `perid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=509 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('244', '18', '1');
INSERT INTO `t_role_permission` VALUES ('245', '18', '2');
INSERT INTO `t_role_permission` VALUES ('247', '18', '8');
INSERT INTO `t_role_permission` VALUES ('248', '18', '9');
INSERT INTO `t_role_permission` VALUES ('249', '18', '10');
INSERT INTO `t_role_permission` VALUES ('250', '18', '11');
INSERT INTO `t_role_permission` VALUES ('251', '18', '12');
INSERT INTO `t_role_permission` VALUES ('252', '18', '3');
INSERT INTO `t_role_permission` VALUES ('254', '18', '14');
INSERT INTO `t_role_permission` VALUES ('255', '18', '15');
INSERT INTO `t_role_permission` VALUES ('256', '18', '16');
INSERT INTO `t_role_permission` VALUES ('257', '18', '4');
INSERT INTO `t_role_permission` VALUES ('258', '18', '18');
INSERT INTO `t_role_permission` VALUES ('478', '1', '1');
INSERT INTO `t_role_permission` VALUES ('479', '1', '2');
INSERT INTO `t_role_permission` VALUES ('480', '1', '8');
INSERT INTO `t_role_permission` VALUES ('481', '1', '9');
INSERT INTO `t_role_permission` VALUES ('482', '1', '10');
INSERT INTO `t_role_permission` VALUES ('483', '1', '11');
INSERT INTO `t_role_permission` VALUES ('484', '1', '12');
INSERT INTO `t_role_permission` VALUES ('485', '1', '3');
INSERT INTO `t_role_permission` VALUES ('486', '1', '14');
INSERT INTO `t_role_permission` VALUES ('487', '1', '15');
INSERT INTO `t_role_permission` VALUES ('488', '1', '16');
INSERT INTO `t_role_permission` VALUES ('489', '1', '4');
INSERT INTO `t_role_permission` VALUES ('490', '1', '18');
INSERT INTO `t_role_permission` VALUES ('491', '1', '25');
INSERT INTO `t_role_permission` VALUES ('492', '1', '26');
INSERT INTO `t_role_permission` VALUES ('493', '1', '5');
INSERT INTO `t_role_permission` VALUES ('494', '1', '27');
INSERT INTO `t_role_permission` VALUES ('495', '1', '28');
INSERT INTO `t_role_permission` VALUES ('496', '1', '29');
INSERT INTO `t_role_permission` VALUES ('497', '1', '31');
INSERT INTO `t_role_permission` VALUES ('498', '1', '32');
INSERT INTO `t_role_permission` VALUES ('499', '1', '34');
INSERT INTO `t_role_permission` VALUES ('500', '1', '35');
INSERT INTO `t_role_permission` VALUES ('501', '1', '36');
INSERT INTO `t_role_permission` VALUES ('502', '1', '37');
INSERT INTO `t_role_permission` VALUES ('503', '1', '40');
INSERT INTO `t_role_permission` VALUES ('504', '1', '41');
INSERT INTO `t_role_permission` VALUES ('505', '1', '42');
INSERT INTO `t_role_permission` VALUES ('506', '1', '43');
INSERT INTO `t_role_permission` VALUES ('507', '1', '44');
INSERT INTO `t_role_permission` VALUES ('508', '1', '45');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classid` int(11) DEFAULT NULL COMMENT '所在期班',
  `stuno` varchar(255) DEFAULT NULL,
  `stuname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `political` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '1', '20141402043', '张三', '男', '中国', '11235748965', '123456789987654321', '中国', '面貌', '2023-03-21 20:35:46');
INSERT INTO `t_student` VALUES ('2', '1', '20141402043', '李四', '男', '中国', '11235748965', '123456789987654321', '中国', '面貌', '2023-03-21 20:35:46');
INSERT INTO `t_student` VALUES ('3', '1', '20141402043', '王五', '男', '中国', '11235748965', '123456789987654321', '中国', '面貌', '2023-03-21 20:35:46');
INSERT INTO `t_student` VALUES ('4', '1', '20141402043', '赵六', '男', '中国', '11235748965', '123456789987654321', '中国', '面貌', '2023-03-21 20:35:46');
INSERT INTO `t_student` VALUES ('5', '1', '20141402043', '孙悟空', '男', '中国', '11235748965', '123456789987654321', '中国', '面貌', '2023-03-21 20:35:46');
INSERT INTO `t_student` VALUES ('6', '1', '20141402043', '唐僧', '女', '中国', '11235748965', '123456789987654321', '中国', '面貌', '2023-03-21 20:35:46');
INSERT INTO `t_student` VALUES ('7', '1', '20141402043', '猪八戒', '男', '中国', '11235748965', '123456789987654321', '中国', '面貌', '2023-03-21 20:35:46');

-- ----------------------------
-- Table structure for t_type_data
-- ----------------------------
DROP TABLE IF EXISTS `t_type_data`;
CREATE TABLE `t_type_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) DEFAULT NULL,
  `typeno` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_type_data
-- ----------------------------
INSERT INTO `t_type_data` VALUES ('1', '1', '1001', '培训层次1');
INSERT INTO `t_type_data` VALUES ('2', '9', '1009', '教室位置1');
INSERT INTO `t_type_data` VALUES ('3', '9', '1009', '教室位置2');
INSERT INTO `t_type_data` VALUES ('4', '9', '1009', '教室位置3');
INSERT INTO `t_type_data` VALUES ('5', '9', '1009', '教室位置4');
INSERT INTO `t_type_data` VALUES ('6', '1', '1001', '培训层次2');
INSERT INTO `t_type_data` VALUES ('7', '2', '1002', '任务类别1');
INSERT INTO `t_type_data` VALUES ('8', '2', '1002', '任务类别2');
INSERT INTO `t_type_data` VALUES ('9', '10', '1010', '专业1');
INSERT INTO `t_type_data` VALUES ('10', '10', '1010', '计算机科学与技术');
INSERT INTO `t_type_data` VALUES ('11', '11', '1011', '2022年春季学期');
INSERT INTO `t_type_data` VALUES ('12', '11', '1011', '2022年秋季学期');
INSERT INTO `t_type_data` VALUES ('13', '11', '1011', '2023年秋季学期');
INSERT INTO `t_type_data` VALUES ('14', '6', '1006', '实践类别1');
INSERT INTO `t_type_data` VALUES ('15', '6', '1006', '实践类别2');
INSERT INTO `t_type_data` VALUES ('16', '6', '1006', '实践类别3');
INSERT INTO `t_type_data` VALUES ('17', '7', '1007', '教学类型1');
INSERT INTO `t_type_data` VALUES ('18', '7', '1007', '教学类型');
INSERT INTO `t_type_data` VALUES ('19', '7', '1007', '教学类型3');
INSERT INTO `t_type_data` VALUES ('20', '12', '1012', '授课节次1');
INSERT INTO `t_type_data` VALUES ('21', '12', '1012', '授课节次2');
INSERT INTO `t_type_data` VALUES ('22', '12', '1012', '授课节次3');
INSERT INTO `t_type_data` VALUES ('23', '12', '1012', '授课节次4');
INSERT INTO `t_type_data` VALUES ('24', '12', '1012', '授课节次5');

-- ----------------------------
-- Table structure for t_type_manage
-- ----------------------------
DROP TABLE IF EXISTS `t_type_manage`;
CREATE TABLE `t_type_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(11) DEFAULT NULL COMMENT '编号',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_type_manage
-- ----------------------------
INSERT INTO `t_type_manage` VALUES ('1', '1001', '培训层次');
INSERT INTO `t_type_manage` VALUES ('2', '1002', '任务类别');
INSERT INTO `t_type_manage` VALUES ('3', '1003', '人员类别');
INSERT INTO `t_type_manage` VALUES ('4', '1004', '职称类别');
INSERT INTO `t_type_manage` VALUES ('5', '1005', '证件类别');
INSERT INTO `t_type_manage` VALUES ('6', '1006', '实践类型');
INSERT INTO `t_type_manage` VALUES ('7', '1007', '教学类型');
INSERT INTO `t_type_manage` VALUES ('8', '1008', '政治面貌类别');
INSERT INTO `t_type_manage` VALUES ('9', '1009', '教室位置');
INSERT INTO `t_type_manage` VALUES ('10', '1010', '专业名称');
INSERT INTO `t_type_manage` VALUES ('11', '1011', '开课学期');
INSERT INTO `t_type_manage` VALUES ('12', '1012', '授课节次');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT '',
  `phone` varchar(255) DEFAULT '',
  `deptid` int(11) DEFAULT '0',
  `contact` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT '',
  `usertype` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '管理员31', 'admin', 'admin', '男', '13597807743', '25', '02758696543', '/api/avatar/光猫.jpg', '1', '2023-03-17 15:51:02');
INSERT INTO `t_user` VALUES ('2', '123', '123', '123', null, null, '1', '123', null, '0', '2023-03-17 15:50:09');
INSERT INTO `t_user` VALUES ('5', '321', '321', '321', null, null, '26', '321', null, '0', '2023-03-17 15:50:11');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('23', '1', '2');
INSERT INTO `t_user_role` VALUES ('24', '1', '1');
INSERT INTO `t_user_role` VALUES ('25', '2', '2');
INSERT INTO `t_user_role` VALUES ('26', '2', '18');
INSERT INTO `t_user_role` VALUES ('27', '2', '1');