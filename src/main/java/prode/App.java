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
       port(4445);
       get("/", (req, res) -> {
           return new ModelAndView(null, "./Dashboard/hello.mustache");
         }, new MustacheTemplateEngine()
       );

        new UserController(new UserService());
      }
}
