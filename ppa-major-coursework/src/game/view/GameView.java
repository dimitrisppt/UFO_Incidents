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



public class GameView extends JPanel implements Observer{

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
	
	public GameView() throws IOException {
		
		
		this.setPreferredSize(new Dimension(600,600));
		this.setSize(new Dimension(600,600));
		
		
		clickObsv = new ClickModel();
		gameModel = new GameModel();
		storeItems = new GameIconCreator(gameModel);
		initWidgets();
		setButtonsVisibility();
		gameModel.addObserver(this);
		this.setOpaque(false);
		
		
	}
	
	
	
	private void initWidgets() {
		
		JPanel jpDisplay = new JPanel(new BorderLayout());
		JPanel jpEast = new JPanel(new BorderLayout());
		JPanel jpEastStore = new JPanel(new GridLayout(12,1));
		JPanel jpCenter = new JPanel(new BorderLayout());
		JPanel jpCenterNorth = new JPanel(new BorderLayout());
		JPanel jpWest = new JPanel(new BorderLayout());
		JPanel jpWestInfo = new JPanel(new GridLayout(12,1));
		JPanel jpCenterCenterNorth = new JPanel();
		JPanel jpCenterCenter = new JPanel(new BorderLayout());
		JPanel jpSouth = new JPanel(new BorderLayout());
		JPanel jpSouthEast = new JPanel(new BorderLayout());
		
		jpEast.setOpaque(false);
		jpEastStore.setOpaque(false);
		jpCenter.setOpaque(false);
		jpCenterNorth.setOpaque(false);
		jpWest.setOpaque(false);
		jpWestInfo.setOpaque(false);
		jpCenterCenterNorth.setOpaque(false);
		jpCenterCenter.setOpaque(false);
		
		
		
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
		
		jbStoreItem1 = new JButton("<html>Fist" + "<br>" 
		        + "Price: " + gameModel.getFistPrice() + "</html>");
		jbStoreItem1.setBorderPainted( false );
		jbStoreItem1.addActionListener(new FistButtonListener(gameModel));
		jbStoreItem1.setIcon(new ImageIcon(storeItems.getImageFist()));
		jbStoreItem1.setOpaque(false);
		jbStoreItem2 = new JButton("<html>Rock"+ "<br>" 
		        + "Price: " + gameModel.getRockPrice() + "</html>");
		jbStoreItem2.setBorderPainted( false );
		jbStoreItem2.addActionListener(new RockButtonListener(gameModel));
		jbStoreItem2.setIcon(new ImageIcon(storeItems.getImageRock()));
		jbStoreItem2.setOpaque(false);
		jbStoreItem3 = new JButton("<html>Slingshot" + "<br>" 
		        + "Price: " + gameModel.getSlingshotPrice() + "</html>");
		jbStoreItem3.setBorderPainted( false );
		jbStoreItem3.addActionListener(new SlingshotButtonListener(gameModel));
		jbStoreItem3.setIcon(new ImageIcon(storeItems.getImageSlingshot()));
		jbStoreItem3.setOpaque(false);
		jbStoreItem4 = new JButton("<html>Baseball bat"+ "<br>" 
		        + "Price: " + gameModel.getBaseballBatPrice() + "</html>");
		jbStoreItem4.setBorderPainted( false );
		jbStoreItem4.addActionListener(new BaseballBatButtonListener(gameModel));
		jbStoreItem4.setIcon(new ImageIcon(storeItems.getImageBaseballBat()));
		jbStoreItem4.setOpaque(false);
		jbStoreItem5 = new JButton("<html>Golf club"+ "<br>" 
		        + "Price: " + gameModel.getGolfClubPrice() + "</html>");
		jbStoreItem5.setBorderPainted( false );
		jbStoreItem5.addActionListener(new GolfClubButtonListener(gameModel));
		jbStoreItem5.setIcon(new ImageIcon(storeItems.getImageGolfClub()));
		jbStoreItem5.setOpaque(false);
		jbStoreItem6 = new JButton("<html>Katana"+ "<br>" 
		        + "Price: " + gameModel.getKatanaPrice() + "</html>");
		jbStoreItem6.setBorderPainted( false );
		jbStoreItem6.addActionListener(new KatanaButtonListener(gameModel));
		jbStoreItem6.setIcon(new ImageIcon(storeItems.getImageKatana()));
		jbStoreItem6.setOpaque(false);
		jbStoreItem7 = new JButton("<html>Lightsaber" + "<br>" 
		        + "Price: " + gameModel.getLightsaberPrice() + "</html>");
		jbStoreItem7.setBorderPainted( false );
		jbStoreItem7.addActionListener(new LightsaberButtonListener(gameModel));
		jbStoreItem7.setIcon(new ImageIcon(storeItems.getImageLightsaber()));
		jbStoreItem7.setOpaque(false);
		jbStoreItem8 = new JButton("<html>Catapult" + "<br>" 
		        + "Price: " + gameModel.getCatapultPrice() + "</html>");
		jbStoreItem8.setBorderPainted( false );
		jbStoreItem8.addActionListener(new CatapultButtonListener(gameModel));
		jbStoreItem8.setIcon(new ImageIcon(storeItems.getImageCatapult()));
		jbStoreItem8.setOpaque(false);
		jbStoreItem9 = new JButton("<html>T.N.T"+ "<br>" 
		        + "Price: " + gameModel.getTntPrice() + "</html>");
		jbStoreItem9.setIcon(new ImageIcon(storeItems.getImageTnt()));
		jbStoreItem9.addActionListener(new TntButtonListener(gameModel));
		jbStoreItem9.setBorderPainted( false );
		jbStoreItem9.setOpaque(false);
		jbStoreItem10 = new JButton("<html>Nuclear Bomb" + "<br>" 
		        + "Price: " + gameModel.getMissilePrice() + "</html>");
		jbStoreItem10.setIcon(new ImageIcon(storeItems.getImageNuclearBomb()));
		jbStoreItem10.addActionListener(new NuclearBombButtonListener(gameModel));
		jbStoreItem10.setBorderPainted( false );
		jbStoreItem10.setOpaque(false);
		
		
		progressBar = new JProgressBar(0, gameModel.getUfoMaxHealth());
		progressBar.setValue(gameModel.getUfoMaxHealth());
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.RED);
		progressBar.setString(gameModel.getUfoHealth() + " /" + gameModel.getUfoMaxHealth());
		
		
		jlInfoItem1 = new JLabel("<html>Fist's Level: " + gameModel.getFistLevel() + "<br>" 
		        + "Fist's Damage: " + gameModel.getFistDamage() + "</html>");
		
