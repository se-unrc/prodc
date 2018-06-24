package prode;

import org.javalite.activejdbc.Model;

public class Match extends Model {
	private int cantMatch = 0;

	public Match(){

	}
	
	public void addMatch(String eLocal, String eVisitante){
		Match m = new Match();
		cantMatch = cantMatch + 1;
		m.set("cod_partido", cantMatch);
		m.set("equipo_local", eLocal);
		m.set("equipo_visitante", eVisitante);
		m.saveIt();
	}

/*	public Match getMatch(int codMatch){
		Match m = new Match();
		m = Match.where("cod_partido = ?", codMatch);
		return m;
	}*/
}