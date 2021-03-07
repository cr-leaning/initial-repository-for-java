CREATE TABLE IF NOT EXISTS sample_table (
	id BIGINT(13) NOT NULL AUTO_INCREMENT,
	name VARCHAR(20),
	value VARCHAR(20),
    data_status VARCHAR(10),
    data_information VARCHAR(1000),
	deleted_flg BOOLEAN NOT NULL DEFAULT FALSE,
	create_date DATETIME DEFAULT NOW(),
	update_date DATETIME DEFAULT NOW(),
	create_by VARCHAR(64) NULL,
	update_by VARCHAR(64) NULL,
	version INT DEFAULT 1,
	PRIMARY KEY (id),
	UNIQUE KEY sample_table_name(name) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
