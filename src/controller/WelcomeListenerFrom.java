package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import model.IncidentsFetcher;

	public class WelcomeListenerFrom implements ActionListener {
		
		private IncidentsFetcher fetcher;
		
		public WelcomeListenerFrom(IncidentsFetcher ifetcher) {
			fetcher = ifetcher;
		}
		
		public void actionPerformed(ActionEvent e){
			JComboBox<Integer> fromComboBox = (JComboBox) e.getSource();
			int startYear = (int) fromComboBox.getItemAt(fromComboBox.getSelectedIndex());
            fetcher.setStartDate(startYear);
        }
	}
	
