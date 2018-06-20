package prode;

import org.javalite.activejdbc.Model;

public class Team extends Model {
  static{
    validatePresenceOf();
  }
  
  public Team(String nombre) {
	  set("name", nombre);
	  saveIt();
  }
  
  public String getImage() {
	  return (getString("image"));
  }

  public String getName() {
	  return (getString("name"));
  }


}
