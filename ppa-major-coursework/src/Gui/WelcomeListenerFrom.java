package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

	public class WelcomeListenerFrom implements ActionListener {

		JComboBox<Integer> fromComboBox;
		JComboBox<Integer> toComboBox;
		WelcomeModel welcomeModel;
		
		public WelcomeListenerFrom(JComboBox<Integer> fromComboBox , WelcomeModel welcomeModel){
			this.fromComboBox = fromComboBox;
			this.welcomeModel= welcomeModel;
		}
		
		public void actionPerformed(ActionEvent e){
        
			fromComboBox = (JComboBox) e.getSource();
            welcomeModel.setFrom(Integer.toString((int) fromComboBox.getItemAt(fromComboBox.getSelectedIndex())));
        }
	}
	
