package prode;

import org.javalite.activejdbc.Model;
	
public class Schadule extends Model {

	public void addSchadule(int numFecha, int codPartido){
		Schadule s = new Schadule();
		s.set("num_fecha", numFecha);
		s.set("cod_partido", codPartido);
		s.saveIt();
	}
}