package map;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MapInformationWindow extends JFrame{
	

	public MapInformationWindow() {
		
		super("");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel jpTop = new JPanel();
		JPanel jpCenter = new JPanel();
		
		JComboBox<String> jcbSortSightings = new JComboBox<String>();
	
		JButton button = new JButton("Test");
		JTextArea jtaIncidentInfo = new JTextArea();
		
		JScrollPane scroll = new JScrollPane(jtaIncidentInfo);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
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
}