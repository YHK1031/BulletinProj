CREATE DATABASE  IF NOT EXISTS `web_bulletin`;
USE `web_bulletin`;


--
-- Table structure for table `ROLE_TB`
--

DROP TABLE IF EXISTS `ROLE_TB`;

CREATE TABLE `ROLE_TB` (
  `ROLE_ID` varchar(16) PRIMARY KEY,
  `ROLE` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `USER_TB`
--

DROP TABLE IF EXISTS `USER_TB`;

CREATE TABLE `USER_TB` (
  `ID` varchar(16) NOT NULL,
  `PW` varchar(255) NOT NULL,
  `FIRSTNAME` varchar(16) NOT NULL,
  `LASTNAME` varchar(16) NOT NULL,
  `EMAIL` varchar(48) NOT NULL,
  `VALIDITY` int(11) NOT NULL,
  `ROLE_ID` varchar(16),
  PRIMARY KEY (`ID`),
  foreign key(`ROLE_ID`) references ROLE_TB(ROLE_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `BOARD_KIND_TB`
--

DROP TABLE IF EXISTS `BOARD_KIND_TB`;

CREATE TABLE `BOARD_KIND_TB` (
	`BoardKindId`	VARCHAR(16),
	`BoardKindName`	VARCHAR(16),
	PRIMARY KEY (`BoardKindId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `BOARD_TB`
--

DROP TABLE IF EXISTS `BOARD_TB`;

CREATE TABLE `BOARD_TB` (
	`BoardIdx`	int(11)	NOT NULL AUTO_INCREMENT,
	`BoardKindId`	VARCHAR(16),
	`Title`	VARCHAR(255)	NULL,
	`Content`	longtext	NULL,
	`Hits`	int(11)	NULL,
	`CreateDate`	datetime	NULL,
	`LikeCount`	int(11)	NULL,
    `DislikeCount`	int(11)	NULL,
    `ID` varchar(16) NOT NULL,
    foreign key(`BoardKindId`) references BOARD_KIND_TB(BoardKindId),
    foreign key(`ID`) references USER_TB(ID),
    PRIMARY KEY (`BoardIdx`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Table structure for table `COMMENT_TB`
--

DROP TABLE IF EXISTS `COMMENT_TB`;

CREATE TABLE `COMMENT_TB` (
	`CommentIdx`	int(11)	NOT NULL AUTO_INCREMENT,
	`CreateDate`	datetime	NULL,
	`BoardIdx`	int(11)	NOT NULL,
	`Content`	longtext	NULL,
	`LikeCount`	int(11)	NULL,
    `DislikeCount`	int(11)	NULL,
	`Parent`	int(11)	NOT NULL,
	`BoardKindId`	VARCHAR(16)	NOT NULL,
    `ID` varchar(16) NOT NULL,
    PRIMARY KEY (`CommentIdx`),
    foreign key(`ID`) references USER_TB(ID),
    foreign key(`BoardIdx`) references BOARD_TB(BoardIdx),
    foreign key(`BoardKindId`) references BOARD_TB(BoardKindId),
    foreign key(`Parent`) references COMMENT_TB(CommentIdx)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Table structure for table `BOARD_LIKE_TB`
--

DROP TABLE IF EXISTS `BOARD_LIKE_TB`;

CREATE TABLE `BOARD_LIKE_TB` (
	`BoardLikeIdx`	int(11)	NOT NULL AUTO_INCREMENT,
	`ID`	VARCHAR(16)	NOT NULL,
	`Liked`	int(11)	NULL,
	`BoardIdx`	int(11)	NOT NULL,
    PRIMARY KEY (`BoardLikeIdx`),
    foreign key(`ID`) references USER_TB(ID),
    foreign key(`BoardIdx`) references BOARD_TB(BoardIdx)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Table structure for table `COMMENT_LIKE_TB`
--

DROP TABLE IF EXISTS `COMMENT_LIKE_TB`;

CREATE TABLE `COMMENT_LIKE_TB` (
	`CommentLikeIdx`	int(11)	NOT NULL AUTO_INCREMENT,
	`ID`	VARCHAR(16)	NOT NULL,
	`Liked`	int(11)	NULL,
	`CommentIdx`	int(11)	,
    PRIMARY KEY (`CommentLikeIdx`),
    foreign key(`ID`) references USER_TB(ID),
    foreign key(`CommentIdx`) references COMMENT_TB(CommentIdx)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO web_bulletin.role_tb values ('ROLE_USER', 'USER');
INSERT INTO web_bulletin.role_tb values ('ROLE_ADMIN', 'ADMIN');
INSERT INTO web_bulletin.BOARD_KIND_TB values ('MAIN', 'MAIN');
