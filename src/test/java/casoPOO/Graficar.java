package casoPOO;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Graficar {
	
	private JFrame frame;
	private JLabel label;
	
	Graficar(SeasonManager season, TimeManager time, PlantManager plant) {
		frame = new JFrame("Virtual Garden");
		label = new JLabel();  
		
		frame.setSize(new Dimension(950, 800));
		
		frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 50));
		Label seasonlabel = new Label("Temporada: " + season.getCurrentSeason());
        frame.add(seasonlabel);
        Label templabel = new Label("Sun level: " + season.getSunLevel());
        frame.add(templabel);
        Label rainlabel = new Label("Rain level: " + season.getRainLevel());
        frame.add(rainlabel);
        Label dayslabel = new Label("Days passed: " + 0);
        frame.add(dayslabel);
        Label datelabel = new Label("Date: " + time.getDate());
        frame.add(datelabel);
        Label waterlabel = new Label("Water: " + plant.getWaterpoints());
        frame.add(waterlabel);
        Label fertlabel = new Label("Fertilizer: " + plant.getFertilpoints());
        frame.add(fertlabel);
        Label lifelabel = new Label("Life: " + plant.getLifepoints());
        frame.add(lifelabel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label);
        frame.setLocation(250, 50); 
        frame.setVisible(true);
	}
	
	public void displayNewValues(SeasonManager season, TimeManager time, PlantManager plant) {
		//aun no esta hecha, pero este metodo es para actualizar los valores cambiantes dentro del ciclo de vida
	}
}