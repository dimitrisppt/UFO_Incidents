package map.controller;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import map.model.MapInfoModel;
import map.model.RectGroup;
import map.model.StateGroup;
import map.view.MapInfoWindow;
import model.IncidentsFetcher;

/**
 * This class is part of the controller , it has all the listeners and allows action 
 * such as clicking to be used on the ufo to show up a pop up window
 * @author Jayen 
 * 
 */

public class UfoListener implements MouseListener {
	private RectGroup r; //rectangle group
	private StateGroup s;//state group
	private MapInfoWindow mapWindow;
	private IncidentsFetcher fetcher;
	
	
	/**
	 * The constructor receives an object of IncidentsFetcher , RectGroup and StateGroup
	 * and initialises the fields.
	 * @param fetcher
	 * @param r
	 * @param s
	 * 
	 */
	public UfoListener(IncidentsFetcher fetcher, RectGroup r, StateGroup s){
		this.r = r;
		this.s = s;
		this.fetcher = fetcher;
	}
	
	/**
	 * This gets the coordinates of where the user clicked and pass the values to the 
	 * MapInfoWindow if clicked in the appropriate rectangle
	 * @param e
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent e) { //when mouse is clicked
		Point mousePoint = e.getPoint();//specific point of mouse at time of event 
		int x = e.getX();//mouse point x
		int y = e.getY();//mouse point y
		
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i).contains(x,y)) {//if mouse pointer was in rectangle area of any state
				
				mapWindow = new MapInfoWindow(new MapInfoModel(fetcher, s.get(i).getName()));//gets info of state clicked //print name of state clicked
				
			}
		}
	}
	
	/**
	 * methods to implement the mouse click when the class is called
	 * @param arg0
	 * 
	 */
	//methods to implement the mouse click when the class is called
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * methods to implement the mouse click when the class is called
	 * @param arg0
	 * 
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * methods to implement the mouse click when the class is called
	 * @param arg0
	 * 
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * methods to implement the mouse click when the class is called
	 * @param arg0
	 * 
	 */
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
