package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import org.json.simple.parser.ParseException;

public class SeasonManager extends SeasonRules {
	
	private int mes;
	private int niveldeLluvia;
	private int niveldeSol;
	private String currentSeason;
	private Season objetoSeasonActual;
	
	SeasonManager() throws FileNotFoundException, IOException, ParseException {
		super();
	}

	public void checkSeason(LocalDate fecha) {
		mes = fecha.getMonthValue();
		for(int i = 0; i < this.getEpocas().length; i++) {
			//se toman los valores de inicio y fin de cada season 
			if(this.getEpocas()[i].getStartMonth() <= mes && mes <= this.getEpocas()[i].getEndMonth()) {
				//esto significa que el mes actual esta dentro del rango de JSON, entonces se pone como currentSeason
				currentSeason = this.getEpocas()[i].getName();
				objetoSeasonActual = this.getEpocas()[i];
			}   
        }
	}
	
	public void changeClimate() {
		//los siguientes son randomizers del nivel de intensidad del sol y lluvia
		niveldeLluvia = ThreadLocalRandom.current().nextInt(objetoSeasonActual.getPrecipitacionMin(), objetoSeasonActual.getPrecipitacionMax() + 1);
		System.out.println("LLUVIA AHORA ESTA EN: " + niveldeLluvia);
		
		niveldeSol = ThreadLocalRandom.current().nextInt(objetoSeasonActual.getSolMin(), objetoSeasonActual.getSolMax() + 1);
		System.out.println("SOL AHORA ESTA EN: " + niveldeSol);
	}
	public int getRainLevel() {
		return niveldeLluvia;
	}
	public int getSunLevel() {
		return niveldeSol;
	}
	public String getCurrentSeason() {
		return currentSeason;
	}
}