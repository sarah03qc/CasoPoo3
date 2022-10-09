package casoPOO;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class PlantManager extends Planta {

	PlantManager(int plantNumber) throws FileNotFoundException, IOException, ParseException {
		super(plantNumber); 
	}
	public void checkFertilizer() {
		//hay que comparar el nivel actual de fertilizante y si se pasa del rango estipulado en JSON
		//van a ocurrir las consecuencias negativas que dice el JSON, si no se pasa, ocurren las consecuancias positivas que 
		//estipula el JSON
		
		if(this.getFertilizerReqMin() <= this.getFertilpoints() && this.getFertilpoints() <= this.getFertilizerReqMax()) {
			//caso positivo
			if(this.getLifepoints() + this.getFpositiveEffect() <= 100) {
				this.setLifepoints(this.getLifepoints() + this.getFpositiveEffect());  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(this.getLifepoints() - this.getFnegativeEffect() >= 0) {
				this.setLifepoints(this.getLifepoints() - this.getFnegativeEffect());  //que no de en numeros negativos
			} else {
				//como no se puede eliminar la cantidad especificada en el json de vida, porque daria negativo, simplemente se pone en cero
				this.setLifepoints(0);
			}
		}
	}
	public void checkSun(SeasonManager temporada) {
		//comparar nivel de sol actual segun el clima y si se pasa de lo estipulado en JSON, se dan las consecuencias
		//que diga el JSON
		
		if(this.getSunReqMin() <= temporada.getSunLevel() && temporada.getSunLevel() <= this.getSunReqMax()) {
			//caso positivo
			if(this.getLifepoints() + this.getSpositiveEffect() <= 100) {
				this.setLifepoints(this.getLifepoints() + this.getSpositiveEffect());  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(this.getLifepoints() - this.getSnegativeEffect() >= 0) {
				this.setLifepoints(this.getLifepoints() - this.getSnegativeEffect());  //que no de en numeros negativos
			} else {
				//como no se puede eliminar la cantidad especificada en el json de vida, porque daria negativo, simplemente se pone en cero
				this.setLifepoints(0);
			}
		}
	}
	public void checkWater(SeasonManager temporada) {
		//comparar nivel de precipitacion actual segun el clima y el nivel de agua por riego 
		//y si se pasan de lo estipulado en JSON, se dan las consecuencias
		//que diga el JSON
		
		int aguaTotal = this.getWaterpoints() + temporada.getRainLevel();
		
		if(this.getWaterReqMin() <= aguaTotal && aguaTotal <= this.getWaterReqMax()) {
			//caso positivo
			if(this.getLifepoints() + this.getWpositiveEffect() <= 100) {
				this.setLifepoints(this.getLifepoints() + this.getWpositiveEffect());  //que no se pase de 100, que siempre es el maximo para medir la vida 
			}
		} else {
			//caso negativo
			if(this.getLifepoints() - this.getWnegativeEffect() >= 0) {
				this.setLifepoints(this.getLifepoints() - this.getWnegativeEffect());  //que no de en numeros negativos
			} else {
				//como no se puede eliminar la cantidad especificada en el json de vida, porque daria negativo, simplemente se pone en cero
				this.setLifepoints(0);
			}
		}
	}
}