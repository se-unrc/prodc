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
  /*Segun que fecha ingrese el usuario,
    va a ser el nroPartido(id_game en database)
    en fecha=0 (octavos) son 8 partidos y comienza con el primero
    la */
 public void createPrediction(int id_user, int fecha,String [] equipos) {
   String equipo_local;
   String equipo_visitante;
   int nroPartido = 0;
   switch(fecha){
       case 0:
       nroPartido=1;//octavos
       break;
       case 1:
       nroPartido=9;//cuartos
       break;
       case 2:
       nroPartido=13;//semifinales
       break;
       case 3:
       nroPartido=15;//finalº
       break;
   }
   for (int i=0; i < equipos.length; i++) {
        equipo_local = equipos[i];
        equipo_visitante = equipos[i+1];
        if(!equipos[i].isEmpty() && !equipos[i+1].isEmpty()){
           Prediction prediccion = new Prediction(nroPartido, id_user, equipo_local, equipo_visitante, fecha);
        }
        else{/*entra por else siel ususario no lleno los campos del equipo, tratar error*/}
        i++;
        nroPartido++;
    }
 }

 //Lista todas las predicciones de un usuario
 public List<Prediction> listPredictions(String id_user){
   List<Prediction> lp = (Prediction.findBySQL("SELECT * FROM predictions WHERE id_user = ?", id_user));
   return lp;
 }

}
