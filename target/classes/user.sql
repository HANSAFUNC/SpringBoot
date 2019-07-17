DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS student (
`id` INT(10) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NULL DEFAULT NULL ,
`age` INT(2) NOT NULL ,
PRIMARY KEY (id)
 );

ALTER TABLE student
add column grader int(2) NOT NULL default 0 comment '年级' after age;

CREATE TABLE IF NOT EXISTS user (
    uid VARCHAR(50) NOT NULL ,
    user_nickName VARCHAR(50) NULL DEFAULT '',
    user_name VARCHAR(50) NULL DEFAULT '',
    sex INT(1) NOT NULL DEFAULT 0,
    userHeadImg varchar(255) NULL DEFAULT '',
    account varchar(11) NOT NULL,
    pwd varchar(255) NOT NULL,
    PRIMARY KEY (uid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT =1;

# INSERT INTO `user` (`uid`) values (1);