CREATE TABLE matches (
	cod_partido int,
	equipo_local int,
	equipo_visitante int,
CONSTRAINT cp_cod_partido PRIMARY KEY (cod_partido),
CONSTRAINT cf_local FOREIGN KEY (equipo_local)
	REFERENCES teams (cod_equipo),
CONSTRAINT cf_visitante FOREIGN KEY (equipo_visitante)
	REFERENCES teams (cod_equipo)
);

