CREATE TABLE users (
  id int(11) auto_increment PRIMARY KEY,
  nick VARCHAR(128),
  email VARCHAR(128),
  password VARCHAR(128),
  type int,
  score int,
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;
