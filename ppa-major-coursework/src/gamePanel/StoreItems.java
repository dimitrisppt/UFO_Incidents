package gamePanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StoreItems {

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

	private int attack;
	private BufferedImage image;
	private int price;
	
	
	public StoreItems() throws IOException {
		
		imageFist = ImageIO.read(new File("src/MajorProjectGameIcons/fist.png"));
		imageRock = ImageIO.read(new File("src/MajorProjectGameIcons/rock.png"));
		imageSlingshot = ImageIO.read(new File("src/MajorProjectGameIcons/slingshot.png"));
		imageBaseballBat = ImageIO.read(new File("src/MajorProjectGameIcons/baseballbat.png"));
		imageGolfClub = ImageIO.read(new File("src/MajorProjectGameIcons/sniper.png"));
		imageKatana = ImageIO.read(new File("src/MajorProjectGameIcons/katana.png"));
		imageLightsaber = ImageIO.read(new File("src/MajorProjectGameIcons/bluelightsaber.png"));
		imageCatapult = ImageIO.read(new File("src/MajorProjectGameIcons/catapult.png"));
		imageTnt = ImageIO.read(new File("src/MajorProjectGameIcons/tnt.png"));
		imageNuclearBomb = ImageIO.read(new File("src/MajorProjectGameIcons/nuclearbomb.png"));
		
		ufo1 = ImageIO.read(new File("src/Ufos/Ufo1.png"));
		ufo2 = ImageIO.read(new File("src/Ufos/Ufo2.png"));
		ufo3 = ImageIO.read(new File("src/Ufos/Ufo3.png"));
		ufo4 = ImageIO.read(new File("src/Ufos/Ufo4.png"));
		ufo5 = ImageIO.read(new File("src/Ufos/Ufo5.png"));
		ufo6 = ImageIO.read(new File("src/Ufos/Ufo6.png"));
		ufo7 = ImageIO.read(new File("src/Ufos/Ufo7.png"));
		ufo8 = ImageIO.read(new File("src/Ufos/Ufo8.png"));
		
		
	}
	
	public int getItemAttackValue() {
		return attack;
	}
	
	public int getItemPrice() {
		return price;
	}
	
	public BufferedImage getItemImage() {
		return image;
	}
	
	
	
	
	
	

	public BufferedImage getImageFist() {
		return imageFist;
	}

	public BufferedImage getImageRock() {
		return imageRock;
	}

	public BufferedImage getImageSlingshot() {
		return imageSlingshot;
	}

	public BufferedImage getImageBaseballBat() {
		return imageBaseballBat;
	}

	public BufferedImage getImageGolfClub() {
		return imageGolfClub;
	}

	public BufferedImage getImageKatana() {
		return imageKatana;
	}

	public BufferedImage getImageLightsaber() {
		return imageLightsaber;
	}

	public BufferedImage getImageCatapult() {
		return imageCatapult;
	}

	public BufferedImage getImageTnt() {
		return imageTnt;
	}

	public BufferedImage getImageNuclearBomb() {
		return imageNuclearBomb;
	}
	
	public BufferedImage getImageUfo1() {
		return ufo1;
	}


	public BufferedImage getImageUfo2() {
		return ufo2;
	}

	public BufferedImage getImageUfo3() {
		return ufo3;
	}

	public BufferedImage getImageUfo4() {
		return ufo4;
	}
	public BufferedImage getImageUfo5() {
		return ufo5;
	}

	public BufferedImage getImageUfo6() {
		return ufo6;
	}

	public BufferedImage getImageUfo7() {
		return ufo7;
	}

	public BufferedImage getImageUfo8() {
		return ufo8;
	}

	

}
