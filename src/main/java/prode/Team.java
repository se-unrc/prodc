package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;

import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.Model;

public class Team extends Model {

	public Team(){ }
	
	public boolean validTeam(String s) {
		return (s != "" && s.length() >= 4);
	}

	public boolean checkTeam(Request req) throws IllegalArgumentException{
		String nom = req.queryParams ("nombre");
		if (!validTeam(nom)) 
			throw new IllegalArgumentException("Nombre de Team no valido"); 
		List<Team> busqueda = Team.where("nom_equipo = ?", nom);
		Boolean esta = (busqueda.size() != 0);
		return esta;
	}
	
	public void addTeam(Request req) throws IllegalArgumentException{
		String nom = req.queryParams ("nombre");
		if (!validTeam(nom)) 
			throw new IllegalArgumentException("Nombre de Team no valido"); 
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