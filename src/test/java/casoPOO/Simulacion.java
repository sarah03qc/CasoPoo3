package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Simulacion extends Thread {
	
	private int IDplantType;
	
	Simulacion(int pIDplantType) {
		IDplantType = pIDplantType;
	}
	
	//aca va a estar todo lo importante
	//se van a instanciar las clases correspondientes y llamar los metodos importante, se van a conectar entre si
	
	public void run() {
		
		try {
			
			PlantManager planta;
			planta = new PlantManager(IDplantType);
			TimeManager tiempo = new TimeManager(planta);
			SeasonManager temporada = new SeasonManager();
			
			
			while(planta.getLifepoints() > 0) {
				
				System.out.println("Fecha: " + tiempo.getDate());
				System.out.println("Hora: " + tiempo.getTime());
				System.out.println("Dias pasados: " + tiempo.getDaysPassed());
				temporada.checkSeason(tiempo.getDate());
				temporada.changeClimate();
				System.out.println("Season actual: " + temporada.getCurrentSeason());
				
				planta.abonar();
				planta.regar();
				
				planta.checkFertilizer();
				planta.checkSun(temporada);
				planta.checkWater(temporada);
				
				System.out.println("Vida en: " + planta.getLifepoints());
				
				tiempo.passOneday(this);  //adentro de esto se usa el hilo y los detalles de fecha y tiempo
			
			}
		} catch(IOException | InterruptedException | ParseException e) {
			System.out.println("Excepcion ha ocurrido: " + e);
		}
	}
}
			
		