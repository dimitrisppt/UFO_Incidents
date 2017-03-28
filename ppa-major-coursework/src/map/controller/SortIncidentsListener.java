package map.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultListModel;
import map.model.MapInfoModel;

/**
 * This class implements ItemListener and sorts the incidents list by
 * different properties. e.g Date, City, Shape etc.
 * 
 * @author Dimitris Papatheodoulou
 *
 */
public class SortIncidentsListener implements ItemListener{
	
	// Declaring fields.
	private MapInfoModel clickObsv;
	private DefaultListModel<String> listModel;
	
	/**
	 * The constructor initialises the fields with the two parameters, infoModel and listModel.
	 * 
	 * @param infoModel
	 * @param listModel
	 */
	public SortIncidentsListener(MapInfoModel infoModel, DefaultListModel<String> listModel) {
		
		clickObsv = infoModel;
		this.listModel = listModel;
	}
	
	/*
	 * When a new property has been selected by the user.
	 * Sorts the list again.
	 * 
	 * (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Object item = e.getItem();
			// Sets the selected property.
			clickObsv.setSortProperty(item.toString());
			// Sorts the list again according to the selected property.
			clickObsv.sortAgain(listModel);
		}
	}

}


