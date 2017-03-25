package statistics;

import java.util.ArrayList;
import api.ripley.Incident;
import model.IncidentsFetcher;

public class YearWithMostIncidents {
	
	private IncidentsFetcher fetcher;
	private static ArrayList<Incident> incidentsList;
	private int yearWithMostIncidents;
	private int counter;
	
	public YearWithMostIncidents(IncidentsFetcher fetcher) {
		this.fetcher = fetcher;	
	}
	
	public void updateYearWithMostIncidents(){
		counter = 0;
        yearWithMostIncidents = 0;
		
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
