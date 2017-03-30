package game.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


import game.controller.BaseballBatButtonListener;
import game.controller.CatapultButtonListener;
import game.controller.FistButtonListener;
import game.controller.GolfClubButtonListener;
import game.controller.InfoButtonListener;
import game.controller.KatanaButtonListener;
import game.controller.LightsaberButtonListener;
import game.controller.NuclearBombButtonListener;
import game.controller.RockButtonListener;
import game.controller.SlingshotButtonListener;
import game.controller.TntButtonListener;
import game.controller.GameUfoListener;
import game.model.ClickModel;
import game.model.GameModel;


/**
 * The GameView class contains all the components of the game,
 * The initialisation of all widgets is done in the initWidgets method
 * 
 * 
 * @author Dimitris Papatheodoulou
 *
 */
public class GameView extends JPanel implements Observer{

	// Declaring fiels.
	private GameIconCreator storeItems;
	private ClickModel clickObsv;
	private GameModel gameModel;
	private JLabel jlInfoItem1;
	private JLabel jlInfoItem2;
	private JLabel jlInfoItem3;
	private JLabel jlInfoItem4;
	private JLabel jlInfoItem5;
	private JLabel jlInfoItem6;
	private JLabel jlInfoItem7;
	private JLabel jlInfoItem8;
	private JLabel jlInfoItem9;
	private JLabel jlInfoItem10;
	private JButton jbStoreItem1;
	private JButton jbStoreItem2;
	private JButton jbStoreItem3;
	private JButton jbStoreItem4;
	private JButton jbStoreItem5;
	private JButton jbStoreItem6;
	private JButton jbStoreItem7;
	private JButton jbStoreItem8;
	private JButton jbStoreItem9;
	private JButton jbStoreItem10;
	private JLabel jlTotalMoney;
	private JLabel jlUfo;
	private JProgressBar progressBar;
	private JLabel jlUfoCharacter;
	private JButton infoButton;
	
	
	/**
	 * The constructor creates objects of ClickModel, GameModel and GameIconCreator,
	 * initialises all the widgets of the game panel and adds this class as observer of 
	 * gameModel.
	 * 
	 * @throws IOException
	 */
	public GameView() throws IOException {
		
		clickObsv = new ClickModel();
		gameModel = new GameModel();
		storeItems = new GameIconCreator(gameModel);
		initWidgets();
		setButtonsVisibility();
		// Adds this class as observer of gameModel.
		gameModel.addObserver(this);
		this.setOpaque(false);
		
	}
	
