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
}