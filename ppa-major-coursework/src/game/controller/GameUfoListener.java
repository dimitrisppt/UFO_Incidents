package game.controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import game.model.ClickModel;
import game.model.GameModel;


public class GameUfoListener  implements MouseListener {
	
	private ClickModel clickObsv;
	private GameModel gameModel;
	public GameUfoListener(ClickModel clickObsv, GameModel gameModel)
	{
		this.clickObsv = clickObsv;
		this.gameModel = gameModel;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel label = (JLabel)arg0.getSource();
		
			clickObsv.singleClicked();
			gameModel.hitUFO();
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
