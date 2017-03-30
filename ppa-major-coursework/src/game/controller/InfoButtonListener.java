package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class InfoButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		JOptionPane.showMessageDialog(null,
				"<html>To kill a Ufo, you will have to buy items and attack it by clicking on its picture, "
						+ "<br> and by lowering its health until it dies. When a ufo dies a new ufo with a higher level will spawn.</html>",
				"Help", JOptionPane.INFORMATION_MESSAGE);
	}

}
