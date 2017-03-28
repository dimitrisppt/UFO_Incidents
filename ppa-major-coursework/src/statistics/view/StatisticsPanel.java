package statistics.view;
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
import statistics.model.StatisticsPreferenceManager;
import statistics.model.StatsModel;

public class StatisticsPanel extends JPanel implements Observer {
	
	private StatisticsSubPanel subPanel0;
	private StatisticsSubPanel subPanel1;
	private StatisticsSubPanel subPanel2;
	private StatisticsSubPanel subPanel3;
	private String[] titles = new String[8];
	private String[] stats = new String[8];
	private boolean[] positionBools = {false, false, false, false, false, false, false, false};
	private StatsModel model;
	private StatisticsPreferenceManager panelPref;
	
	//This class is quite confusing but bear with me
	
	/* The main Statistic Panel has inside it 4 sub panels that all act the same way
	 * The sub panels have two JLabels for a title and the actual statistic as well as buttons to change them
	 * The main panel has two arrays 8 elements big for the title and the statistic
	 * The subpanels work by having a "position" that corresponds with the index on the title and statistic array
	 * They display the statistic and title by getting them from the arrays in the same index as their position
	 * They change position in such a way that no two panels can have the same position
	 * This is done by looking to another array of bools that say if that position is occupied or not
	 *
	 * */
	
	
	public StatisticsPanel(IncidentsFetcher iFetcher){
		super();	
		
		model = new StatsModel(iFetcher);
		model.addObserver(this);
		
		//initialising titles
		titles[0] = "Hoaxes";
		titles[1] = "Non US Sightings";
		titles[2] = "Next Likeliest State";
		titles[3] = "youtbe UFO videos";
		titles[4] = "Year with most incidents";
		titles[5] = "Most Common UFO shape";
		titles[6] = "Total Number Of Incidents";
		titles[7] = "Least Common UFO shape";
		
		//initialising statistics
		stats[0] = "-";
		stats[1] = "-";
		stats[2] = "-";
		stats[3] = "-";
		stats[4] = "-";
		stats[5] = "-";
		stats[6] = "-";
		stats[7] = "-";
		
		initMainPanelWidgets();
	}
	
	public void initMainPanelWidgets(){
		
		panelPref = new StatisticsPreferenceManager();
		
		//creating sub panels
		subPanel0 = new StatisticsSubPanel(panelPref.getFirstPreference(),0);
		subPanel1 = new StatisticsSubPanel(panelPref.getSecondPreference(),1);
		subPanel2 = new StatisticsSubPanel(panelPref.getThirdPreference(),2);
		subPanel3 = new StatisticsSubPanel(panelPref.getFourthPreference(),3);
		
		subPanel0.setOpaque(false);
		subPanel1.setOpaque(false);
		subPanel2.setOpaque(false);
		subPanel3.setOpaque(false);
		
		setLayout(new GridLayout(2, 2));
		add(subPanel0);
		add(subPanel1);
		add(subPanel2);
		add(subPanel3);
	}

	/*---------------------------------Start of sub panel class------------------------------------*/
	
	//Sub panel class
	public class StatisticsSubPanel extends JPanel {

		private JLabel title;
		private JLabel statistic;
		private int position;
		private int panelNumber;
		
		//Constructor
		StatisticsSubPanel() {
			super();
			initSubPanelWidgets();
			setBorder(new EtchedBorder(EtchedBorder.RAISED));
			
			//takes the first unoccupied position
			for (int i = 0; i < positionBools.length ; i ++){
				if (!positionBools[i]){
					position = i;
					setStatisticPosition(i);
					break;
				}
			}
		}
		
		StatisticsSubPanel(int index, int panelNumber){
			super();
			initSubPanelWidgets();
			position = index;
			setStatisticPosition(index);
			setBorder(new EtchedBorder(EtchedBorder.RAISED));
			this.panelNumber = panelNumber;
		}
		

		private void initSubPanelWidgets() {
			//button stuff
			JButton leftButton = new JButton("<");
			JButton rightButton = new JButton(">");

			Font buttonFont = new Font("Dialog", Font.BOLD, 30);
			leftButton.setFont(buttonFont);
			rightButton.setFont(buttonFont);
			rightButton.addActionListener(new StatsButtonListeners(true));
			leftButton.addActionListener(new StatsButtonListeners(false));

			this.setLayout(new BorderLayout());

			this.add(leftButton, BorderLayout.WEST);
			this.add(rightButton, BorderLayout.EAST);

			//title and statistic stuff
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
		}
		
		private void setStat(String newStat){
			statistic.setText(newStat);
		}
		
		//updates title and statistic according to new position
		//also updates the boolean array to occupy new position
		public void setStatisticPosition(int index){
			positionBools[position] = false;
			title.setText(titles[index]);
			setStat(stats[index]);
			positionBools[index] = true;
			position = index;
			this.revalidate();
			this.repaint();
		}
		
		//moved the panel to the next unoccupied position to the right. 
		//Rolls over to start if no unoccupied positions to the right
		public void moveRight(){
			int newPosition = position;
			while(positionBools[newPosition]){
				newPosition = (newPosition + 1) % 8;
			}
			
			setStatisticPosition(newPosition);
			panelPref.replacePreferance(panelNumber, newPosition);
		}
		
		//same as moveRight but towards the left
		public void moveLeft(){
			int newPosition = position;
			while(positionBools[newPosition]){
				newPosition = (((newPosition - 1)%8)+8)%8;
			}
			setStatisticPosition(newPosition);
			panelPref.replacePreferance(panelNumber, newPosition);
		}
		
		public int getPosition(){
			return position;
		}
		
		//Listener class for the buttons
		public class StatsButtonListeners implements ActionListener{

			//goRight checks if the button is a button to go right or go left
			boolean goRight;
			public StatsButtonListeners(boolean goRight) {
				this.goRight = goRight;
			}
			
			//calls move methods depending on if the button goes right or left
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
	
	/*------------------------------------End of sub panel class-------------------------------------*/
	

	
	@Override
	public void update(Observable o, Object arg) {
		//updates statistics values in the statistics array
		stats[0] = model.getHoaxes();
		stats[1] = model.getNonUSSightings();
		stats[2] = model.getLikeliestState();
		stats[3] = model.getYoutubeStat();
		stats[4] = model.getYearWithMostIncidents();
		stats[5] = model.getMostCommonShape();
		stats[6] = model.getTotalIncidents();
		stats[7] = model.getLeastCommonShape();
		
		
		//changes the value of the statistic in each sub panel according to their position
		subPanel0.setStat(stats[subPanel0.getPosition()]);
		subPanel1.setStat(stats[subPanel1.getPosition()]);
		subPanel2.setStat(stats[subPanel2.getPosition()]);
		subPanel3.setStat(stats[subPanel3.getPosition()]);
	}
}
