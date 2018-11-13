CREATE TABLE points (
 cod_point int auto_increment, 
 idUser int,
 idFecha int,
 puntajeActual int default 0,
 puntajeTotal int default 0,
CONSTRAINT cp_num_points PRIMARY KEY (cod_point, idUser, idFecha),
CONSTRAINT cf_cod_users FOREIGN KEY (idUser)
	REFERENCES users (id),
CONSTRAINT cf_cod_fecha FOREIGN KEY (idFecha)
	REFERENCES schadules (num_fecha)
);

