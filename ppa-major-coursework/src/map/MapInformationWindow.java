package map;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MapInformationWindow extends JFrame implements Observer{
	

	private InfoModel infoModel;
	private JList jlInfo;
	private DefaultListModel listModel;

	public MapInformationWindow(InfoModel infoModel) {
		
		super("");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.infoModel = infoModel;
		this.infoModel.addObserver(this);
		
		
		JPanel jpTop = new JPanel();
		JPanel jpCenter = new JPanel();
		
		JComboBox<String> jcbSortSightings = new JComboBox<String>();
	
		
		listModel = new DefaultListModel();
		
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
	
	public static void main(String[] args) {
		MapInformationWindow window = new MapInformationWindow(new InfoModel());
	}

	@Override
	public void update(Observable o, Object arg) {
		
		
		
		if (infoModel.getDoubleClick()) {
			int index = jlInfo.getSelectedIndex();
			infoModel.showSpecificInfo(index);
			

		}

		infoModel.resetDoubleClick();
		
	}
}