	/**
	 * Initialises all widgets of the game panel.
	 */
	private void initWidgets() {
		
		// Creation of JPanels
		JPanel jpDisplay = new JPanel(new BorderLayout());
		JPanel jpEast = new JPanel(new BorderLayout());
		JPanel jpEastStore = new JPanel(new GridLayout(12,1));
		JPanel jpCenter = new JPanel(new BorderLayout());
		JPanel jpCenterNorth = new JPanel(new BorderLayout());
		JPanel jpWest = new JPanel(new BorderLayout());
		JPanel jpWestInfo = new JPanel(new GridLayout(12,1));
		JPanel jpCenterCenterNorth = new JPanel();
		JPanel jpCenterCenter = new JPanel(new BorderLayout());
		JPanel jpNorth = new JPanel(new BorderLayout());
		JPanel jpNorthWest = new JPanel(new BorderLayout());
		
		// Sets the JPanels to transparent.
		jpEast.setOpaque(false);
		jpEastStore.setOpaque(false);
		jpCenter.setOpaque(false);
		jpCenterNorth.setOpaque(false);
		jpWest.setOpaque(false);
		jpWestInfo.setOpaque(false);
		jpCenterCenterNorth.setOpaque(false);
		jpCenterCenter.setOpaque(false);
		
		// Creation of JLabels with information about the game
		jlUfo = new JLabel("UFO Level: " + gameModel.getUfoLevel(), SwingConstants.RIGHT);
		jlUfo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		jlUfo.setForeground(Color.YELLOW);
		JLabel jlInfo = new JLabel("Items Information: ", SwingConstants.CENTER);
		jlInfo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		jlInfo.setForeground(Color.YELLOW);
		JLabel jlStore = new JLabel("Store: ", SwingConstants.CENTER);
		jlStore.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		jlStore.setForeground(Color.YELLOW);
		jlTotalMoney = new JLabel("Total Coins: " + gameModel.getTotalMoney());
		jlTotalMoney.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		jlTotalMoney.setForeground(Color.YELLOW);
		
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem1 = new JButton("<html>Fist" + "<br>" 
		        + "Price: " + gameModel.getFistPrice() + "</html>");
		jbStoreItem1.setBorderPainted( false );
		jbStoreItem1.addActionListener(new FistButtonListener(gameModel));
		// Sets the icon of the button
		jbStoreItem1.setIcon(new ImageIcon(storeItems.getImageFist()));
		jbStoreItem1.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem2 = new JButton("<html>Rock"+ "<br>" 
		        + "Price: " + gameModel.getRockPrice() + "</html>");
		jbStoreItem2.setBorderPainted( false );
		jbStoreItem2.addActionListener(new RockButtonListener(gameModel));
		// Sets the icon of the button
		jbStoreItem2.setIcon(new ImageIcon(storeItems.getImageRock()));
		jbStoreItem2.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem3 = new JButton("<html>Slingshot" + "<br>" 
		        + "Price: " + gameModel.getSlingshotPrice() + "</html>");
		jbStoreItem3.setBorderPainted( false );
		jbStoreItem3.addActionListener(new SlingshotButtonListener(gameModel));
		// Sets the icon of the button
		jbStoreItem3.setIcon(new ImageIcon(storeItems.getImageSlingshot()));
		jbStoreItem3.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem4 = new JButton("<html>Baseball bat"+ "<br>" 
		        + "Price: " + gameModel.getBaseballBatPrice() + "</html>");
		jbStoreItem4.setBorderPainted( false );
		jbStoreItem4.addActionListener(new BaseballBatButtonListener(gameModel));
		// Sets the icon of the button
		jbStoreItem4.setIcon(new ImageIcon(storeItems.getImageBaseballBat()));
		jbStoreItem4.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem5 = new JButton("<html>Golf club"+ "<br>" 
		        + "Price: " + gameModel.getGolfClubPrice() + "</html>");
		jbStoreItem5.setBorderPainted( false );
		jbStoreItem5.addActionListener(new GolfClubButtonListener(gameModel));
		// Sets the icon of the button
		jbStoreItem5.setIcon(new ImageIcon(storeItems.getImageGolfClub()));
		jbStoreItem5.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem6 = new JButton("<html>Katana"+ "<br>" 
		        + "Price: " + gameModel.getKatanaPrice() + "</html>");
		jbStoreItem6.setBorderPainted( false );
		jbStoreItem6.addActionListener(new KatanaButtonListener(gameModel));
		jbStoreItem6.setIcon(new ImageIcon(storeItems.getImageKatana()));
		// Sets the icon of the button
		jbStoreItem6.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem7 = new JButton("<html>Lightsaber" + "<br>" 
		        + "Price: " + gameModel.getLightsaberPrice() + "</html>");
		jbStoreItem7.setBorderPainted( false );
		jbStoreItem7.addActionListener(new LightsaberButtonListener(gameModel));
		jbStoreItem7.setIcon(new ImageIcon(storeItems.getImageLightsaber()));
		// Sets the icon of the button
		jbStoreItem7.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem8 = new JButton("<html>Catapult" + "<br>" 
		        + "Price: " + gameModel.getCatapultPrice() + "</html>");
		jbStoreItem8.setBorderPainted( false );
		jbStoreItem8.addActionListener(new CatapultButtonListener(gameModel));
		// Sets the icon of the button
		jbStoreItem8.setIcon(new ImageIcon(storeItems.getImageCatapult()));
		jbStoreItem8.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem9 = new JButton("<html>T.N.T"+ "<br>" 
		        + "Price: " + gameModel.getTntPrice() + "</html>");
		// Sets the icon of the button
		jbStoreItem9.setIcon(new ImageIcon(storeItems.getImageTnt()));
		jbStoreItem9.addActionListener(new TntButtonListener(gameModel));
		jbStoreItem9.setBorderPainted( false );
		jbStoreItem9.setOpaque(false);
		
		// Creation of JButtons for all the available items in the store.
		jbStoreItem10 = new JButton("<html>Nuclear Bomb" + "<br>" 
		        + "Price: " + gameModel.getMissilePrice() + "</html>");
		// Sets the icon of the button
		jbStoreItem10.setIcon(new ImageIcon(storeItems.getImageNuclearBomb()));
		jbStoreItem10.addActionListener(new NuclearBombButtonListener(gameModel));
		jbStoreItem10.setBorderPainted( false );
		jbStoreItem10.setOpaque(false);
		
		// Creation of a progressBar with bounds from 0 to ufo's max health
		progressBar = new JProgressBar(0, gameModel.getUfoMaxHealth());
		// Sets the starting value of the progressBar to the ufo's max health
		progressBar.setValue(gameModel.getUfoMaxHealth());
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.RED);
		progressBar.setString(gameModel.getUfoHealth() + " /" + gameModel.getUfoMaxHealth());
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem1 = new JLabel("<html>Fist's Level: " + gameModel.getFistLevel() + "<br>" 
		        + "Fist's Damage: " + gameModel.getFistDamage() + "</html>");
		jlInfoItem1.setIcon(new ImageIcon(storeItems.getImageFist()));
		jlInfoItem1.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem2 = new JLabel("<html>Rock's Level: " + gameModel.getRockLevel() + "<br>" 
		        + "Rock's Damage: " + gameModel.getRockDamage() + "</html>");
		jlInfoItem2.setIcon(new ImageIcon(storeItems.getImageRock()));
		jlInfoItem2.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem3 = new JLabel("<html>Slingshot's Level: " + gameModel.getSlingshotLevel() + "<br>" 
		        + "Slingshot's Damage: " + gameModel.getSlingshotDamage() + "</html>");
		jlInfoItem3.setIcon(new ImageIcon(storeItems.getImageSlingshot()));
		jlInfoItem3.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem4 = new JLabel("<html>Baseball Bat's Level: " + gameModel.getBaseballBatLevel() + "<br>" 
		        + "Baseball Bat's Damage: " + gameModel.getBaseballBatDamage() + "</html>");
		jlInfoItem4.setIcon(new ImageIcon(storeItems.getImageBaseballBat()));
		jlInfoItem4.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem5 = new JLabel("<html>Golf Club's Level: " + gameModel.getGolfClubLevel() + "<br>" 
		        + "GolfClub's Damage: " + gameModel.getGolfClubDamage() + "</html>");
		jlInfoItem5.setIcon(new ImageIcon(storeItems.getImageGolfClub()));
		jlInfoItem5.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem6 = new JLabel("<html>Katana's Level: " + gameModel.getKatanaLevel() + "<br>" 
		        + "Katana's Damage: " + gameModel.getKatanaDamage() + "</html>");
		jlInfoItem6.setIcon(new ImageIcon(storeItems.getImageKatana()));
		jlInfoItem6.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem7 = new JLabel("<html>Lightsaber's Level: " + gameModel.getLightsaberLevel() + "<br>" 
		        + "Lightsaber's Damage: " + gameModel.getLightsaberDamage() + "</html>");
		jlInfoItem7.setIcon(new ImageIcon(storeItems.getImageLightsaber()));
		jlInfoItem7.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem8 = new JLabel("<html>Catapult's Level: " + gameModel.getCatapultLevel() + "<br>" 
		        + "Catapult's Damage: " + gameModel.getCatapultDamage() + "</html>");
		jlInfoItem8.setIcon(new ImageIcon(storeItems.getImageCatapult()));
		jlInfoItem8.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem9 = new JLabel("<html>T.N.T's Level: " + gameModel.getTntLevel() + "<br>" 
		        + "T.N.T's Damage: " + gameModel.getTntDamage() + "</html>");
		jlInfoItem9.setIcon(new ImageIcon(storeItems.getImageTnt()));
		jlInfoItem9.setForeground(Color.WHITE);
		
