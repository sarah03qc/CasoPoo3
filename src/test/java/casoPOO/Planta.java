package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;


public class Planta extends PlantRules {
	
	private int pointswater = 0;
	private int pointsfertil = 0;
	private int lifepoints = 100; 
	
	Planta(int plantNumber) throws FileNotFoundException, IOException, ParseException {
		super(plantNumber);
		
	}	
	public void abonar() {

		pointsfertil = pointsfertil + this.getFertilAbonoQuantity();   //se agrega el abono que se pide en el json
		}
	
	public void regar() {
		
		pointswater = pointswater + this.getWaterRiegoQuantity();     //se agrega el agua que se pide en el json
	    }
	public void takeNutrientesAbono() {
		//es para consumir lo que el JSON dice que se consume diario de fertilizer
		pointsfertil = pointsfertil - this.getFertilConsumoPerDay();   //se consume
	}
	public void takeNutrientesAgua() {
		//es para consumir lo que el JSON dice que se consume diario de agua
		pointswater = pointswater - this.getWaterConsumoPerDay();   //se consume
	}
	public void morir() {
		System.out.println("PLANTA HA FALLECIDO");
		System.out.println("Vida en " + this.getDiesWhenLifeIs());
		lifepoints = this.getDiesWhenLifeIs();
	}
	public int getWaterpoints() {
		return pointswater;
	}
	public int getFertilpoints() {
		return pointsfertil;
	}
	public void setLifepoints(int value) {
		lifepoints = value;
	}
	public int getLifepoints() {
		return lifepoints;
	}
}