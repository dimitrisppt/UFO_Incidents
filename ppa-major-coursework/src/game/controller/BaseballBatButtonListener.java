package game.controller;
/**
 * This class has a purpose of triggering an action and call a method from the model
 * when we click on the Baseball bat 
 * This class is part of the controllers  
 * @author Dimitris Papatheodoulou
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.GameModel;

public class BaseballBatButtonListener implements ActionListener {

	private GameModel model;
	/**
	 * The constructor initialises the class variables
	 * @param model  The constructor will get passed the model of the game for us to be able to trigger an action when used 
	 */
	public BaseballBatButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	
	/**
	 * This class will call the method buyBaseballBat that will buy a Baseball Bat 
	 * when available and clicked on
	 * @param e    This method takes an ActionEvent e 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyBaseballBat();
	}
		
}
