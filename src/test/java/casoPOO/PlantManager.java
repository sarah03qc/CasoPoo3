package casoPOO;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class PlantManager extends Planta {
	
	private JSONObject JSONPlant;

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
			if(this.getLifepoints() + FpositiveEffect <= 100) {
				this.setLifepoints(this.getLifepoints() + FpositiveEffect);  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(this.getLifepoints() - FnegativeEffect >= 0) {
				this.setLifepoints(this.getLifepoints() - FnegativeEffect);  //que no de en numeros negativos
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
			if(this.getLifepoints() + SpositiveEffect <= 100) {
				this.setLifepoints(this.getLifepoints() + SpositiveEffect);  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(this.getLifepoints() - SnegativeEffect >= 0) {
				this.setLifepoints(this.getLifepoints() - SnegativeEffect);  //que no de en numeros negativos
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
			if(this.getLifepoints() + WpositiveEffect <= 100) {
				this.setLifepoints(this.getLifepoints() + WpositiveEffect);  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(this.getLifepoints() - WnegativeEffect >= 0) {
				this.setLifepoints(this.getLifepoints() - WnegativeEffect);  //que no de en numeros negativos
			}
		}
	}
}