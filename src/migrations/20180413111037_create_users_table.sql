CREATE TABLE users (
	id int auto_increment PRIMARY KEY,
	username	VARCHAR(126),
	password	VARCHAR(126),
    superu      BOOLEAN,
	created_at	DATETIME,
	updated_at	DATETIME
)ENGINE=InnoDB;

 


