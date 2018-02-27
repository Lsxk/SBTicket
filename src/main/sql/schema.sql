CREATE DATABASE db_sbticket;
USE db_sbticket;

CREATE TABLE t_path(
  'path_id' BIGINT NOT NULL AUTO_INCREMENT,
  'distance' FLOAT,
  'time' FLOAT,
  'source' VARCHAR(20),
  'distination' VARCHAR(20),

  PRIMARY KEY (path_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8;

CREATE TABLE t_ticket(
  'path_id' BIGINT NOT NULL,
  'ticket_id' BIGINT NOT NULL AUTO_INCREMENT,
  'num' INT,
  'price' INT,
  'departure' VARCHAR(30),

  PRIMARY KEY (ticket_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8;