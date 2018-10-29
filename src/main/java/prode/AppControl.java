package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import static spark.Spark.*;	
import prode.User;
//import spark.ModelAndView;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class AppControl { 
	
	public static ModelAndView registro(Request req, Response res) {
		User nUsuario = new User();
		Map nuevoUser = new HashMap();
		if (nUsuario.checkUser(req)) {
			nUsuario.addUser(req);
			return new ModelAndView(nuevoUser, "./html/inicio.html");
		} else {
			nuevoUser.put("Error", "Nombre de usuario invalido");
			return new ModelAndView(nuevoUser, "./html/registro.html");
		}
		
	}
	
	public static ModelAndView ingreso(Request req, Response res) {
		User userLog = new User();
		Map logUser = new HashMap(); 
		if (userLog.checkUser(req)) {
			logUser	= userLog.getUser(req);
			if ((Boolean)logUser.get("superu") == false){
				req.session().attribute("user", logUser.get("user"));
				return new ModelAndView(logUser, "./html/logs.html");
			} else {
				req.session().attribute("user", logUser.get("user"));
				return new ModelAndView(logUser, "./html/logsu.html");
			}	
		}	
		return new ModelAndView(logUser, "./html/inicio.html");
	}

	public static ModelAndView agregarEquipo(Request req, Response res) {
		Team nTeam = new Team();
   		Map nuevoTeam = new HashMap();
   		if (!nTeam.checkTeam(req)) {
   			nTeam.addTeam(req);
			return new ModelAndView(nuevoTeam, "./html/logsu.html");
   		} else {
   			nuevoTeam.put("Error", "Equipo ya cargado");
   			return new ModelAndView(nuevoTeam, "./html/agregarequipo.html");
   		}
   	}
	
	public static ModelAndView cargarFecha(Request req, Response res) {
	   	Map nuevosteams = new HashMap();
	   	Team teams = new Team();
	   	List<Team> teamsList = teams.getTeams(); 
	   	nuevosteams.put("equipos", teamsList);
	   	return new ModelAndView (nuevosteams, "./html/cargar.mustache");
	}
	
	public static ModelAndView armarFecha(Request req, Response res) {
		Match nMatch = new Match();
		Map nuevoMatch = nMatch.addMatchs(req);
		Schadule nSchadule = new Schadule();
		ArrayList<String> aux = new ArrayList<String>();
		aux = nMatch.getCode();
		nSchadule.addSchadule(aux);
		return new ModelAndView(nuevoMatch, "./html/logsu.html"); 
	}
}