package prode;

import org.javalite.activejdbc.Model;

public class Game extends Model {

  static{
    validatePresenceOf("name").message("Ingresa el nombre del equipo");
  }
}
