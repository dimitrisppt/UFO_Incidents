package map.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultListModel;

import map.model.MapInfoModel;

public class SortIncidentsListener implements ItemListener{
	
	private MapInfoModel clickObsv;
	private DefaultListModel listModel;
	
	public SortIncidentsListener(MapInfoModel infoModel, DefaultListModel<String> listModel) {
		
		clickObsv = infoModel;
		this.listModel = listModel;
	}
	


	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Object item = e.getItem();
			clickObsv.setSortProperty(item.toString());
			
			//System.out.println("trying to sort again. ListModel in listener is : " + listModel);
			clickObsv.sortAgain(listModel);
		}
		
		
	}
	

}


