package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.javalite.activejdbc.Base;

import Services.*;
import prode.Prediction;
import prode.Team;
import spark.ModelAndView;

public class PredictionController {

	public PredictionController(final PredictionService predictionService, final GameService gameService ) {

    post("/prediction", (req, res) -> {
			Map map = new HashMap();
			String option = req.queryParams("option");
      map.put("nombre",req.session().attribute("USER"));
			switch(option){
				case "Octavos":
					return new ModelAndView(map, "./Dashboard/octavos.mustache");
				case "Cuartos":
					return new ModelAndView(map, "./Dashboard/cuartos.mustache");
				case "Semifinales":
					return new ModelAndView(map, "./Dashboard/semifinales.mustache");
				case "Finales":
					return new ModelAndView(map, "./Dashboard/finales.mustache");
			}
      return new ModelAndView(map, "./Dashboard/index.mustache");
    }, new MustacheTemplateEngine());

    post("/prediction/new", (req, res) -> {
			Map map = new HashMap();
			String[] games = req.queryParamsValues("partidos[]");
			String  fecha = (req.queryParams("fecha")).toString();
			int option = Integer.parseInt(fecha);
			int id_user = req.session().attribute("ID");
			String type = req.session().attribute("TYPE");
			map.put("nombre",req.session().attribute("USER"));
			if(type.equalsIgnoreCase("1")){
         gameService.updateGames(option, games);
       }
 			else {
        predictionService.createPrediction(id_user, option, games);
      }
      return new ModelAndView(map, "./Dashboard/profile.mustache");
    }, new MustacheTemplateEngine());

    get("/teams", (req, res) -> {
      Map<String, List<Team>> map = new HashMap<>();
      List<Team> lt = gameService.listTeams();
      map.put("games",lt);
			map.put("nombre",req.session().attribute("USER"));
      return new ModelAndView(map, "./Dashboard/teams.mustache");
    }, new MustacheTemplateEngine());




  }
}
