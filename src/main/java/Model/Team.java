package Model;

import org.javalite.activejdbc.Model;

public class Team extends Model {
  static{
    validatePresenceOf();
  }
  public Team(){}

  public Team(String nombre, String image) {
	  set("name", nombre);
	  set("image", image);
	  saveIt();
  }

  public String getImage() {
	  return (getString("image"));
  }

  public String getName() {
	  return (getString("name"));
  }


}
