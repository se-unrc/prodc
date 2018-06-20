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
				case "octavos":
					return new ModelAndView(map, "./Dashboard/octavos.mustache");
				case "cuartos":
					return new ModelAndView(map, "./Dashboard/cuartos.mustache");
				case "semifinales":
					return new ModelAndView(map, "./Dashboard/cuartos.mustache");
				case "finales":
					return new ModelAndView(map, "./Dashboard/cuartos.mustache");
			}
      return new ModelAndView(null, "./Dashboard/index.mustache");
    }, new MustacheTemplateEngine());

    post("/prediction/new", (req, res) -> {
			Map map = new HashMap();
      String option = req.queryParams("prueba");
			map.put("result",option);
      return new ModelAndView(map, "./Dashboard/profile.mustache");
    }, new MustacheTemplateEngine());

  }
}
