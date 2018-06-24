package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.*;

import org.javalite.activejdbc.Base;

import Services.GameService;
import prode.User;
import prode.Game;
import spark.ModelAndView;


public class ResultsController {

	public ResultsController(final GameService gameService) {

		//Devuelve tabla de puntos renderiza en results
  get("/results", (req, res) -> {
		Map<String,List<User>> map = new HashMap<>();
    List<User> lu = gameService.listPoints();
		map.put("users",lu);
		map.put("nombre",req.session().attribute("USER"));
    return new ModelAndView(map, "./Dashboard/results.mustache");
  }, new MustacheTemplateEngine());

	//Devuelve tabla de juegos creados por el administrador
  get("/results/games", (req, res) -> {
		Map<String,List<Game>> map = new HashMap<>();
    List<Game> lg = gameService.listGames();
		map.put("games",lg);
		map.put("nombre",req.session().attribute("USER"));
    return new ModelAndView(map, "./Dashboard/games.mustache");
  }, new MustacheTemplateEngine());

  }
}
