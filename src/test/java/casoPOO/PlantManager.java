package casoPOO;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class PlantManager extends Planta {
	
	private JSONObject JSONPlant;
	private int lifepoints = 100; 

	PlantManager(int plantNumber) throws FileNotFoundException, IOException, ParseException {
		super(plantNumber); 
		
		JSONPlant = this.getJSONPlant(); //tomamos el tipo de planta en JSON de la clase padre
	}
	
	public void checkFertilizer() {
		//hay que comparar el nivel actual de fertilizante y si se pasa del rango estipulado en JSON
		//van a ocurrir las consecuencias negativas que dice el JSON, si no se pasa, ocurren las consecuancias positivas que 
		//estipula el JSON
		
		int FertilizerReqMin = ((Long) JSONPlant.get("FertilizerReqMin")).intValue();		
		int FertilizerReqMax = ((Long) JSONPlant.get("FertilizerReqMax")).intValue();	
		
		int FpositiveEffect = ((Long) JSONPlant.get("FpositiveEffect")).intValue();		
		int FnegativeEffect = ((Long) JSONPlant.get("FnegativeEffect")).intValue();	
		
		if(FertilizerReqMin <= this.getFertilpoints() && this.getFertilpoints() <= FertilizerReqMax) {
			//caso positivo
			if(lifepoints + FpositiveEffect <= 100) {
				lifepoints = lifepoints + FpositiveEffect;  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(lifepoints - FnegativeEffect >= 0) {
				lifepoints = lifepoints - FnegativeEffect;  //que no de en numeros negativos
			}
		}
	}
	public void checkSun(SeasonManager temporada) {
		//comparar nivel de sol actual segun el clima y si se pasa de lo estipulado en JSON, se dan las consecuencias
		//que diga el JSON
		
		int SunReqMax = ((Long) JSONPlant.get("SunReqMax")).intValue();		
		int SunReqMin = ((Long) JSONPlant.get("SunReqMin")).intValue();	
		
		int SpositiveEffect = ((Long) JSONPlant.get("SpositiveEffect")).intValue();		
		int SnegativeEffect = ((Long) JSONPlant.get("SnegativeEffect")).intValue();	
		
		if(SunReqMin <= temporada.getSunLevel() && temporada.getSunLevel() <= SunReqMax) {
			//caso positivo
			if(lifepoints + SpositiveEffect <= 100) {
				lifepoints = lifepoints + SpositiveEffect;  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(lifepoints - SnegativeEffect >= 0) {
				lifepoints = lifepoints - SnegativeEffect;  //que no de en numeros negativos
			}
		}
	}
	public void checkWater(SeasonManager temporada) {
		//comparar nivel de precipitacion actual segun el clima y el nivel de agua por riego 
		//y si se pasan de lo estipulado en JSON, se dan las consecuencias
		//que diga el JSON
		
		int WaterReqMax = ((Long) JSONPlant.get("WaterReqMax")).intValue();		
		int WaterReqMin = ((Long) JSONPlant.get("WaterReqMin")).intValue();	
		
		int WpositiveEffect = ((Long) JSONPlant.get("WpositiveEffect")).intValue();		
		int WnegativeEffect = ((Long) JSONPlant.get("WnegativeEffect")).intValue();	
		
		int aguaTotal = this.getWaterpoints() + temporada.getRainLevel();
		
		if(WaterReqMin <= aguaTotal && aguaTotal <= WaterReqMax) {
			//caso positivo
			if(lifepoints + WpositiveEffect <= 100) {
				lifepoints = lifepoints + WpositiveEffect;  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(lifepoints - WnegativeEffect >= 0) {
				lifepoints = lifepoints - WnegativeEffect;  //que no de en numeros negativos
			}
		}
	}
	public int getLifepoints() {
		return lifepoints;
	}
}