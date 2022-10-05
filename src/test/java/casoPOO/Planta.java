package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class Planta {
	
	protected JSONObject estaPlanta;
	private int pointswater = 0;
	private int pointsfertil = 0;
	protected int lifepoints = 0;
	
	Planta(int plantNumber) throws FileNotFoundException, IOException, ParseException {
		//constructor que toma la planta y sus reglas del menu, que a su vez toma los tipos del JSON
		
		MenuPlantas clasemenu = new MenuPlantas();
		Vector<JSONObject> menu = clasemenu.getMenu();
		
		if(menu.size()-1 < plantNumber) {
			//ver que el tipo de planta que se selecciona 'plantNumber'
			//exista como posicion en el menu de plantas, empieza desde cero
			System.out.println("ADVERTENCIA, la planta seleccionada no existe, creela desde el JSON");
		} else {
			for(int i = 0; i < menu.size(); i++) {
				if(i == plantNumber) {
					estaPlanta = menu.elementAt(i);   //asigno que la planta actual va a ser la de la posicion que se desea
					System.out.println("planta: " + estaPlanta);
				}
			}
		}
	}
		
	public void abonar() throws FileNotFoundException, IOException, ParseException {

		int abonoQuantity = ((Long) estaPlanta.get("fertilAbonoQuantity")).intValue();  //tomamos del json la cantidad que se agrega al abonar
		pointsfertil = pointsfertil + abonoQuantity;   //se agrega el abono que se pide en el json
		}
	
	public void regar() {
		
		int riegoQuantity = ((Long) estaPlanta.get("waterRiegoQuantity")).intValue();  //tomamos del json la cantidad que se agrega al regar
		pointswater = pointswater + riegoQuantity;     //se agrega el agua que se pide en el json
	    }
	
	public JSONObject getJSONPlant() {
		return estaPlanta;
	}
}