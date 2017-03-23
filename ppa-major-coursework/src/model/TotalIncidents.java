package model;

import java.util.ArrayList;

import api.ripley.Incident;

public class TotalIncidents {
	private IncidentsFetcher fetcher;
	private ArrayList<Incident> incidentList;
	
	public TotalIncidents(IncidentsFetcher fetcher) {
		this.fetcher = fetcher;
		
	}
	
	
	public String getTotalIncidents(){
		incidentList = fetcher.getIncidentsList();
		return new Integer(incidentList.size()).toString();
	}
}
