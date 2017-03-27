package statistics.model.personalStats;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import api.ripley.Incident;
import model.IncidentsFetcher;

/**
 * This class calculates the least common shape of Ufo incident that is reported,
 * with a number of incidents during the selected time period.
 * 
 * @author Jayen Kerai
 *
 */
public class LeastCommonShape {
	
	// Creation of fields.
	private ArrayList<Incident> incidentsList;
	private final String[] shapes;
	private String statistic;
	private Set<String> setOfShapes;
	
	/**
	 * The constructor receives an IncidentsFetcher parameter to minimise the calls
	 * of the Ripley API.
	 * @param fetcher
	 */
	public LeastCommonShape(IncidentsFetcher fetcher) {

		// Initialises the incidentsList field with the contents from the fetcher object.
		incidentsList = fetcher.getIncidentsList();	
		shapes = new String[getHashSetSize()];
		// Converting the set of shapes to an array.
		setOfShapes.toArray(shapes);
		
	}
	
	
	/**
	 * Collecting the shapes of the incidentsList and removes any duplicate
	 * entries by converting the list to a HashSet. 
	 * @return s.size()
	 */
	public int getHashSetSize(){
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0; i<incidentsList.size(); i++){
			
			// Adds the all the incident shapes to the list.
			list.add(incidentsList.get(i).getShape());	
		}
		// Removes duplicate entries by converting the list to HashSet.
		setOfShapes = new HashSet<String>(list);
		
		return setOfShapes.size();
	}
	

	
	/**
	 * Calculates the least common shape of Ufo incident that is reported,
	 * with a number of incidents during the selected time period.
	 * 
	 * @return statistic
	 */
	public String calculateStat() {
	
		int counter = 0;
		int tempCounter = 0;
		String tempShape="";
		String shape="";
		
		// Looping through the array of all different shapes.
		for (int j=0; j< shapes.length; j++) {
			// Looping through all incident reports.
			for(int i=0; i < incidentsList.size(); i++){
			
				// Checks whether a shape from incidentsList matches with a shape from shapes array.
				if (incidentsList.get(i).getShape().equals(shapes[j])) {
					tempCounter++;
					tempShape = incidentsList.get(i).getShape();
				}
			}
			if (tempCounter < counter){
				counter = tempCounter;
				tempCounter = 0;
				shape = tempShape;
				tempShape = "";
				
			}else{
				tempCounter = 0;
			}
		}
		statistic = "Shape: " + shape + "\n" + "Number of incidents: " + counter;
		
		return statistic;
	}
	

}