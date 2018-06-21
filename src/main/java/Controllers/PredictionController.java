package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.*;

import org.javalite.activejdbc.Base;

import Services.*;
 	 	import prode.Prediction;
import spark.ModelAndView;

public class PredictionController {


	public PredictionController(final PredictionService predictionService, final GameService gameService ) {

    post("/prediction", (req, res) -> {
			Map map = new HashMap();
      String option = req.queryParams("option");
			map.put("result",option);
			switch(option){
				case "Octavos":
					return new ModelAndView(map, "./Dashboard/octavos.mustache");
				case "Cuartos":
					return new ModelAndView(map, "./Dashboard/cuartos.mustache");
				case "Semifinales":
					return new ModelAndView(map, "./Dashboard/cuartos.mustache");
				case "Finales":
					return new ModelAndView(map, "./Dashboard/cuartos.mustache");
			}
      return new ModelAndView(null, "./Dashboard/index.mustache");
    }, new MustacheTemplateEngine());

    post("/prediction/new", (req, res) -> {
			String[] games = req.queryParamsValues("octavos[]");
			String  fecha = (req.queryParams("registro")).toString();
			int option = Integer.parseInt(fecha);
			int id_user = req.session().attribute("ID");
			String type = req.session().attribute("TYPE");
			if(type.equalsIgnoreCase("1")){
         gameService.updateGames(option, games);
       }
 			else {
        System.out.println("ENTROOOOOOOOOOO AQUIIIIIIIIIIIIIIIIIII");
        predictionService.createPrediction(id_user, option, games);
      }
      return new ModelAndView(null, "./Dashboard/profile.mustache");
    }, new MustacheTemplateEngine());

  }
}
