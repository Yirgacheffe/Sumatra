-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: NSV_TIMENTRY
-- -----------------------------------------------------------------------------------------------------
-- Server version 5.7.11

CREATE DATABASE IF NOT EXISTS `NSV_TIMENTRY` default charset utf8 COLLATE utf8_general_ci;
USE `NSV_TIMENTRY`;

--
-- Table structure for table `PHASES` ------------------------------------------------------------------
--
DROP TABLE IF EXISTS `PHASES`;

CREATE TABLE `PHASES` (
  ID                    TINYINT                   NOT NULL AUTO_INCREMENT,
  NAME                  VARCHAR(30)               NOT NULL UNIQUE,
  MEMO                  VARCHAR(30),
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `DEPARTMENTS` -------------------------------------------------------------
--
DROP TABLE IF EXISTS `DEPARTMENTS`;

CREATE TABLE `DEPARTMENTS` (
  ID                    TINYINT                   NOT NULL AUTO_INCREMENT,
  NAME                  VARCHAR(100)              NOT NULL UNIQUE,
  MEMO                  VARCHAR(100),
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `HR_ROLES` ----------------------------------------------------------------
--
DROP TABLE IF EXISTS `HR_ROLES`;

CREATE TABLE `HR_ROLES` (
  ID                    TINYINT                   NOT NULL AUTO_INCREMENT,
  NAME                  VARCHAR(50)               NOT NULL UNIQUE,
  IS_TVs                BIT(1)                    NOT NULL DEFAULT 0 COMMENT '0:ads     1:TVs',
  IS_REMOVED            BIT(1)                    NOT NULL DEFAULT 0 COMMENT '0:Normal  1:Removed',
  MEMO                  VARCHAR(100)              NOT NULL DEFAULT '',
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `DIPLOMA` -----------------------------------------------------------------
--
DROP TABLE IF EXISTS `DIPLOMA`;

CREATE TABLE `DIPLOMA` (
  ID                    TINYINT                   NOT NULL AUTO_INCREMENT,
  NAME                  VARCHAR(30)               NOT NULL UNIQUE,
  MEMO                  VARCHAR(30)               NOT NULL DEFAULT '',
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `EMPLOYEE` ----------------------------------------------------------------
--
DROP TABLE IF EXISTS `EMPLOYEES`;

CREATE TABLE `EMPLOYEES` (
  ID                    SMALLINT                  NOT NULL AUTO_INCREMENT,
  NAME                  VARCHAR(50)               NOT NULL,
  GENDER                ENUM('F', 'M', 'O')       NOT NULL COMMENT 'F:Female M:Male O:Others',
  EMAIL                 VARCHAR(50)               NOT NULL UNIQUE,
  ON_BOARD_DATE         DATE                      NOT NULL,
  DEPT_ID               TINYINT                   NOT NULL,
  PROBATION_END         DATE                      NOT NULL,
  DIPLOMA_ID            TINYINT                   NOT NULL,
  GRADUATION_YR         VARCHAR(4)                NOT NULL,
  COLLEGE               VARCHAR(100)              NOT NULL,
  MAJOR                 VARCHAR(150)              NOT NULL,
  HR_ROLE_ID            TINYINT                   NOT NULL, 
  POSITION              VARCHAR(100)              NOT NULL,
  NATION                CHAR(10)                  NOT NULL,
  IS_MARRIED            BIT(1)                    NOT NULL DEFAULT  0  COMMENT '1:Married 0:Not married',
  POLITICAL_TYPE        ENUM('P', 'L', 'R')       NOT NULL DEFAULT 'R' COMMENT 'P:Party L:League G:Residence',
  RESIDENCE             VARCHAR(200)              NOT NULL,
  IS_AGRICULTURAL       BIT(1)                    NOT NULL DEFAULT  0  COMMENT '1:Agricultural 0:Non-Agricultural',
  IDCARD_NUM            CHAR(18)                  NOT NULL,
  LAST_WORKING_DAY      DATE,
  ARCHIVE_FILE          VARCHAR(150),
  MEMO                  VARCHAR(150),
  VERSION               SMALLINT                  NOT NULL DEFAULT  1,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `EMP_HR_ROLES` ------------------------------------------------------------
--
DROP TABLE IF EXISTS `EMP_HR_ROLES`;

-- CREATE TABLE `EMP_HR_ROLES` (
--   EMP_ID                SMALLINT                  NOT NULL,
--   HR_ROLE_ID            TINYINT                   NOT NULL,
--   PRIMARY KEY(`EMP_ID`, `HR_ROLE_ID`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `EMP_CERTIFICATE` ---------------------------------------------------------
--
DROP TABLE IF EXISTS `CERTIFICATES`;

CREATE TABLE `CERTIFICATES` (
  ID                    SMALLINT                  NOT NULL AUTO_INCREMENT,
  CERT_NAME             VARCHAR(50)               NOT NULL,
  EMP_ID                SMALLINT                  NOT NULL,
  ISSUER                VARCHAR(50)               NOT NULL,
  ISSUE_DATE            DATE                      NOT NULL,
  EXPIRE_DATE           DATE,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `ROLES` -------------------------------------------------------------------
--
DROP TABLE IF EXISTS `ROLES`;

CREATE TABLE `ROLES` (
  ID                    TINYINT                   NOT NULL AUTO_INCREMENT,
  TYPE                  CHAR(2)                   NOT NULL UNIQUE,
  NAME                  VARCHAR(50)               NOT NULL,
  IS_REMOVED            BIT(1)                    NOT NULL DEFAULT 0 COMMENT '0:Normal 1:Removed',
  MEMO                  VARCHAR(50)               NOT NULL DEFAULT '',
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `USERS` -------------------------------------------------------------------
--
DROP TABLE IF EXISTS `USERS`;

CREATE TABLE `USERS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  EMAIL                 VARCHAR(50)               NOT NULL UNIQUE,
  PASSWORD              CHAR(41)                  NOT NULL,
  EMP_ID                SMALLINT                  NOT NULL,
  ROLE_ID               TINYINT                   NOT NULL,
  IS_REMOVED            BIT(1)                    NOT NULL DEFAULT 0 COMMENT '0:Normal 1:Removed',
  OFFICE_ID             TINYINT                   NOT NULL,
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `HOLIDAY` -----------------------------------------------------------------
--
DROP TABLE IF EXISTS `NON_WORKINGDAY`;

CREATE TABLE `NON_WORKINGDAY` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  HOLI_DATE             DATE                      NOT NULL,
  NAME                  VARCHAR(20)               NOT NULL,
  TYPE                  ENUM('N', 'W', 'H')       NOT NULL COMMENT 'N:Normal W:Weekend H:Public Holiday',
  WEEK                  TINYINT                   NOT NULL,
  MEMO                  VARCHAR(100)              NOT NULL DEFAULT '',
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `PROJ_ROLES` --------------------------------------------------------------
--
DROP TABLE IF EXISTS `PROJ_ROLES`;

CREATE TABLE `PROJ_ROLES` (
  ID                    TINYINT                   NOT NULL AUTO_INCREMENT,
  ACRONYM               CHAR(4)                   NOT NULL UNIQUE,
  NAME                  VARCHAR(50)               NOT NULL UNIQUE,
  MEMO                  VARCHAR(50)               NOT NULL DEFAULT '',
  IS_REMOVED            BIT(1)                    NOT NULL DEFAULT 0 COMMENT '0:Normal 1:Removed',
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `PROJECTS` ----------------------------------------------------------------
--
DROP TABLE IF EXISTS `PROJECTS`;

CREATE TABLE `PROJECTS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  PROJ_NUM              VARCHAR(50)               NOT NULL UNIQUE,
  NAME                  VARCHAR(50)               NOT NULL,
  START_DATE            DATE                      NOT NULL,
  CLOSE_DATE            DATE,
  IS_PROJ               BIT(1)                    NOT NULL DEFAULT 1 COMMENT '0: Not Project, 1: Not project',
  BUDGET                INT                       NOT NULL DEFAULT  0 ,
  STATUS                ENUM('S', 'P', 'C')       NOT NULL COMMENT 'S: Start P: In Progress C: Close',
  MEMO                  VARCHAR(200)              NOT NULL DEFAULT '',
  CREATOR_ID            INT                       NOT NULL,
  LAST_UPDATED_BY       INT                       NOT NULL,
  TS_CREATED            DATETIME                  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  TS_UPDATED            DATETIME                  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `PROJ_TASKS` --------------------------------------------------------------
--
DROP TABLE IF EXISTS `TASKS`;

CREATE TABLE `TASKS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  PROJ_ID               INT                       NOT NULL,
  NAME                  VARCHAR(50)               NOT NULL,
  IS_EXTENAL            BIT(1)                    NOT NULL DEFAULT 1 COMMENT '1: External, 0: Internal',
  START_DATE            DATE                      NOT NULL,
  CLOSE_DATE            DATE                      NOT NULL,
  ESTIMATION            INT                       NOT NULL,
  PHASE_ID              TINYINT                   NOT NULL DEFAULT 0,
  MEMO                  VARCHAR(200)              NOT NULL,
  CREATOR_ID            INT                       NOT NULL,
  LAST_UPDATED_BY       INT                       NOT NULL,
  TS_CREATED            DATETIME                  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  TS_UPDATED            DATETIME                  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `PROJ_EMPS` ---------------------------------------------------------------
--
DROP TABLE IF EXISTS `PROJ_EMPS`;

CREATE TABLE `PROJ_EMPS` (
  PROJ_ID               INT                       NOT NULL,
  EMP_ID                SMALLINT                  NOT NULL,
  PRIMARY KEY(`PROJ_ID`, `EMP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `TASK_EMPS` ---------------------------------------------------------------
--
DROP TABLE IF EXISTS `TASK_EMPS`;

CREATE TABLE `TASK_EMPS` (
  TASK_ID               INT                       NOT NULL,
  EMP_ID                SMALLINT                  NOT NULL,
  PRIMARY KEY(`TASK_ID`, `EMP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `WEEK_LOGS` ---------------------------------------------------------------
--
DROP TABLE IF EXISTS `WEEK_LOGS`;

CREATE TABLE `WEEK_LOGS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  YEAR                  TINYINT                   NOT NULL,
  WEEK                  TINYINT                   NOT NULL,
  EMP_ID                SMALLINT                  NOT NULL,
  STATUS                ENUM('C', 'S', 'R', 'P')  NOT NULL COMMENT 'C: Created, S: Submitted, R: Rejected, P: Permitted',
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY(`ID`),
  UNIQUE KEY(`YEAR`, `WEEK`, `EMP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `DAY_LOGS` ----------------------------------------------------------------
--
DROP TABLE IF EXISTS `DAY_LOGS`;

CREATE TABLE `DAY_LOGS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  WORK_DAY              DATE                      NOT NULL,
  EMP_ID                SMALLINT                  NOT NULL,
  WEEK_LOG              INT                       NOT NULL,
  STATUS                ENUM('C', 'S', 'R', 'P')  NOT NULL COMMENT 'C: Created, S: Submitted, R: Rejected, P: Permitted',
  HOURS                 TINYINT                   NOT NULL,
  MEAL                  TINYINT                   NOT NULL,
  VERSION               SMALLINT                  NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY(`WORK_DAY`, `EMP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `LOG_ITEMS` ---------------------------------------------------------------
--
DROP TABLE IF EXISTS `LOG_ITEMS`;

CREATE TABLE `LOG_ITEMS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  DAY_LOG               INT                       NOT NULL,
  PROJ_ID               INT                       NOT NULL,
  TASK_ID               INT,
  TYPE                  ENUM('N', 'O', 'D', 'S')  DEFAULT 'N' COMMENT 'N: Normal O: Overtime L: DayOff S: Shift',
  CONTENT               VARCHAR(300)              NOT NULL,
  HOURS                 TINYINT                   NOT NULL,
  START_ON              TIME                      DEFAULT NULL,
  CLOSE_ON              TIME                      DEFAULT NULL,
  PLACE                 CHAR(1)                   DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `OFFICES` ---------------------------------------------------------------
--
DROP TABLE IF EXISTS `OFFICES`;

CREATE TABLE `OFFICES` (
  ID                    TINYINT                   NOT NULL AUTO_INCREMENT,
  ADDRESS               VARCHAR(150)              NOT NULL,
  NAME                  VARCHAR(30)               NOT NULL,
  WORKING_HOURS         TINYINT                   NOT NULL,
  IS_INUSE              BIT(1)                    NOT NULL DEFAULT 1 COMMENT '0:Not Used 1:In Use',
  MEMO                  VARCHAR(100),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- END OF THE DDL FILE ---------------------------------------------------------------------------------
