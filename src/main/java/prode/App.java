package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import static spark.Spark.*;	
import prode.User;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App{
    
    public static void main( String[] args ){
		before((request, response) -> {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode?nullNamePatternMatchesAll=true", "root", "root");
		});

		after((request, response) -> {
    	Base.close();
   		});	

		Map inicio = new HashMap();
   		get("/inicio", (req, res) -> {
			return new ModelAndView(inicio, "./html/inicio.html");
        }, new MustacheTemplateEngine()
    	);

    	Map logs = new HashMap();
   		get("/logs", (req, res) -> {
   			User userLog = new User();
   			Map logUser = userLog.getUser(req);
   			if((Integer)logUser.get("user") != null){
   				if ((Boolean)logUser.get("superu") == false){
   					req.session().attribute("user", logUser.get("user"));
   					return new ModelAndView(logUser, "./html/logs.html");
   				} else {
   					req.session().attribute("user", logUser.get("user"));
   					return new ModelAndView(logUser, "./html/logsu.html");
   				}
   			} else {
   				return new ModelAndView(logUser, "./html/inicio.html");
   			}
   		}, new MustacheTemplateEngine()
   		);

   		Map reg = new HashMap();
    	get("/registro", (req, res) -> {
 			return new ModelAndView(reg, "./html/registro.html");
  		}, new MustacheTemplateEngine()
   		);

   		post("/registro", (req, res) -> {
   			User nUsuario = new User();
   			Map nuevoUser = nUsuario.addUser(req);
   			if ((String)nuevoUser.get("Error") != null)
   				return new ModelAndView(nuevoUser, "./html/registro.html");
   			return new ModelAndView(nuevoUser, "./html/inicio.html");
   		}, new MustacheTemplateEngine()
   		);

   		Map pronostico = new HashMap();
    	get("/pronosticar", (req, res) -> {
 			return new ModelAndView(pronostico, "./html/pronosticar.html");
  		}, new MustacheTemplateEngine()
   		);

	   	post("/pronosticar", (req, res) -> {
   			Prediction nPrediccion = new Prediction();
   			Map nuevaPred = nPrediccion.addPrediction(req); 
   			return new ModelAndView(nuevaPred, "./html/logs.html");
   		}, new MustacheTemplateEngine()
   		);   		

	   	Map agrega = new HashMap();
	   	get("/agregar", (req, res) -> {
	   	return new ModelAndView(agrega, "./html/agregarequipo.html");	
	   	}, new MustacheTemplateEngine()
	   	);

	   	post("/agregar",(req, res) -> {
	   		Team nTeam = new Team();
	   		Map nuevoTeam = nTeam.addTeam(req);
	   		return new ModelAndView(nuevoTeam, "./html/logsu.html");	   		
	   	}, new MustacheTemplateEngine()
	   	);

	   
	   	get("/cargar",(req, res) -> {
	   		Map nuevosteams = new HashMap();
	   		Team teams = new Team();
	   		nuevosteams = teams.getTeams();
	   		return new ModelAndView (nuevosteams, "./html/cargar.html");
		},	new MustacheTemplateEngine()
		);

	   	post("/cargar",(req, res) -> {
	   		Match nMatch = new Match();
	   		Map nuevoMatch = nMatch.addMatch(req);
	   		Schadule nSchadule = new Schadule();
	   		ArrayList<String> aux = new ArrayList<String>();
	   		aux = nMatch.getCode();
	   		nSchadule.addSchadule(aux);
	   		return new ModelAndView(nuevoMatch, "./html/logsu.html"); 
    	}, new MustacheTemplateEngine()
	   	);
	 
	}   	
}

