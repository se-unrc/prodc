package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.javalite.activejdbc.Base;

import Dao.*;
import Model.*;
import spark.ModelAndView;

public class TeamController {

	public TeamController() {

	//formulario para crear un equipo
	get("/team/new",(req, res)->{
	return new ModelAndView (null, "./Dashboard/teamcreate.mustache");
	}, new MustacheTemplateEngine());
	

  }
}

