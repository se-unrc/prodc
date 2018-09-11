package prode;

import java.util.*;
import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.*;

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

	public Map addMatch(Request req){
		cantMatch++;
		String elocal = req.queryParams ("local");
		String evisitante = req.queryParams ("visitante");
		Map game = new HashMap();
		Match m = new Match();
		m.set("cod_partido", cantMatch);
		m.set("equipo_local", elocal);
		m.set("equipo_visitante", evisitante);
		m.saveIt();
		return game;
	}
}

