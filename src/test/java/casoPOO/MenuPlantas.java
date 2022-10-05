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

public class MenuPlantas {
	//clase que toma del json el array de tipos distintos de plantas y las pone en un vector llamado menu
	
	private Vector<JSONObject> menu = new Vector<JSONObject>();  //vector que tendra todos los objetos de distintos tipos de plantas sacadas del json
	
	MenuPlantas() throws FileNotFoundException, IOException, ParseException {
		
		Object obj = new JSONParser().parse(new FileReader(".\\src/test/java\\casoPOO\\virtualgarden.json"));
		JSONObject jo = (JSONObject) obj;
		JSONArray jsonArray = (JSONArray) jo.get("Plant");
		
		//Iterando por el array del json
		Iterator<JSONObject> iterator = jsonArray.iterator();
		while(iterator.hasNext()) {
			//agregamos el tipo de planta que se itera al menu
			menu.add(iterator.next()); //agregamos el tipo de planta al vector menu
	        }
	}
	
	public Vector<JSONObject> getMenu() {
		return menu;
	}
}
