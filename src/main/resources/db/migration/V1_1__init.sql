CREATE TABLE IF NOT EXISTS user_info (
	id BIGINT(13) NOT NULL AUTO_INCREMENT,
	user_id INT NOT NULL,
	passward VARCHAR(128) NOT NULL,
	external_id VARCHAR(64) NOT NULL,
	name VARCHAR(64) NOT NULL,
	name_kana VARCHAR(128),
	birthday DATETIME NOT NULL,
	data_of_entry DATETIME NOT NULL,
	data_of_retirement DATETIME NULL,
	deleted_flg BOOLEAN NOT NULL DEFAULT FALSE,
	create_date DATETIME DEFAULT NOW(),
	update_date DATETIME DEFAULT NOW(),
	create_by VARCHAR(64) NULL,
	update_by VARCHAR(64) NULL,
	version INT DEFAULT 1,
	PRIMARY KEY (id),
	UNIQUE KEY user_info_user_id(user_id) USING BTREE,
	UNIQUE KEY user_info_external_id(external_id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS address (
	id BIGINT(13) NOT NULL AUTO_INCREMENT,
	user_id INT NOT NULL,
	type VARCHAR(10) NOT NULL,
	postal_code VARCHAR(7) NOT NULL,
	prefecture VARCHAR(20) NOT NULL,
	cities_towns_villages VARCHAR(64) NOT NULL,
	address_1 VARCHAR(128),
	address_2 VARCHAR(128),
	deleted_flg BOOLEAN NOT NULL DEFAULT FALSE,
	create_date DATETIME DEFAULT NOW(),
	update_date DATETIME DEFAULT NOW(),
	create_by VARCHAR(64) NULL,
	update_by VARCHAR(64) NULL,
	version INT DEFAULT 1,
	PRIMARY KEY (id),
	INDEX address_user_id(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS phone_number (
	id BIGINT(13) NOT NULL AUTO_INCREMENT,
	phone_number VARCHAR(15) NOT NULL,
	type VARCHAR(10) NOT NULL,
	user_id INT NOT NULL,
	deleted_flg BOOLEAN  NOT NULL DEFAULT FALSE,
	create_date DATETIME DEFAULT NOW(),
	update_date DATETIME DEFAULT NOW(),
	create_by VARCHAR(64) NULL,
	update_by VARCHAR(64) NULL,
	version INT DEFAULT 1,
	PRIMARY KEY (id),
	INDEX phone_number_user_id(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
