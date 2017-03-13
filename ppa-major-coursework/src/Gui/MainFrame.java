package Gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.ListCellRenderer;

import javax.swing.SwingConstants;

import Listeners.ItemChangeListener;
import Listeners.MainActionListener;
import Listeners.MainComboBoxListener;
import api.ripley.Incident;
import api.ripley.Ripley;
import map.InfoModel;
import map.MapInformationWindow;


public class MainFrame extends JFrame implements Observer {
	
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
	private JLabel centerLabel;
	private JLabel rightLabel;
	private JPanel rightCard;
	private JLabel leftLabel;
	private JPanel leftCard;
	private WelcomePanel welcomePanel;
	private WelcomeListenerFrom welcomeListenerFrom;
	private WelcomeListenerTo welcomeListenerTo;
	private WelcomeModel welcomeModel;

	private Incident incident;
	public static void main(String[] args) {

		MainFrame mainFrame = new MainFrame();
		
	}

	
	
	public MainFrame() {
		
		super("UFO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ripley = new Ripley("90tLI3GUstGyVD6ql2OMtA==", "lBgm4pVq9gHVqL46EnH7ew==");
		years = new ArrayList<Integer>();
		welcomeModel = new WelcomeModel();
		welcomePanel = new WelcomePanel(welcomeModel);
		//MapInformationWindow window = new MapInformationWindow(new InfoModel());
		
		
		initWidgets();
	}

	

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
	
	
	
	public JPanel setPanels(JLabel label) {
		
		centerCard = welcomePanel;
		centerCard.setOpaque(false);
		//centerLabel = new JLabel("CENTER");
		//centerLabel.setForeground(Color.white);
		//centerLabel.setOpaque(false);
		//centerCard.add(centerLabel);

        rightCard = new JPanel();
        rightCard.setOpaque(false);
        rightLabel = new JLabel("RIGHT");
        rightLabel.setForeground(Color.white);
        rightLabel.setOpaque(false);
        rightCard.add(rightLabel);
        
        leftCard = new JPanel();
        leftCard.setOpaque(false);
        leftLabel = new JLabel("LEFT");
        leftLabel.setForeground(Color.white);
        leftLabel.setOpaque(false);
        leftCard.add(leftLabel);
        
        cards = new JPanel(new CardLayout());
        cards.setOpaque(false);
        cards.add(centerCard, "Center");
        cards.add(rightCard, "Right");
        cards.add(leftCard, "Left");
        
        getContentPane().add(cards);
        
        return cards;
	}
	
	
	
	
	public JLabel setBackground() {
		
		ImageIcon backgroundStars = new ImageIcon("src/Gui/source.gif");
		ImageIcon image = backgroundStars;
		int width = 1000;
		int height = 800;
		image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		JLabel backLabel = new JLabel(image);
		backLabel.setLayout(new BorderLayout());
		setContentPane(backLabel);
		
		return backLabel;
	}
	
	
	
	

	public void setTopPanel() {
		
		dateFromComboBox = new JComboBox<Integer>();
		dateToComboBox = new JComboBox<Integer>();

		dateFromComboBox.setToolTipText("All available years.");
		dateToComboBox.setToolTipText("All available years.");

		for (int i = 0; i <= ripley.getLatestYear() - ripley.getStartYear(); i++) {

			years.add(ripley.getStartYear() + i);
			dateFromComboBox.addItem(years.get(i));
			dateToComboBox.addItem(years.get(i));

		}

		dateFromComboBox.setSelectedIndex(-1);
		dateFromComboBox.setRenderer(new MainComboBoxListener("    -"));

		dateToComboBox.setSelectedIndex(-1);
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

		//dateFromComboBox.addItemListener(new ItemChangeListener());
		//dateToComboBox.addItemListener(new ItemChangeListener());
		
		welcomeListenerFrom = new WelcomeListenerFrom(dateFromComboBox , welcomeModel);
		dateFromComboBox.addActionListener(welcomeListenerFrom);
		welcomeListenerTo = new WelcomeListenerTo(dateToComboBox , welcomeModel);
		dateToComboBox.addActionListener(welcomeListenerTo);
		
		jpTop.add(jpDates, BorderLayout.EAST);
		
		
		background.add(jpTop, BorderLayout.NORTH);
	}
	
	
	
	
	public void setCenterPanel() {
		
		jpCenter = new JPanel();
		jpCenter.setOpaque(false);
		
		background.add(jpCenter, BorderLayout.CENTER);
		
	}
	
	
	
	public void setBottomPanel() {
		
		jpBottom = new JPanel();
		jpBottom.setOpaque(false);
		
		jbLeft = new JButton("<");
		jbLeft.setEnabled(true);
		jbRight = new JButton(">");
		jbRight.setEnabled(true);
		
		labelLastUpdate = new JLabel(ripley.getLastUpdated(), SwingConstants.CENTER);
		labelLastUpdate.setForeground(Color.white);
		
	
		
		jpBottom.setLayout(new BorderLayout());
		
		jpBottom.add(jbLeft, BorderLayout.WEST);
		jpBottom.add(jbRight, BorderLayout.EAST);
		jpBottom.add(labelLastUpdate, BorderLayout.CENTER);
		
		jbLeft.addActionListener(new MainActionListener(panels, true));
		jbRight.addActionListener(new MainActionListener(panels, false));
		
		background.add(jpBottom, BorderLayout.SOUTH);

	}



	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
