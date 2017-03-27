package game.controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import game.model.ClickModel;


public class UfoListener  implements MouseListener {
	
	private ClickModel clickObsv;

	public UfoListener(ClickModel clickObsv)
	{
		this.clickObsv = clickObsv;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel label = (JLabel)arg0.getSource();
		
			clickObsv.singleClicked();
			System.out.println("print ok");
		
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
