package controller;

import java.awt.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * Listener for the cardlayout in mainframe
 * @author Dimitris
 *
 */
public class MainActionListener extends JPanel implements ActionListener {

	private boolean isLeftButton;
	private JPanel cards;

	/**
	 * constructor. Initialises fields
	 * @param cards
	 * @param isLeftButton
	 */
	public MainActionListener(JPanel cards, boolean isLeftButton) {

		this.isLeftButton = isLeftButton;
		this.cards = cards;
	}

	/*
	 * checks if the button clicked is the left button and updates the card layout accordingly
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (isLeftButton) {

			CardLayout cardLayout = (CardLayout) cards.getLayout();
			cardLayout.previous(cards);

		} else {

			CardLayout cardLayout = (CardLayout) cards.getLayout();
			cardLayout.next(cards);

		}

	}

}
