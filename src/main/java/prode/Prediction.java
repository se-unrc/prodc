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
  
  public void setsP(int id_game, String nick, String local, String visitante, int fecha) {
	set("id_game",id_game);
	set("nick",nick); //funciona como el id de usuario
	set("team_loc", local);
	set("team_vis", visitante);
	set("fecha", fecha);
	saveIt();
  }
  
  public void actualizarPredictions(String nick, int fecha,String [] equipos) {
	  int i = 0;
	  int c = 0;
	  if(fecha==0) {c=0;} //octavos
	  if(fecha==1) {c=8;} //cuartos
	  if(fecha==2) {c=12;} //semis
	  if(fecha==3) {c=14;}
	  while(i< equipos.length) { //ese length no me gusta
		  setsP(c, nick, equipos[i], equipos[i+1], fecha);
		  i=i+2;
		  c++;
	  }
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
