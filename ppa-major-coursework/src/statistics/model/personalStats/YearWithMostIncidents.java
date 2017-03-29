package statistics.model.personalStats;

import java.util.ArrayList;
import api.ripley.Incident;
import model.IncidentsFetcher;

/**
 * Personal Statistic class.
 * Takes an incident list and finds the year with the most incidences within that list
 * @author Aakash Doshi
 *
 */
public class YearWithMostIncidents {
	
	private IncidentsFetcher fetcher;
	private static ArrayList<Incident> incidentsList;
	private int yearWithMostIncidents;
	private int counter;
	
	/**
	 * Constructor. initialises fetcher
	 * @param fetcher
	 */
	public YearWithMostIncidents(IncidentsFetcher fetcher) {
		this.fetcher = fetcher;	
	}
	
	/*
	 * method to update yearWithMostIncidents
	 */
	public void updateYearWithMostIncidents(){
		//resets counter and yearWithMostIncidences
		counter = 0;
        yearWithMostIncidents = 0;
		
        //updates incident list
        incidentsList = fetcher.getIncidentsList();
        
        //for each year, goes through all incidents in incident list and increments a tempcounter if the incident year matches
		for (int i = fetcher.getStartDate(); i < fetcher.getEndDate()+1; i++){
			int currentYear = i;
			int tempCounter = 0;
			
			//goes through all incidents in incidentlist
			for (Incident incident : incidentsList){
				String yearString = incident.getDateAndTime().substring(0, 4);
				int incidentYear = Integer.parseInt(yearString);
				//if incident year is the same as current year increments temp counter
				if(incidentYear == currentYear){
					tempCounter++;
				}
			}
			
			//if temp counter is greater than counter update yearWithMostIncidences and counter
			if (tempCounter > counter){
				counter = tempCounter;
				yearWithMostIncidents = currentYear;
			}
		}
	}
	
	
	/**
	 * getter method for yearWithMostIncidences with a catch for invalid results
	 * @return
	 */
	public String getYearWithMostIncidents(){
		//if yearWithMostIncidences is 0, incidentList is probably null thus return "-"
		//else return the year with most incidences
		if (yearWithMostIncidents == 0){
			return "-";
		}else{
			return new Integer(yearWithMostIncidents).toString();
		}
	}
	
	
	
}
