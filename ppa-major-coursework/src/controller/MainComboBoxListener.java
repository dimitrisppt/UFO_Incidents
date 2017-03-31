package controller;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
/**
 * Listener that sets the initial String value for the dates in the combo box.
 * this is because you can't add a string value to JCombobox of ints
 * 
 * @author Dimitris
 *
 */
public class MainComboBoxListener extends JLabel implements ListCellRenderer { 

	private String cbTitle;

	/**
	 * constructor. Initialises variables
	 * @param title
	 */
	public MainComboBoxListener(String title) {
		
		cbTitle = title;
	}


	/*
	 * sets the initial value of date JComboboxes to cbTitle
	 * (non-Javadoc)
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		
		if (index == -1 && value == null)
			setText(cbTitle);
		else
			setText(value.toString());
		return this;
	}
	
}
