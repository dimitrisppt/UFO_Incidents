package game.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.GameModel;

public class BaseballBatButtonListener implements ActionListener {

	private GameModel model;
	
	public BaseballBatButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyBaseballBat();
	}
		
}
