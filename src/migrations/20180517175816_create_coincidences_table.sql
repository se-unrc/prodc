CREATE TABLE coincidences (
	num_boleta int,
	num_fecha int,
	puntos int,
CONSTRAINT cp_coinciden PRIMARY KEY (num_boleta, num_fecha),
CONSTRAINT cf_num_fecha_coinciden FOREIGN KEY (num_fecha)
	REFERENCES schadules (num_fecha),
CONSTRAINT cf_num_boleta_coinciden FOREIGN KEY (num_boleta)
	REFERENCES tickets (num_boleta)
);
