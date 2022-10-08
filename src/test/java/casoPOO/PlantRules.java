package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class PlantRules {
	
	private String Type;
    private int dayInseconds;
    private int diesWhenLifeIs;
    private int lifeExpectancyDays; 
    
    private int Stage; 
    private int stagesQuantity;
    
    private int WaterReqMin;
    private int WaterReqMax;
    private int WpositiveEffect;
    private int WnegativeEffect;
    private int waterRiegoQuantity;
    private int waterConsumoPerDay;
    
    private int SunReqMin;
    private int SunReqMax;
    private int SpositiveEffect;
    private int SnegativeEffect; 
    
    private int FertilizerReqMin;
    private int FertilizerReqMax;
    private int FpositiveEffect;
    private int FnegativeEffect;
    private int fertilAbonoQuantity;
    private int fertilConsumoPerDay;
    
    private int cantidadPlantTypes = 0;
	
    private EstadoRules estados[];
    private JSONArray estadosBeforeConversion;
	
	PlantRules(int plantNumber) throws FileNotFoundException, IOException, ParseException {
		
		//se toman las reglas y se almacenan en esta clase
		MapJSON map = new MapJSON();
		Map<String, ArrayList<JSONObject>> mapa = map.getJSONMap();
		
		ArrayList<JSONObject> plants = mapa.get("Plant");
		JSONObject planta = plants.get(plantNumber);  //para que sean del tipo de planta deseado
		
		for (int i = 0; i < plants.size(); i++) {
			  cantidadPlantTypes = getCantidadPlantTypes() + 1;  
		}
		
		Type = (String) planta.get("Type");
		
		dayInseconds = ((Long) planta.get("dayInseconds")).intValue();
		diesWhenLifeIs = ((Long) planta.get("diesWhenLifeIs")).intValue();
		lifeExpectancyDays = ((Long) planta.get("lifeExpectancyDays")).intValue();
		
		Stage = ((Long) planta.get("Stage")).intValue();
		stagesQuantity = ((Long) planta.get("stagesQuantity")).intValue();
		
		WaterReqMin = ((Long) planta.get("WaterReqMin")).intValue();
		WaterReqMax = ((Long) planta.get("WaterReqMax")).intValue();
		WpositiveEffect = ((Long) planta.get("WpositiveEffect")).intValue();
		WnegativeEffect = ((Long) planta.get("WnegativeEffect")).intValue();
		waterRiegoQuantity = ((Long) planta.get("waterRiegoQuantity")).intValue();
		waterConsumoPerDay = ((Long) planta.get("waterConsumoPerDay")).intValue();
		
		SunReqMin = ((Long) planta.get("SunReqMin")).intValue();
		SunReqMax = ((Long) planta.get("SunReqMax")).intValue();
		SpositiveEffect = ((Long) planta.get("SpositiveEffect")).intValue();
		SnegativeEffect = ((Long) planta.get("SnegativeEffect")).intValue();
		
		FertilizerReqMin = ((Long) planta.get("FertilizerReqMin")).intValue();
		FertilizerReqMax = ((Long) planta.get("FertilizerReqMax")).intValue();
		FpositiveEffect = ((Long) planta.get("FpositiveEffect")).intValue();
		FnegativeEffect = ((Long) planta.get("FnegativeEffect")).intValue();
		fertilAbonoQuantity = ((Long) planta.get("fertilAbonoQuantity")).intValue();
		fertilConsumoPerDay = ((Long) planta.get("fertilConsumoPerDay")).intValue();
		
		//ahora con el JSONArray de estados de planta, hay que en su lugar, almacenar los datos en un array estados[], elementos tipo EstadoRules
		
		estadosBeforeConversion = (JSONArray) planta.get("estados");
		estados = new EstadoRules[estadosBeforeConversion.size()];
		JSONObject statusenJson;
		for(int i = 0; i < estadosBeforeConversion.size(); i++) {
			EstadoRules status = new EstadoRules();    
			statusenJson = (JSONObject) estadosBeforeConversion.get(i);  //se toma del JSON el objeto i del array de estados
			status.setTipo((String) statusenJson.get("tipo"));  //y se usa para sacarle todos sus atributos y ponerlos en el objeto nuevo
			status.setLink((String) statusenJson.get("link")); 
			status.setLifepointsFrom(((Long) statusenJson.get("lifepointsFrom")).intValue());
			status.setLifepointsTo(((Long) statusenJson.get("lifepointsTo")).intValue());
		
			estados[i] = status;  //se agrega al array
		}
	}

	public String getType() {
		return Type;
	}

	public int getDayInseconds() {
		return dayInseconds;
	}

	public int getDiesWhenLifeIs() {
		return diesWhenLifeIs;
	}

	public int getLifeExpectancyDays() {
		return lifeExpectancyDays;
	}

	public int getStage() {
		return Stage;
	}

	public int getStagesQuantity() {
		return stagesQuantity;
	}

	public int getWaterReqMin() {
		return WaterReqMin;
	}

	public int getWaterReqMax() {
		return WaterReqMax;
	}

	public int getWpositiveEffect() {
		return WpositiveEffect;
	}

	public int getWnegativeEffect() {
		return WnegativeEffect;
	}

	public int getWaterRiegoQuantity() {
		return waterRiegoQuantity;
	}

	public int getWaterConsumoPerDay() {
		return waterConsumoPerDay;
	}

	public int getSunReqMin() {
		return SunReqMin;
	}

	public int getSunReqMax() {
		return SunReqMax;
	}

	public int getSpositiveEffect() {
		return SpositiveEffect;
	}

	public int getSnegativeEffect() {
		return SnegativeEffect;
	}

	public int getFertilizerReqMin() {
		return FertilizerReqMin;
	}

	public int getFertilizerReqMax() {
		return FertilizerReqMax;
	}

	public int getFpositiveEffect() {
		return FpositiveEffect;
	}

	public int getFnegativeEffect() {
		return FnegativeEffect;
	}

	public int getFertilAbonoQuantity() {
		return fertilAbonoQuantity;
	}

	public int getFertilConsumoPerDay() {
		return fertilConsumoPerDay;
	}

	public EstadoRules[] getEstados() {
		return estados;
	}

	public int getCantidadPlantTypes() {
		return cantidadPlantTypes;
	}
}