CREATE TABLE schadule (
	num_fecha int,
	cod_partido int,
CONSTRAINT cp_num_fecha PRIMARY KEY (num_fecha, cod_partido),
CONSTRAINT cf_cod_match FOREIGN KEY (cod_partido)
	REFERENCES matchs (cod_partido)
);
