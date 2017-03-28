package map.view;


import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import map.controller.InfoClickListener;
import map.controller.SortIncidentsListener;
import map.model.MapInfoModel;

/**
 * Represents the pop-up window with all the incidents from the selected
 * range of years.
 * 
 * @author Dimitris Papatheodoulou
 *
 */
public class MapInfoWindow extends JFrame implements Observer{
	
	// Initialisation of fields.
	private MapInfoModel infoModel;
	private JList<String> jlInfo;
	private DefaultListModel<String> listModel;
	private JComboBox<String> jcbSortSightings;
	private SortIncidentsListener sortListener;
	private String sortProperty;

	/**
	 * The constructor receives an object of MapInfoModel as a parameter and
	 * creates the view of the window.
	 * @param infoModel
	 */
	public MapInfoWindow(MapInfoModel infoModel) {
		
		super("List of Incidents");
		ImageIcon img = new ImageIcon("src/game/view/Ufo5.png");
		// Sets the icon of the frame to a UFO image.
		this.setIconImage(img.getImage());
		
		this.infoModel = infoModel;
		this.infoModel.addObserver(this);
		
		JPanel jpTop = new JPanel();
		JPanel jpCenter = new JPanel();
		
		listModel = new DefaultListModel<String>();
		
		jcbSortSightings = new JComboBox<String>();
		
		// Adds sort properties to the combo box.
		jcbSortSightings.addItem("-");
		jcbSortSightings.addItem("Date");
		jcbSortSightings.addItem("City");
		jcbSortSightings.addItem("Shape");
		jcbSortSightings.addItem("Duration");
		jcbSortSightings.addItem("Posted");
		sortListener = new SortIncidentsListener(infoModel, listModel);
		jcbSortSightings.addItemListener(sortListener);
		
		jlInfo = new JList(listModel);
		infoModel.addIncidentsToList(listModel);
		
		JScrollPane scroll = new JScrollPane(jlInfo);
		// Adds a vertical scroll bar.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		InfoClickListener clListen = new InfoClickListener(infoModel);
		jlInfo.addMouseListener(clListen);
		
		jpTop.setLayout(new BorderLayout());
		jpTop.add(jcbSortSightings, BorderLayout.CENTER);
		
		jpCenter.setLayout(new BorderLayout());
		jpCenter.add(scroll, BorderLayout.CENTER);	
		
		setLayout(new BorderLayout());
		add(jpTop, BorderLayout.NORTH);
		add(jpCenter, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	/*
	 * When the user double clicks on an incident, shows the detailed
	 * report in a new Dialog message.
	 * 
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		if (infoModel.getDoubleClick()) {
			int index = jlInfo.getSelectedIndex();
			// Shows a dialog message with the detailed report of that incident.
			infoModel.showSpecificInfo(index);
		}
		infoModel.resetDoubleClick();
	}
}

