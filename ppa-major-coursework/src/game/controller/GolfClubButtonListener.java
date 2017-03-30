package game.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.GameModel;

public class GolfClubButtonListener implements ActionListener {
	
	private GameModel model;
	
	public GolfClubButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyGolfClub();
	}
		
}
