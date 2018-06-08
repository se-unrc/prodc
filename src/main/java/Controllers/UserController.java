 package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.*;

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


  before("/users/*",(request, response) -> {
    boolean authenticated = request.session().attribute("USER")!= null;
    if (!authenticated) {
      halt(401, "You are not welcome here");
    }
  });

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
      map.put("email",user.getemail());
      return new ModelAndView(map, "./Dashboard/index.mustache");
		}, new MustacheTemplateEngine());


    post("/users", (req, res) -> {
      String username = req.queryParams("username");
      String pass = req.queryParams("password");
      User user = userService.getUser(username);
      if(user != null){
        req.session(true);
        req.session().attribute("USER",username);
      }
      else return new ModelAndView(null, "./404.mustache");
      map.put("email",user.getemail());
      map.put("name",req.session().attribute("SESSION_NAME"));
      return new ModelAndView(map, "./Dashboard/index.mustache");
    }, new MustacheTemplateEngine());


    post("/create/user", (req, res) -> {
      String username = req.queryParams("username");
      String pass = req.queryParams("password");
      User user = userService.getUser(username);
      if(user == null){
        return new ModelAndView(null, "./404.mustache");
      }
      map.put("email",user.getemail());
      return new ModelAndView(map, "./Dashboard/index.mustache");
    }, new MustacheTemplateEngine());
  }
}
