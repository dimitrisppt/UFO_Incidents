package model;

import java.util.ArrayList;
import java.util.Observable;

import api.ripley.Incident;
import api.ripley.Ripley;

public class IncidentsFetcher extends Observable{
	
	private static ArrayList<Incident> incidentsList;
	private static Ripley ripley;
	private static int startDate;
	private static int endDate;
	private static boolean validDates;
	private static String fetchTimeString;
	
	public IncidentsFetcher(){
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		updateValidDates();
	}
	
	public IncidentsFetcher(int startYear, int endYear){
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		updateValidDates();
		setStartDate(startYear);
		setEndDate(endYear);
	}
	
	private void updateIncidentsInRange(){
		if(validDates){
			long startTime = System.currentTimeMillis();
			String start = Integer.toString(startDate) + "-01-01 00:00:00";
			String end = Integer.toString(endDate) + "-12-31 23:59:59";
			incidentsList =  ripley.getIncidentsInRange(start, end);
			long endTime = System.currentTimeMillis();
			updatefetchTimeString(startTime, endTime);
		}else{
			incidentsList = null;
		}
	}
	
	private void updatefetchTimeString(long startTime, long endTime){
		long fetchTime, mSecTime, secTime, minTime;
		
		fetchTime = startTime - endTime;
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
		startDate = startYear;
		updateValidDates();
		updateIncidentsInRange();
		updateObservers();
	}
	
	public void setEndDate(int endYear){
		endDate = endYear;
		updateValidDates();
		updateIncidentsInRange();
		updateObservers();
	}
	
	public boolean isValidDates(){
		return validDates;
	}
	
	private void updateValidDates(){
		if(new Integer(startDate) != null && new Integer(endDate) != null){
			validDates = (startDate < endDate) && (startDate > ripley.getStartYear()) && (endDate < ripley.getLatestYear()) ;
		}else{
			validDates = false;
		}
	}
	
	private void updateObservers(){
		setChanged();
		notifyObservers();
	}
	
	
	
}
