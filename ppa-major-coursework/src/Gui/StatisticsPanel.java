package Gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import model.IncidentsFetcher;
import model.StatsModel;

public class StatisticsPanel extends JPanel implements Observer {
	
	private StatisticsSubPanel subPanel0;
	private StatisticsSubPanel subPanel1;
	private StatisticsSubPanel subPanel2;
	private StatisticsSubPanel subPanel3;
	private String[] titles = new String[8];
	private String[] stats = new String[8];
	private boolean[] positionBools = {false, false, false, false, false, false, false, false};
	private StatsModel model;
	
	
	//TODO: check if initMainWidgets() works if put above StatisticsSubPanel inner class
	
	StatisticsPanel(IncidentsFetcher iFetcher){
		super();	
		
		model = new StatsModel(iFetcher);
		model.addObserver(this);
		
		titles[0] = "Hoaxes";
		titles[1] = "Non US Sightings";
		titles[2] = "Next Likeliest State";
		titles[3] = "T3";
		titles[4] = "T4";
		titles[5] = "T5";
		titles[6] = "T6";
		titles[7] = "T7";
		
		stats[0] = new Integer(model.getHoaxes()).toString();
		stats[1] = new Integer(model.getNonUSSightings()).toString();
		stats[2] = model.getLikeliestState();
		stats[3] = "S3";
		stats[4] = "S4";
		stats[5] = "S5";
		stats[6] = "S6";
		stats[7] = "S7";
		
		subPanel0 = new StatisticsSubPanel(0);
		subPanel1 = new StatisticsSubPanel(1);
		subPanel2 = new StatisticsSubPanel(2);
		subPanel3 = new StatisticsSubPanel(3);
		subPanel0.setOpaque(false);
		subPanel1.setOpaque(false);
		subPanel2.setOpaque(false);
		subPanel3.setOpaque(false);
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
					setStatisticPosition(i);
					break;
				}
			}
		}
		
		StatisticsSubPanel(int index){
			super();
			initWidgets();
			position = index;
			setStatisticPosition(index);
			setBorder(new EtchedBorder(EtchedBorder.RAISED));
		}

		private void initWidgets() {

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

			
			title = new JLabel("Title");
			title.setForeground(Color.WHITE);
			statistic = new JLabel("");
			statistic.setForeground(Color.WHITE);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			statistic.setHorizontalAlignment(SwingConstants.CENTER);

			title.setFont(new Font("Dialog", Font.BOLD, 22));
			statistic.setFont(new Font("Dialog", Font.BOLD, 44));
			this.add(title, BorderLayout.NORTH);
			this.add(statistic, BorderLayout.CENTER);

			this.setMinimumSize(new Dimension(300, 300));
			//find appropriate border
			//setBorder(new B);
		}
		
		public void setStat(String newStat){
			statistic.setText(newStat);
		}
		
		public void setStatisticPosition(int index){
			positionBools[position] = false;
			title.setText(titles[index]);
			setStat(stats[index]);
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
			
			setStatisticPosition(newPosition);
		}
		
		public void moveLeft(){
			int newPosition = position;
			while(positionBools[newPosition]){
				newPosition = (((newPosition - 1)%8)+8)%8;
			}
			setStatisticPosition(newPosition);
		}
		
		public int getPosition(){
			return position;
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

	@Override
	public void update(Observable o, Object arg) {
		stats[0] = new Integer(model.getHoaxes()).toString();
		stats[1] = new Integer(model.getNonUSSightings()).toString();
		stats[2] = model.getLikeliestState();
		stats[3] = "S3";
		stats[4] = "S4";
		stats[5] = "S5";
		stats[6] = "S6";
		stats[7] = "S7";
		
		
		
		subPanel0.setStat(stats[subPanel0.getPosition()]);
		subPanel1.setStat(stats[subPanel1.getPosition()]);
		subPanel2.setStat(stats[subPanel2.getPosition()]);
		subPanel3.setStat(stats[subPanel3.getPosition()]);
	}
}
