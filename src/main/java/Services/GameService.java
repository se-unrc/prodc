package Services;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import static spark.Spark.*;
import java.util.List;

import prode.Game;
import prode.User;

public class GameService {

    //Capturar si existe una excepcion
 public void updateGames(int fecha, String [] equipos) {
   int i = 0;
   int c = 1;
   if(fecha==0) {c=1;} //octavos
   if(fecha==1) {c=9;} //cuartos
   if(fecha==2) {c=13;} //semis
   if(fecha==3) {c=15;}
   while(i < equipos.length) {
     Game game = Game.findFirst(" id = ?", c);
     if(!equipos[i].isEmpty() && !equipos[i + 1].isEmpty()){
       game.set("team_loc",equipos[i]);
       game.set("team_vis",equipos[i + 1]);
       game.saveIt();
       updatePoints(c);
     }
     i=i+2;
     c++;
   }
 }

 private void updatePoints(int id_game){
   int score;
   List<User> users = User.findBySQL("SELECT a.* FROM users a INNER JOIN predictions b ON a.id = b.id_user INNER JOIN games c ON b.id_game = c.id WHERE b.team_local = c.team_loc AND b.team_visitante = c.team_vis AND b.team_visitante != '' AND c.id = ?;",id_game);
   for(User p: users){
     score = Integer.parseInt(p.getScore()) + 1;
     p.set("score",score).saveIt();
   }
  }

  public List<User> listPoints(){
    List<User> lu = User.findBySQL("SELECT * FROM users WHERE id != 1 ORDER BY score DESC LIMIT 10");
    return lu;
  }

}
/*
 */
