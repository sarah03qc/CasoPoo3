package casoPOO;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckStatusForImage {
	
	private PlantManager planta;
	private ImageDisplayer desplegador;
	
	CheckStatusForImage(PlantManager pplanta) {
		planta = pplanta;
	}
	
	public void check(JFrame frame, JLabel label) {
		
		for(int i = 0; i < planta.getEstados().length; i++) {
			//hay que revisar el rango de vida establecido en cada uno 
			if(planta.getEstados()[i].getLifepointsFrom() < planta.getLifepoints() && planta.getEstados()[i].getLifepointsTo() >= planta.getLifepoints()) {
				desplegador = new ImageDisplayer(planta.getEstados()[i].getLink(), frame, label);
			}
		}
	}
}
