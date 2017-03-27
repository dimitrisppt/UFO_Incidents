package map.view;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import map.controller.InfoClickListener;
import map.controller.SortIncidentsListener;
import map.model.MapInfoModel;


public class MapInfoWindow extends JFrame implements Observer{
	

	private MapInfoModel infoModel;
	private JList jlInfo;
	private DefaultListModel listModel;
	private JComboBox<String> jcbSortSightings;
	private SortIncidentsListener sortListener;
	private static String sortProperty;

	public MapInfoWindow(MapInfoModel infoModel) {
		
		super("");
		ImageIcon img = new ImageIcon("src/game/view/Ufo5.png");
		// Sets the icon of the frame to a UFO image.
		this.setIconImage(img.getImage());
		
		this.infoModel = infoModel;
		this.infoModel.addObserver(this);
		
		
		JPanel jpTop = new JPanel();
		JPanel jpCenter = new JPanel();
		
		listModel = new DefaultListModel();
		
		jcbSortSightings = new JComboBox<String>();
		
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
	
	
//	public static void main(String[] args) {
//		MapInformationWindow window = new MapInformationWindow(new InfoModel(sortProperty));
//	}

	@Override
	public void update(Observable o, Object arg) {
		
		
		
		if (infoModel.getDoubleClick()) {
			int index = jlInfo.getSelectedIndex();
			infoModel.showSpecificInfo(index);
			

		}

		infoModel.resetDoubleClick();
		
	}
}

