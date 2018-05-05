CREATE TABLE result(
	id_resultado int auto_increment,
	cod_partido int,
	resultado_partido int,	# DEFINIDO COMO INT PORQUE FALTA VER COMO CREAR DOMINIOS
CONSTRAINT cp_id_resultado PRIMARY KEY (id_resultado),
CONSTRAINT cf_cod_partido FOREIGN KEY (cod_partido)
	REFERENCES matchs (cod_partido)
);
