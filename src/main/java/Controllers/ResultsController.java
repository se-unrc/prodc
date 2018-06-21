package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.*;

import org.javalite.activejdbc.Base;

import Services.UserService;
import prode.User;
import spark.ModelAndView;


public class ResultsController {

	public ResultsController(final UserService userService) {

  get("/results", (req, res) -> {
		Map<String,List<User>> map = new HashMap<>();
    List<User> lu = userService.getAllUsers();
		map.put("users",lu);
    return new ModelAndView(map, "./Dashboard/results.mustache");
  }, new MustacheTemplateEngine());

  }
}
