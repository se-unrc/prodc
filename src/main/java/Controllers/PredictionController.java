package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.*;

import org.javalite.activejdbc.Base;

import Services.UserService;
import prode.User;
import spark.ModelAndView;

public class PredictionController {


	public PredictionController(final UserService userService) {

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

    post("/prediction", (req, res) -> {
			Map map = new HashMap();
      String option = req.queryParams("prueba");
			map.put("result",option);
      return new ModelAndView(map, "./Dashboard/profile.mustache");
    }, new MustacheTemplateEngine());

  }
}
