package map.controller;

import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.event.MouseInputListener;

import map.model.MapInfoModel;

public class InfoClickListener implements MouseInputListener {
	
	private MapInfoModel clickObsv;

	public InfoClickListener(MapInfoModel infoModel)
	{
		clickObsv = infoModel;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	
		JList list = (JList)arg0.getSource();
		if (arg0.getClickCount() == 2) {
			clickObsv.doubleClicked();
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

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
