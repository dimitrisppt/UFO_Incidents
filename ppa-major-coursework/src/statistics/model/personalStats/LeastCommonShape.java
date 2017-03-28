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
	
	// field initialisation
	private ArrayList<Incident> incidentsList;
	private String[] shapes;
	private String[] shapeInstances;
	private String statistic;
	private Set<String> setOfShapes;
	private IncidentsFetcher fetcher;
	
	/**
	 * The constructor receives an IncidentsFetcher parameter to minimise the calls
	 * of the Ripley API.
	 * @param fetcher
	 */
	public LeastCommonShape(IncidentsFetcher fetcher) {
		this.fetcher = fetcher;
	}
	

	
	/**
	 * Calculates the least common shape of Ufo incident that is reported,
	 * with a number of incidents during the selected time period.
	 * 
	 * @return statistic
	 */
	public void updateStatistic() {
		String shape="";
		
		// Initialises the incidentsList field with the contents from the fetcher object.
		incidentsList = fetcher.getIncidentsList();	
		shapes = new String[getHashSetSize()];
		// Converting the set of shapes to an array.
		setOfShapes.toArray(shapes);
		
		
		int[] shapeInstances = new int[shapes.length];
		
		// Looping through the array of all different shapes.
		for (int j=0; j< shapes.length; j++) {
			// Looping through all incident reports.
			for(int i=0; i < incidentsList.size(); i++){
			
				// Checks whether a shape from incidentsList matches with a shape from shapes array.
				if (incidentsList.get(i).getShape().equals(shapes[j])) {
					shapeInstances[j]++;
				}
			}
		}
		
		int minIndex = 0;
		for (int i = 0; i < shapeInstances.length; i++){
			if (shapeInstances[i] < shapeInstances[minIndex]){
				minIndex = i;
			}
		}
		statistic = shapes[minIndex];
	}
	
	
	/**
	 * Collecting the shapes of the incidentsList and removes any duplicate
	 * entries by converting the list to a HashSet. 
	 * @return s.size()
	 */
	private int getHashSetSize(){
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0; i<incidentsList.size(); i++){
			
			// Adds the all the incident shapes to the list.
			list.add(incidentsList.get(i).getShape());	
		}
		// Removes duplicate entries by converting the list to HashSet.
		setOfShapes = new HashSet<String>(list);
		
		return setOfShapes.size();
	}
	
	
	
	public String getLeastCommonShape(){
		return statistic;
	}
	

}