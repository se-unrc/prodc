package prode;

import java.util.*;
import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.*;

public class Match extends Model {
	


	public Match(){ }

	public Map addMatchs(Request req){
		String elocal1 = req.queryParams ("local1");
		String evisitante1 = req.queryParams ("visitante1");
		String elocal2 = req.queryParams ("local2");
		String evisitante2 = req.queryParams ("visitante2");
		String elocal3 = req.queryParams ("local3");
		String evisitante3 = req.queryParams ("visitante3");
		String elocal4 = req.queryParams ("local4");
		String evisitante4 = req.queryParams ("visitante4");
		Map game = new HashMap();
		Match m = new Match();
		m.set("equipo_local", elocal1);
		m.set("equipo_visitante", evisitante1);
		m.saveIt();
		Match p = new Match();
		p.set("equipo_local", elocal2);
		p.set("equipo_visitante", evisitante2);
		p.saveIt();
		Match o = new Match();
		o.set("equipo_local", elocal3);
		o.set("equipo_visitante", evisitante3);
		o.saveIt();
		Match n = new Match();
		n.set("equipo_local", elocal4);
		n.set("equipo_visitante", evisitante4);
		n.saveIt();	
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
    	if (resMatch != null) 
    		return resMatch;	
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

    public List<Match> getMatchList() {
        List<Match> busqueda  = Match.findBySQL("select * from matches ");
        return busqueda;       
    }
}

