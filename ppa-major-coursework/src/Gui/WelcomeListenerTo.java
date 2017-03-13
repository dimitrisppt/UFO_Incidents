package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

	public class WelcomeListenerTo implements ActionListener {

		
		JComboBox<Integer> toComboBox;
		WelcomeModel welcomeModel;
		
		public WelcomeListenerTo(JComboBox<Integer> toComboBox , WelcomeModel welcomeModel){
			
			this.toComboBox = toComboBox;
			this.welcomeModel= welcomeModel;
		}
		
		public void actionPerformed(ActionEvent e){
        
			toComboBox = (JComboBox) e.getSource();
			welcomeModel.setTo(Integer.toString((int) toComboBox.getItemAt(toComboBox.getSelectedIndex())));  
        }
   }
