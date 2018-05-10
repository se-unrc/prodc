package prode;

import org.javalite.activejdbc.Base;

import prode.User;



public class App
{
    public static void main( String[] args )
    {

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode?nullNamePatternMatchesAll=true", "root", "root");

        User u = new User();
        u.set("username", "Ramiro");
        u.set("password", "password");
        u.saveIt();

        Base.close();

        System.out.println( "Hello World!" );
    }
}
