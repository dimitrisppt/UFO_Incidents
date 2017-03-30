package game.controller;
/**
 * This class has a purpose of triggering an action and call a method from the model
 * when we click on the Fist which is the first item the user will use , this item will be 
 * free at the beginning
 * This class is part of the controllers  
 * @author Dimitris Papatheodoulou
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import game.model.GameModel;

public class FistButtonListener implements ActionListener{
	
	private GameModel model;
	/**
	 * The constructor initialises the class variables
	 * @param model  The constructor will get passed the model of the game for us to be able to trigger an action when used 
	 */
	public FistButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	
	/**
	 * This class will call the method buyFist that will buy a Fist
	 * when available and clicked on
	 * it will be the first item used
	 * @param e    This method takes an ActionEvent e 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyFist();
	}
		
}


