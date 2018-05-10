package prode;

import org.javalite.activejdbc.Model;

public class User extends Model {

  static{
    validatePresenceOf("username").message("Por favor, ingrese un nombre");
  }
}
