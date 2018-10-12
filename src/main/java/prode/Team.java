package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
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
    	resultTeams.put("equipos", busqueda);
    	if (resultTeams != null) 	
    		return resultTeams;
    	else
    		resultTeams.put("error","No hay equipos cargados");
    		return resultTeams;
    

    }
}