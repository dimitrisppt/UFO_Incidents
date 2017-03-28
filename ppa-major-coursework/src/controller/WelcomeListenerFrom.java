package controller;

//This class is part of the controller , it will get the Date when the date od the FromDate is selected in the JComboBox and pass it to the incident fetcher 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import model.IncidentsFetcher;

	public class WelcomeListenerFrom implements ActionListener {
		
		//We then create an object of the Incident fetcher which is the model

		private IncidentsFetcher fetcher;
		
		public WelcomeListenerFrom(IncidentsFetcher ifetcher) {
			fetcher = ifetcher;
		//We then initialise the class variables and pass the incidentFetchet to the constructor
		}
		
		public void actionPerformed(ActionEvent e){
			//We then create here a temporary comboBox that will take the value of the user selection
			JComboBox<Integer> fromComboBox = (JComboBox) e.getSource();
			//We then create a startYear integer variable that will have the value of the Date selected 
			int startYear = (int) fromComboBox.getItemAt(fromComboBox.getSelectedIndex());
			//And we then set the startYear of the fetcher to the value of the startYear variable
			fetcher.setStartDate(startYear);
        }
	}
	
