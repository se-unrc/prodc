CREATE TABLE users (
  nick VARCHAR(128) PRIMARY KEY,
  email VARCHAR(128),
  password VARCHAR(128),
  type int,
  score int,
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;
