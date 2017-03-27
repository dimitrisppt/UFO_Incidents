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
	private RectGroup r;
	private StateGroup s;
	private MapInfoWindow mapWindow;
	private IncidentsFetcher fetcher;
	
	public UfoListener(IncidentsFetcher fetcher, RectGroup r, StateGroup s){
		this.r = r;
		this.s = s;
		this.fetcher = fetcher;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point mousePoint = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		System.out.println(x);
		System.out.println(y);
		
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i).contains(x,y)) {
				
				mapWindow = new MapInfoWindow(new MapInfoModel(fetcher, s.get(i).getName())); //print name of state clicked
				
			}
		}
	}

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
