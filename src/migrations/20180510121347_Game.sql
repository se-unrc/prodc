CREATE TABLE games (
  id_game int(11) auto_increment PRIMARY KEY,
  id_schedule int(11) FOREIGN KEY REFERENCES schedules(id_schedule),
  id_result int(11) FOREIGN KEY REFERENCES results(id_result),
  /*Duda relacion visitante local*/
  id_visitante int(11) NOT NULL,
  id_local int(11) NOT NULL,
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;
/***/
