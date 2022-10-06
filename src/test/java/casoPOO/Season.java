package casoPOO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Season {
	
	protected Vector<JSONObject> seasons = new Vector<JSONObject>();  //vector que tendra todos los objetos seasons sacadas del json
	
	Season() throws FileNotFoundException, IOException, ParseException {
		//constructor donde se toma el array season del JSON
		
		Object obj = new JSONParser().parse(new FileReader(".\\src/test/java\\casoPOO\\virtualgarden.json"));
		JSONObject jo = (JSONObject) obj;
		JSONArray jsonArray = (JSONArray) jo.get("Season");
		
		//Iterando por el array del json
		for (int i = 0; i < jsonArray.size(); ++i) {
		    JSONObject temp = (JSONObject) jsonArray.get(i);
		    //agregamos el JSONObject season al vector seasons
			seasons.add(temp); 
		}
	}
	  
	public Vector<JSONObject> getSeasons() {
		return seasons;
	}
}