		// Creation of JLabels for all the owned items of the user.
		jlInfoItem10 = new JLabel("<html>Nuclear Bomb's Level: " + gameModel.getMissileLevel() + "<br>" 
		        + "Nuclear Bomb's Damage: " + gameModel.getMissileDamage() + "</html>");
		jlInfoItem10.setIcon(new ImageIcon(storeItems.getImageNuclearBomb()));
		jlInfoItem10.setForeground(Color.WHITE);
		
		// Creation of a JLabel that holds the Ufo icon.
		jlUfoCharacter = new JLabel();
		jlUfoCharacter.setIcon(new ImageIcon(storeItems.getImageUfo1()));
		// Sets the position of the JLabel to center of the panel.
		jlUfoCharacter.setHorizontalAlignment(JLabel.CENTER);
		jlUfoCharacter.addMouseListener(new GameUfoListener(clickObsv, gameModel));
		
		// Creates a button that will show a message dialog with information about the game
		infoButton = new JButton("Help");
		infoButton.addActionListener(new InfoButtonListener());
		
		// Adds the item buttons under the store label.
		jpEastStore.add(new JLabel(""));
		jpEastStore.add(jlStore);
		jpEastStore.add(jbStoreItem1);
		jpEastStore.add(jbStoreItem2);
		jpEastStore.add(jbStoreItem3);
		jpEastStore.add(jbStoreItem4);
		jpEastStore.add(jbStoreItem5);
		jpEastStore.add(jbStoreItem6);
		jpEastStore.add(jbStoreItem7);
		jpEastStore.add(jbStoreItem8);
		jpEastStore.add(jbStoreItem9);
		jpEastStore.add(jbStoreItem10);
		
