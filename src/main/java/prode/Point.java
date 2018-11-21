package prode;

import java.util.*;

import static spark.Spark.*;
import spark.*;
import org.javalite.activejdbc.*;

public class Point extends Model {
	
	
	public Point() {	}
	
	public void crearPoint(int idUser, int idFecha) {
		Point p = new Point();
		p.set("idUser", idUser);
		p.set("idFecha", idFecha);
		p.saveIt();
		
	}
	
	public int puntajeTotal(int idUser) {
		int suma = 0;
		Point p = new Point();
	    List<Point> sum = Point.findBySQL("SELECT * from points WHERE idUser = '"+idUser+"'");
	    for (int i = 0; i<sum.size();i++) {
	    	 p = sum.get(i);
	         suma = suma + (Integer)p.get("puntajeActual"); 
	    }
		return suma;
	}	
	
	public static List<Point> listaPuntosPorFecha(int idFecha ) {
		List<Point> busqueda = null;
		if (idFecha != 0 ) {
			busqueda  = Point.findBySQL("SELECT b.puntajeActual FROM users a JOIN points b ON a.id = b.idUser where b.idFecha = '"+idFecha+"' ORDER BY b.puntajeActual DESC");
			return busqueda;
		}
		return null;
	}
	
/*	 public String username() {
		 	System.out.println("ACAAAAAAAAAAAAAAAAAAAA\n\n\n"+this.getInteger("idUser"));
		 	//System.out.println("ACAAAAAAAAAAAAAAAAAAAA\n\n\n"+this.get(User.class, ""));
	    	return User.findById(this.getInteger("idUser")).getString("username");
	    }
	*/
	public int puntajeActual() {
    	return this.getInteger("puntajeActual");
    }
	
	
}
