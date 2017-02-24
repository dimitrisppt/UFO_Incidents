package Listeners;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MainComboBoxListener extends JLabel implements ListCellRenderer { 

	private String cbTitle;

	public MainComboBoxListener(String title) {
		
		cbTitle = title;
	}


	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		
		if (index == -1 && value == null)
			setText(cbTitle);
		else
			setText(value.toString());
		return this;
	}
	
}
