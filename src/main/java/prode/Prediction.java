package prode;

import org.javalite.activejdbc.Model;

public class Prediction extends Model {

  static{
    validatePresenceOf();
  }

  public Prediction(){}

  public Prediction(int id_game, String nick, String local, String visitante, int fecha) {
    set("id_game",id_game);
    set("nick",nick); //funciona como el id de usuario
    set("team_loc", local);
    set("team_vis", visitante);
    set("fecha", fecha);
    saveIt();
  }

  public int getIdGame(){
	  return ((int) get("id_game"));
  }
  public String getNick(){
	  return getString("nick");
  }
  public String getTeamLoc() {
	  return (getString("team_loc"));
  }
  public String getTeamVis() {
	  return (getString("team_vis"));
  }
  public int getFecha() {
	  return ((int) get("fecha"));
  }

}
