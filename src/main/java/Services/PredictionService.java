package Services;

import java.util.List;
import java.util.ArrayList;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import static spark.Spark.*;

import prode.Prediction;

public class PredictionService {

  //Crea predicciones para usuarios
 public void createPrediction(int id_user, int fecha,String [] equipos) {
   int i = 0;
   int c = 1;
   if(fecha==0) {c=1;} //octavos
   if(fecha==1) {c=9;} //cuartos
   if(fecha==2) {c=13;} //semis
   if(fecha==3) {c=15;}
   while(i < equipos.length) {
    if(!equipos[i].isEmpty() && !equipos[i + 1].isEmpty()){
      Prediction p = new Prediction(c, id_user, equipos[i], equipos[i+1], fecha);
     }
     i=i+2;
     c++;
   }
 }

 //Lista todas las predicciones de un usuario
 public List<Prediction> listPredictions(String id_user){
   List<Prediction> lp = (Prediction.findBySQL("SELECT * FROM predictions WHERE id_user = ?", id_user));
   return lp;
 }

}
