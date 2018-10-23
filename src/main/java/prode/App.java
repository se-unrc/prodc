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

      get("/pronosticar", (req, res) -> {
        Map pronostico = new HashMap();
        Match pronTeams = new Match();
        List<Match> teamsForPron = pronTeams.getMatchList();
        //System.out.println(teamsForPron.get(0).getInteger("equipo_local"));
        //Team eq1 = Team.findById(teamsForPron.get(0).getInteger("equipo_local"));
        //Team eq2 = Team.findById(teamsForPron.get(0).getInteger("equipo_visitante"));
        List<Team> eq1 = Team.findBySQL("select nom_equipo from teams where cod_equipo = 1");
        List<Team> eq2 = Team.findBySQL("select nom_equipo from teams where cod_equipo = 2");
        Team eq1prima = eq1.get(0);
        Team eq2prima = eq2.get(0);
        pronostico.put("nombreEquipo1",eq1prima.getString("nom_equipo"));
        pronostico.put("nombreEquipo2",eq2prima.getString("nom_equipo"));
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
	   		List<Team> teamsList = teams.getTeams(); 
	   		//Team t = teamsList.get(0);
	   		//System.out.println(t.toString());
	   		nuevosteams.put("equipos", teamsList);
	   		return new ModelAndView (nuevosteams, "./html/cargar.mustache");
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

