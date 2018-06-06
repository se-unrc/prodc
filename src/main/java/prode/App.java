package prode;

import org.javalite.activejdbc.Base;
import prode.User;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.*;


public class App
{
    public static void main( String[] args )
    {
        // port(4444);
        // staticFiles.location("/public");

        Map map = new HashMap();
             map.put("name", "Sam");
             map.put("value", 1000);
             map.put("taxed_value", 1000 - (1000 * 0.4));
             map.put("in_ca", true);

             get("/hello", (req, res) -> {
                 return new ModelAndView(map, "./Dashboard/hello.mustache");
               }, new MustacheTemplateEngine()
             );

        // Base.open();
        // User u = new User("Ramiro","ramiro1935@gmail.com","123456", new Fixture("Copa"));
        // u.saveIt();
        // Base.close();
        // System.out.println( "Hello World!" );
    }
}
