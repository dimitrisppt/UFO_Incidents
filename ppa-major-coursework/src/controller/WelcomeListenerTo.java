package controller;

/**
 * This class is part of the controller , it will get the Date when 
 * the date of the FromDate is selected in the JComboBox and pass it 
 * to the incident fetcher 
 * @author Henry Valeyre
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import model.IncidentsFetcher;

	public class WelcomeListenerTo implements ActionListener {
				//We then create an object of the Incident fetcher which is the model
				private IncidentsFetcher fetcher;
				
				/**
				 * We initialise all the class variables in this constructor
				 * @param ifetcher   we pass an IncidentsFetcher object to the constructor
				 */
				public WelcomeListenerTo(IncidentsFetcher ifetcher) {
					fetcher = ifetcher;
					//We then initialise the class variables and pass the incidentFetchet to the constructor

				}
				
				/**
				 * Here in this method we pass the value of the date selected to the IncidentsFetcher
				 * @param e  it is an event for when the user selects a date for the Date Range
				 */
				public void actionPerformed(ActionEvent e){
					//We then create here a temporary comboBox that will take the value of the user selection

					JComboBox<Integer> toComboBox = (JComboBox) e.getSource();
					//We then create an endYear integer variable that will have the value of the Date selected 
					int endYear = (int) toComboBox.getItemAt(toComboBox.getSelectedIndex());
					//And we then set the startYear of the fetcher to the value of the startYear variable
		            fetcher.setEndDate(endYear);
        }
   }
