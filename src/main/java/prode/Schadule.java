package prode;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.javalite.activejdbc.Model;

import spark.Request;
	
public class Schadule extends Model {
	
	public Schadule() { }

	public void addSchadule(ArrayList<String> req){
		List<Schadule> busqueda = Schadule.findBySQL("select num_fecha from schadules ");
		Integer cantFecha = 0;
		if (busqueda.size() != 0) {
			Schadule actualFecha = busqueda.get(busqueda.size()-1);
			cantFecha = (Integer)actualFecha.get("num_fecha");
		}
		for (int i = 0; i < req.size(); i++) {
			Schadule s = new Schadule();
			String cdp = req.get(i);
			int codp = Integer.parseInt(cdp);
			s.set("cod_partido", codp);
			s.set("num_fecha", (cantFecha+1));
			s.saveIt();
		}
	
	}
	
	
	
}