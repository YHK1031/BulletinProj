CREATE DATABASE  IF NOT EXISTS `web_bulletin`;
USE `web_bulletin`;

--
-- Table structure for table `USER_TB`
--

DROP TABLE IF EXISTS `USER_TB`;

CREATE TABLE `USER_TB` (
  `ID` varchar(16) PRIMARY KEY,
  `PW` varchar(16) DEFAULT NULL,
  `FIRSTNAME` varchar(16) DEFAULT NULL,
  `LASTNAME` varchar(16) DEFAULT NULL,
  `EMAIL` varchar(48) DEFAULT NULL,
  `VALIDITY` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `BOARD_KIND_TB`
--

DROP TABLE IF EXISTS `BOARD_KIND_TB`;

CREATE TABLE `BOARD_KIND_TB` (
	`BoardKindIdx`	int(11)	NOT NULL AUTO_INCREMENT,
	`BoardKindName`	VARCHAR(255),
	PRIMARY KEY (`BoardKindIdx`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Table structure for table `BOARD_TB`
--

DROP TABLE IF EXISTS `BOARD_TB`;

CREATE TABLE `BOARD_TB` (
	`BoardIdx`	int(11)	NOT NULL AUTO_INCREMENT,
	`BoardKindIdx`	int(11),
	`Title`	VARCHAR(255)	NULL,
	`Content`	longtext	NULL,
	`Hits`	VARCHAR(255)	NULL,
	`CreateDate`	datetime	NULL,
	`LikeCount`	VARCHAR(255)	NULL,
    foreign key(`BoardKindIdx`) references BOARD_KIND_TB(BoardKindIdx),
    PRIMARY KEY (`BoardIdx`,`BoardKindIdx`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Table structure for table `COMMENT_TB`
--

DROP TABLE IF EXISTS `COMMENT_TB`;

CREATE TABLE `COMMENT_TB` (
	`CommentIdx`	int(11)	NOT NULL AUTO_INCREMENT,
	`CreateDate`	datetime	NULL,
	`BoardIdx`	int(11)	NOT NULL,
	`Content`	VARCHAR(255)	NULL,
	`LikeCount`	int(11)	NULL,
	`Parent`	int(11)	NOT NULL,
	`BoardKindIdx`	int(11)	NOT NULL,
    PRIMARY KEY (`CommentIdx`),
    foreign key(`BoardIdx`) references BOARD_TB(BoardIdx),
    foreign key(`BoardKindIdx`) references BOARD_TB(BoardKindIdx),
    foreign key(`Parent`) references COMMENT_TB(CommentIdx)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Table structure for table `LIKE_TB`
--

DROP TABLE IF EXISTS `LIKE_TB`;

CREATE TABLE `LIKE_TB` (
	`LikeIdx`	int(11)	NOT NULL,
	`ID`	VARCHAR(255)	NOT NULL,
	`Liked`	VARCHAR(255)	NULL,
	`BoardIdx`	int(11)	,
	`CommentIdx`	int(11)	,
	`BoardKindIdx`	int(11)	,
    PRIMARY KEY (`LikeIdx`),
    foreign key(`ID`) references USER_TB(ID),
    foreign key(`CommentIdx`) references COMMENT_TB(CommentIdx),
    foreign key(`BoardIdx`) references BOARD_TB(BoardIdx),
    foreign key(`BoardKindIdx`) references BOARD_TB(BoardKindIdx)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