		jlInfoItem1.setIcon(new ImageIcon(storeItems.getImageFist()));
		jlInfoItem1.setForeground(Color.WHITE);
		
		jlInfoItem2 = new JLabel("<html>Rock's Level: " + gameModel.getRockLevel() + "<br>" 
		        + "Rock's Damage: " + gameModel.getRockDamage() + "</html>");
		jlInfoItem2.setIcon(new ImageIcon(storeItems.getImageRock()));
		jlInfoItem2.setForeground(Color.WHITE);
		
		jlInfoItem3 = new JLabel("<html>Slingshot's Level: " + gameModel.getSlingshotLevel() + "<br>" 
		        + "Slingshot's Damage: " + gameModel.getSlingshotDamage() + "</html>");
		jlInfoItem3.setIcon(new ImageIcon(storeItems.getImageSlingshot()));
		jlInfoItem3.setForeground(Color.WHITE);
		
		jlInfoItem4 = new JLabel("<html>Baseball Bat's Level: " + gameModel.getBaseballBatLevel() + "<br>" 
		        + "Baseball Bat's Damage: " + gameModel.getBaseballBatDamage() + "</html>");
		jlInfoItem4.setIcon(new ImageIcon(storeItems.getImageBaseballBat()));
		jlInfoItem4.setForeground(Color.WHITE);
		
		jlInfoItem5 = new JLabel("<html>Golf Club's Level: " + gameModel.getGolfClubLevel() + "<br>" 
		        + "GolfClub's Damage: " + gameModel.getGolfClubDamage() + "</html>");
		jlInfoItem5.setIcon(new ImageIcon(storeItems.getImageGolfClub()));
		jlInfoItem5.setForeground(Color.WHITE);
		
		jlInfoItem6 = new JLabel("<html>Katana's Level: " + gameModel.getKatanaLevel() + "<br>" 
		        + "Katana's Damage: " + gameModel.getKatanaDamage() + "</html>");
		jlInfoItem6.setIcon(new ImageIcon(storeItems.getImageKatana()));
		jlInfoItem6.setForeground(Color.WHITE);
		
		jlInfoItem7 = new JLabel("<html>Lightsaber's Level: " + gameModel.getLightsaberLevel() + "<br>" 
		        + "Lightsaber's Damage: " + gameModel.getLightsaberDamage() + "</html>");
		jlInfoItem7.setIcon(new ImageIcon(storeItems.getImageLightsaber()));
		jlInfoItem7.setForeground(Color.WHITE);
		
