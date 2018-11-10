CREATE TABLE points (
 idPrim int auto_increment,	
 id int,
 puntajeActual int default 0,
 puntajeTotal int default 0,
CONSTRAINT cp_num_POINTS PRIMARY KEY (idPrim, id),
CONSTRAINT cf_cod_users FOREIGN KEY (id)
	REFERENCES users (id)
);

