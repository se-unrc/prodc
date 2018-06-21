package Services;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import static spark.Spark.*;

import prode.Prediction;

public class PredictionService {

  //Capturar si existe una excepcion
 public void createPrediction(String nick, int fecha,String [] equipos) {
   int i = 0;
   int c = 1;
   if(fecha==0) {c=1;} //octavos
   if(fecha==1) {c=9;} //cuartos
   if(fecha==2) {c=13;} //semis
   if(fecha==3) {c=15;}
   while(i < equipos.length) {
     Prediction p = new Prediction(c, nick, equipos[i], equipos[i+1], fecha);
     i=i+2;
     c++;
   }
 }
}
