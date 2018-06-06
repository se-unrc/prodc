package prode;

import org.javalite.activejdbc.Model;

public class User extends Model {

    static {
      validatePresenceOf();
    }

    public User() {}

    //Registro de usuarios
    public User(String name, String email, String password){
      set("nick",name);
      set("email",email);
      set("password",password);
      set("type",0);
      set("score",0);
      saveIt();
    }

    public String getName(){ return getString("nick"); }
    public String getemail(){ return getString("email"); }
    public String getpassword(){ return getString("password"); }

}
