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
  VERSION               TINYINT                   NOT NULL DEFAULT 1 ,
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
DROP TABLE IF EXISTS `EMPLOYEE`;

CREATE TABLE `EMPLOYEE` (
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
  POSITION              VARCHAR(100)              NOT NULL,
  NATION                CHAR(10)                  NOT NULL,
  IS_MARRIED            BIT(1)                    NOT NULL DEFAULT  0  COMMENT '1:Married 0:Not married',
  POLITICAL_TYPE        ENUM('P', 'L', 'R')       NOT NULL DEFAULT 'R' COMMENT 'P:Party L:League G:Residence',
  RESIDENCE             VARCHAR(200)              NOT NULL,
  RESIDENCE_TYPE        ENUM('A', 'B')            NOT NULL,
  IDCARD_NUM            CHAR(18)                  NOT NULL,
  LAST_WORKING_DAY      DATE,
  ARCHIVE_FILE          VARCHAR(150),
  MEMO                  VARCHAR(150)              NOT NULL,
  VERSION               TINYINT                   NOT NULL DEFAULT 1,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `EMP_HR_ROLES` ------------------------------------------------------------
--
DROP TABLE IF EXISTS `EMP_HR_ROLES`;

CREATE TABLE `EMP_HR_ROLES` (
  EMP_ID                SMALLINT                  NOT NULL,
  HR_ROLE_ID            TINYINT                   NOT NULL,
  PRIMARY KEY(`EMP_ID`, `HR_ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `EMP_CERTIFICATE` ---------------------------------------------------------
--
DROP TABLE IF EXISTS `EMP_CERTIFICATE`;

CREATE TABLE `EMP_CERTIFICATE` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  EMP_ID                SMALLINT                  NOT NULL,
  CERT_NAME             VARCHAR(50)               NOT NULL,
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
  IS_REMOVED            BIT(1)                    NOT NULL DEFAULT 0 COMMENT '0：Normal 1：Removed',
  MEMO                  VARCHAR(50)               NOT NULL DEFAULT '',
  VERSION               TINYINT                   NOT NULL DEFAULT 1 ,
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
  EMP_ID                SMALLINT,
  ROLE_ID               TINYINT                   NOT NULL,
  IS_REMOVED            BIT(1)                    NOT NULL DEFAULT 0 COMMENT '0：Normal 1：Removed',
  OFFICE_ID             TINYINT                   NOT NULL,
  VERSION               TINYINT                   NOT NULL DEFAULT 1,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `HOLIDAY` -----------------------------------------------------------------
--
DROP TABLE IF EXISTS `HOLIDAY`;

CREATE TABLE `HOLIDAY` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  HOLI_DATE             DATE                      NOT NULL,
  NAME                  VARCHAR(20)               NOT NULL,
  TYPE                  ENUM('N', 'W', 'H')       NOT NULL COMMENT 'N: Normal W: Weekend H: Public Holiday',
  WEEK                  TINYINT                   NOT NULL,
  MEMO                  VARCHAR(100)              NOT NULL DEFAULT '',
  VERSION               TINYINT                   NOT NULL DEFAULT 1 ,
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
  IS_REMOVED            BIT(1)                    NOT NULL DEFAULT 0 COMMENT '0：Normal 1：Removed',
  VERSION               TINYINT                   NOT NULL DEFAULT 1,
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
  VERSION               TINYINT                   NOT NULL DEFAULT 1,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `PROJ_TASKS` --------------------------------------------------------------
--
DROP TABLE IF EXISTS `PROJ_TASKS`;

CREATE TABLE `PROJ_TASKS` (
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
  VERSION               TINYINT                   NOT NULL DEFAULT 1,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `PROJ_EMPS` ---------------------------------------------------------------
--
DROP TABLE IF EXISTS `PROJ_EMPS`;

CREATE TABLE `PROJ_EMPS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  PROJ_ID               INT                       NOT NULL,
  TASK_ID               INT                       NOT NULL DEFAULT 0,
  EMP_ID                SMALLINT                  NOT NULL,
  ROLE_ID               TINYINT                   NOT NULL,
  JOIN_DATE             DATE                      NOT NULL,
  LEFT_DATE             DATE,
  PRIMARY KEY(`ID`)
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
  VERSION               TINYINT                   NOT NULL DEFAULT 1,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `DAY_LOGS` ----------------------------------------------------------------
--
DROP TABLE IF EXISTS `DAY_LOGS`;

CREATE TABLE `DAY_LOGS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  WEEK_LOG              INT                       NOT NULL,
  WORK_DAY              DATE                      NOT NULL,
  EMP_ID                SMALLINT                  NOT NULL,
  STATUS                ENUM('C', 'S', 'R', 'P')  NOT NULL COMMENT 'C: Created, S: Submitted, R: Rejected, P: Permitted',
  HOURS                 TINYINT                   NOT NULL,
  MEAL                  TINYINT                   NOT NULL,
  VERSION               TINYINT                   NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `PROJ_LOGS` ---------------------------------------------------------------
--
DROP TABLE IF EXISTS `PROJ_LOGS`;

CREATE TABLE `PROJ_LOGS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  DAY_LOG               INT                       NOT NULL,
  ITEM_ID               INT                       NOT NULL,
  PROJ_ID               INT                       NOT NULL,
  TASK_ID               INT                       NOT NULL DEFAULT 0,
  PRIMARY KEY(`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `LOG_ITEMS` ---------------------------------------------------------------
--
DROP TABLE IF EXISTS `LOG_ITEMS`;

CREATE TABLE `LOG_ITEMS` (
  ID                    INT                       NOT NULL AUTO_INCREMENT,
  TYPE                  ENUM('N', 'O', 'L', 'S')  DEFAULT 'N' COMMENT 'N: Normal O: Overtime L: Leave S: Shift',
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

-- Add index and constraint conditions as following ----------------------------------------------------

CREATE INDEX idx_DeptName_on_Departments ON DEPARTMENTS ( NAME     );
CREATE INDEX idx_EmpName_on_Employee     ON EMPLOYEE    ( NAME     );
CREATE INDEX idx_ProjNum_on_Projects     ON PROJECTS    ( PROJ_NUM );
CREATE INDEX idx_ProjName_on_Projects    ON PROJECTS    ( NAME     );
CREATE INDEX idx_TaskName_on_ProjTasks   ON PROJ_TASKS  ( NAME     );

ALTER TABLE PROJ_TASKS      ADD CONSTRAINT fk_ProjID_on_ProjTasks        FOREIGN KEY ( PROJ_ID  )        REFERENCES PROJECTS    ( ID );
ALTER TABLE PROJ_TASKS      ADD CONSTRAINT fk_PhaseID_on_ProjTasks       FOREIGN KEY ( PHASE_ID )        REFERENCES PHASES      ( ID );
ALTER TABLE PROJ_TASKS      ADD CONSTRAINT fk_CreatorID_on_ProjTasks     FOREIGN KEY ( CREATOR_ID )      REFERENCES USERS       ( ID );
ALTER TABLE PROJ_TASKS      ADD CONSTRAINT fk_LastUpdatedID_on_ProjTasks FOREIGN KEY ( LAST_UPDATED_BY ) REFERENCES USERS       ( ID );
ALTER TABLE PROJ_EMPS       ADD CONSTRAINT fk_ProjID_on_ProjEmps         FOREIGN KEY ( PROJ_ID  )        REFERENCES PROJECTS    ( ID );
ALTER TABLE PROJ_EMPS       ADD CONSTRAINT fk_EmpID_on_ProjEmps          FOREIGN KEY ( EMP_ID   )        REFERENCES EMPLOYEE    ( ID );
ALTER TABLE WEEK_LOGS       ADD CONSTRAINT fk_EmpID_on_WeekLogs          FOREIGN KEY ( EMP_ID   )        REFERENCES EMPLOYEE    ( ID );
ALTER TABLE DAY_LOGS        ADD CONSTRAINT fk_WeekLogID_on_DayLogs       FOREIGN KEY ( WEEK_LOG )        REFERENCES WEEK_LOGS   ( ID );
ALTER TABLE PROJ_LOGS       ADD CONSTRAINT fk_DayLogID_on_ProjLogs       FOREIGN KEY ( DAY_LOG  )        REFERENCES DAY_LOGS    ( ID );
ALTER TABLE PROJ_LOGS       ADD CONSTRAINT fk_ProjID_on_ProjLogs         FOREIGN KEY ( PROJ_ID  )        REFERENCES PROJECTS    ( ID );
ALTER TABLE PROJ_LOGS       ADD CONSTRAINT fk_ItemID_on_ProjLogs         FOREIGN KEY ( ITEM_ID  )        REFERENCES LOG_ITEMS   ( ID );
ALTER TABLE EMPLOYEE        ADD CONSTRAINT fk_DiplomaID_on_Employee      FOREIGN KEY ( DIPLOMA_ID )      REFERENCES DIPLOMA     ( ID );
ALTER TABLE EMPLOYEE        ADD CONSTRAINT fk_DeptID_on_Employee         FOREIGN KEY ( DEPT_ID )         REFERENCES DEPARTMENTS ( ID );
ALTER TABLE EMP_CERTIFICATE ADD CONSTRAINT fk_EmpID_on_EmpCertificate    FOREIGN KEY ( EMP_ID )          REFERENCES EMPLOYEE    ( ID );
ALTER TABLE USERS           ADD CONSTRAINT fk_RoleID_on_Users            FOREIGN KEY ( ROLE_ID )         REFERENCES ROLES       ( ID );
ALTER TABLE USERS           ADD CONSTRAINT fk_OfficeID_on_Users          FOREIGN KEY ( OFFICE_ID )       REFERENCES OFFICES     ( ID );
ALTER TABLE PROJECTS        ADD CONSTRAINT fk_CreatorID_on_Projects      FOREIGN KEY ( CREATOR_ID )      REFERENCES USERS       ( ID );
ALTER TABLE PROJECTS        ADD CONSTRAINT fk_LastUpdatedID_on_Projects  FOREIGN KEY ( LAST_UPDATED_BY ) REFERENCES USERS       ( ID );

-- END OF THE DDL FILE ---------------------------------------------------------------------------------