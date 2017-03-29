package map.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import api.ripley.Incident;
import api.ripley.Ripley;
import model.IncidentsFetcher;

/**
 * The class is responsible for the pop-up window, that
 * holds a list of incidents from the selected date range. 
 * When the user double click on an incident from the list a new dialog message
 * appears informing the user about the specific event.
 * 
 * @author Dimitris Papatheodoulou
 *
 */
public class MapInfoModel extends Observable {

	// Declaring fields.
	private boolean doubleClick;
	private ArrayList<Incident> incidentsList;
	private ArrayList<Incident> incidentsListOfState;
	private Ripley ripley;
	private Icon ufoIcon;
	private String sortProperty = "Date";
	private String stateName = "";
	private IncidentsFetcher fetcher;
	private String mapString;
	
	private final String[] stateNames = {"Alabama","Alaska","Arizona","Arkansas","California",
			 "Colorado","Connecticut","Delaware","Florida","Georgia",
			 "Hawaii","Idaho","Illinois","Indiana","Iowa",
			 "Kansas","Kentucky","Louisiana","Maine","Maryland",
			 "Massachusetts","Michigan","Minnesota","Mississippi","Missouri",
			 "Montana","Nebraska","Nevada","New Hampshire","New Jersey",
			 "New Mexico","New York","North Carolina","North Dakota","Ohio",
			 "Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina",
			 "South Dakota","Tennessee","Texas","Utah","Vermont",
			 "Virginia","Washington","West Virginia","Wisconsin","Wyoming"};

	private final String[] stateAbreviations = {"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA",
					 "HI","ID","IL","IN","IA","KS","KY","LA","ME","MD",
					 "MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ",
					 "NM","NY","NC","ND","OH","OK","OR","PA","RI","SC",
					 "SD","TN","TX","UT","VT","VA","WA","WV","WI","WY",};


	/**
	 * The constructor receives an object of IncidentsFetcher and a String as parameters and
	 * initialises the fields.
	 * @param fetcher
	 * @param stateName
	 */
	public MapInfoModel(IncidentsFetcher fetcher, String stateName) {
		
		this.fetcher = fetcher;
		incidentsList = fetcher.getIncidentsList();
		ripley = fetcher.getRipley();
		doubleClick = false;
		ufoIcon = new ImageIcon("src/mainframe/view/ufo.png");
		this.stateName = stateName;
	
		incidentsListOfState = new ArrayList<Incident>();
		// Stores the incidents of a specific state.
		incidentsListOfState = getIncidentsListOfState(stateName);
	}

	/**
	 * Adds all the incidents of a specific state which is passed as a parameter
	 * to the incidentsListOfState and returns an ArraList of Incident.
	 * 
	 * @param stateName
	 * @return incidentsListOfState
	 */
	public ArrayList<Incident> getIncidentsListOfState(String stateName) {

		for (int i = 0; i < incidentsList.size(); i++) {
			// Checks whether the State of the current element is equal to stateName variable.
			if (incidentsList.get(i).getState().equals(stateName)) {

				incidentsListOfState.add(incidentsList.get(i));
			}
		}
		return incidentsListOfState;
	}
	

	/**
	 * Sets the doubleClick variable to true,
	 * calls the setChanged and notifyObservers methods.
	 */
	public void doubleClicked() {
		doubleClick = true;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return doubleClick
	 */
	public boolean getDoubleClick() {
		return doubleClick;
	}

	/**
	 * Resets the doubleClick back to false.
	 */
	public void resetDoubleClick() {
		doubleClick = false;
	}

	/**
	 * Adds incidents to the list by Time, City, Shape, Duration and Posted.
	 * @param listModel
	 */
	public void addIncidentsToList(DefaultListModel<String> listModel) {

		// Sorts the incidents list using the selected sort property
		Collections.sort(incidentsListOfState, new OrderIncidentsList(sortProperty));

		// Loops through the ArrayList of all states
		for (int i = 0; i < incidentsListOfState.size(); i++) {
			
			Incident incident = incidentsListOfState.get(i);
			// Adds the incident with their details to the list.
			listModel.add(i,
					"Time: " + incident.getDateAndTime() + " City: " + incident.getCity() + " Shape: "
							+ incident.getShape() + " Duration: " + incident.getDuration() + " Posted: "
							+ incident.getPosted());
		}
	

	}
	/**
	 * This method will return a String that will be the title of the pop up window
	 * @return mapString
	 */
	public String getStateName(){
		mapString="";
		for(int i=0 ; i < stateNames.length ; i++)
			if(stateName.equals(stateAbreviations[i])){
			mapString=stateAbreviations[i] +"  -  " +stateNames[i];
			}
		return mapString;
	}

	/**
	 * Shows a pop-up dialog message with the detailed information
	 * of each incident.
	 * @param index
	 */
	public void showSpecificInfo(int index) {
		
		// Stores the details of the incident to a string.
		String str = ripley.getIncidentDetails(incidentsListOfState.get(index).getIncidentID());
		// Adds the string to a label using html tags in order to restrict the width and the height of the dialog.
		JLabel descriptionLabel = new JLabel(
				"<html><body><p style='width: 450px;height:200px; '>" + str + "</p></body></html>");
		// Creates a new message Dialog
		JOptionPane.showMessageDialog(null, descriptionLabel, "Detailed Information", JOptionPane.INFORMATION_MESSAGE, ufoIcon);

	}

	/**
	 * @param sortProperty
	 */
	public void setSortProperty(String sortProperty) {
		this.sortProperty = sortProperty;
	}

	/**
	 * Re-sorts the list again when a new
	 * property is selected.
	 * @param listModel
	 */
	public void sortAgain(DefaultListModel<String> listModel) {

		listModel.removeAllElements();
		addIncidentsToList(listModel);
	}
	
}
