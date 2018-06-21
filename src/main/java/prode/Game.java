package prode;

import java.sql.Date;
import org.javalite.activejdbc.Model;


public class Game extends Model {
  static{
    validatePresenceOf();
  }

  public Game(){}

  public Game(Date diaPartido,int fecha) { //primero se crean los partidos pero no sabemos quien juega en cada cual, solo la fecha
	  set("fecha", fecha);
	  set("date_game", diaPartido);
	  saveIt();
  }

  public Game(Date diaPartido, int fecha, String equipoLocal, String equipoVisitante) {//no creo que lo usemos nunca(discutir si borrar)
	  set("fecha", fecha);
	  set("date_game", diaPartido);
	  set("team_loc", equipoLocal);
	  set("team_vis", equipoVisitante);
	  saveIt();
  }

  public void setTeams(String equipoLocal, String equipoVisitante) {
	  //Implementar, ingresar equipos en un juego ya creado(solo usado por admin)
	  set("team_loc", equipoLocal);
	  set("team_vis", equipoVisitante);
  }

  public int getIdGame() {
	  return ((int) get("id"));
  }

  public int getFecha() {
	  return ((int) get("fecha"));
  }

  public String getTeamLoc() {
	  return (getString("team_loc"));
  }

  public String getTeamVis() {
	  return (getString("team_vis"));
  }

}
