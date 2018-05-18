package prode;

import org.javalite.activejdbc.Base;
import prode.User;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;



/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "templates/Dashboard/hello.vtl");
          }, new VelocityTemplateEngine());

        // Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode?nullNamePatternMatchesAll=true", "root", "root");
        // User u = new User();
        // u.set("username", "Riquelme");
        // u.set("password", "password");
        // u.saveIt();
        // Base.close();
        // System.out.println( "Hello World!" );
    }
}
