package map.model;

import api.ripley.Incident;
import model.IncidentsFetcher;

public class State { //class to represent each state

	private int xCoord; //x coordinate for Ufo icon
	private int yCoord; //y coordinate for Ufo icon
	private int sightings; //no of sightings for each state (initialise to 0, after testing layout)
	private int sightingsReturned;//number of sightings to return
	private int minSightings;//least number of sightings out of all states
	private String name;//name of state
	private IncidentsFetcher fetcher;//incidents fetcher
	private double multiplier;//multiplier used for number of sightings
	
	public State(int xCoord, int yCoord, String name, IncidentsFetcher fetcher, int minSightings){ //state constructor
		this.xCoord = xCoord;//x coordinate of State
		this.yCoord = yCoord; //y coordinate of State
		this.name = name;//name of State
		this.fetcher = fetcher;
		this.minSightings = minSightings;//minimum number of sightings out of all states
		updateSightings();
		
		//creates size of icon for state
		if (minSightings > 1000){
			multiplier = 0.5;//max multiplier for icon
		} else if (minSightings > 800 && minSightings <= 1000){//if the minimum amount of Sightings is between 800 and 1000 sightings
			multiplier = 0.4;
			//Same for the following
		} else if (minSightings > 600 && minSightings <= 800){
			multiplier = 0.3;
		} else if (minSightings > 400 && minSightings <= 600){
			multiplier = 0.2;
		} else if (minSightings >= 0 && minSightings <= 400){
			multiplier = 0.1;//a minimum amount of multiplier
		}
		
		if (sightings * multiplier > 1000) {
			sightingsReturned = 60; //max size for icon
		} else if (sightings * multiplier > 800 && sightings * multiplier <= 1000) {
			sightingsReturned = 48;
		} else if (sightings * multiplier > 600 && sightings * multiplier <= 800) {
			sightingsReturned = 36;
		} else if (sightings * multiplier > 400 && sightings * multiplier <= 600) {
			sightingsReturned = 24;
		} else {
			sightingsReturned = 24;
		}
	}

	
	public int getSightings(){ //return number of sightings
		return sightingsReturned;
	}
	
	public int getX(){ //return x coordinates
		return xCoord;
	}
	
	public int getY(){ //return y coordinates
		return yCoord;
	}
	
	public String getName(){ //return x coordinates
		return name;
	}
	
	
	private void updateSightings(){ //update sightings for each state
		sightings = 0;
		for (Incident incident: fetcher.getIncidentsList()){
			if(incident.getState().equals(name)){
				sightings++;
			}
		}
	}
}
