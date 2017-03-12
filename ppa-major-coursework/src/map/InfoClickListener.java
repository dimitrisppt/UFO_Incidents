package map;

import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.event.MouseInputListener;

public class InfoClickListener implements MouseInputListener {
	
	private InfoModel clickObsv;

	public InfoClickListener(InfoModel infoModel)
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
