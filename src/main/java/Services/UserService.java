 package Services;

import java.util.List;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import static spark.Spark.*;

import prode.User;

public class UserService {

	public List<User> getAllUsers() {
    List<User> users;
    users = User.findAll();
    return users;
	}

  //Retorna un usuario por id
	public User getUser(String id) {
    User user;
    user = User.findFirst("nick = ?", id);
	  return user;
	}

  //Crea un usuario
	public User createUser(String name, String password, String email) {
    User user;
		user = new User(name, email, password);
		return user;
	}

  public User isUser(String name, String password){
    User user = User.findFirst("nick = ? AND password = ?", name, password);
    return user;
  }

	// public User updateUser(String id, String name, String email) {
	// 	User user = users.get(id);
	// 	if (user == null) {
	// 		throw new IllegalArgumentException("No user with id '" + id + "' found");
	// 	}
	// 	failIfInvalid(name, email);
	// 	user.setName(name);
	// 	user.setEmail(email);
	// 	return user;
	// }

}
