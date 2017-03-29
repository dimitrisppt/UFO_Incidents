package map.model;

import api.ripley.Incident;
import model.IncidentsFetcher;
/**
 * this class will set the value and size of each ufo
 * @author Jayen
 * 
 */
public class State { //class to represent each state

	private int xCoord; //x coordinate for Ufo icon
	private int yCoord; //y coordinate for Ufo icon
	private int sightings; //no of sightings for each state (initialise to 0, after testing layout)
	private int sightingsReturned;//number of sightings to return
	private int minSightings;//least number of sightings out of all states
	private String name;//name of state
	private IncidentsFetcher fetcher;//incidents fetcher
	private double multiplier;//multiplier used for number of sightings
	
	/**
	 * the constructor receives the x and y coordinates
	 * it receives a fetcher 
	 * and a minimum Sightings
	 * it will initialise the class variables
	 * and will set the value and size of each ufo
	 * @param xCoord
	 * @param yCoord
	 * @param name
	 * @param fetcher
	 * @param minSightings
	 * 
	 */
	
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

	/**
	 * method to get the sightings
	 * @return sightingsReturned
	 * 
	 */
	public int getSightings(){ //return number of sightings
		return sightingsReturned;
	}
	
	/**
	 * method to get the x coordinates
	 * @return xCoord
	 * 
	 */
	public int getX(){ //return x coordinates
		return xCoord;
	}
	/**
	 * method to get the y coordinates
	 * @return yCoord
	 * 
	 */
	public int getY(){ //return y coordinates
		return yCoord;
	}
	/**
	 * method to get the name
	 * @return name
	 * 
	 */
	public String getName(){ //return the name
		return name;
	}
	
	/**
	 * method to update when the model is updated it will go through the state
	 * and increase the sightings
	 * 
	 */
	private void updateSightings(){ //update sightings for each state
		sightings = 0;
		for (Incident incident: fetcher.getIncidentsList()){
			if(incident.getState().equals(name)){
				sightings++;
			}
		}
	}
}
