CREATE TABLE teams (
  id_team int(11) auto_increment PRIMARY KEY,
  name VARCHAR(128),
  image VARCHAR(128),
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;
