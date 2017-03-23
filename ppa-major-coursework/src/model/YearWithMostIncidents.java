package model;

import java.util.ArrayList;
import api.ripley.Incident;

public class YearWithMostIncidents {
	
	private IncidentsFetcher fetcher;
	private static ArrayList<Incident> incidentsList;
	private int yearWithMostIncidents;
	private int counter;
	
	public YearWithMostIncidents(IncidentsFetcher fetcher) {
		this.fetcher = fetcher;	
	}
	
	public void updateYearWithMostIncidents(){
		//incidentsList = fetcher.getIncidentsList();
		counter = 0;
            	
        incidentsList = fetcher.getIncidentsList();
        
		for (int i = fetcher.getStartDate(); i < fetcher.getEndDate()+1; i++){
			int currentYear = i;
			int tempCounter = 0;
			
			for (Incident incident : incidentsList){
				String yearString = incident.getDateAndTime().substring(0, 4);
				int incidentYear = Integer.parseInt(yearString);
				if(incidentYear == currentYear){
					tempCounter++;
				}
			}
			
			if (tempCounter > counter){
				counter = tempCounter;
				yearWithMostIncidents = currentYear;
			}
		}
	}
	
	
	
	public String getYearWithMostIncidents(){
		if (yearWithMostIncidents == 0){
			return "-";
		}else{
			return new Integer(yearWithMostIncidents).toString();
		}
	}
	
	
	
}
