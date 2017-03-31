package model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.SwingUtilities;

import api.ripley.Incident;
import api.ripley.Ripley;

/**
 * 
 * This is the main way of interacting with ripley and class deals with valid dates
 * @author Aakash Doshi
 *
 */
public class IncidentsFetcher extends Observable{
	
	private static ArrayList<Incident> incidentsList;
	private static Ripley ripley;
	private static int startDate;
	private static int endDate;
	private static boolean validDates;
	private static String fetchTimeString;
	private boolean fetchedIncidents;
	
	/**
	 * Constructor
	 * initialises ripley with the ripley keys
	 */
	public IncidentsFetcher(){
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		System.out.println(ripley.getAcknowledgementString());
		updateValidDates();
	}
	
	/**
	 * Constructor
	 * initialises ripley with the ripley keys
	 * changes startYear and endYear to given values and updates isValidDates
	 * @param startYear
	 * @param endYear
	 */
	public IncidentsFetcher(int startYear, int endYear){
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		System.out.println(ripley.getAcknowledgementString());
		updateValidDates();
		setStartDate(startYear);
		setEndDate(endYear);
	}
	
	/**
	 * updates variable incidentList with an arrayList of all incidents between start date and end date
	 * only updates incidentList if dates are valid
	 * if dates are not valid makes incidentList null
	 * 
	 * Additionally, measures time at start and end of getting the list of incidents from ripley
	 * and calls a method that updates fetchTimeString with the difference between the two times
	 * 
	 */
	private void updateIncidentsInRange(){
		//
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		if(validDates){
			long startTime = System.currentTimeMillis();
			String start = Integer.toString(startDate) + "-01-01 00:00:00";
			String end = Integer.toString(endDate) + "-12-31 23:59:59";
			incidentsList =  ripley.getIncidentsInRange(start, end);
			long endTime = System.currentTimeMillis();
			fetchedIncidents  = true;
			updatefetchTimeString(startTime, endTime);
		}else{
			incidentsList = null;
		}
            }
        });
	}
	
	/**
	 * updates fetchTimeString 
	 */
	private void updatefetchTimeString(long startTime, long endTime){
		long fetchTime, mSecTime, secTime, minTime;
		
		fetchTime = endTime - startTime;
		mSecTime = fetchTime%1000;
		fetchTime = (fetchTime - mSecTime)/1000;
		secTime = fetchTime%60;
		fetchTime = (fetchTime - secTime)/60;
		minTime = fetchTime;
		
		fetchTimeString = (minTime + " minutes, " + secTime + " seconds, " + mSecTime + " milliseconds");
	}
	
	/**
	 * getter for fetchTimeString
	 * @return fetchTimeString
	 */
	public String getFetchTimeString(){
		return fetchTimeString;
	}
	
	/**
	 * getter method for incidentList
	 * @return incidentList
	 */
	public ArrayList<Incident> getIncidentsList(){
		return incidentsList;
	}
	
	/**
	 * changes start date, updates valid date, incidentList and updates Observers
	 */
	public void setStartDate(int startYear){
		fetchedIncidents = false;
		startDate = startYear;
		updateValidDates();
		updateIncidentsInRange();
		updateObservers();
	}
	
	/**
	 * changes end date, updates valid date, incidentList and updates Observers
	 */
	public void setEndDate(int endYear){
		fetchedIncidents = false;
		endDate = endYear;
		updateValidDates();
		updateIncidentsInRange();
		updateObservers();
	}
	
	/**
	 * getter method for endDate
	 * @return endDate
	 */
	public int getEndDate(){
		return endDate;
	}
	
	/**
	 * getter method for startDate
	 * @return startDate
	 */
	public int getStartDate(){
		return startDate;
		
	}
	
	/**
	 * getter method for fetchedIncidents which returns true after incidentList is fetched from ripley
	 * @return fetchedIncidents
	 */
	public boolean hasFetchedIncidents(){
		return fetchedIncidents;
	}
	
	/**
	 * getter method for validDates which returns true if start date and end date produce a valid range of dates
	 * @return validDates
	 */
	public boolean isValidDates(){
		return validDates;
	}
	
	/**
	 * getter method for fetchTimeString 
	 * which is a string that indicates how long ripley took to fetch the list of incidents
	 * @return fetchTimeString
	 */
	public String getFetchTime(){
		return fetchTimeString;
	}
	
	/**
	 * updates variable validDates if startDate and endDate make a valid range of dates
	 */
	private void updateValidDates(){
		if(new Integer(startDate) != null && new Integer(endDate) != null){
			validDates = (startDate <= endDate) && (startDate >=  ripley.getStartYear()) 
					&& (endDate <= ripley.getLatestYear()) && ((endDate - startDate) <= 30);
		}else{
			validDates = false;
		}
	}
	
	/**
	 * updates observers
	 */
	private void updateObservers(){
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * getter method for the ripley object
	 * @return ripley
	 */
	public Ripley getRipley() {
		return ripley;
	}
	
	
	
	
	
}
