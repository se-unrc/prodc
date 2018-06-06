CREATE TABLE users (
  nick VARCHAR(128) PRIMARY KEY,
  type int,
  score int,
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;
