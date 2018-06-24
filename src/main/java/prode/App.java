package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import static spark.Spark.*;	
import prode.User;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App{
    
    public static void main( String[] args ){
		before((request, response) -> {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode?nullNamePatternMatchesAll=true", "root", "root");
		});

		after((request, response) -> {
    	Base.close();
   		});	

		Map logs = new HashMap();
   		get("/inicio", (req, res) -> {
			return new ModelAndView(logs, "./html/inicio.html");
        }, new MustacheTemplateEngine()
    	);

   		// Hacer el login

   		Map reg = new HashMap();
    	get("/registro", (req, res) -> {
 			return new ModelAndView(reg, "./html/registro.html");
  		}, new MustacheTemplateEngine()
   		);

   		post("/registro", (req, res) -> {
   			User nUsuario = new User();
   			Map nuevoUser = nUsuario.addUser(req);
   			if ((String)nuevoUser.get("Error") != null)
   				return new ModelAndView(nuevoUser, "./html/registro.html");
   			return new ModelAndView(nuevoUser, "./html/inicio.html");
   		}, new MustacheTemplateEngine()
   		);

	}
}

/*      
		Map users = new HashMap();
	   	List<User> allUsers = User.findAll();
	    //int i = 0;
	    for(User u:allUsers){
			users.put("user", u);		    	
	    }

		users.put("usersList", allUsers);
		users.put("title", "User List");
	    return new ModelAndView(users, "./views/users/index.mustache");

----


		User u = new User();
        u.set("username", "pepito1");
        u.set("password", "pepito");
        u.saveIt();

	    Map map = new HashMap();
	    map.put("name", "Sam");
	    map.put("value", 1000);
	    map.put("taxed_value", 1000 - (1000 * 0.4));
	    map.put("in_ca", true);

	    get("/hello", (req, res) -> {
	        return new ModelAndView(map, "./views/hello.mustache");
	    }, new MustacheTemplateEngine()
	    );
*/