CREATE TABLE ticket (
	num_boleta int auto_increment,
	id_usuario int,
	num_fecha int,
CONSTRAINT cp_num_boleta PRIMARY KEY (num_boleta),
CONSTRAINT cf_id_usuario FOREIGN KEY (id_usuario)
	REFERENCES users (id),
CONSTRAINT cf_num_fecha FOREIGN KEY (num_fecha)
	REFERENCES schadule (num_fecha)
);