		jlInfoItem8 = new JLabel("<html>Catapult's Level: " + gameModel.getCatapultLevel() + "<br>" 
		        + "Catapult's Damage: " + gameModel.getCatapultDamage() + "</html>");
		jlInfoItem8.setIcon(new ImageIcon(storeItems.getImageCatapult()));
		jlInfoItem8.setForeground(Color.WHITE);
		
		jlInfoItem9 = new JLabel("<html>T.N.T's Level: " + gameModel.getTntLevel() + "<br>" 
		        + "T.N.T's Damage: " + gameModel.getTntDamage() + "</html>");
		jlInfoItem9.setIcon(new ImageIcon(storeItems.getImageTnt()));
		jlInfoItem9.setForeground(Color.WHITE);
		
		jlInfoItem10 = new JLabel("<html>Nuclear Bomb's Level: " + gameModel.getMissileLevel() + "<br>" 
		        + "Nuclear Bomb's Damage: " + gameModel.getMissileDamage() + "</html>");
		jlInfoItem10.setIcon(new ImageIcon(storeItems.getImageNuclearBomb()));
		jlInfoItem10.setForeground(Color.WHITE);
		
		
		jlUfoCharacter = new JLabel();
		jlUfoCharacter.setIcon(new ImageIcon(storeItems.getImageUfo1()));
		jlUfoCharacter.setHorizontalAlignment(JLabel.CENTER);
		jlUfoCharacter.addMouseListener(new GameUfoListener(clickObsv, gameModel));
		
		
		infoButton = new JButton("Help");
		infoButton.addActionListener(new InfoButtonListener());
		
		
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
		
		jpSouthEast.add(infoButton, BorderLayout.WEST);
		jpSouthEast.setOpaque(false);
		jpSouth.add(jpSouthEast, BorderLayout.NORTH);
		jpSouth.setOpaque(false);
		
		jpWestInfo.add(jpSouth);
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
		
		jpEast.add(jpEastStore);
		jpCenterNorth.add(jlTotalMoney, BorderLayout.WEST);
		jpCenterNorth.add(jlUfo, BorderLayout.CENTER);
		jpCenter.add(jpCenterNorth, BorderLayout.NORTH);
		jpCenterCenterNorth.add(progressBar);
		jpCenterCenter.add(jpCenterCenterNorth, BorderLayout.NORTH);
		jpCenterCenter.add(jlUfoCharacter, BorderLayout.CENTER);
		jpCenter.add(jpCenterCenter, BorderLayout.CENTER);
		
		
		
		jpWest.add(jpWestInfo);
		
		
		jpDisplay.add(jpEast, BorderLayout.EAST);
		jpDisplay.add(jpCenter, BorderLayout.CENTER);
		jpDisplay.add(jpWest, BorderLayout.WEST);
		
		add(jpDisplay);
		jpDisplay.setOpaque(false);
		jpDisplay.setPreferredSize(new Dimension(1000,750));
		
		setVisible(true);
		
	}



	@Override
	public void update(Observable o, Object arg) {
		
		jlUfoCharacter.setIcon(new ImageIcon(storeItems.changeUfoIcon()));
		
		setButtonsVisibility();
		progressBar.setMaximum(gameModel.getUfoMaxHealth());
		progressBar.setValue(gameModel.getUfoHealth());
		progressBar.setString(gameModel.getUfoHealth() + " /" + gameModel.getUfoMaxHealth());
		
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
	
	
	public void setButtonsVisibility() {
		
		if (gameModel.getTotalMoney() >= gameModel.getFistPrice()) {
			jbStoreItem1.setEnabled(true);
		} else {
			jbStoreItem1.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getRockPrice()) {
			jbStoreItem2.setEnabled(true);
		} else {
			jbStoreItem2.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getSlingshotPrice()) {
			jbStoreItem3.setEnabled(true);
		} else {
			jbStoreItem3.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getBaseballBatPrice()) {
			jbStoreItem4.setEnabled(true);
		} else {
			jbStoreItem4.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getGolfClubPrice()) {
			jbStoreItem5.setEnabled(true);
		} else {
			jbStoreItem5.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getKatanaPrice()) {
			jbStoreItem6.setEnabled(true);
		} else {
			jbStoreItem6.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getLightsaberPrice()) {
			jbStoreItem7.setEnabled(true);
		} else {
			jbStoreItem7.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getCatapultPrice()) {
			jbStoreItem8.setEnabled(true);
		} else {
			jbStoreItem8.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getTntPrice()) {
			jbStoreItem9.setEnabled(true);
		} else {
			jbStoreItem9.setEnabled(false);
		}
		
		if (gameModel.getTotalMoney() >= gameModel.getMissilePrice()) {
			jbStoreItem10.setEnabled(true);
		} else {
			jbStoreItem10.setEnabled(false);
		}
		

	}
	
}
