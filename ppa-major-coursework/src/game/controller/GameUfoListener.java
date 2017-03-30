package game.controller;
/**
 * This class will trigger an action when used , the action is to hit the ufo
 * @author Dimitris Papatheodoulou
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import game.model.ClickModel;
import game.model.GameModel;


public class GameUfoListener  implements MouseListener {
	
	private ClickModel clickObsv;
	private GameModel gameModel;
	/**
	 * The constructor initialises the class variables
	 * @param clickObsv   Object of ClickModel class passed to the constructor
	 * @param gameModel   Object of the gameModel class passed to the constructor 
	 */
	public GameUfoListener(ClickModel clickObsv, GameModel gameModel)
	{
		this.clickObsv = clickObsv;
		this.gameModel = gameModel;
	}
	/**
	 * This method says that when the mouse is clicked and used , the ufo gets hit
	 * @param arg0   Triggered when the mouse is used
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel label = (JLabel)arg0.getSource();
		
			clickObsv.singleClicked();
			gameModel.hitUFO();
	}
	/**
	 * Necessary method called when there is a mouse action and the class gets called
	 * @param arg0   Triggered when the mouse is used 
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Necessary method called when there is a mouse action and the class gets called
	 * @param arg0   Triggered when the mouse is used 
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Necessary method called when there is a mouse action and the class gets called
	 * @param arg0   Triggered when the mouse is used 
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Necessary method called when there is a mouse action and the class gets called
	 * @param arg0   Triggered when the mouse is used 
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
