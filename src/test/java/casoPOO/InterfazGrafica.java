package casoPOO;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfazGrafica {
	
	private JFrame frame;
	private JLabel label;
	private Label seasonlabel;
	private Label templabel;
	private Label rainlabel;
	private Label dayslabel;
	private Label datelabel;
	private Label waterlabel;
	private Label fertlabel;
	private Label lifelabel;
	private StatusForImage actualizarImagen;
	private NewPlant newp;
	
	private int contador = 0;
	
	InterfazGrafica(SeasonManager season, TimeManager time, PlantManager plant) {
		frame = new JFrame("Virtual Garden");
		label = new JLabel();  
		
		frame.setSize(new Dimension(950, 800));
		
		frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 50));
		seasonlabel = new Label("Temporada: " + season.getCurrentSeason());
        frame.add(seasonlabel);
        templabel = new Label("Sun level: " + season.getSunLevel());
        frame.add(templabel);
        rainlabel = new Label("Rain level: " + season.getRainLevel());
        frame.add(rainlabel);
        dayslabel = new Label("Days passed: " + 0);
        frame.add(dayslabel);
        datelabel = new Label("Date: " + time.getDate());
        frame.add(datelabel);
        waterlabel = new Label("Water: " + plant.getWaterpoints());
        frame.add(waterlabel);
        fertlabel = new Label("Fertilizer: " + plant.getFertilpoints());
        frame.add(fertlabel);
        lifelabel = new Label("Life level: " + plant.getLifepoints());
        frame.add(lifelabel);
        
        JButton abonar = new JButton("Abonar");
        abonar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               plant.abonar(); 
            }
        });
           
        frame.add(abonar);
        
        JButton regar = new JButton("Regar");
        regar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               plant.regar(); 
            }
        });
        frame.add(regar);  
        
        actualizarImagen = new StatusForImage(plant);
        
        
        while(contador < plant.getCantidadPlantTypes()) {
        	JButton addnew = new JButton("Agregar planta de tipo " + contador);
            addnew.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                   newp.addnew(plant, time, contador); 
                }
            });
            frame.add(addnew); 	
        	contador++;
        }
         
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label);
        frame.setLocation(250, 50); 
        frame.setVisible(true);
	}
	
	public void displayNewValues(SeasonManager season, TimeManager time, PlantManager plant) {
		//aun no esta hecha, pero este metodo es para actualizar los valores cambiantes dentro del ciclo de vida
		
		actualizarImagen.check(frame, label);
		
		seasonlabel.setText("Temporada: " + season.getCurrentSeason());
		templabel.setText("Sun level: " + season.getSunLevel());
		rainlabel.setText("Rain level: " + season.getRainLevel());
		dayslabel.setText("Days passed: " + time.getDaysPassed());
		datelabel.setText("Date: " + time.getDate());
		waterlabel.setText("Water: " + plant.getWaterpoints());
		fertlabel.setText("Fertilizer: " + plant.getFertilpoints());
		lifelabel.setText("Life level: " + plant.getLifepoints());
	}
}