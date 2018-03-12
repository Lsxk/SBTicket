CREATE DATABASE db_sbticket;
USE db_sbticket;

CREATE TABLE t_ticket(
  `ticket_id` BIGINT NOT NULL AUTO_INCREMENT,
  `source_id` BIGINT,
  `dist_id` BIGINT,
  `num` INT,
  `price` INT,
  `date` VARCHAR(30),
  `time` VARCHAR(30),
  `distance` FLOAT,
  `lasting` FLOAT,
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