CREATE TABLE games (
  id_game int(11) auto_increment PRIMARY KEY,
  team_loc VARCHAR(128),
  team_vis VARCHAR(128),
  winner VARCHAR(128),
  date_game DATETIME,
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;
