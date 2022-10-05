package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class GardenMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		//Planta plant = new Planta(0);
		
		
		//de momento son solo  pruebas para verificar que las cosas funcionen, pero no van a estar aca !!!!!!!!
		PlantManager plant = new PlantManager(0);
		
		plant.regar();
		plant.abonar();
		
		
		TimeManager time = new TimeManager(plant);
		int conta = 0;
		while(conta<1) {
			Thread hilo = new Thread();
			time.passOneday(hilo);
			System.out.println(time);
			conta++;
		}
		
		SeasonManager epoca = new SeasonManager();
		epoca.checkSeason(time.getDate());
		System.out.println(epoca.getCurrentSeason());
	}
}
