package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class GardenMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		
		Simulacion simulacion1 = new Simulacion(0);
		
		simulacion1.start();
	}
}
