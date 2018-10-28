package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;

import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.Model;

public class Team extends Model {

	public Team(){ }

	public boolean checkTeam(Request req) {
		String nom = req.queryParams ("nombre");
		List<Team> busqueda = Team.where("nom_equipo = ?", nom);
		Boolean esta = (busqueda.size() != 0);
		return esta;
	}
	
	public void addTeam(Request req){
		String nom = req.queryParams ("nombre");
		Team t = new Team();
		t.set("nom_equipo", nom);
		t.saveIt();
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
}