package game.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.model.GameModel;

public class LightsaberButtonListener implements ActionListener {

	private GameModel model;
	
	public LightsaberButtonListener(GameModel model) {
		
		this.model = model;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.buyLightsaber();
	}
		
}
