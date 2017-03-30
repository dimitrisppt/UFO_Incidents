package game.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.GameModel;

public class KatanaButtonListener implements ActionListener {

	private GameModel model;
	
	public KatanaButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyKatana();
	}
		
}
