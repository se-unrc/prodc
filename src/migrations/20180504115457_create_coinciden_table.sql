CREATE TABLE coinciden (
	num_boleta int,
	num_fecha int,
	puntos int,
CONSTRAINT cp_coinciden PRIMARY KEY (num_boleta, num_fecha),
CONSTRAINT cf_num_fecha_coinciden FOREIGN KEY (num_fecha)
	REFERENCES schadule (num_fecha),
CONSTRAINT cf_num_boleta_coinciden FOREIGN KEY (num_boleta)
	REFERENCES ticket (num_boleta)
);

