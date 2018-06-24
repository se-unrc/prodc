package prode;

import java.util.*;
import org.javalite.activejdbc.Base;
import static spark.Spark.*;
import spark.*;

import org.javalite.activejdbc.Model;

public class User extends Model {

	public User(){

	}

	public User(String user, String pass){
		User u = new User();
        u.set("username", user);
        u.set("password", pass);
        u.saveIt();
	}

	public Map addUser(Request req){
		String userlog = req.queryParams("user");
		String passlog = req.queryParams("password");

		Map resultUser = new HashMap();
		List<User> busqueda = User.where("user = ?", userlog);
		Boolean esta = (busqueda.size() == 0);
		if (esta){
			User u = new User();
			u.set("username", userlog);
			u.set("password", passlog);
			u.saveIt();
		} else {
			resultUser.put("Error","<div class='alert alert-danger' id='alert-danger'><strong>Error!</strong> Usuario en uso, intente con otro</div>");
			return resultUser;
		}
		return resultUser;
    }

    public Map getUser(Request req){
    	String userlog = req.queryParams("user");
    	String passlog = req.queryParams("password");

    	Map resultUser =new HashMap();

    	List<User> busqueda= User.where("user = ? and password = ?", userlog, passlog);
    	Boolean esta = (busqueda.size() == 0);

    	if (!(esta)){
    		resultUser.put("user", busqueda.get(0).get("id"));
    		return resultUser;
    	}
    	resultUser.put("user", 0);
    	return resultUser;
    }
}