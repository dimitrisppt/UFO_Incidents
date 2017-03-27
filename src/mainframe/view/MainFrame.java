package mainframe.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.SwingConstants;

import api.ripley.Incident;
import api.ripley.Ripley;
import controller.MainActionListener;
import controller.MainComboBoxListener;
import controller.WelcomeListenerFrom;
import controller.WelcomeListenerTo;
import map.view.Map;
import model.IncidentsFetcher;
import statistics.view.StatisticsPanel;

/**
 * The MainFrame is responsible for the GUI of the application.
 * All subpanels are included and the interaction between them is done with two buttons.
 * The initial panel is always the welcome panel followed by map statistics and game panel.
 * There are combo boxes at the top right hand side where you can select a range of years.
 *  
 * @author Dimitris Papatheodoulou
 *
 */

public class MainFrame extends JFrame implements Observer {
	
	// Declaring fields
	private Ripley ripley;
	private JPanel cards;
	private JLabel labelFrom;
	private JLabel labelTo;
	private ArrayList<Integer> years;
	private JComboBox<Integer> dateFromComboBox;
	private JComboBox<Integer> dateToComboBox;
	private JPanel jpTop;
	private JLabel labelLastUpdate;
	private JPanel jpBottom;
	private JButton jbLeft;
	private JButton jbRight;
	private JPanel panels;
	private JPanel jpDates;
	private JLabel background;
	private JPanel jpCenter;
	private JPanel centerCard;
	private JPanel rightCard;
	private JLabel leftLabel;
	private JPanel leftCard;
	private WelcomePanel welcomePanel;
	private IncidentsFetcher incidentsFetcher;
	private StatisticsPanel statsPanel;
	private Map mapPanel;
	
	
	/**
	 * The constructor initialises all panels.
	 * Creates a Ripley object with authentication keys.
	 * Initialises all the widgets.
	 */
	public MainFrame() {
		
		super("UFO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("src/game/view/Ufo5.png");
		// Sets the icon of the frame to a UFO image.
		this.setIconImage(img.getImage());
		
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		years = new ArrayList<Integer>();
		incidentsFetcher = new IncidentsFetcher();
		incidentsFetcher.addObserver(this);
		statsPanel = new StatisticsPanel(incidentsFetcher);
		welcomePanel = new WelcomePanel(incidentsFetcher);
		mapPanel = new Map(incidentsFetcher);
		
		initWidgets();
	}

	
	/**
	 * Initialises the widgets.
	 */
	public void initWidgets() {

		background = setBackground();
		setLayout(new BorderLayout());
		
		setTopPanel();
		setCenterPanel();
		
		panels = setPanels(background);
		panels.setOpaque(false);
		
		setBottomPanel();
		
		pack();
		setVisible(true);
		
	}
	
	
	/**
	 * Adds the panels to their positions using CardLayout.
	 * The first card is the welcome panel, the second is the map,
	 * the third is the statistics and the forth is the game panel.
	 * 
	 * @param label
	 * @return cards
	 */
	public JPanel setPanels(JLabel label) {
		
		// Sets the first card to the welcome panel.
		centerCard = welcomePanel;
		// Makes the card transparent.
		centerCard.setOpaque(false);

		// Sets the second card to the statistics panel
        rightCard = statsPanel;
        // Makes the card transparent.
        rightCard.setOpaque(false);
        statsPanel.setForeground(Color.white);
       
        
        leftCard = mapPanel;
//        leftCard.setOpaque(false);
//        leftLabel = new JLabel("LEFT");
//        leftLabel.setForeground(Color.white);
//        leftLabel.setOpaque(false);
//        leftCard.add(leftLabel);
        
        // Creates a JPanel of cards with CardLayout.
        cards = new JPanel(new CardLayout());
        cards.setOpaque(false);
        cards.add(centerCard, "Center");
        cards.add(rightCard, "Right");
        cards.add(leftCard, "Left");
        
        getContentPane().add(cards);
        
        return cards;
	}
	
	
	
	/**
	 * Sets the background of the frame to a gif.
	 * @return backLabel
	 */
	public JLabel setBackground() {
		//Creates an ImageIcon using a specific path.
		ImageIcon backgroundStars = new ImageIcon("src/mainframe/view/source.gif");
		ImageIcon image = backgroundStars;
		int width = 1000;
		int height = 800;
		image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		JLabel backLabel = new JLabel(image);
		backLabel.setLayout(new BorderLayout());
		setContentPane(backLabel);
		
		return backLabel;
	}
	
	
	/**
	 * Sets up the top panel that contains two combo boxes with a range of years.
	 */
	public void setTopPanel() {
		
		dateFromComboBox = new JComboBox<Integer>();
		dateToComboBox = new JComboBox<Integer>();

		dateFromComboBox.setToolTipText("Please select a starting year.");
		dateToComboBox.setToolTipText("Please select an ending year.");

		for (int i = 0; i <= ripley.getLatestYear() - ripley.getStartYear(); i++) {

			years.add(ripley.getStartYear() + i);
			dateFromComboBox.addItem(years.get(i));
			dateToComboBox.addItem(years.get(i));
		}

		dateFromComboBox.setSelectedIndex(-1);
		// Sets the first entry of the combo box to '-' (blank).
		dateFromComboBox.setRenderer(new MainComboBoxListener("    -"));

		dateToComboBox.setSelectedIndex(-1);
		// Sets the first entry of the combo box to '-' (blank).
		dateToComboBox.setRenderer(new MainComboBoxListener("    -"));

		labelFrom = new JLabel("From: ", SwingConstants.RIGHT);
		labelFrom.setForeground(Color.white);
		labelTo = new JLabel("To: ", SwingConstants.RIGHT);
		labelTo.setForeground(Color.white);
		
		jpTop = new JPanel();
		jpTop.setOpaque(false);
		jpTop.setLayout(new BorderLayout());
		
		jpDates = new JPanel();
		jpDates.setOpaque(false);
		jpDates.setLayout(new FlowLayout());

		jpDates.add(labelFrom);
		jpDates.add(dateFromComboBox);
		jpDates.add(labelTo);
		jpDates.add(dateToComboBox);

		// Adding action listeners to the combo boxes.
		dateFromComboBox.addActionListener(new WelcomeListenerFrom(incidentsFetcher));
		dateToComboBox.addActionListener(new WelcomeListenerTo(incidentsFetcher));
		
		jpTop.add(jpDates, BorderLayout.EAST);
		
		background.add(jpTop, BorderLayout.NORTH);
		
	}
	
	
	
	/**
	 * Creates a new central panel.
	 */
	public void setCenterPanel() {
		
		jpCenter = new JPanel();
		jpCenter.setOpaque(false);
		
		background.add(jpCenter, BorderLayout.CENTER);
		
	}
	
	
	/**
	 * Sets up the bottom panel with the buttons and ripley's last updated date.
	 */
	public void setBottomPanel() {
		
		jpBottom = new JPanel();
		jpBottom.setOpaque(false);
		
		jbLeft = new JButton("<");
		jbLeft.setEnabled(false);
		jbRight = new JButton(">");
		jbRight.setEnabled(false);
		jbRight.setToolTipText("Please select a valid date range to activate buttons.");
		jbRight.setToolTipText("Please select a valid date range to activate buttons.");
		
		labelLastUpdate = new JLabel(ripley.getLastUpdated(), SwingConstants.CENTER);
		labelLastUpdate.setForeground(Color.white);
		
		jpBottom.setLayout(new BorderLayout());
		
		jpBottom.add(jbLeft, BorderLayout.WEST);
		jpBottom.add(jbRight, BorderLayout.EAST);
		jpBottom.add(labelLastUpdate, BorderLayout.CENTER);
		
		/* Adding action listeners to the buttons by passing as parameters the panels and true or false,
		 * to differentiate left from right button.
		 */
		jbLeft.addActionListener(new MainActionListener(panels, true));
		jbRight.addActionListener(new MainActionListener(panels, false));
		
		background.add(jpBottom, BorderLayout.SOUTH);
		
	}


	/*
	 * Updates the buttons to disabled or enabled depending whether the selected dates 
	 * are valid or not.
	 * 
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		
		
		
		if (incidentsFetcher.isValidDates()) {
			jbRight.setEnabled(true);
			jbLeft.setEnabled(true);
			jbRight.setToolTipText("Press to switch to the next panel.");
			jbLeft.setToolTipText("Press to switch to the previous panel.");
		} else {
			jbRight.setEnabled(false);
			jbLeft.setEnabled(false);
			jbRight.setToolTipText("Please select a valid date range to activate buttons.");
			jbRight.setToolTipText("Please select a valid date range to activate buttons.");
		}
		
//		for (Component comp : this.getComponents()) {
//		    if (comp.isVisible() == true) {
//		        cards = (JPanel) comp;
//		    }
//		}
		
	}

}
