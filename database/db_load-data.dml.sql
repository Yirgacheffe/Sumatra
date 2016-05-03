-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: nsv_timentry
-- -----------------------------------------------------------------------------------------------------
-- Server version	5.7.11

--
-- Initialized data for table `PHASES` -----------------------------------------------------------------
--
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '无状态',     'No Status'            );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '需求开始',   'Requirement Start'    );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '需求分析中', 'Requirement Analysis' );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '产品设计',   'Product Design'       );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( 'UI设计中',   'UI Design'            );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '等待开发',   'Ready For Dev'        );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '开发中',     'Developing'           );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '待测试',     'Ready For Test'       );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '测试中',     'Testing'              );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '待上线',     'Ready For Release'    );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '已上线',     'On Production'        );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '暂停',       'Suspend'              );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '已变更',     'Requirement Changed'  );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '需求结束',   'Requirement Complete' );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '异常结束',   'Incident Complete'    );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '已完成',     'Completed'            );
INSERT INTO PHASES ( NAME, MEMO ) VALUES ( '进行中',     'In Progress'          );

--
-- Initialized data for table `DEPARTMENTS` ------------------------------------------------------------
--
INSERT INTO DEPARTMENTS ( NAME, MEMO ) VALUES ( '开发', 'Development' );
INSERT INTO DEPARTMENTS ( NAME, MEMO ) VALUES ( '测试', 'QA'          );
INSERT INTO DEPARTMENTS ( NAME, MEMO ) VALUES ( '售前', 'PreSales'    );
INSERT INTO DEPARTMENTS ( NAME, MEMO ) VALUES ( '售后', 'PostSales'   );
INSERT INTO DEPARTMENTS ( NAME, MEMO ) VALUES ( '商务', 'Business'    );
INSERT INTO DEPARTMENTS ( NAME, MEMO ) VALUES ( '管理', 'Management'  );

--
-- Initialized data for table `HR_ROLES` ---------------------------------------------------------------
--
INSERT INTO HR_ROLES ( NAME, IS_TVs, IS_REMOVED, MEMO, VERSION ) VALUES ( '话事人',    0, 0, 'Big Gun',        1 );
INSERT INTO HR_ROLES ( NAME, IS_TVs, IS_REMOVED, MEMO, VERSION ) VALUES ( '人事经理',  0, 0, 'HR',             1 );
INSERT INTO HR_ROLES ( NAME, IS_TVs, IS_REMOVED, MEMO, VERSION ) VALUES ( '高级管理',  0, 0, 'Senior Manager', 1 );
INSERT INTO HR_ROLES ( NAME, IS_TVs, IS_REMOVED, MEMO, VERSION ) VALUES ( '职员',      0, 0, 'Employee',       1 );
INSERT INTO HR_ROLES ( NAME, IS_TVs, IS_REMOVED, MEMO, VERSION ) VALUES ( '销售人员',  0, 0, 'Sales Staff',    1 );
INSERT INTO HR_ROLES ( NAME, IS_TVs, IS_REMOVED, MEMO, VERSION ) VALUES ( '销售主管',  0, 0, 'Sales Manager',  1 );

--
-- Initialized data for table `ROLES` ------------------------------------------------------------------
--
INSERT INTO ROLES ( TYPE, NAME, IS_REMOVED, MEMO, VERSION ) VALUES ( 'SU', '管理员',   0, 'Super User',   1 );
INSERT INTO ROLES ( TYPE, NAME, IS_REMOVED, MEMO, VERSION ) VALUES ( 'GU', '用户',     0, 'General User', 1 );
INSERT INTO ROLES ( TYPE, NAME, IS_REMOVED, MEMO, VERSION ) VALUES ( 'GT', '访客',     0, 'Guest User',   1 );
INSERT INTO ROLES ( TYPE, NAME, IS_REMOVED, MEMO, VERSION ) VALUES ( 'ST', '统计用户', 0, 'Statistician', 1 );

--
-- Initialized data for table `PROJ_ROLES` -------------------------------------------------------------
--
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'PM', '项目主管', 'Project Manager',  0, 1 );
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'AR', '架构师',   'Architect' ,       0, 1 );
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'SD', '高级开发', 'Senior Developer', 0, 1 );
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'MD', '开发',     'Medium Developer', 0, 1 );
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'JD', '初级开发', 'Junior Developer', 0, 1 );
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'ST', '高级测试', 'Senior Tester',    0, 1 );
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'MT', '测试',     'Medium Tester',    0, 1 );
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'JT', '初级测试', 'Junior Tester',    0, 1 );
INSERT INTO PROJ_ROLES ( ABBR, NAME, MEMO, IS_REMOVED, VERSION ) VALUES ( 'IN', '实习生',   'Intern',           0, 1 );

--
-- Initialized data for table `DIPLOMA` ----------------------------------------------------------------
--
INSERT INTO `DIPLOMA` ( NAME, MEMO ) VALUES ( '初中',        'Junior'      );
INSERT INTO `DIPLOMA` ( NAME, MEMO ) VALUES ( '高中',        'High School' );
INSERT INTO `DIPLOMA` ( NAME, MEMO ) VALUES ( '专科',        'Tertiary'    );
INSERT INTO `DIPLOMA` ( NAME, MEMO ) VALUES ( '本科',        'Bachelor'    );
INSERT INTO `DIPLOMA` ( NAME, MEMO ) VALUES ( '硕士',        'Master'      );
INSERT INTO `DIPLOMA` ( NAME, MEMO ) VALUES ( '博士',        'Doctor'      );
INSERT INTO `DIPLOMA` ( NAME, MEMO ) VALUES ( '专科 - 自考',  'Tertiary'    );

--
-- Initialized data for table `OFFICES` ----------------------------------------------------------------
--
INSERT INTO OFFICES ( ADDRESS, NAME, WORKING_HOURS ) VALUES ( '天津华苑产业园区兰苑路2号', '頂佳', 75 );

-- END OF FILE DML SQL ---------------------------------------------------------------------------------
