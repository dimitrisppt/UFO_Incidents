package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import model.IncidentsFetcher;

	public class WelcomeListenerFrom implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			JComboBox<Integer> fromComboBox = (JComboBox) e.getSource();
			int startYear = (int) fromComboBox.getItemAt(fromComboBox.getSelectedIndex());
            new IncidentsFetcher().setStartDate(startYear);
        }
	}
	
