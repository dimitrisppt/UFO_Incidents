package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import api.ripley.Ripley;

public class MainFrame extends JFrame {
	
	public static void main(String[] args) {
		
		MainFrame mainFrame = new MainFrame();
		
	}
	
	private Ripley ripley;
	
	public MainFrame() {
		super("");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		initWidgets();
	}

	private void initWidgets() {
		
		SpinnerDateModel dateFromModel = new SpinnerDateModel();
		SpinnerDateModel dateToModel = new SpinnerDateModel();
		
		JSpinner spinnerFrom = new JSpinner(dateFromModel);
		JSpinner spinnerTo = new JSpinner(dateToModel);
		
		JLabel labelFrom = new JLabel("From: ",  SwingConstants.RIGHT);
		JLabel labelTo = new JLabel("To: ", SwingConstants.RIGHT);
		JLabel labelLastUpdate = new JLabel(ripley.getLastUpdated(), SwingConstants.CENTER);
		
		JPanel jpTop = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpBottom = new JPanel();
		JPanel jpDates =  new JPanel();
		
		JButton jbLeft = new JButton("<");
		jbLeft.setEnabled(false);
		JButton jbRight = new JButton(">");
		jbRight.setEnabled(false);
		
		this.setLayout(new BorderLayout());
		
		jpTop.setLayout(new BorderLayout());
		jpBottom.setLayout(new BorderLayout());
		jpDates.setLayout(new FlowLayout());
		
		jpDates.add(labelFrom);
		jpDates.add(spinnerFrom);
		jpDates.add(labelTo); 
		jpDates.add(spinnerTo);
		
		jpTop.add(jpDates, BorderLayout.EAST);
		
		jpBottom.add(jbLeft, BorderLayout.WEST);
		jpBottom.add(jbRight, BorderLayout.EAST);
		jpBottom.add(labelLastUpdate, BorderLayout.CENTER);
		
		add(jpTop, BorderLayout.NORTH);
		add(jpCenter, BorderLayout.CENTER);
		add(jpBottom, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		
		
	}

}
