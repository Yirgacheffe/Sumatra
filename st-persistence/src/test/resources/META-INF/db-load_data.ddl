INSERT INTO EMPLOYEES`
(
  `ID`,
  `NAME`,
  `GENDER`,
  `EMAIL`,
  `ON_BOARD_DATE`,
  `DEPT_ID`,
  `PROBATION_END`,
  `DIPLOMA_ID`,
  `GRADUATION_YR`,
  `COLLEGE`,
  `MAJOR`,
  `HR_ROLE_ID`,
  `POSITION`,
  `NATION`,
  `IS_MARRIED`,
  `POLITICAL_TYPE`,
  `RESIDENCE`,
  `IS_AGRICULTURAL`,
  `IDCARD_NUM`,
  `VERSION`
)
  VALUES
(
  1, 'Eric Smith', 'M', 'Eric.Smith@outlook.com', '20140216', 1, '20140516', 4, '1994', 'Ji Lin University',
  'Computer Science and Tech',
  3, '', '汉', 0, 'R', 'BaiDi Lu, Nankai, TianJin', 0, '220204119736621345', 1
);


INSERT INTO `EMPLOYEES`
(
  `ID`,
  `NAME`,
  `GENDER`,
  `EMAIL`,
  `ON_BOARD_DATE`,
  `DEPT_ID`,
  `PROBATION_END`,
  `DIPLOMA_ID`,
  `GRADUATION_YR`,
  `COLLEGE`,
  `MAJOR`,
  `HR_ROLE_ID`,
  `POSITION`,
  `NATION`,
  `IS_MARRIED`,
  `POLITICAL_TYPE`,
  `RESIDENCE`,
  `IS_AGRICULTURAL`,
  `IDCARD_NUM`,
  `VERSION`
)
  VALUES
(
  2, 'Aaron Yu', 'M', 'Aaron.Yuu@outlook.com', '20160212', 1, '20160512', 4, '2003', 'Ji Lin Univercity',
  'Computer Science and Tech',
  3, '', '汉', 0, 'R', 'ZhongBeiZhen, XiQing, TianJin', 0, '220204119839921345', 1
);

INSERT INTO `USERS`
(
  `EMAIL`, `PASSWORD`, `EMP_ID`, `ROLE_ID`, `MGR_ID`, `IS_REMOVED`, `OFFICE_ID`, `VERSION`
)
VALUES (
  'Aaron.Yuu@outlook.com', '123456789', 2, 2, 1, 0, 1, 1
);

