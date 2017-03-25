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

public class Map extends JPanel implements Observer {
	private int pixelIncrease = 50;
	private BufferedImage imageMap;
	private BufferedImage imageAlien;
	private StateGroup s = new StateGroup(); //the ArrayList containing all states 
	private RectGroup r;
	boolean addedMouseListener = false;
	Map() { //constructor for map
		int width = getWidth();
		int height = getHeight();
		r = new RectGroup(s, width, height);
		//System.out.println(width + " is the width");
		//System.out.println(height + " is the height");
		//this.addMouseListener(new UfoListener(r));
	}
	



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		 //number of pixels the alien image increases by per sighting
		
		// storing the images in the private fields 
		try {
			imageMap = ImageIO.read(new File("src/USAnew.png")); //image for Map *do not change*
			imageAlien = ImageIO.read(new File("src/Ufo.png")); //image for alien/ufo
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
			g.drawImage(imageAlien, //what image to add
					(int) getWidth() * s.get(i).getX()/2000, //x coordinates of image
					(int) getHeight() * s.get(i).getY()/1236, //y coordinates of image
					getWidth() * s.get(i).getSightings() * pixelIncrease/2000, //width of image (#frameWidth *# noOfSightings in that area * pixelIncreasePerSighting #/ WidthresolutionOfMap#)
					getHeight() * s.get(i).getSightings() * pixelIncrease/1236, //height of image (#frameHeight *# noOfSightings in that area * pixelIncreasePerSighting #/ HeightresolutionOfMap#)
					this);
					System.out.println("new width " + getWidth());
					System.out.println("new height "+ getHeight());
					if(!addedMouseListener){
						r = new RectGroup(s, getWidth(), getHeight());
						this.addMouseListener(new UfoListener(r, s));
						addedMouseListener = true;
						System.out.println("one time check");
					}
					//alien icon stretches with map (to remove, this feature, remove areas marked #, from above
		}
		
		//------------------------------------------------------------------------
	
	
		//------------------------------------------------------------------------   
		    
		/*
		//for drawing rectangles
		g.setColor(Color.black);
		Graphics g2 = g;
		for (int i = 0; i < r.size();i++){ 
			g2.drawRect(
					(int) getWidth() * r.get(i).getX()/2000, 
					(int) getHeight() * r.get(i).getY()/1236,
					(int) getWidth() * s.get(i).getSightings() * pixelIncrease/2000,
					(int) getHeight() * s.get(i).getSightings() * pixelIncrease/1236
					);
		}	
		*/
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		// update the images' positioning after the changes in the Model 
		repaint();

	}
	
}

