package casoPOO;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeManager {
	
	private LocalTime time; 
	private LocalDate fecha;
	private int diasPasados = 0;
	private int diaEnSegundos;
	
	TimeManager(Planta plant) {
		//constructor que inicia el time
		
		time = LocalTime.now();
		fecha = LocalDate.now();	
		
		diaEnSegundos = plant.getDayInseconds();
	}
	
	public void passOneday(Thread hilo) throws InterruptedException {
		//para que pase un dia, toma el hilo de la simulacion para pausarlo
		
		System.out.println(fecha);
	    System.out.println(time);
		
	    time = time.plusHours(24); 
	    fecha = fecha.plusDays(1); //se agrega un dia
	    diasPasados++;
	    
		//se hace un sleep de lo que JSON nos dice que seria un dia en segundos
	    Thread.sleep(diaEnSegundos * 1000);
	}
	
	public LocalDate getDate() {
		return fecha;
	}
	public LocalTime getTime() {
		return time;
	}
	public int getDaysPassed() {
		return diasPasados;
	}
}