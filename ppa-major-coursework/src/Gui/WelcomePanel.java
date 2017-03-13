package Gui;

import api.ripley.Ripley;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel implements Observer{
	
	private Ripley ripley;
	private long startTime;
	private long endTime;
	private long methodTime;
	private long millisecondTime;
	private long compareTime;
	private long sTime;
	private long mTime;
	private String startDate;
	private String endDate;
	private WelcomeModel welcomeModel;
	private JLabel dateLabel;
	private JLabel dataGrabbing;
	private JLabel statement;
	private JLabel time;
	
	public WelcomePanel(WelcomeModel welcomeModel){
		
		this.welcomeModel = welcomeModel;
		this.welcomeModel.addObserver(this);
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		widgets();
	}
	
	private void widgets(){ 
			
		startTime = System.currentTimeMillis();
		this.setLayout(new GridLayout(10,1));
		JLabel RipleyVersion = new JLabel ("Welcome to the Ripley API v"+ Double.toString(ripley.getVersion()) , SwingConstants.CENTER);
		JLabel printing = new JLabel("Please select from the dates above, in order to begin analysing UFO sighting data." , SwingConstants.CENTER);
		this.add(RipleyVersion);
		this.add(printing);
		
		
		dateLabel = new JLabel("date range selected :" + startDate + " - " + endDate, SwingConstants.CENTER);
		this.add(dateLabel);
		endTime = System.currentTimeMillis();
		methodTime =endTime - startTime ;//Time in milliseconds
		millisecondTime = methodTime%1000;
		methodTime = (methodTime - millisecondTime)/1000;
		sTime = (methodTime%60);
		methodTime -= sTime;
		mTime = methodTime/60;
		dataGrabbing = new JLabel("" , SwingConstants.CENTER);
		statement = new JLabel ("" , SwingConstants.CENTER);
		statement.setFont(statement.getFont().deriveFont(Font.BOLD, 14f));
		time = new JLabel ("" , SwingConstants.CENTER);
		this.add(dataGrabbing);
		this.add(time);
		this.add(statement);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		startDate = welcomeModel.getfrom();
		endDate = welcomeModel.getTo();
		dateLabel.setText("date range selected :" + startDate + " - " + endDate);
		if(startDate!=null && endDate!=null){
		checkDates();
		}
		repaint();
		
		
	}
	public void checkDates(){
		dataGrabbing.setText("Grabbing data ... , ");
		statement.setText("\u001BPlease now interact with this data using the buttons to the left and the right");
		time.setText(mTime + "minutes" + sTime + "second" + millisecondTime + "milliseconds");
	
	}
	
	
}
