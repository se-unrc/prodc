package prode;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

import Controllers.*;
import Dao.*;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.*;

import Model.*;

import com.codahale.metrics.*;
import utils.*;

//Clase principal
public class App
{
	
    public static void main( String[] args )
    {
		//metrica
		Meter requests = Metrica.getRegistry().meter("requests");
		Metrica.startReport();
		
      //Directorio de recursos /imagenes/estilos/scripts
       staticFiles.location("/public/");
       //Puerto de la aplicacion
       port(1112);

       //Abre conexion antes de cada solicitud
       before((request, response) -> {
		 requests.mark();  
         Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode_test?nullNamePatternMatchesAll=true", "root", "root");
       });

       //Cierra conexion
       after((request, response) -> {
         Base.close();
       });

       //Pagina por defecto index
       get("/", (req, res) -> {
           Map map = new HashMap();
           map.put("error",false);
           return new ModelAndView(map, "./Dashboard/index.mustache");
         }, new MustacheTemplateEngine()
       );

        //Inicializa controladores
        new UserController(new UserDao());
        new PredictionController(new PredictionDao(), new GameDao());
        new ResultsController(new GameDao());
      }

}
