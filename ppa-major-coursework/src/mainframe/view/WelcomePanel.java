package mainframe.view;

//This class will be used to Print a welcomePanel that will be part of the view 
//This welcomePanel will print some statements , show the Ripley version and the time it took to 
//get all the informations from the date selected . 
//It will just aware the user of what he needs

import api.ripley.Ripley;
import model.IncidentsFetcher;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

//Here we implemented an Observer as this is the view and it will be updated depending of what happens in the model
//the model for this class is the IncidentFetcher.
public class WelcomePanel extends JPanel implements Observer{
	
	
	private static final long serialVersionUID = 1L;
	//Here we call the ripley that i will initialise later on
	private Ripley ripley;
	//We created some variables that will be given a value later on such as the startDate and endDate
	private String startDate;
	private String endDate;
	//The incidentFetcher is called and we will initialise it in the constructor
	private IncidentsFetcher incidentsFetcher;
	//The labels that will be used in the entire view are created here
	private JLabel dateLabel;
	private JLabel dataGrabbing;
	private JLabel statement;
	private JLabel time;
	
	
	public WelcomePanel(IncidentsFetcher incidentsFetcher){
		
		this.incidentsFetcher = incidentsFetcher;
		this.incidentsFetcher.addObserver(this);
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		widgets();
	//All the class variables are then initialised , the ripley is given our personal access
	//The incidentFetcher is passed to the constructor and we then call the widgets method as shown below that will create everything
	}
	
	private void widgets(){ 
			
		//We set the layout of the WelcomePanel to a GridLayout , so that every labels will be printed one under the another
		this.setLayout(new GridLayout(10,1));
		//Every printing will be in white and in the center to make it better for the user to read
		//We created first an empty Label to center the entire printing in terms of design
		JLabel emptyLabel = new JLabel("" + SwingConstants.CENTER);
		//We print the ripley version
		JLabel ripleyVersion = new JLabel ("Welcome to the Ripley API v"+ Double.toString(ripley.getVersion()) , SwingConstants.CENTER);
		ripleyVersion.setForeground(Color.WHITE);
		//We then ask the user to select dates from the combo boxes
		JLabel printing = new JLabel("Please select from the dates above, in order to begin analysing UFO sighting data." , SwingConstants.CENTER);
		printing.setForeground(Color.WHITE);
		//We then add the Labels to the Panel
		this.add(emptyLabel);
		this.add(ripleyVersion);
		this.add(printing);
		
		//The date label asks to select a Date range and will be modified later on depending of our dateRange Selection
		dateLabel = new JLabel("Please Select a Date range ", SwingConstants.CENTER);
		dateLabel.setForeground(Color.WHITE);
		this.add(dateLabel);
		//We then create some empty Labels that will be this time modified later on depending of the user interaction with the code  
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
		
		//We then give the start date and date the values of the selected dates from the model to the class variables 
		
		startDate =  Integer.toString(incidentsFetcher.getStartDate());
		endDate = Integer.toString(incidentsFetcher.getEndDate());
		//if no dates are selected then the dateLabel won't be updated 
		//if only an endDate is selected the dateLabel will tell the user to select a startDate and will print the endDate
		if((startDate.equals("0") && endDate!= null) || (startDate.equals("0") && !endDate.equals("0")) || (startDate == null && endDate!= null) || (startDate == null && !endDate.equals("0"))){
			dateLabel.setText("You only selected a end Date , please select a start Date , end Date is : " + endDate );
		}
		//if only a start date is selected , then the dateLabel will tell the user to select an endDate and will print the startdate
		if((!startDate.equals("0") && endDate== null) || (!startDate.equals("0") && endDate.equals("0")) || (startDate != null && endDate== null) || (startDate != null && endDate.equals("0"))){
			dateLabel.setText("You only selected an start Date , please select an end Date , start Date is : " + startDate );
		}
		
	
		if (startDate!=null && endDate!=null && !startDate.equals("0") && !endDate.equals("0")){
			//If the endDate andStart date are selected but the Date are not valid , then the dateLabel will aware the user of an invalid Date range selection
			if(incidentsFetcher.isValidDates() == false){
				dateLabel.setText("You selected an invalide Date range");
			}else{
				//if everything is correct , then it will print the selected Dates 
				dateLabel.setText("Date range selected :" + startDate + " - " + endDate);
				//Say that it is grabbing gata 
				dataGrabbing.setText("Grabbing data ... , ");
				//And call the checkDates method defined below
				checkDates();
			
			}
		}
		//It then repaints the frame
		repaint();
		
	}
	
	public void checkDates(){
		//We then tell the code with a thread that this should be called later on 
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//We then print the time it took to grab the data 
            	time.setText(incidentsFetcher.getFetchTime());
            	//We then tell the user that he can now interact with the data 
            	statement.setText("\u001BPlease now interact with this data using the buttons to the left and the right");
            }
        });
	}
	
	
}
