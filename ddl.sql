-- pointssystem.activity definition

CREATE TABLE `activity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `info` varchar(255) DEFAULT NULL,
  `dead_date` date DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `organiser` varchar(255) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `page_photo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


-- pointssystem.blood_sugar_record definition

CREATE TABLE `blood_sugar_record` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `record_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;


-- pointssystem.credit_transaction definition

CREATE TABLE `credit_transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `expired_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;


-- pointssystem.event definition

CREATE TABLE `event` (
  `id` bigint NOT NULL,
  `info` varchar(100) NOT NULL,
  `type` bit(1) NOT NULL DEFAULT b'0',
  `points` int NOT NULL DEFAULT '0',
  `max_frequency_per_day` int NOT NULL DEFAULT '0',
  `max_frequency_per_month` int NOT NULL DEFAULT '0',
  `max_frequency_per_year` int NOT NULL DEFAULT '0',
  `effective_day` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- pointssystem.insulin_record definition

CREATE TABLE `insulin_record` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `value` decimal(10,0) DEFAULT NULL,
  `record_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;


-- pointssystem.`user` definition

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `head` varchar(255) DEFAULT NULL,
  `register_date` date DEFAULT NULL,
  `last_login_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `complication` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `login_count` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_IDX` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16712866999 DEFAULT CHARSET=utf8mb3;