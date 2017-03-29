package map.view;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import map.controller.UfoListener;
import map.model.RectGroup;
import map.model.StateGroup;
import model.IncidentsFetcher;

public class Map extends JPanel implements Observer {
	
	private IncidentsFetcher fetcher;
	private BufferedImage imageMap;//image for map
	private BufferedImage imageUfo; //image for Ufo icon
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
				
		// storing the images in the private fields 
		try {
			imageMap = ImageIO.read(new File("src/map/view/USAnew.png")); //image for Map *do not change*
			imageUfo = ImageIO.read(new File("src/map/view/Ufo.png")); //image for alien/ufo
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// drawing the map
		g.drawImage(imageMap, //image to add as map
				(int) 0,// x axis top corner of map matches top corner of frame
				(int) 0, // y axis top corner of map matches top corner of frame
				getWidth(), //stretch map width with frame
				getHeight(), //stretch map height with frame
				this);
		
		
		//drawing each alien
		for (int i = 0; i < s.size();i++){ //for all states in ArrayList StateGroup
			g.drawImage(imageUfo, //image image to add as UFO
					(int) getWidth() * s.get(i).getX()/2000, //x coordinates of image
					(int) getHeight() * s.get(i).getY()/1236, //y coordinates of image
					(int) (getWidth() * s.get(i).getSightings()/2000),  //pixelIncrease/2000), //width of image (#frameWidth *# noOfSightings in that area * pixelIncreasePerSighting #/ WidthresolutionOfMap#)
					(int) (getHeight() * s.get(i).getSightings()/1236), //pixelIncrease/1236), //height of image (#frameHeight *# noOfSightings in that area * pixelIncreasePerSighting #/ HeightresolutionOfMap#)
					this);

					if(!addedMouseListener){
						r = new RectGroup(s, getWidth(), getHeight());
						this.addMouseListener(new UfoListener(fetcher, r, s));
						addedMouseListener = true;
						
					}
					//alien icon stretches with map (to remove, this feature, remove areas marked #, from above
		}
		
	
	}

	@Override
	public void update(Observable arg0, Object arg1) { //update all states and rectangles within their groups
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		if(fetcher.isValidDates() && fetcher.getIncidentsList() != null){//on the first time the program runs, this is needed
	        s = new StateGroup(fetcher);//initialise stateGroup
	       
			r = new RectGroup(s, getWidth(), getHeight()); //initialise RectGroup
	            
		}
        }});
		
		// update the images' positioning after the changes in the Model 
		repaint();

	}
	
}

