package map.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import map.controller.UfoListener;
import map.model.RectGroup;
import map.model.StateGroup;
import model.IncidentsFetcher;

public class Map extends JPanel implements Observer {
	
	private IncidentsFetcher fetcher;
	//private double pixelIncrease = 1;
	private BufferedImage imageMap;
	private BufferedImage imageUfo;
	private StateGroup s; //the ArrayList containing all states 
	private RectGroup r;
	private boolean addedMouseListener = false;
	
	public Map(IncidentsFetcher fetcher) { //constructor for map
		this.fetcher = fetcher;
		fetcher.addObserver(this);
	}
	



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		 //number of pixels the alien image increases by per sighting
		
		// storing the images in the private fields 
		try {
			imageMap = ImageIO.read(new File("src/map/view/USAnew.png")); //image for Map *do not change*
			imageUfo = ImageIO.read(new File("src/map/view/Ufo.png")); //image for alien/ufo
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// drawing the map
		g.drawImage(imageMap,
				(int) 0,
				(int) 0,
				getWidth(), //stretch map width with frame
				getHeight(), //stretch map height with frame
				this);
		
		
		//drawing each alien
		for (int i = 0; i < s.size();i++){ //for all states in ArrayList StateGroup
			g.drawImage(imageUfo, //what image to add
					(int) getWidth() * s.get(i).getX()/2000, //x coordinates of image
					(int) getHeight() * s.get(i).getY()/1236, //y coordinates of image
					(int) (getWidth() * s.get(i).getSightings()/2000),  //pixelIncrease/2000), //width of image (#frameWidth *# noOfSightings in that area * pixelIncreasePerSighting #/ WidthresolutionOfMap#)
					(int) (getHeight() * s.get(i).getSightings()/1236), //pixelIncrease/1236), //height of image (#frameHeight *# noOfSightings in that area * pixelIncreasePerSighting #/ HeightresolutionOfMap#)
					this);

					if(!addedMouseListener){
						r = new RectGroup(s, getWidth(), getHeight());
						this.addMouseListener(new UfoListener(fetcher, r, s));
						addedMouseListener = true;
						System.out.println("one time check");
					}
					//alien icon stretches with map (to remove, this feature, remove areas marked #, from above
		}
		
	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("update happened in MAP");
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		if(fetcher.isValidDates() && fetcher.getIncidentsList() != null){
	        s = new StateGroup(fetcher);
	        System.out.println("initialised STATE STUFF");
			r = new RectGroup(s, getWidth(), getHeight());
	            
		}
        }});
		
		// update the images' positioning after the changes in the Model 
		repaint();

	}
	
}

