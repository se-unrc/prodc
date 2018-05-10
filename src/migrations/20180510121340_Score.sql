CREATE TABLE scores(
	id_score int(11) auto_increment PRIMARY KEY,
	FOREIGN KEY(id_user) REFERENCES users(id_user),
	FOREIGN KEY(id_result) REFERENCES results(id_result),
	points int,
	/*Consultar ultimo registro**/
)ENGINE=InnoDB;
