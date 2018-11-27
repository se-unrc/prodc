CREATE TABLE predictions (
  id int(11) auto_increment PRIMARY KEY,
  id_game int(11),
  id_user int(11),
  team_local VARCHAR(128),
  team_visitante VARCHAR(128),
  fecha int(3),
  created_at DATETIME,
  updated_at DATETIME,
  FOREIGN KEY (id_game) REFERENCES games(id),
  FOREIGN KEY (id_user) REFERENCES users(id)
)ENGINE=InnoDB;
