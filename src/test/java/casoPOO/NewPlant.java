package casoPOO;

public class NewPlant {
	
	private int lifeporcent;
	
	public void addnew(PlantManager plant, TimeManager time, int id) {
		lifeporcent = (plant.getLifeExpectancyDays() * 30)/ 100; //sacar el 30% porciento de lo que seria la expectativa de vida total en dias
		if(lifeporcent <= time.getDaysPassed()) {
			Simulacion simular = new Simulacion(id);
			simular.start();
		}
	}
}
