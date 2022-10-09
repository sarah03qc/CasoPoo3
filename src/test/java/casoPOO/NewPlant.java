package casoPOO;

import java.awt.Label;
import java.awt.font.GraphicAttribute;

import javax.swing.JFrame;

public class NewPlant {
	
	private int lifeporcent;
	private int id;
	private PlantManager plant;
	private TimeManager time;
	private JFrame frame;
	
	
	NewPlant(PlantManager pPlant, TimeManager pTime, int pId, JFrame pFrame) {
		plant = pPlant;
		time = pTime;
		id = pId;
		frame = pFrame;
		lifeporcent = (plant.getLifeExpectancyDays() * 30)/ 100; //sacar el 30% porciento de lo que seria la expectativa de vida total en dias
	}
	
	public void addnew() {
		
		if(lifeporcent <= time.getDaysPassed()) {
			Simulacion simular = new Simulacion(id);
			Label message = new Label("Creando planta tipo: " + id);
	        frame.add(message);
			simular.start();
		} else {
			Label message = new Label("La planta aún no está a su 30% de vida, se podrá crear otra desde día: " + lifeporcent);
	        frame.add(message);  //se pone mensaje de que aun no se puede crear otra
		}
	}
	
}
