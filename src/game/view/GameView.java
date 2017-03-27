package game.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import game.controller.ButtonListener;
import game.controller.UfoListener;
import game.model.ClickModel;

public class GameView extends JFrame implements Observer{

	private StoreItems storeItems;
	private ClickModel clickObsv;

	public GameView() throws IOException {
		
		super("Clicker Game");
		this.setPreferredSize(new Dimension(800,800));
		
		storeItems = new StoreItems();
		clickObsv = new ClickModel();
		initWidgets();
		
		
	}
	
	
	
	private void initWidgets() {
		
		JPanel jpDisplay = new JPanel(new BorderLayout());
		JPanel jpEast = new JPanel(new BorderLayout());
		JPanel jpEastStore = new JPanel(new GridLayout(11,1));
		JPanel jpCenter = new JPanel(new BorderLayout());
		JPanel jpCenterNorth = new JPanel(new BorderLayout());
		JPanel jpWest = new JPanel(new BorderLayout());
		JPanel jpWestInfo = new JPanel(new GridLayout(11,1));
		
		
		JLabel jlUfoCounter = new JLabel("UFO sighted", SwingConstants.CENTER);
		JLabel jlInfo = new JLabel("Info: ", SwingConstants.CENTER);
		JLabel jlStore = new JLabel("Store: ", SwingConstants.CENTER);
		JLabel jlCounter = new JLabel("Counter");
		
		JButton jbStoreItem1 = new JButton("Fist");
		jbStoreItem1.setBorderPainted( false );
		jbStoreItem1.setIcon(new ImageIcon(storeItems.getImageFist()));
		JButton jbStoreItem2 = new JButton("Rock");
		jbStoreItem2.setBorderPainted( false );
		jbStoreItem2.setIcon(new ImageIcon(storeItems.getImageRock()));
		JButton jbStoreItem3 = new JButton("Slingshot");
		jbStoreItem3.setBorderPainted( false );
		jbStoreItem3.setIcon(new ImageIcon(storeItems.getImageSlingshot()));
		JButton jbStoreItem4 = new JButton("Baseball bat");
		jbStoreItem4.setBorderPainted( false );
		jbStoreItem4.setIcon(new ImageIcon(storeItems.getImageBaseballBat()));
		JButton jbStoreItem5 = new JButton("Golf club");
		jbStoreItem5.setBorderPainted( false );
		jbStoreItem5.setIcon(new ImageIcon(storeItems.getImageGolfClub()));
		JButton jbStoreItem6 = new JButton("Katana");
		jbStoreItem6.setBorderPainted( false );
		jbStoreItem6.setIcon(new ImageIcon(storeItems.getImageKatana()));
		JButton jbStoreItem7 = new JButton("Lightsaber");
		jbStoreItem7.setBorderPainted( false );
		jbStoreItem7.setIcon(new ImageIcon(storeItems.getImageLightsaber()));
		JButton jbStoreItem8 = new JButton("Catapult");
		jbStoreItem8.setBorderPainted( false );
		jbStoreItem8.setIcon(new ImageIcon(storeItems.getImageCatapult()));
		JButton jbStoreItem9 = new JButton("T.N.T");
		jbStoreItem9.setIcon(new ImageIcon(storeItems.getImageTnt()));
		jbStoreItem9.setBorderPainted( false );
		JButton jbStoreItem10 = new JButton("Nuclear Bomb");
		jbStoreItem10.setIcon(new ImageIcon(storeItems.getImageNuclearBomb()));
		jbStoreItem10.setBorderPainted( false );
		
		
		JLabel jlInfoItem1 = new JLabel("Info 1");
		jlInfoItem1.setIcon(new ImageIcon(storeItems.getImageFist()));
		
		JLabel jlInfoItem2 = new JLabel("Info 2");
		jlInfoItem2.setIcon(new ImageIcon(storeItems.getImageRock()));
		
		JLabel jlInfoItem3 = new JLabel("Info 3");
		jlInfoItem3.setIcon(new ImageIcon(storeItems.getImageSlingshot()));
		
		JLabel jlInfoItem4 = new JLabel("Info 4");
		jlInfoItem4.setIcon(new ImageIcon(storeItems.getImageBaseballBat()));
		
		JLabel jlInfoItem5 = new JLabel("Info 5");
		jlInfoItem5.setIcon(new ImageIcon(storeItems.getImageGolfClub()));
		
		JLabel jlInfoItem6 = new JLabel("Info 6");
		jlInfoItem6.setIcon(new ImageIcon(storeItems.getImageKatana()));
		
		JLabel jlInfoItem7 = new JLabel("Info 7");
		jlInfoItem7.setIcon(new ImageIcon(storeItems.getImageLightsaber()));
		
		JLabel jlInfoItem8 = new JLabel("Info 8");
		jlInfoItem8.setIcon(new ImageIcon(storeItems.getImageCatapult()));
		
		JLabel jlInfoItem9 = new JLabel("Info 9");
		jlInfoItem9.setIcon(new ImageIcon(storeItems.getImageTnt()));
		
		JLabel jlInfoItem10 = new JLabel("Info 10");
		jlInfoItem10.setIcon(new ImageIcon(storeItems.getImageNuclearBomb()));
		
		
		JLabel jlUfoCharacter = new JLabel();
		jlUfoCharacter.setIcon(new ImageIcon(storeItems.getImageUfo1()));
		jlUfoCharacter.setHorizontalAlignment(JLabel.CENTER);
		jlUfoCharacter.addMouseListener(new UfoListener(clickObsv));
		
		
		JButton jbClicker = new JButton("Find");
		jbClicker.addActionListener(new ButtonListener());
		
	
		
		
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
		jpCenterNorth.add(jlCounter, BorderLayout.WEST);
		jpCenterNorth.add(jlUfoCounter, BorderLayout.CENTER);
		jpCenter.add(jpCenterNorth, BorderLayout.NORTH);
		jpCenter.add(jlUfoCharacter);
		jpWest.add(jpWestInfo);
		
		jpCenter.add(jbClicker, BorderLayout.SOUTH);
		
		
		jpDisplay.add(jpEast, BorderLayout.EAST);
		jpDisplay.add(jpCenter, BorderLayout.CENTER);
		jpDisplay.add(jpWest, BorderLayout.WEST);
		
		add(jpDisplay);
		
		
		pack();
		setVisible(true);
		
	}
	
//	public void drawUfo (String input){
//		 
//	    Ufo ufo = new Ufo(input);
//        
//        add (ufo);
//        
//        
//	}



	public static void main(String[] args) throws IOException {
		
		GameView gameView = new GameView();
	}


	@Override
	public void update(Observable o, Object arg) {
		
		
	}
	
	
	public void setButtonsEnable(int coins) {
		
		
		
	}
	
}
