package prode;

import org.javalite.activejdbc.Model;

public class Prediction extends Model {

  static{
    validatePresenceOf();
  }

  public Prediction(){}

  public Prediction(int id_game, int id_user, String local, String visitante, int fecha) {
    set("id_game",id_game);
    set("id_user",id_user); 
    set("team_local", local);
    set("team_visitante", visitante);
    set("fecha", fecha);
    saveIt();
  }

  public int getIdPrediction(){
	  return ((int) get("id"));
  }
  public int getIdGame(){
	  return ((int) get("id_game"));
  }
  public int getIdUser(){
    return ((int) get("id_user"));
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
