package Dao;

import java.util.List;
import java.util.ArrayList;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import static spark.Spark.*;

import Model.Prediction;

public class PredictionDao {

  //Crea predicciones para usuarios
  /*pre: lista de equipos cargada correctamente
    post: escribe los predicciones de una fecha del usueario en la base de datos
  */
 public void createPrediction(int id_user, int fecha,String [] equipos) {
   String equipo_local;
   String equipo_visitante;
   int nroPartido = selector(fecha);
   for (int i=0; i < equipos.length; i++) {
      equipo_local = equipos[i];
      equipo_visitante = equipos[i+1];
      Prediction prediccion = new Prediction(nroPartido, id_user, equipo_local, equipo_visitante, fecha);
      i++;
      nroPartido++;
   }
 }

 //Selecciona el nroPartido adecuado
  public static int selector (int caso){
    switch(caso){
        case 0:
        return 1;//octavos
        case 1:
        return 9;//cuartos
        case 2:
        return 13;//semifinales
        case 3:
        return 15;//final
        case 4:
        return 16; //Ganador
    }
    return 0;
  }

 //Lista todas las predicciones de un usuario
 public List<Prediction> listPredictions(String id_user){
   List<Prediction> lp = (Prediction.findBySQL("SELECT * FROM predictions WHERE id_user = ?", id_user));
   return lp;
 }

}
