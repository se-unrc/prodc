CREATE TABLE predictions (
  id_prediction int(11) auto_increment PRIMARY KEY,
  id_game int(11),
  nick VARCHAR(128),
  team_local VARCHAR(128),
  team_visitante VARCHAR(128),
  fecha int(3),
  created_at DATETIME,
  updated_at DATETIME,
  FOREING KEY (id_game) REFERENCES games(id_game)
  FOREING KEY (fecha) REFERENCES games(fecha)
  FOREIGN KEY (nick) REFERENCES users(nick)
)ENGINE=InnoDB;