		// Adds the infoButton to the NorthWest panel
		jpNorthWest.add(infoButton, BorderLayout.WEST);
		jpNorthWest.setOpaque(false);
		// Adds the NorthWest panel to the North
		jpNorth.add(jpNorthWest, BorderLayout.NORTH);
		jpNorth.setOpaque(false);
		
		// Adds the item labels under the Item Information label.
		jpWestInfo.add(jpNorth);
		jpWestInfo.add(jlInfo);
		jpWestInfo.add(jlInfoItem1);
		jpWestInfo.add(jlInfoItem2);
		jpWestInfo.add(jlInfoItem3);
		jpWestInfo.add(jlInfoItem4);
		jpWestInfo.add(jlInfoItem5);
		jpWestInfo.add(jlInfoItem6);
		jpWestInfo.add(jlInfoItem7);
		jpWestInfo.add(jlInfoItem8);
		jpWestInfo.add(jlInfoItem9);
		jpWestInfo.add(jlInfoItem10);
		
		// Sets the position of each panel.
		jpEast.add(jpEastStore);
		jpCenterNorth.add(jlTotalMoney, BorderLayout.WEST);
		jpCenterNorth.add(jlUfo, BorderLayout.CENTER);
		jpCenter.add(jpCenterNorth, BorderLayout.NORTH);
		jpCenterCenterNorth.add(progressBar);
		jpCenterCenter.add(jpCenterCenterNorth, BorderLayout.NORTH);
		jpCenterCenter.add(jlUfoCharacter, BorderLayout.CENTER);
		jpCenter.add(jpCenterCenter, BorderLayout.CENTER);
		jpWest.add(jpWestInfo);
		
