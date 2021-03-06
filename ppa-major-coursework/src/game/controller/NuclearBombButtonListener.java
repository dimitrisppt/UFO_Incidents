package game.controller;

/**
 * This class has a purpose of triggering an action and call a method from the model
 * when we click on the Missile/NuclearBomb 
 * This class is part of the controllers  
 * @author Dimitris Papatheodoulou
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.GameModel;

public class NuclearBombButtonListener implements ActionListener {

	private GameModel model;
	
	/**
	 * The constructor initialises the class variables
	 * @param model  The constructor will get passed the model of the game for us to be able to trigger an action when used 
	 */
	public NuclearBombButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	
	/**
	 * This class will call the method buyMissile that will buy a nuclear Bomb 
	 * when available and clicked on
	 * @param e    This method takes an ActionEvent e 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyMissile();
	}
		
}
