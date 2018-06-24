package prode;

import org.javalite.activejdbc.Model;

public class Team extends Model {
	private int cantTeam = 0;

	public Team(){

	}

/*	public void addTeam(String nomEquipo){
		Team t = new Team();
		cantTeam = cantTeam + 1;
        t.set("cod_equipo", cantTeam);
        t.set("nom_equipo", nomEquipo);
        t.saveIt();
	}

	public Team getTeam(String nEquipo){
		Team t = new Team();
		t = Team.where("nom_equipo = ?", nEquipo);
		return t;
	}

	public Team getTeam(int cod){
		Team t = new Team();
		t = Team.where("id = ?", cod);
		return t;
	}*/
}