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
  `ticket_id` BIGINT NOT NULL AUTO_INCREMENT,
  `path_id` BIGINT NOT NULL,
  `num` INT,
  `price` INT,
  `date` VARCHAR(30),
  `time` VARCHAR(30),
  `balance` INT,

  PRIMARY KEY (ticket_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8;

CREATE TABLE t_site(
  `site_id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20),
  `campus` VARCHAR(10),

  PRIMARY KEY (site_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8;

CREATE TABLE t_order(
  `order_id` VARCHAR(50) NOT NULL,
  `ticket_id` BIGINT,
  `order_uid` VARCHAR(100),
  `order_time` VARCHAR(30),
  `total_price` FLOAT,
  `order_status` INT,

  PRIMARY KEY (order_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;