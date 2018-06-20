package prode;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

import Controllers.UserController;
import Services.UserService;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.*;

public class App
{
    
    public static void main( String[] args )
    {
       staticFiles.location("/public/");
       port(1112);

       before((request, response) -> {
         Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode_test?nullNamePatternMatchesAll=true", "root", "");
       });

       after((request, response) -> {
         Base.close();
       });

       get("/", (req, res) -> {
           Map map = new HashMap();
           map.put("error",false);
           return new ModelAndView(map, "./Dashboard/index.mustache");
         }, new MustacheTemplateEngine()
       );

        new UserController(new UserService());
        
     
        
      }
}
