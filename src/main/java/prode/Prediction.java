package prode;

import java.util.*;
import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.*;

public class Prediction extends Model {

	public Prediction(){

	}

	public Prediction(int equipoL, int equipoV){
		Prediction p = new Prediction();
		p.set("equipoL", equipoL);
		p.set("equipoV", equipoV);
	}

	public Map addPrediction(Request req, HashMap pUser, HashMap pronostic){

		int idUser = (int)pUser.get("user");
		List<Match> match = pronostic.get("partidos");
		Match t = match.get(0);
    	Object a = t.get("cod_partido");
    	String j = a.toString();
    	int idMatch = Integer.parseInt(j);
		String golloc = req.queryParams("elocal1");
		String golvis = req.queryParams("evisit1");

		int golLocal = (int)golloc.charAt(0);
		int golVisit = (int)golvis.charAt(0);

		Map pred = new HashMap();
		Prediction p = new Prediction();
		p.set("equipoL", golLocal);
		p.set("equipoV", golVisit);
		p.set("id_usuario", idUser);
		p.set("cod_partido", idMatch);
		p.saveIt();


		golloc = req.queryParams("elocal2");
		golvis = req.queryParams("evisit2");
		t = match.get(1).
    	a = t.get("cod_partido");
    	j = a.toString();
    	idMatch = Integer.parseInt(j);

		golLocal = (int)golloc.charAt(0);
		golVisit = (int)golvis.charAt(0);

		Prediction q = new Prediction();
		q.set("equipoL", golLocal);
		q.set("equipoV", golVisit);
		q.set("id_usuario", idUser);
		q.set("cod_partido", idMatch);
		q.saveIt();


		golloc = req.queryParams("elocal3");
		golvis = req.queryParams("evisit3");
		t = match.get(2).
    	a = t.get("cod_partido");
    	j = a.toString();
    	idMatch = Integer.parseInt(j);

		golLocal = (int)golloc.charAt(0);
		golVisit = (int)golvis.charAt(0);

		Prediction r = new Prediction();
		r.set("equipoL", golLocal);
		r.set("equipoV", golVisit);
		r.set("id_usuario", idUser);
		r.set("cod_partido", idMatch);
		r.saveIt();


		golloc = req.queryParams("elocal4");
		golvis = req.queryParams("evisit4");
		t = match.get(3).
    	a = t.get("cod_partido");
    	j = a.toString();
    	idMatch = Integer.parseInt(j);

		golLocal = (int)golloc.charAt(0);
		golVisit = (int)golvis.charAt(0);

		Prediction s = new Prediction();
		s.set("equipoL", golLocal);
		s.set("equipoV", golVisit);
		s.set("id_usuario", idUser);
		s.set("cod_partido", idMatch);
		s.saveIt();


		pred.put("exito", "Predicción realizada! MUCHA SUERTE!");
		return pred;
	}
}