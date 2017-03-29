package map.controller;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import map.model.MapInfoModel;
import map.model.RectGroup;
import map.model.StateGroup;
import map.view.MapInfoWindow;
import model.IncidentsFetcher;

public class UfoListener implements MouseListener {
	private RectGroup r; //rectangle group
	private StateGroup s;//state group
	private MapInfoWindow mapWindow;
	private IncidentsFetcher fetcher;
	
	public UfoListener(IncidentsFetcher fetcher, RectGroup r, StateGroup s){
		this.r = r;
		this.s = s;
		this.fetcher = fetcher;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) { //when mouse is clicked
		Point mousePoint = e.getPoint();//specific point of mouse at time of event 
		int x = e.getX();//mouse point x
		int y = e.getY();//mouse point y
		System.out.println(x);
		System.out.println(y);
		
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i).contains(x,y)) {//if mouse pointer was in rectangle area of any state
				
				mapWindow = new MapInfoWindow(new MapInfoModel(fetcher, s.get(i).getName()));//gets info of state clicked //print name of state clicked
				
			}
		}
	}

	//methods to implement the mouse click when the class is called
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
