package Gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StatisticsPanel extends JPanel {
	
	private StatisticsSubPanel subPanel1;
	private StatisticsSubPanel subPanel2;
	private StatisticsSubPanel subPanel3;
	private StatisticsSubPanel subPanel4;
	
	
	//TODO: check if initMainWidgets() works if put above StatisticsSubPanel inner class
	
	StatisticsPanel(){
		super();	
		subPanel1 = new StatisticsSubPanel();
		subPanel2 = new StatisticsSubPanel();
		subPanel3 = new StatisticsSubPanel();
		subPanel4 = new StatisticsSubPanel();
		initMainWidgets();
	}

	public class StatisticsSubPanel extends JPanel {

		StatisticsSubPanel() {
			super();
			initWidgets();
		}

		public void initWidgets() {

			JButton leftButton = new JButton("<");
			JButton rightButton = new JButton(">");

			Font buttonFont = new Font("Dialog", Font.BOLD, 30);
			leftButton.setFont(buttonFont);
			rightButton.setFont(buttonFont);
			// leftButton.setBorderPainted(false);
			// leftButton.setFocusPainted(false);
			// leftButton.setContentAreaFilled(false);

			this.setLayout(new BorderLayout());

			this.add(leftButton, BorderLayout.WEST);
			this.add(rightButton, BorderLayout.EAST);

			JPanel statisticHolder = new JPanel();
			statisticHolder.setLayout(new BorderLayout());
			this.add(statisticHolder, BorderLayout.CENTER);

			JLabel title = new JLabel("Title");
			JLabel statistic = new JLabel("42");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			statistic.setHorizontalAlignment(SwingConstants.CENTER);

			title.setFont(new Font("Dialog", Font.BOLD, 22));
			statistic.setFont(new Font("Dialog", Font.BOLD, 44));
			statisticHolder.add(title, BorderLayout.NORTH);
			statisticHolder.add(statistic, BorderLayout.CENTER);

			this.setMinimumSize(new Dimension(300, 300));
		}

	}
	
	
	public void initMainWidgets(){
		setLayout(new GridLayout(2, 2));
		add(subPanel1);
		add(subPanel2);
		add(subPanel3);
		add(subPanel4);
	}

}
