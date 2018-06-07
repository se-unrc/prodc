package prode;

import org.javalite.activejdbc.Model;

public class Prediction extends Model {

  static{
    validatePresenceOf("name").message("Ingresa el nombre del equipo");
  }
}
