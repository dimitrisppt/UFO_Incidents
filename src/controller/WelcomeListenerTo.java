package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import model.IncidentsFetcher;

	public class WelcomeListenerTo implements ActionListener {
		
				private IncidentsFetcher fetcher;
				
				public WelcomeListenerTo(IncidentsFetcher ifetcher) {
					fetcher = ifetcher;
				}
				
				public void actionPerformed(ActionEvent e){
					JComboBox<Integer> toComboBox = (JComboBox) e.getSource();
					int endYear = (int) toComboBox.getItemAt(toComboBox.getSelectedIndex());
		            fetcher.setEndDate(endYear);
        }
   }
