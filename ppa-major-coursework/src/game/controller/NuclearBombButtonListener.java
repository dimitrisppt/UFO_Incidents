package game.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.GameModel;

public class NuclearBombButtonListener implements ActionListener {

	private GameModel model;
	
	public NuclearBombButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyMissile();;
	}
		
}
