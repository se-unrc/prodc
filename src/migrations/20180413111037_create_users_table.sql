CREATE TABLE users (
	id int auto_increment PRIMARY KEY,
	username	VARCHAR(128),
	password	VARCHAR(128),
	created_at	DATETIME,
	updated_at	DATETIME
)ENGINE=InnoDB;
