package map;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import api.ripley.Incident;
import api.ripley.Ripley;

public class InfoModel extends Observable { 
	
	private boolean doubleClick;
	
	private ArrayList<Incident> incidentsList;
	
	private Ripley ripley;
	
	private int fromYear = 2015;
	private int toYear= 2017;
	
	private String startYear;
	private String endYear;
	
	private Icon ufoIcon;

	public InfoModel() {
		
		this.ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		doubleClick = false;
		
		startYear = Integer.toString(fromYear) + "-01-01 01:01:01";
		endYear = Integer.toString(toYear) + "-12-31 23:59:59";
	
		incidentsList = ripley.getIncidentsInRange(startYear, endYear);
		
		  ufoIcon = new ImageIcon("src/Gui/ufo.png");
		 
		  
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
		
		for (int i=0; i<incidentsList.size(); i++) {
			
			Incident incident = incidentsList.get(i);
			
			listModel.add(i, "Time: " + incident.getDateAndTime() + " City: " + incident.getCity() + " Shape: " + incident.getShape() + " Duration: " + incident.getDuration() + " Posted: " + incident.getPosted());
		}
	}
	
	public void showSpecificInfo(int index) {
		
		
		String str = ripley.getIncidentDetails(incidentsList.get(index).getIncidentID());
		
		JLabel descriptionLabel = new JLabel("<html><body><p style='width: 450px;height:200px; '>" + str + "</p></body></html>");

		JOptionPane.showMessageDialog(null, descriptionLabel, "Message", JOptionPane.INFORMATION_MESSAGE, ufoIcon);
		
		
	}
	
	
	
	
	
	
	
}
