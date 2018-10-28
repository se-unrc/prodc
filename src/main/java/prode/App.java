package prode;

import java.util.*;
import com.codahale.metrics.*;
import java.util.concurrent.TimeUnit;
import org.javalite.activejdbc.Base;
import static spark.Spark.*;	
import prode.User;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App{
	
	 static final MetricRegistry metrics = new MetricRegistry();
    
    public static void main( String[] args ){
    	/**
    	 * Apertura de la base de datos
    	 */
		before((request, response) -> {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode?nullNamePatternMatchesAll=true", "root", "root");
		});

		after((request, response) -> {
    	Base.close();
   		});	

		/**
		 * Carga de la pagina de inicio
		 */
		Map inicio = new HashMap();
   		get("/inicio", (req, res) -> {
			return new ModelAndView(inicio, "./html/inicio.html");
        }, new MustacheTemplateEngine()
    	);
   		
   		startReport();
        Meter requests = metrics.meter("requests");
        requests.mark();
        wait5Seconds();

   		/**
		 * Carga de la pagina de de logueo
		 */
   		Map logs = new HashMap();
   		get("/logs", AppControl::ingreso, new MustacheTemplateEngine());

   		/**
		 * Carga de la pagina de registro
		 */
   		Map reg = new HashMap();
    	get("/registro", (req, res) -> {
 		return new ModelAndView(reg, "./html/registro.html");
  		}, new MustacheTemplateEngine()
   		);
    	
    	/**
		 * 
		 */
    	post("/registro",AppControl::registro, new MustacheTemplateEngine());

    	/**
		 * Carga de la pagina para agregar equipos
		 */
	   	Map agrega = new HashMap();
	   	get("/agregar", (req, res) -> {
	   	return new ModelAndView(agrega, "./html/agregarequipo.html");	
	   	}, new MustacheTemplateEngine()
	   	);
	   
	   	post("/agregar",AppControl::agregarEquipo, new MustacheTemplateEngine());
	   	
	   	/**
		 * Carga de la pagina para cargar fechas
		 */
	   	get("/cargar",AppControl::cargarFecha, new MustacheTemplateEngine());

	   	post("/cargar",AppControl::armarFecha, new MustacheTemplateEngine());
	 
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	Map pronostico = new HashMap();
   		get("/pronosticar", (req, res) -> {
        Match pronTeams = new Match();
        List<Match> teamsForPron = pronTeams.getMatchList();
        //System.out.println(teamsForPron.get(0).getInteger("equipo_local"));
        //Team eq1 = Team.findById(teamsForPron.get(0).getInteger("equipo_local"));
        //Team eq2 = Team.findById(teamsForPron.get(0).getInteger("equipo_visitante"));
        List<Team> eq1 = Team.findBySQL("select nom_equipo from teams where cod_equipo = 1");
        List<Team> eq2 = Team.findBySQL("select nom_equipo from teams where cod_equipo = 2");
        Team eq1prima = eq1.get(0);
        Team eq2prima = eq2.get(0);
        pronostico.put("nombreEquipo1",eq1prima.getString("nom_equipo"));
        pronostico.put("nombreEquipo2",eq2prima.getString("nom_equipo"));
        return new ModelAndView(pronostico, "./html/pronosticar.html");
   		}, new MustacheTemplateEngine()
   		);

	   	post("/pronosticar", (req, res) -> {
   		Prediction nPrediccion = new Prediction();
   		Map nuevaPred = nPrediccion.addPrediction(req); 
   		return new ModelAndView(nuevaPred, "./html/logs.html");
   		}, new MustacheTemplateEngine()
   		);
	}   
    
    //Metricas
    
    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();
        reporter.start(1, TimeUnit.SECONDS);
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(5*1000);
        }
        catch(InterruptedException e) {}
    }
    
}

