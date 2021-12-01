SET SESSION FOREIGN_KEY_CHECKS=0;


CREATE TABLE test_write
(
	wr_uid int NOT NULL AUTO_INCREMENT,
	wr_subject varchar(200) NOT NULL,
	wr_content text,
	wr_name varchar(20) NOT NULL,
	wr_viewcnt int DEFAULT 0,
	wr_regdate datetime DEFAULT now(),
	PRIMARY KEY (wr_uid)
);
