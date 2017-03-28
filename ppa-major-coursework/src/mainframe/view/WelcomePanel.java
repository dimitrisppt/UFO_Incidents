package mainframe.view;

import api.ripley.Ripley;
import model.IncidentsFetcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class WelcomePanel extends JPanel implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ripley ripley;
	private String startDate;
	private String endDate;
	private IncidentsFetcher incidentsFetcher;
	private JLabel dateLabel;
	private JLabel dataGrabbing;
	private JLabel statement;
	private JLabel time;
	
	public WelcomePanel(IncidentsFetcher incidentsFetcher){
		
		this.incidentsFetcher = incidentsFetcher;
		this.incidentsFetcher.addObserver(this);
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		widgets();
	}
	
	private void widgets(){ 
			
		
		this.setLayout(new GridLayout(10,1));
		JLabel emptyLabel = new JLabel("" + SwingConstants.CENTER);
		JLabel ripleyVersion = new JLabel ("Welcome to the Ripley API v"+ Double.toString(ripley.getVersion()) , SwingConstants.CENTER);
		ripleyVersion.setForeground(Color.WHITE);
		JLabel printing = new JLabel("Please select from the dates above, in order to begin analysing UFO sighting data." , SwingConstants.CENTER);
		printing.setForeground(Color.WHITE);
		this.add(emptyLabel);
		this.add(ripleyVersion);
		this.add(printing);
		
		
		dateLabel = new JLabel("Please Select a Date range ", SwingConstants.CENTER);
		dateLabel.setForeground(Color.WHITE);
		this.add(dateLabel);
		dataGrabbing = new JLabel("" , SwingConstants.CENTER);
		dataGrabbing.setForeground(Color.WHITE);
		statement = new JLabel ("" , SwingConstants.CENTER);
		statement.setForeground(Color.WHITE);
		statement.setFont(statement.getFont().deriveFont(Font.BOLD, 14f));
		time = new JLabel ("" , SwingConstants.CENTER);
		time.setForeground(Color.WHITE);
		this.add(dataGrabbing);
		this.add(time);
		this.add(statement);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("updating welcome panel");
		startDate =  Integer.toString(incidentsFetcher.getStartDate());
		endDate = Integer.toString(incidentsFetcher.getEndDate());
		
		
		if((startDate.equals("0") && endDate!= null) || (startDate.equals("0") && !endDate.equals("0")) || (startDate == null && endDate!= null) || (startDate == null && !endDate.equals("0"))){
			dateLabel.setText("You only selected a end Date , please select a start Date , end Date is : " + endDate );
		}
		if((!startDate.equals("0") && endDate== null) || (!startDate.equals("0") && endDate.equals("0")) || (startDate != null && endDate== null) || (startDate != null && endDate.equals("0"))){
			dateLabel.setText("You only selected an start Date , please select an end Date , start Date is : " + startDate );
		}
		
	
		
		if (startDate!=null && endDate!=null && !startDate.equals("0") && !endDate.equals("0")){
			if(incidentsFetcher.isValidDates() == false){
				dateLabel.setText("You selected an invalide Date range");
			}else{
			dateLabel.setText("Date range selected :" + startDate + " - " + endDate);
			System.out.println("valid dates");
			dataGrabbing.setText("Grabbing data ... , ");
			checkDates();
			
			}
		}
		
		repaint();
		System.out.println("finished updating welcome panel");
		
	}
	
	public void checkDates(){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		time.setText(incidentsFetcher.getFetchTime());
		statement.setText("\u001BPlease now interact with this data using the buttons to the left and the right");
            }
            });
	}
	
	
}
