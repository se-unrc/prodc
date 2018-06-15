package Controllers;

import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;

import java.util.*;

import org.javalite.activejdbc.Base;

import Services.UserService;
import prode.User;
import spark.ModelAndView;

public class UserController {


	public UserController(final UserService userService) {

  before("/profile/*",(request, response) -> {
    boolean authenticated = request.session().attribute("USER")!= null;
    if (!authenticated) {
      halt(401, "You are not welcome here");
    }
  });

  before("/users/*",(request, response) -> {
    boolean authenticated = request.session().attribute("USER")!= null;
    if (!authenticated) {
      halt(401, "You are not welcome here");
    }
  });


  get("/prueba", (req, res) -> {
		Map<String,List<User>> map = new HashMap<>();
    List<User> lu = userService.getAllUsers();
		map.put("users",lu);
    return new ModelAndView(map, "./Dashboard/users.mustache");
  }, new MustacheTemplateEngine());


  get("/users/:id", (req, res) -> {
			Map map = new HashMap();
			String id = req.params(":id");
			User user = userService.getUser(id);
      if(user == null){
        return new ModelAndView(null, "./404.mustache");
      }
      map.put("email",user.getEmail());
      return new ModelAndView(map, "./Dashboard/index.mustache");
		}, new MustacheTemplateEngine());

		//Autenticacion
    post("/profile", (req, res) -> {
			Map map = new HashMap();
      String username = req.queryParams("username");
      String pass = req.queryParams("password");
      User user = userService.isUser(username,pass);
      if(user != null){
        req.session(true);
        req.session().attribute("USER",username);
				map.put("email",user.getEmail());
				map.put("name",req.session().attribute("SESSION_NAME"));
      }
			else{
				map.put("error",true);
				return new ModelAndView(map, "./Dashboard/index.mustache");
			}
      return new ModelAndView(map, "./Dashboard/profile.mustache");
    }, new MustacheTemplateEngine());


    post("/new/user", (req, res) -> {
      String username = req.queryParams("username");
      String pass = req.queryParams("password");
      String email = req.queryParams("email");
      User user = userService.createUser(username,pass,email);
      if(user == null){
        return new ModelAndView(null, "./404.mustache");
      }
      return new ModelAndView(null, "./Dashboard/index.mustache");
    }, new MustacheTemplateEngine());
  }
}
