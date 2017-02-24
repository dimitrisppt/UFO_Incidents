package Listeners;

import java.awt.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MainActionListener extends JPanel implements ActionListener {

	private boolean isLeftButton;
	private JPanel cards;

	public MainActionListener(JPanel cards, boolean isLeftButton) {

		this.isLeftButton = isLeftButton;
		this.cards = cards;
	}

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
