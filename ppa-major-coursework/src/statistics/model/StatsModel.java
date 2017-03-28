package statistics.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

import api.ripley.Incident;
import model.IncidentsFetcher;
import statistics.model.personalStats.LeastCommonShape;
import statistics.model.personalStats.MostCommonShape;
import statistics.model.personalStats.TotalIncidents;
import statistics.model.personalStats.YearWithMostIncidents;

public class StatsModel extends Observable implements Observer{

	private IncidentsFetcher fetcher;
	private ArrayList<Incident> incidentList;
	
	private int hoaxes;
	private int nonUSSightings;
	private String likeliestState;
	
	private YearWithMostIncidents aakashStat;
	private MostCommonShape dimitrisStat;
	private TotalIncidents henryStat;
	private LeastCommonShape jayanStat;
	
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
	
	
	
	//Constructor
	public StatsModel(IncidentsFetcher iFetcher) {
		//initialising variables
		stateSightings = new int[stateAbbreviations.length];
		fetcher = iFetcher;
		fetcher.addObserver(this);
		incidentList = fetcher.getIncidentsList();
		
		//initialising personal statistics classes
		aakashStat = new YearWithMostIncidents(fetcher);
		dimitrisStat = new MostCommonShape(fetcher);
		henryStat = new TotalIncidents(fetcher);
		jayanStat = new LeastCommonShape(fetcher);
	}

	//updates the hoaxes statistic
	private void updateHoaxes(){
		hoaxes = 0;
		for (Incident incident : incidentList){
			String lowerCaseSummary = incident.getSummary().toLowerCase();
			if (lowerCaseSummary.contains("hoax")){
				hoaxes++;
			}
		}
	}
	
	//updates non US sightings statistic by checking for incidents with no specified state.
	//incidents inside the U.S without a specified state will be counted towards non U.S sightings.
	private void updateNonUSSightings(){
		//resets nonUSSightings
		nonUSSightings = 0;
		//checks each incident for the string "Not specified."
		for (Incident incident : incidentList){
			if (incident.getState().equals("Not specified.")){
				//increment when "Not specified." is found
				nonUSSightings++;
			}
		}
	}
	
	//updates likeliestState statistic by checking for the state with the most sightings
	private void updateLikeliestState(){
		//resets vales for state sightings
		for (int i = 0; i < stateSightings.length; i++){
			stateSightings[i] = 0;
		}
		
		//for each sighting's state it it goes through each stateAbbrevation to check for a match
		for (Incident incident : incidentList){
			String incidentState = incident.getState();
			for (int i = 0; i < stateSightings.length; i++){
				if(incidentState.equals(stateAbbreviations[i])){
					//increments the state's value in the sightings array if match is found
					stateSightings[i] ++;
				}
			}
		}
		
		//after the sightings array is updated above looks for the index with the maximum value
		int max = 0;
		for (int i = 0; i<stateSightings.length; i++){
			if(stateSightings[i] > stateSightings[max]){
				max = i;
			}
		}
		//indices in stateSightings corresponds indices in stateSightings 
		//so we can use the same index to find the name of the state
		likeliestState = stateNames[max];
	}
	
	public String getHoaxes(){
		return new Integer(hoaxes).toString();
	}
	
	public String getNonUSSightings(){
		return new Integer(nonUSSightings).toString();
	}
	
	public String getLikeliestState(){
		return likeliestState;
	}
	
	public String getYearWithMostIncidents(){
		return aakashStat.getYearWithMostIncidents();
	}
	
	public String getTotalIncidents(){
		return henryStat.getTotalIncidents();
	}
	
	public String getMostCommonShape(){
		return dimitrisStat.getShape();
	}
	
	public String getLeastCommonShape(){
		return jayanStat.getLeastCommonShape();
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		//delays running so that incidentFetcher can get incident list.
		//refer to IncidentFetcher.getIncidentList() for more details
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		//gets new incident list
		incidentList = fetcher.getIncidentsList();
		//if incident list isn't null and the dates are valid, statistics will be updated and observers notified.
		if(incidentList != null && fetcher.isValidDates()){
			updateStatistics();
			updateObservers();
		}
		
            }});
	}
	
	//updates all statistics
	private void updateStatistics(){
		aakashStat.updateYearWithMostIncidents();
		dimitrisStat.updateMostCommonShape();
		henryStat.updateTotalIncidents();
		jayanStat.updateStatistic();
		
		updateHoaxes();
		updateNonUSSightings();
		updateLikeliestState();
	}
	
	private void updateObservers(){
		setChanged();
		notifyObservers();
	}
}
