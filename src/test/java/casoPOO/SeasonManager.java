package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class SeasonManager extends Season {
	
	private int mes;
	
	SeasonManager() throws FileNotFoundException, IOException, ParseException {
		super();
	}

	public void checkSeason(LocalDate fecha) {
		mes = fecha.getMonthValue();
		int startmonth;
		int endmonth;
		for(int i = 0; i < seasons.size(); i++) {
			startmonth = ((Long) seasons.get(i).get("startMonth")).intValue();
			endmonth = ((Long) seasons.get(i).get("endMonth")).intValue();
			if(startmonth <= mes && mes <= endmonth) {
				//esto significa que el mes actual esta dentro del rango de JSON, entonces se pone como currentSeason
				currentSeason = (String) seasons.get(i).get("Name");
			}   
        }
	}
	
	public void changeClimate() {
		
	}
}
