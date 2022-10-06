package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class GardenMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		
		//Simulacion simulacion1 = new Simulacion(0);
		
		//simulacion1.start();
		
		//MENU YA SE CAMBIO A MAP PARA TOMAR EL JSON EN UN MAP, FALTA ACONDICIONAR EL RESTO DE CLASES A ESTE CAMBIO
		//PARA QUE YA NO ACCEDAN DIRECTAMENTE AL JSON
		
		MapJSON map = new MapJSON();
		
	}
}
