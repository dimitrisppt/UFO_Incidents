package game.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.GameModel;

public class SlingshotButtonListener implements ActionListener {

	private GameModel model;
	
	public SlingshotButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buySlingshot();
	}
		
}
