CREATE DATABASE db_sbticket;
USE db_sbticket;

CREATE TABLE t_path(
  `path_id` BIGINT NOT NULL AUTO_INCREMENT,
  `distance` FLOAT,
  `time` FLOAT,
  `source` INT,
  `distination` INT,

  PRIMARY KEY (path_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8;

CREATE TABLE t_ticket(
  `path_id` BIGINT NOT NULL,
  `ticket_id` BIGINT NOT NULL AUTO_INCREMENT,
  `num` INT,
  `price` INT,
  `date` VARCHAR(30),
  `time` VARCHAR(30),

  PRIMARY KEY (ticket_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8;

CREATE TABLE t_site(
  `site_id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20),

  PRIMARY KEY (site_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8;