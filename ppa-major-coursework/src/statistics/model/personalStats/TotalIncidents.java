package statistics.model.personalStats;

import java.util.ArrayList;

import api.ripley.Incident;
import model.IncidentsFetcher;

/**
 * Personal Statistic that returns the total incidents in the date range in string form.
 * @author Henry Valeyre
 *
 */
public class TotalIncidents {
	private IncidentsFetcher fetcher;
	private ArrayList<Incident> incidentList;
	private int totalIncidents;
	
	public TotalIncidents(IncidentsFetcher fetcher) {
		this.fetcher = fetcher;
	}
	
	public void updateTotalIncidents(){
		incidentList = fetcher.getIncidentsList();
		totalIncidents = incidentList.size();
	}
	
	
	public String getTotalIncidents(){
		return new Integer(totalIncidents).toString();
	}
}
