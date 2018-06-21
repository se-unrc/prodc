package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.*;

import org.javalite.activejdbc.Base;

import Services.PredictionService;
import prode.Prediction;
import spark.ModelAndView;

public class PredictionController {


	public PredictionController(final PredictionService predictionService) {

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
			Map map = new HashMap();
      String  fecha = (req.queryParams("registro")).toString();
      int option = Integer.parseInt(fecha);
			String nick = req.session().attribute("USER");
			String[] games = req.queryParamsValues("octavos[]");
			predictionService.createPrediction(nick, option, games);
      return new ModelAndView(map, "./Dashboard/profile.mustache");
    }, new MustacheTemplateEngine());

  }
}
