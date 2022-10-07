package casoPOO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SeasonRules {
	
	private Season epocas[];
	
	SeasonRules() throws FileNotFoundException, IOException, ParseException {
		//se carga toda la info del JSON de season a esta clase
		
		Object obj = new JSONParser().parse(new FileReader(".\\src/test/java\\casoPOO\\virtualgarden.json"));
		JSONObject jo = (JSONObject) obj;
		JSONArray jsonArray = (JSONArray) jo.get("Season");
		
		//Iterando por el array del json
		epocas = new Season[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); ++i) {
		    JSONObject temp = (JSONObject) jsonArray.get(i);
		    Season temporada = new Season();
		    temporada.setName((String) temp.get("Name"));
		    temporada.setStartMonth(((Long) temp.get("startMonth")).intValue());
		    temporada.setEndMonth(((Long) temp.get("endMonth")).intValue());
		    temporada.setSolMin(((Long) temp.get("solMin")).intValue());
		    temporada.setSolMax(((Long) temp.get("solMax")).intValue());
		    temporada.setPrecipitacionMin(((Long) temp.get("precipitacionMin")).intValue());
		    temporada.setPrecipitacionMax(((Long) temp.get("precipitacionMax")).intValue());
		    
		    epocas[i] = temporada;  //se agrega al array
		}
	}

	public Season[] getEpocas() {
		return epocas;
	}
}			  