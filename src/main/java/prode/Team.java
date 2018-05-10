package prode;

import org.javalite.activejdbc.Model;

public class Team extends Model {

  static{
    validatePresenceOf("name").message("Por favor, ingrese el nombre del equipo");
  }
}