		// Adds the each panel to the correct position on jpDisplay. 
		jpDisplay.add(jpEast, BorderLayout.EAST);
		jpDisplay.add(jpCenter, BorderLayout.CENTER);
		jpDisplay.add(jpWest, BorderLayout.WEST);
		
		// Adds jpDisplay to the gamePanel.
		add(jpDisplay);
		jpDisplay.setOpaque(false);
		// Sets the dimensions of the panel.
		jpDisplay.setPreferredSize(new Dimension(1000,750));
		
		setVisible(true);
		
	}


	/*
	 * Every component of the gamePanel it gets updated accordingly to the user action,
	 * every time this method is been called.
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		jlUfoCharacter.setIcon(new ImageIcon(storeItems.changeUfoIcon()));
		
		setButtonsVisibility();
		// Updates the Health progressBar.
		progressBar.setMaximum(gameModel.getUfoMaxHealth());
		progressBar.setValue(gameModel.getUfoHealth());
		progressBar.setString(gameModel.getUfoHealth() + " /" + gameModel.getUfoMaxHealth());
		
		// Updates all JLabels with the new values.
		jlInfoItem1.setText("<html>Fist's Level: " + gameModel.getFistLevel() + "<br>" 
		        + "Fist's Damage: " + gameModel.getFistDamage() + "</html>");
		
		jlInfoItem2.setText("<html>Rock's Level: " + gameModel.getRockLevel() + "<br>" 
		        + "Rock's Damage: " + gameModel.getRockDamage() + "</html>");
		
		jlInfoItem3.setText("<html>Slingshot's Level: " + gameModel.getSlingshotLevel() + "<br>" 
		        + "Slingshot's Damage: " + gameModel.getSlingshotDamage() + "</html>");
		
		jlInfoItem4.setText("<html>Baseball Bat's Level: " + gameModel.getBaseballBatLevel() + "<br>" 
		        + "Baseball Bat's Damage: " + gameModel.getBaseballBatDamage() + "</html>");
		
		jlInfoItem5.setText("<html>Golf Club's Level: " + gameModel.getGolfClubLevel() + "<br>" 
		        + "GolfClub's Damage: " + gameModel.getGolfClubDamage() + "</html>");
		
		jlInfoItem6.setText("<html>Katana's Level: " + gameModel.getKatanaLevel() + "<br>" 
		        + "Katana's Damage: " + gameModel.getKatanaDamage() + "</html>");
		
		jlInfoItem7.setText("<html>Lightsaber's Level: " + gameModel.getLightsaberLevel() + "<br>" 
		        + "Lightsaber's Damage: " + gameModel.getLightsaberDamage() + "</html>");
		
		jlInfoItem8.setText("<html>Catapult's Level: " + gameModel.getCatapultLevel() + "<br>" 
		        + "Catapult's Damage: " + gameModel.getCatapultDamage() + "</html>");
		
		jlInfoItem9.setText("<html>T.N.T's Level: " + gameModel.getTntLevel() + "<br>" 
		        + "T.N.T's Damage: " + gameModel.getTntDamage() + "</html>");
		
		jlInfoItem10.setText("<html>Nuclear Bomb's Level: " + gameModel.getMissileLevel() + "<br>" 
		        + "Nuclear Bomb's Damage: " + gameModel.getMissileDamage() + "</html>");
		
		jlUfo.setText("UFO Level: " + gameModel.getUfoLevel());
		
		jlTotalMoney.setText("Total Coins: " + gameModel.getTotalMoney());
		
		
		// Updates all JButtons with the new values.
		jbStoreItem1.setText("<html>Fist" + "<br>" 
		        + "Price: " + gameModel.getFistPrice() + "</html>");
		
		jbStoreItem2.setText("<html>Rock"+ "<br>" 
		        + "Price: " + gameModel.getRockPrice() + "</html>");
		
		jbStoreItem3.setText("<html>Slingshot" + "<br>" 
		        + "Price: " + gameModel.getSlingshotPrice() + "</html>");
		
		jbStoreItem4.setText("<html>Baseball bat"+ "<br>" 
		        + "Price: " + gameModel.getBaseballBatPrice() + "</html>");
		
		jbStoreItem5.setText("<html>Golf club"+ "<br>" 
		        + "Price: " + gameModel.getGolfClubPrice() + "</html>");
		
		jbStoreItem6.setText("<html>Katana"+ "<br>" 
		        + "Price: " + gameModel.getKatanaPrice() + "</html>");
		
		jbStoreItem7.setText("<html>Lightsaber" + "<br>" 
		        + "Price: " + gameModel.getLightsaberPrice() + "</html>");
		
		jbStoreItem8.setText("<html>Catapult" + "<br>" 
		        + "Price: " + gameModel.getCatapultPrice() + "</html>");
		
		jbStoreItem9.setText("<html>T.N.T"+ "<br>" 
		        + "Price: " + gameModel.getTntPrice() + "</html>");
		
		jbStoreItem10.setText("<html>Nuclear Bomb" + "<br>" 
		        + "Price: " + gameModel.getMissilePrice() + "</html>");
	}
	
	/**
	 * Changes the visibility of each button accordingly to the user coins.
	 */
	public void setButtonsVisibility() {
		
		// If the user has more coins that the price of Fist, Fist button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getFistPrice()) {
			jbStoreItem1.setEnabled(true);
		} else {
			jbStoreItem1.setEnabled(false);
		}
		
		// If the user has more coins that the price of Rock, Rock button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getRockPrice()) {
			jbStoreItem2.setEnabled(true);
		} else {
			jbStoreItem2.setEnabled(false);
		}
		
		// If the user has more coins that the price of Slingshot, Slingshot button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getSlingshotPrice()) {
			jbStoreItem3.setEnabled(true);
		} else {
			jbStoreItem3.setEnabled(false);
		}
		
		// If the user has more coins that the price of Baseball Bat, Baseball bat button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getBaseballBatPrice()) {
			jbStoreItem4.setEnabled(true);
		} else {
			jbStoreItem4.setEnabled(false);
		}
		
		// If the user has more coins that the price of GolfClub, GolfClub button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getGolfClubPrice()) {
			jbStoreItem5.setEnabled(true);
		} else {
			jbStoreItem5.setEnabled(false);
		}
		
		// If the user has more coins that the price of Katana, Katana button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getKatanaPrice()) {
			jbStoreItem6.setEnabled(true);
		} else {
			jbStoreItem6.setEnabled(false);
		}
		
		// If the user has more coins that the price of Lightsaber, Lightsaber button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getLightsaberPrice()) {
			jbStoreItem7.setEnabled(true);
		} else {
			jbStoreItem7.setEnabled(false);
		}
		
		// If the user has more coins that the price of Catapult, Catapult button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getCatapultPrice()) {
			jbStoreItem8.setEnabled(true);
		} else {
			jbStoreItem8.setEnabled(false);
		}
		
		// If the user has more coins that the price of Tnt, Tnt button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getTntPrice()) {
			jbStoreItem9.setEnabled(true);
		} else {
			jbStoreItem9.setEnabled(false);
		}
		
		// If the user has more coins that the price of Missile, Missile button becomes enabled.
		if (gameModel.getTotalMoney() >= gameModel.getMissilePrice()) {
			jbStoreItem10.setEnabled(true);
		} else {
			jbStoreItem10.setEnabled(false);
		}
		

	}
	
}
