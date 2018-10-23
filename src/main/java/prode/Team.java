package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;

import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.Model;

public class Team extends Model {

	public Team(){ }

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
	
    public List<Team> getTeams(){
    	
    	List<Team> busqueda  = Team.findBySQL("select cod_equipo, nom_equipo from teams ");
    	return busqueda;
    } 
    
    public int cod_equipo() {
    	return this.getInteger("cod_equipo");//IMPORTANTE
    }
    
    public String nom_equipo() {
    	return this.getString("nom_equipo");
    }
    	
    	/*Integer i = 0;
    	Integer k = busqueda.size();
    	while (i < k) {
    		Team t = busqueda.get(i);
    		Object a = t.get("nom_equipo");
    		String j = i.toString();
    		resultTeams.put(j, a);
    		i++;
    	}	
    	if (resultTeams != null) {
    		return resultTeams;
    	}	
    	else {
    		resultTeams.put("error","No hay equipos cargados");
    		return resultTeams;


    	 */
     
}