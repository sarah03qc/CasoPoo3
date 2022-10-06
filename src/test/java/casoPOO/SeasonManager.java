package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class SeasonManager extends Season {
	
	private int mes;
	private int niveldeLluvia;
	private int niveldeSol;
	private String currentSeason;
	private JSONObject actualEpoca;
	
	SeasonManager() throws FileNotFoundException, IOException, ParseException {
		super();
	}

	public void checkSeason(LocalDate fecha) {
		mes = fecha.getMonthValue();
		int startmonth;
		int endmonth;
		for(int i = 0; i < seasons.size(); i++) {
			//se toman los valores de inicio y fin de cada season segun el JSON
			startmonth = ((Long) seasons.get(i).get("startMonth")).intValue();
			endmonth = ((Long) seasons.get(i).get("endMonth")).intValue();
			if(startmonth <= mes && mes <= endmonth) {
				//esto significa que el mes actual esta dentro del rango de JSON, entonces se pone como currentSeason
				currentSeason = (String) seasons.get(i).get("Name");
				actualEpoca = seasons.get(i);
			}   
        }
	}
	
	public void changeClimate() {
		//se toman las reglas del clima de la  season actual del JSON
		int precipitacionMin = ((Long) actualEpoca.get("precipitacionMin")).intValue();		
		int precipitacionMax = ((Long) actualEpoca.get("precipitacionMax")).intValue();		
		
		int solMin = ((Long) actualEpoca.get("solMin")).intValue();		
		int solMax = ((Long) actualEpoca.get("solMax")).intValue();	
		
		//los siguientes son randomizers del nivel de intensidad del sol y lluvia
		niveldeLluvia = ThreadLocalRandom.current().nextInt(precipitacionMin, precipitacionMax + 1);
		System.out.println("LLUVIA AHORA ESTA EN: " + niveldeLluvia);
		
		niveldeSol = ThreadLocalRandom.current().nextInt(solMin, solMax + 1);
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
