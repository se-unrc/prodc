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

	public Map addPrediction(Request req){
		String golloc = req.queryParams("elocal");
		String golvis = req.queryParams("evisit");

		int golLocal = (int)golloc.charAt(0);
		int golVisit = (int)golvis.charAt(0);

		Map pred = new HashMap();
		Prediction p = new Prediction();
		p.set("equipoL", golLocal);
		p.set("equipoV", golVisit);
		p.saveIt();
		pred.put("exito", "Predicción realizada! MUCHA SUERTE!");
		return pred;
	}
}