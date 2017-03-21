package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.omg.CORBA.portable.IndirectionException;

import api.ripley.Incident;

public class StatsModel extends Observable implements Observer{

	private IncidentsFetcher fetcher;
	private ArrayList<Incident> incidentList;
	
	private int hoaxes;
	private int nonUSSightings;
	private String likeliestState;
	
	private int[] stateSightings;
	
	private final String[] stateNames = {"Alabama","Alaska","Arizona","Arkansas","California",
										 "Colorado","Connecticut","Delaware","Florida","Georgia",
										 "Hawaii","Idaho","Illinois","Indiana","Iowa",
										 "Kansas","Kentucky","Louisiana","Maine","Maryland",
										 "Massachusetts","Michigan","Minnesota","Mississippi","Missouri",
										 "Montana","Nebraska","Nevada","New Hampshire","New Jersey",
										 "New Mexico","New York","North Carolina","North Dakota","Ohio",
										 "Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina",
										 "South Dakota","Tennessee","Texas","Utah","Vermont",
										 "Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
	
	private final String[] stateAbbreviations = {"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA",
												 "HI","ID","IL","IN","IA","KS","KY","LA","ME","MD",
												 "MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ",
												 "NM","NY","NC","ND","OH","OK","OR","PA","RI","SC",
												 "SD","TN","TX","UT","VT","VA","WA","WV","WI","WY",};
	
	
	
	
	public StatsModel(IncidentsFetcher iFetcher) {
		stateSightings = new int[50];
		fetcher = iFetcher;
		fetcher.addObserver(this);
		incidentList = fetcher.getIncidentsList();
	}

	private void updateHoaxes(){
		hoaxes = 0;
		for (Incident incident : incidentList){
			String lowerCaseSummary = incident.getSummary().toLowerCase();
			if (lowerCaseSummary.contains("hoax")){
				hoaxes++;
			}
		}
	}
	
	public int getHoaxes(){
		return hoaxes;
	}
	
	
	//checking for incidents with no specified state.
	//incidents inside the U.S without a specified state will be counted towards non U.S sightings.
	private void updateNonUSSightings(){
		nonUSSightings = 0;
		for (Incident incident : incidentList){
			if (incident.getState().contains("specified")){
				nonUSSightings++;
			}
		}
		System.out.println(nonUSSightings);
	}
	
	public int getNonUSSightings(){
		return nonUSSightings;
	}
	
	
	private void updateLikeliestState(){
		//resets vales for state sightings
		for (int i = 0; i < stateSightings.length; i++){
			stateSightings[i] = 0;
		}
		
		for (Incident incident : incidentList){
			for (int i = 0; i < stateSightings.length; i++){
				if(incident.getState().equals(stateAbbreviations[i])){
					stateSightings[i] ++;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i<stateSightings.length; i++){
			if(stateSightings[i] > stateSightings[max]){
				max = i;
			}
		}
		likeliestState = stateNames[max];
	}
	
	public String getLikeliestState(){
		return likeliestState;
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("test");
		incidentList = fetcher.getIncidentsList();
		if(incidentList != null){
			updateHoaxes();
			updateNonUSSightings();
			updateLikeliestState();
			updateObservers();
			System.out.println("update happened");
		}
	}
	
	private void updateObservers(){
		setChanged();
		notifyObservers();
	}
	
	
	
	
	//google api shit
}
