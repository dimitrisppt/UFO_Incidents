package map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultListModel;

public class SortIncidentsListener implements ItemListener{
	
	private InfoModel clickObsv;
	private DefaultListModel listModel;
	
	public SortIncidentsListener(InfoModel infoModel, DefaultListModel<String> listModel) {
		
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


