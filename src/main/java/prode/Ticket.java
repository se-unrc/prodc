package prode;

import org.javalite.activejdbc.Model;
	
public class Ticket extends Model {

	public Ticket(){

	}

	public void addTicket(int idUsuario, int numFecha){
		Ticket t = new Ticket();
		t.set("id_usuario", idUsuario);
		t.set("num_fecha", numFecha);
	}
}