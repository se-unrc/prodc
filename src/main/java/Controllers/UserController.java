 package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javalite.activejdbc.Base;

import Services.UserService;
import prode.ResponseError;
import prode.User;
import spark.ModelAndView;

public class UserController {

	private Map map;
	private List<Map> lmap;

	public UserController(final UserService userService) {

  map = new HashMap();
  get("/users", (req, res) -> {
    List<User> lu = userService.getAllUsers();
    for(User us: lu) {
    	map = new HashMap();
    	lmap.add((Map) map.put("name", us.getemail()));
    }
    return new ModelAndView(lmap, "./Dashboard/hello.mustache");
  }, new MustacheTemplateEngine());


  get("/users/:id", (req, res) -> {
			String id = req.params(":id");
			User user = userService.getUser(id);
      if(user == null){
        return new ModelAndView(null, "./404.mustache");
      }
      map.put("name",user.getemail());
      return new ModelAndView(map, "./Dashboard/index.mustache");
		}, new MustacheTemplateEngine());


    post("/users", (req, res) -> {
      String id = req.queryParams("username");
      User user = userService.getUser(id);
      if(user == null){
        return new ModelAndView(null, "./404.mustache");
      }
      map.put("name",user.getemail());
      return new ModelAndView(map, "./Dashboard/index.mustache");
    }, new MustacheTemplateEngine());
  }
}
