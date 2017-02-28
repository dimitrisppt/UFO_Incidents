package Gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class StatisticsPanel extends JPanel {
	
	private StatisticsSubPanel subPanel0;
	private StatisticsSubPanel subPanel1;
	private StatisticsSubPanel subPanel2;
	private StatisticsSubPanel subPanel3;
	private String[] titles = new String[8];
	private String[] stats = new String[8];
	private boolean[] positionBools = {false, false, false, false, false, false, false, false};
	
	
	//TODO: check if initMainWidgets() works if put above StatisticsSubPanel inner class
	
	StatisticsPanel(){
		super();	
		
		titles[0] = "T0";
		titles[1] = "T1";
		titles[2] = "T2";
		titles[3] = "T3";
		titles[4] = "T4";
		titles[5] = "T5";
		titles[6] = "T6";
		titles[7] = "T7";
		
		stats[0] = "S0";
		stats[1] = "S1";
		stats[2] = "S2";
		stats[3] = "S3";
		stats[4] = "S4";
		stats[5] = "S5";
		stats[6] = "S6";
		stats[7] = "S7";
		
		subPanel0 = new StatisticsSubPanel(0);
		subPanel1 = new StatisticsSubPanel(1);
		subPanel2 = new StatisticsSubPanel(2);
		subPanel3 = new StatisticsSubPanel(3);
		initMainWidgets();
	}

	
	public class StatisticsSubPanel extends JPanel {

		private JLabel title;
		private JLabel statistic;
		private int position;
		
		StatisticsSubPanel() {
			super();
			initWidgets();
			setBorder(new EtchedBorder(EtchedBorder.RAISED));
			for (int i = 0; i < positionBools.length ; i ++){
				if (!positionBools[i]){
					position = i;
					positionBools[i] = true;
					setStatistic(i);
					break;
				}
			}
		}
		
		StatisticsSubPanel(int index){
			super();
			initWidgets();
			position = index;
			setStatistic(index);
			setBorder(new EtchedBorder(EtchedBorder.RAISED));
		}

		public void initWidgets() {

			JButton leftButton = new JButton("<");
			JButton rightButton = new JButton(">");

			Font buttonFont = new Font("Dialog", Font.BOLD, 30);
			leftButton.setFont(buttonFont);
			rightButton.setFont(buttonFont);
			rightButton.addActionListener(new StatsButtonListeners(true));
			leftButton.addActionListener(new StatsButtonListeners(false));
			// leftButton.setBorderPainted(false);
			// leftButton.setFocusPainted(false);
			// leftButton.setContentAreaFilled(false);

			this.setLayout(new BorderLayout());

			this.add(leftButton, BorderLayout.WEST);
			this.add(rightButton, BorderLayout.EAST);

			JPanel statisticHolder = new JPanel();
			statisticHolder.setLayout(new BorderLayout());
			this.add(statisticHolder, BorderLayout.CENTER);

			title = new JLabel("Title");
			statistic = new JLabel("42");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			statistic.setHorizontalAlignment(SwingConstants.CENTER);

			title.setFont(new Font("Dialog", Font.BOLD, 22));
			statistic.setFont(new Font("Dialog", Font.BOLD, 44));
			statisticHolder.add(title, BorderLayout.NORTH);
			statisticHolder.add(statistic, BorderLayout.CENTER);

			this.setMinimumSize(new Dimension(300, 300));
			//find appropriate border
			//setBorder(new B);
		}
		
		public void setStatistic(int index){
			positionBools[position] = false;
			title.setText(titles[index]);
			statistic.setText(stats[index]);
			positionBools[index] = true;
			position = index;
			this.revalidate();
			this.repaint();
		}
		
		public void moveRight(){
			int newPosition = position;
			while(positionBools[newPosition]){
				newPosition = (newPosition + 1) % 8;
			}
			
			setStatistic(newPosition);
		}
		
		public void moveLeft(){
			int newPosition = position;
			while(positionBools[newPosition]){
				newPosition = (((newPosition - 1)%8)+8)%8;
			}
			setStatistic(newPosition);
		}
		
		public class StatsButtonListeners implements ActionListener{

			boolean goRight;
			public StatsButtonListeners(boolean goRight) {
				this.goRight = goRight;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(goRight){
					moveRight();
				}else{
					moveLeft();
				}
			}
		}
	}
	
	public void initMainWidgets(){
		setLayout(new GridLayout(2, 2));
		add(subPanel0);
		add(subPanel1);
		add(subPanel2);
		add(subPanel3);
	}
}
