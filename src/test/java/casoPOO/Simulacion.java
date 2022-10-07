package casoPOO;

import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Simulacion extends Thread {
	
	private int IDplantType;
	private PlantManager planta;
	private TimeManager tiempo;
	private SeasonManager temporada;
	private int diesWhenLifeIs;
	
	Simulacion(int pIDplantType) {
		IDplantType = pIDplantType;
	}
	
	//aca va a estar todo lo importante
	//se van a instanciar las clases correspondientes y llamar los metodos importante, se van a conectar entre si
	
	public void run() {
		
		try {
			
			planta = new PlantManager(IDplantType);
			tiempo = new TimeManager(planta);
			temporada = new SeasonManager();
			
			diesWhenLifeIs = planta.getDiesWhenLifeIs(); //el valor de vida de cuando muere
			
			Graficar grafico = new Graficar(temporada, tiempo, planta);
			
			while(planta.getLifepoints() > diesWhenLifeIs && tiempo.getDaysPassed() != planta.getLifeExpectancyDays()) {
				
				grafico.displayNewValues(temporada, tiempo, planta);
				
				tiempo.passOneday(this);  //adentro de esto se usa el hilo y los detalles de fecha y tiempo
				
				grafico.displayNewValues(temporada, tiempo, planta);
				
				System.out.println("Fecha: " + tiempo.getDate());
				System.out.println("Hora: " + tiempo.getTime());
				System.out.println("Dias pasados: " + tiempo.getDaysPassed());
				temporada.checkSeason(tiempo.getDate());
				temporada.changeClimate();
				System.out.println("Season actual: " + temporada.getCurrentSeason());
				
				planta.takeNutrientesAbono();
				planta.takeNutrientesAgua();
				
				planta.checkSun(temporada);
				planta.checkFertilizer();
				planta.checkWater(temporada);
				
				System.out.println("Abono en: " + planta.getFertilpoints());
				System.out.println("Agua en: " + planta.getWaterpoints());
				
				System.out.println("Vida en: " + planta.getLifepoints());
				
				
			}
			planta.morir();
			grafico.displayNewValues(temporada, tiempo, planta);
		} catch(IOException | InterruptedException | ParseException e) {
			System.out.println("Excepcion ha ocurrido: " + e);
		}
	}
}