package prode;

import org.javalite.activejdbc.Model;

public class Prediction extends Model {

  static{
    validatePresenceOf();
  }

  public Prediction(){}

  public Prediction(int id_game, String nick, String winner){
    set("id_game",id_game);
    set("nick",nick);
    set("winner",winner);
    saveIt();
  }

  public String getIdGame(){return getString("id_game");}
  public String getNick(){return getString("nick");}
  public String getWinner(){return getString("winner");}

}
