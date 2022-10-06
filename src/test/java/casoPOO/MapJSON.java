package casoPOO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MapJSON {
	//clase que toma del json el array de tipos distintos de plantas y las pone en un vector llamado menu
	
	private Map<String, JSONArray> mapa = new HashMap<String, JSONArray>(); //mapa donde se cargara el JSON
	
	@SuppressWarnings("unchecked")
	MapJSON() throws FileNotFoundException, IOException, ParseException {
		
		Object obj = new JSONParser().parse(new FileReader(".\\src/test/java\\casoPOO\\virtualgarden.json"));
		JSONObject jo = (JSONObject) obj;
		
		int contador = 0;
		
		String[] nombres = {"Plant","Season"};
		Iterator<String> iterador = jo.keySet().iterator();
		while(iterador.hasNext()) {
			String key = iterador.next();
			mapa.put(key, (JSONArray) jo.get(nombres[contador]));
			contador++;
		}
		System.out.println(mapa.keySet());
		System.out.println(mapa.values());
	}
	
	public Map<String, JSONArray> getJSONMap() {
		return mapa;
	}
}