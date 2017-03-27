package map.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import api.ripley.Incident;
import api.ripley.Ripley;
import model.IncidentsFetcher;

public class MapInfoModel extends Observable { 
	
	private boolean doubleClick;
	
	private ArrayList<Incident> incidentsList;
	private ArrayList<Incident> incidentsListOfState;
	
	private Ripley ripley;
	
	private int fromYear = 2015;
	private int toYear= 2017;
	
	private String startYear;
	private String endYear;
	
	private Icon ufoIcon;
	
	private String sortProperty = "Date";
	private String stateName = "";
	
	private IncidentsFetcher fetcher;
	
	public MapInfoModel(IncidentsFetcher fetcher, String stateName) {
		this.fetcher = fetcher;
		System.out.println(fetcher + " fecther stuff");
		
		incidentsList = fetcher.getIncidentsList();
		System.out.println("got incidentlist in infomodel");
		System.out.println(fetcher);
		ripley = fetcher.getRipley();
//		
//		
//		startYear = Integer.toString(fromYear) + "-01-01 01:01:01";
//		endYear = Integer.toString(toYear) + "-12-31 23:59:59";
//	
//		incidentsList = ripley.getIncidentsInRange(startYear, endYear);
		
		doubleClick = false;
		
		ufoIcon = new ImageIcon("src/mainframe/view/ufo.png");
		this.stateName = stateName; 
		incidentsListOfState = new ArrayList<Incident>();
		incidentsListOfState = getIncidentsListOfState(stateName);
		  
	}
	
	public ArrayList<Incident> getIncidentsListOfState(String stateName) {
		
		for (int i=0; i<incidentsList.size(); i++) {
			if (incidentsList.get(i).getState().equals(stateName)){
				
				incidentsListOfState.add(incidentsList.get(i));
			}
		}
		
		return incidentsListOfState;
	
	}
	
	
	
	public void doubleClicked() {
		doubleClick = true;
		setChanged();
		notifyObservers();
	}
	
	public boolean getDoubleClick(){
		return doubleClick;
	}
	
	public void resetDoubleClick() {
		doubleClick = false;
		
	}
	
	
	public void addIncidentsToList(DefaultListModel<String> listModel) {
		
		Collections.sort(incidentsListOfState, new OrderIncidentsList(sortProperty));
		
		for (int i=0; i<incidentsListOfState.size(); i++) {
			
			
			Incident incident = incidentsListOfState.get(i);
			
			listModel.add(i, "Time: " + incident.getDateAndTime() + " City: " + incident.getCity() + " Shape: " + incident.getShape() + " Duration: " + incident.getDuration() + " Posted: " + incident.getPosted() + " State: " + incident.getState());
		
		}
		
	}
	
	public void showSpecificInfo(int index) {
		
		
		String str = ripley.getIncidentDetails(incidentsListOfState.get(index).getIncidentID());
		
		JLabel descriptionLabel = new JLabel("<html><body><p style='width: 450px;height:200px; '>" + str + "</p></body></html>");

		JOptionPane.showMessageDialog(null, descriptionLabel, "Message", JOptionPane.INFORMATION_MESSAGE, ufoIcon);
		
		
	}
	
	public void setSortProperty(String sortProperty) {
		this.sortProperty = sortProperty;
	}
	
	public void sortAgain(DefaultListModel<String> listModel){
		
		listModel.removeAllElements();
		
		addIncidentsToList(listModel);
		
		
		
	}
	

	
	
	
	
	
	
	
	
}
