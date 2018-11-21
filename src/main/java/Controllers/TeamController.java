package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.javalite.activejdbc.Base;

import Dao.*;
import Model.Team;
import spark.ModelAndView;


public class TeamController {

	public TeamController() {

	//formulario para crear un equipo
	get("/team/new",(req, res)->{
	return new ModelAndView (null, "./Dashboard/teamcreate.mustache");
	}, new MustacheTemplateEngine());
	
	//Creacion de usuarios
		post("/team/save", (req, res) -> {
			
			Map map = new HashMap();
			String teamname = req.queryParams("nombre");
			Team team = new Team(teamname);
			String mensaje ="Se creo Equipo exitosamente";
			
			if(team == null){
				mensaje = "Error no se pudo cargar el equipo";
			}
			map.put("mensaje",mensaje);
			return new ModelAndView(map, "./Dashboard/teamcreate.mustache");
		}, new MustacheTemplateEngine());
	

  }
}

