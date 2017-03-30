package game.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import game.model.GameModel;

/**
 * This class is used to read and provide game icons to the game view.
 * 
 * @author Dimitris Papatheodoulou
 *
 */
public class GameIconCreator {


	// Declaring fields that will hold images.
	private BufferedImage imageFist;
	private BufferedImage imageRock;
	private BufferedImage imageSlingshot;
	private BufferedImage imageBaseballBat;
	private BufferedImage imageGolfClub;
	private BufferedImage imageKatana;
	private BufferedImage imageLightsaber;
	private BufferedImage imageCatapult;
	private BufferedImage imageTnt;
	private BufferedImage imageNuclearBomb;
	private BufferedImage ufo1;
	private BufferedImage ufo2;
	private BufferedImage ufo3;
	private BufferedImage ufo4;
	private BufferedImage ufo5;
	private BufferedImage ufo6;
	private BufferedImage ufo7;
	private BufferedImage ufo8;
	
	// Declaring array of Ufo Icons
	private BufferedImage[] arrayOfUfoIcons;
	// Declaring other fields.
	private int attack;
	private int price;
	private GameModel gameModel;
	private int ufoIndex;
	private boolean changedIcon;
	
	/**
	 * The constructor receives a parameter of type GameModel,
	 * initialises all fields with images and adds the ufo images to an array.
	 * 
	 * @param gameModel
	 * @throws IOException
	 */
	public GameIconCreator(GameModel gameModel) throws IOException {
		
		// Reads all the item's icons and initialises the fields accordingly to the path.
		imageFist = ImageIO.read(new File("src/game/view/fist.png"));
		imageRock = ImageIO.read(new File("src/game/view/rock.png"));
		imageSlingshot = ImageIO.read(new File("src/game/view/slingshot.png"));
		imageBaseballBat = ImageIO.read(new File("src/game/view/baseballbat.png"));
		imageGolfClub = ImageIO.read(new File("src/game/view/golfClub.png"));
		imageKatana = ImageIO.read(new File("src/game/view/katana.png"));
		imageLightsaber = ImageIO.read(new File("src/game/view/bluelightsaber.png"));
		imageCatapult = ImageIO.read(new File("src/game/view/catapult.png"));
		imageTnt = ImageIO.read(new File("src/game/view/tnt.png"));
		imageNuclearBomb = ImageIO.read(new File("src/game/view/nuclearbomb.png"));
		
		// Reads all the ufo's icons and initialises the fields accordingly to the path.
		ufo1 = ImageIO.read(new File("src/game/view/Ufo1.png"));
		ufo2 = ImageIO.read(new File("src/game/view/Ufo2.png"));
		ufo3 = ImageIO.read(new File("src/game/view/Ufo3.png"));
		ufo4 = ImageIO.read(new File("src/game/view/Ufo4.png"));
		ufo5 = ImageIO.read(new File("src/game/view/Ufo5.png"));
		ufo6 = ImageIO.read(new File("src/game/view/Ufo6.png"));
		ufo7 = ImageIO.read(new File("src/game/view/Ufo7.png"));
		ufo8 = ImageIO.read(new File("src/game/view/Ufo8.png"));
		
		this.gameModel = gameModel;

		// Creates a new array of BufferedImages with 8 positions.
		arrayOfUfoIcons = new BufferedImage[8];
		arrayOfUfoIcons[0] = ufo1;
		arrayOfUfoIcons[1] = ufo2;
		arrayOfUfoIcons[2] = ufo3;
		arrayOfUfoIcons[3] = ufo4;
		arrayOfUfoIcons[4] = ufo5;
		arrayOfUfoIcons[5] = ufo6;
		arrayOfUfoIcons[6] = ufo7;
		arrayOfUfoIcons[7] = ufo8;
		changedIcon = false;
		
	}
	
	/**
	 * @return attack
	 */
	public int getItemAttackValue() {
		return attack;
	}
	
	/**
	 * @return price
	 */
	public int getItemPrice() {
		return price;
	}
	
	/**
	 * @return imageFist
	 */
	public BufferedImage getImageFist() {
		return imageFist;
	}

	/**
	 * @return imageRock
	 */
	public BufferedImage getImageRock() {
		return imageRock;
	}

	/**
	 * @return imageSlingshot
	 */
	public BufferedImage getImageSlingshot() {
		return imageSlingshot;
	}

	/**
	 * @return imageBaseballBat
	 */
	public BufferedImage getImageBaseballBat() {
		return imageBaseballBat;
	}

	/**
	 * @return imageGolfClub
	 */
	public BufferedImage getImageGolfClub() {
		return imageGolfClub;
	}

	/**
	 * @return imageKatana
	 */
	public BufferedImage getImageKatana() {
		return imageKatana;
	}

	/**
	 * @return imageLightsaber
	 */
	public BufferedImage getImageLightsaber() {
		return imageLightsaber;
	}

	/**
	 * @return imageCatapult
	 */
	public BufferedImage getImageCatapult() {
		return imageCatapult;
	}

	/**
	 * @return imageTnt
	 */
	public BufferedImage getImageTnt() {
		return imageTnt;
	}
	
	/**
	 * @return imageNuclearBomb
	 */
	public BufferedImage getImageNuclearBomb() {
		return imageNuclearBomb;
	}
	
	/**
	 * @return ufo1
	 */
	public BufferedImage getImageUfo1() {
		return ufo1;
	}

	/**
	 * @return ufo2
	 */
	public BufferedImage getImageUfo2() {
		return ufo2;
	}

	/**
	 * @return ufo3
	 */
	public BufferedImage getImageUfo3() {
		return ufo3;
	}

	/**
	 * @return ufo4
	 */
	public BufferedImage getImageUfo4() {
		return ufo4;
	}
	
	/**
	 * @return ufo5
	 */
	public BufferedImage getImageUfo5() {
		return ufo5;
	}

	/**
	 * @return ufo6
	 */
	public BufferedImage getImageUfo6() {
		return ufo6;
	}

	/**
	 * @return ufo7
	 */
	public BufferedImage getImageUfo7() {
		return ufo7;
	}

	/**
	 * @return ufo8
	 */
	public BufferedImage getImageUfo8() {
		return ufo8;
	}

	/**
	 * Changes the ufo icon with the next icon in the arrayOfUfoIcons after
	 * every 10 levels.
	 * 
	 * @return BufferedImage
	 */
	public BufferedImage changeUfoIcon(){
		if (gameModel.getUfoLevel() % 10 == 0){
			if(!changedIcon){
				ufoIndex = (ufoIndex+1)%8;
				changedIcon = true;
			}
		}else{
			changedIcon = false;
		}
		return arrayOfUfoIcons[ufoIndex];
	}
	

}
