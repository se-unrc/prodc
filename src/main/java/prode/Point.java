package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.*;

public class Point extends Model {
	
	
	public Point() {	}
	
	public void crearPoint(int id) {
		Point p = new Point();
		p.set("id", id);
		p.saveIt();
	}
	
	public void puntajeTotal(Point p, int id) {
		int suma = 0;
	    List<Point> sum = Point.findBySQL("SELECT * from points WHERE id = '"+id+"'");
	    
	    for (int i = 0; i<sum.size();i++) {
	    	 p = sum.get(i);
	         suma = suma + (Integer)p.get("puntajeActual"); 
	    }
	    
		p.set("puntajeTotal", suma);
		
	}
	
}
