package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;

import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.Model;

public class Team extends Model {

	public Team(){

	}

	public void Team(String nomEquipo){
		Team t = new Team();
        t.set("nom_equipo", nomEquipo);
        t.saveIt();
	}

	public Map addTeam(Request req){
		
		String nom = req.queryParams ("nombre");

		Map eq = new HashMap();
		List<Team> busqueda = Team.where("nom_equipo = ?", nom);
		Boolean esta = (busqueda.size() == 0);
		if (esta) {
			Team t = new Team();
			t.set("nom_equipo", nom);
			t.saveIt();
		return eq;
		}
		eq.put("Error","Equipo ya cargado");
		return eq;
	}
	
    public Map getTeams(){
    	Map resultTeams = new HashMap();
    	List<Team> busqueda  = Team.findBySQL("select cod_equipo, nom_equipo from teams ");
    	Integer i = 0;
    	while (i < 4) {
    		Team t = busqueda.get(i);
    		Object a = t.get("nom_equipo");
    		String j = i.toString();
    		resultTeams.put(j, a);
    		i++;
    	}	
    	if (resultTeams != null) {
    		System.out.println(resultTeams.get(0));
    		return resultTeams;
    	}	
    	else
    		resultTeams.put("error","No hay equipos cargados");
    		return resultTeams;
    

    }
}