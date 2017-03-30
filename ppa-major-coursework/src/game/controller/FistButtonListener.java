package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import game.model.GameModel;

public class FistButtonListener implements ActionListener{
	
	private GameModel model;
	
	public FistButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyFist();
	}
		
}


