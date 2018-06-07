 package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import org.javalite.activejdbc.Base;

import Services.UserService;
import prode.ResponseError;
import prode.User;
import spark.ModelAndView;

public class UserController {

	public UserController(final UserService userService) {
    Map map = new HashMap();

		get("/users/:id", (req, res) -> {
			String id = req.params(":id");
			User user = userService.getUser(id);
      if(user == null){
        return new ModelAndView(map, "./404.mustache");
      }
      map.put("name",user.getemail());
      return new ModelAndView(map, "./Dashboard/hello.mustache");
		}, new MustacheTemplateEngine());
	}
}
