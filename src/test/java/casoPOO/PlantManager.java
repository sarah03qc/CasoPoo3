package casoPOO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;

import org.json.simple.parser.ParseException;

public class PlantManager extends Planta {

	PlantManager(int plantNumber) throws FileNotFoundException, IOException, ParseException {
		super(plantNumber); //el constructor que tenia Planta, se hace porque se hereda 
	}
	//va a ser el que chequea distintas cosas y las compara con lo estipulado en el json, y dependiendo de esto 
	//la planta se ve afectada para bien o para mal con la gravedad que indique el json
}
