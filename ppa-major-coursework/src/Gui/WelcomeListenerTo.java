package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import model.IncidentsFetcher;

	public class WelcomeListenerTo implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
        
			JComboBox<Integer> toComboBox = (JComboBox) e.getSource();
			int endYear = (int)toComboBox.getItemAt(toComboBox.getSelectedIndex());
			new IncidentsFetcher().setEndDate(endYear);
        }
   }
