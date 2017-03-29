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


/**
 * Statistics model. Observes an incident fetcher and gets an incident list from it. 
 * It uses this incident list to get relevant statistics. 
 * Additionally gets personal statistics from each personal statistic class.
 * on update it gets the incident list again and updates all statistics
 * 
 * @author Aakash
 *
 */
public class StatsModel extends Observable implements Observer{

	private IncidentsFetcher fetcher;
	private ArrayList<Incident> incidentList;
	
	private int hoaxes;
	private int nonUSSightings;
	private String likeliestState;
	private YoutubeStat ytStat;
	
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
	
	
	
	/**
	 * Constructor
	 * @param Incident Fetcher
	 */
	public StatsModel(IncidentsFetcher iFetcher) {
		//initialising variables
		stateSightings = new int[stateAbbreviations.length];
		fetcher = iFetcher;
		fetcher.addObserver(this);
		incidentList = fetcher.getIncidentsList();
		
		ytStat = new YoutubeStat(fetcher);
		
		//initialising personal statistics classes
		aakashStat = new YearWithMostIncidents(fetcher);
		dimitrisStat = new MostCommonShape(fetcher);
		henryStat = new TotalIncidents(fetcher);
		jayanStat = new LeastCommonShape(fetcher);
		
	}

	/**
	 * updates the hoaxes statistic
	 */
	private void updateHoaxes(){
		//resets hoaxes
		hoaxes = 0;
		//for each incident, checks if the summary contains the string "hoax" without case sensitivity
		for (Incident incident : incidentList){
			String lowerCaseSummary = incident.getSummary().toLowerCase();
			if (lowerCaseSummary.contains("hoax")){
				//increments hoaxes if string "hoax" is found in summary
				hoaxes++;
			}
		}
	}
	
	/**
	 * Updates non US sightings statistic by checking for incidents with no specified state.
	 * Incidents inside the U.S, but without a specified state will be counted towards non U.S sightings.
	 */
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
	
	/**
	 * updates likeliestState statistic by checking for the state with the most sightings
	 */
	private void updateLikeliestState(){
		//resets vales for state sightings
		for (int i = 0; i < stateSightings.length; i++){
			stateSightings[i] = 0;
		}
		
		//for each incident's state, it goes through each element in stateAbbrevation to check for a match
		for (Incident incident : incidentList){
			String incidentState = incident.getState();
			for (int i = 0; i < stateSightings.length; i++){
				if(incidentState.equals(stateAbbreviations[i])){
					//increments the state's value in the sightings array if match is found
					stateSightings[i] ++;
				}
			}
		}
		
		//after the sightings array is updated above, look for the index with the maximum value
		int max = 0;
		for (int i = 0; i<stateSightings.length; i++){
			if(stateSightings[i] > stateSightings[max]){
				max = i;
			}
		}
		//indices in stateSightings corresponds indices in stateNames 
		//so we can use the same index to find the name of the state
		likeliestState = stateNames[max];
	}
	
	/**
	 * getter method for hoaxes
	 * @return hoaxes
	 */
	public String getHoaxes(){
		return new Integer(hoaxes).toString();
	}
	
	/**
	 * getter method for non US Sightings
	 * @return
	 */
	public String getNonUSSightings(){
		return new Integer(nonUSSightings).toString();
	}
	
	/**
	 * getter method for next likeliest state
	 * @return likeliestState
	 */
	public String getLikeliestState(){
		return likeliestState;
	}
	
	/**
	 * getter method for year with most incidents
	 * @return yearWithMostIncidents
	 */
	public String getYearWithMostIncidents(){
		return aakashStat.getYearWithMostIncidents();
	}
	
	/**
	 * getter method for total incidents
	 * @return totalIncidents
	 */
	public String getTotalIncidents(){
		return henryStat.getTotalIncidents();
	}
	
	/**
	 * getter method for most common shape
	 * @return mostCommonShape
	 */
	public String getMostCommonShape(){
		return dimitrisStat.getShape();
	}
	
	/**
	 * getter method for least common shape
	 * @return leastCommonShape
	 */
	public String getLeastCommonShape(){
		return jayanStat.getLeastCommonShape();
	}
	
	/**
	 * getter method for youtube videos of UFOs during selected date range
	 * @return youtubeStat
	 */
	public String getYoutubeStat(){
		return new Integer(ytStat.getYoutubeStat()).toString();
	}
	
	
	/**
	 * Update method
	 * when the observed incident fetcher updates, 
	 * gets the updated incident list and updated all the statistics
	 */
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
	
	/**
	 * updates all statistics
	 */
	private void updateStatistics(){
		aakashStat.updateYearWithMostIncidents();
		dimitrisStat.updateMostCommonShape();
		henryStat.updateTotalIncidents();
		jayanStat.updateStatistic();
		
		updateHoaxes();
		updateNonUSSightings();
		updateLikeliestState();
		ytStat.updateYoutubeStat();
	}
	
	/**
	 * updates all observers
	 */
	private void updateObservers(){
		setChanged();
		notifyObservers();
	}
}
