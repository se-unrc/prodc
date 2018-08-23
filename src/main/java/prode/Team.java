package prode;

import java.util.*;
import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.*;

public class Team extends Model {
	private int cantTeam = 0;

	public Team(){

	}

	public void Team(String nomEquipo){
		Team t = new Team();
		cantTeam = cantTeam + 1;
        t.set("cod_equipo", cantTeam);
        t.set("nom_equipo", nomEquipo);
        t.saveIt();
	}

	public Map addTeam(Request req){
		cantTeam++;
		String nom = req.queryParams ("nombre");

		Map eq = new HashMap();
		Team t = new Team();
		t.set("cod_equipo", cantTeam);
		t.set("nom_equipo", nom);
		t.saveIt();
		eq.put("Guardado","salvado");
		return eq;
	}
}