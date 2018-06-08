 package Services;

import java.util.*;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

import prode.User;

public class UserService {

	private Map<String, User> users = new HashMap<>();

	public List<User> getAllUsers() {
    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode_test?nullNamePatternMatchesAll=true", "root", "root");
    List<User> u = User.findAll();
    Base.close();
    return u;
	}

	public User getUser(String id) {
    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode_test?nullNamePatternMatchesAll=true", "root", "root");
    LazyList<Model> u = User.where("nick = ?", id);
    User usr =  (u!= null)?(User)u.get(0):null;
    Base.close();
	  return usr;
	}

	// public User createUser(String name, String email) {
	// 	failIfInvalid(name, email);
	// 	User user = new User(name, email);
	// 	users.put(user.getId(), user);
	// 	return user;
	// }
  // 
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
  //
	// private void failIfInvalid(String name, String email) {
	// 	if (name == null || name.isEmpty()) {
	// 		throw new IllegalArgumentException("Parameter 'name' cannot be empty");
	// 	}
	// 	if (email == null || email.isEmpty()) {
	// 		throw new IllegalArgumentException("Parameter 'email' cannot be empty");
	// 	}
	// }
}
