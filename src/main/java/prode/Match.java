package prode;

import java.util.*;
import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.*;

public class Match extends Model {
	
	public Match(){ }

	public Map addMatch(Request req){
		String elocal = req.queryParams ("local");
		String evisitante = req.queryParams ("visitante");
		Map game = new HashMap();
		Match m = new Match();
		m.set("equipo_local", elocal);
		m.set("equipo_visitante", evisitante);
		m.saveIt();
		return game;
	}
	
	public Map getMatch() {
		Map resMatch = new HashMap();
		List<Match> busqueda  = Match.findBySQL("select cod_partido from matches ");
    	Integer i = 0;
    	Integer k = busqueda.size();
    	while (i < k) {
    		Match t = busqueda.get(i);
    		Object a = t.get("cod_partido");
    		String j = i.toString();
    		resMatch.put(j, a);
    		i++;
    	}	
		
    	if (resMatch != null) {
    		return resMatch;
    	}	
    	else {
    		resMatch.put("error","No hay partidos cargados");
    		return resMatch;
    	}
    	
	}
	
	public ArrayList<String> getCode() {	
    	ArrayList<String> code = new ArrayList<String>();
    	List<Match> busqueda  = Match.findBySQL("select cod_partido from matches where cod_partido not in (select cod_partido from schadules) ");
    	for (int i = 0; i < busqueda.size(); i++) {
    		Match t = busqueda.get(i);
    		Object a = t.get("cod_partido");
    		String j = a.toString();
    		code.add(j);
    	}
    	return code;
    }
}

