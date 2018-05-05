package prode;

import prode.Schadule;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShaduleTest {
    @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/prode_test?nullNamePatternMatchesAll=true", "root", "root");
        System.out.println("SchaduleTest setup");
        Base.openTransaction();
    }

    @After
    public void after(){
        System.out.println("SchaduleTest tearDown");
        Base.rollbackTransaction();
        Base.close();
    }

    @Test
    public void codPartidoNoNulo(){
        Schadule schadule = new Schadule();
        schadule.set(cod_partido, "");
        assertEquals(schadule.isValid(), false);
    }

    @Test
    public void numFechaNoNulo(){
        Schadule schadule = new Schadule();
        schadule.set(num_fecha, "");
        assertEquals(schadule.isValid(), false);
    }
  
}
