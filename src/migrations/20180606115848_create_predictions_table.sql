CREATE TABLE predictions (
  id_prediction int(11) auto_increment PRIMARY KEY,
  id_game int(11),
  nick VARCHAR(128),
  winner VARCHAR(128),
  created_at DATETIME,
  updated_at DATETIME,
  FOREIGN KEY (nick) REFERENCES users(nick)
)ENGINE=InnoDB;
