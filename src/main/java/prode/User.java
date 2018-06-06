package prode;

import org.javalite.activejdbc.Model;

public class User extends Model {

    static {
      validatePresenceOf("username");
    }

    // public User() {}
    //
    // public User(String name, String email, String password, Fixture fixture){
    //   set("name",name);
    //   set("email",name);
    //   set("password",name);
    // }
    //
    // public String getName(){ return getString("name"); }
    // public String getemail(){ return getString("email"); }
    // public String getpassword(){ return getString("password"); }
}
