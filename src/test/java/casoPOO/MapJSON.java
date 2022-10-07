package casoPOO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MapJSON {
	//clase que toma del json el array de tipos distintos de plantas y las pone en un vector llamado menu
	
	private Map<String, ArrayList<JSONObject>> mapa = new HashMap<String, ArrayList<JSONObject>>(); //mapa donde se cargara el JSON
	
	@SuppressWarnings("unchecked")
	MapJSON() throws FileNotFoundException, IOException, ParseException {
		
		Object obj = new JSONParser().parse(new FileReader(".\\src/test/java\\casoPOO\\virtualgarden.json"));
		JSONObject jo = (JSONObject) obj;
		
		int contador = 0;
		
		String[] nombres = {"Plant","Season"};
		Iterator<String> iterador = jo.keySet().iterator();
		while(iterador.hasNext()) {
			String key = iterador.next();
			mapa.put(key, (ArrayList<JSONObject>) jo.get(nombres[contador]));
			contador++;
		}
	}
	
	public Map<String, ArrayList<JSONObject>> getJSONMap() {
		return mapa;
	}
}