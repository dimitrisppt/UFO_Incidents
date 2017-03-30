package game.controller;
/**
 * This class is used to create a pop up message to indicate what happens and the user
 * can play the game
 * @author Dimitris Papatheodoulou
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class InfoButtonListener implements ActionListener {
	/**
	 *This method initialises the pop up message to diplay in a panel when 
	 *we click on the button
	 * @param e   takes an object of the action , triggers an action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JOptionPane.showMessageDialog(null,
				"<html>To kill a Ufo, you will have to buy items and attack it by clicking on its picture, "
						+ "<br> and by lowering its health until it dies. When a ufo dies a new ufo with a higher level will spawn.</html>",
				"Help", JOptionPane.INFORMATION_MESSAGE);
	}

}
