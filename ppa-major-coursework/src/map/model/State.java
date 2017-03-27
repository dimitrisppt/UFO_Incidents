package map.model;

import api.ripley.Incident;
import model.IncidentsFetcher;

public class State { //a state

	int xCoord; //x coordinate for alien icon
	int yCoord; //y coordinate for alien icon
	int sightings; //no of sightings for each state (initialise to 0, after testing layout)
	int sightingsReturned;
	int minSightings;
	String name;
	IncidentsFetcher fetcher;
	double multiplier;
	
	public State(int xCoord, int yCoord, String name, IncidentsFetcher fetcher, int minSightings){ //state constructor
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.name = name;
		this.fetcher = fetcher;
		this.minSightings = minSightings;
		updateSightings();
		
		if (minSightings > 1000){
			multiplier = 0.5;
		} else if (minSightings > 800 && minSightings <= 1000){
			multiplier = 0.4;
		} else if (minSightings > 600 && minSightings <= 800){
			multiplier = 0.3;
		} else if (minSightings > 400 && minSightings <= 600){
			multiplier = 0.2;
		} else if (minSightings >= 0 && minSightings <= 400){
			multiplier = 0.1;
		}
		
		if (sightings * multiplier > 1000) {
			sightingsReturned = 60;
		} else if (sightings * multiplier > 800 && sightings * multiplier <= 1000) {
			sightingsReturned = 48;
		} else if (sightings * multiplier > 600 && sightings * multiplier <= 800) {
			sightingsReturned = 36;
		} else if (sightings * multiplier > 400 && sightings * multiplier <= 600) {
			sightingsReturned = 24;
//		} else if (sightings * multiplier > 200 && sightings * multiplier <= 400) {
//			sightingsReturned = 12;
//		} else if (sightings * multiplier > 100 && sightings * multiplier <= 200) {
//			sightingsReturned = 6;
//		} else if (sightings * multiplier > 0 && sightings * multiplier <= 100) {
//			sightingsReturned = 0;
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
	
	
	private void updateSightings(){
		sightings = 0;
		for (Incident incident: fetcher.getIncidentsList()){
			if(incident.getState().equals(name)){
				sightings++;
			}
		}
	}
}
