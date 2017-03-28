package model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.SwingUtilities;

import api.ripley.Incident;
import api.ripley.Ripley;

public class IncidentsFetcher extends Observable{
	
	private static ArrayList<Incident> incidentsList;
	private static Ripley ripley;
	private static int startDate;
	private static int endDate;
	private static boolean validDates;
	private static String fetchTimeString;
	private boolean fetchedIncidents;
	
	//		System.out.println(ripley.getAcknowledgementString());

	public IncidentsFetcher(){
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		System.out.println(ripley.getAcknowledgementString());
		updateValidDates();
	}
	
	public IncidentsFetcher(int startYear, int endYear){
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		System.out.println(ripley.getAcknowledgementString());
		updateValidDates();
		setStartDate(startYear);
		setEndDate(endYear);
	}
	
	private void updateIncidentsInRange(){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		if(validDates){
			System.out.println("getting incidents");
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
	
	public String getFetchTimeString(){
		return fetchTimeString;
	}
	
	public ArrayList<Incident> getIncidentsList(){
		return incidentsList;
	}
	
	public void setStartDate(int startYear){
		fetchedIncidents = false;
		startDate = startYear;
		updateValidDates();
		updateIncidentsInRange();
		updateObservers();
	}
	
	public void setEndDate(int endYear){
		fetchedIncidents = false;
		endDate = endYear;
		updateValidDates();
		updateIncidentsInRange();
		updateObservers();
	}
	
	public int getEndDate(){
		return endDate;
	}
	
	public int getStartDate(){
		return startDate;
		
	}
	
	public boolean hasFetchedIncidents(){
		return fetchedIncidents;
	}
	
	public boolean isValidDates(){
		return validDates;
	}
	
	public String getFetchTime(){
		return fetchTimeString;
	}
	
	
	private void updateValidDates(){
		if(new Integer(startDate) != null && new Integer(endDate) != null){
			validDates = (startDate <= endDate) && (startDate >=  ripley.getStartYear()) && (endDate <= ripley.getLatestYear()) ;
		}else{
			validDates = false;
		}
	}
	
	private void updateObservers(){
		setChanged();
		notifyObservers();
		
	}
	
	public Ripley getRipley() {
		return ripley;
	}
	
	
	
	
	
}
