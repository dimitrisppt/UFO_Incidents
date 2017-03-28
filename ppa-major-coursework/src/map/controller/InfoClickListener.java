package map.controller;

import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.event.MouseInputListener;

import map.model.MapInfoModel;

/**
 * This class listens the mouse clicks and triggers the doubleClicked method
 * when the user clicks two times to the list, in order to open a dialog message.
 * 
 * @author Dimitris Papatheodoulou
 *
 */
public class InfoClickListener implements MouseInputListener {
	
	// Declaring a variable that will hold the object of MapInfoModel.
	private MapInfoModel clickObsv;

	/**
	 * The constructor initialises the variable clickObsv with its parameter.
	 * 
	 * @param infoModel
	 */
	public InfoClickListener(MapInfoModel infoModel)
	{
		clickObsv = infoModel;
	}
	
	/*
	 * Checks whether the user clicked the mouse two times.
	 * 
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
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
