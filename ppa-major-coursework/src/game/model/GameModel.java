package game.model;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Model for the UFO game
 * @author Aakash
 *
 */
public class GameModel extends Observable implements Observer {

	private Item fist;
	private Item rock;
	private Item slingshot;
	private Item baseballBat;
	private Item golfClub;
	private Item katana;
	private Item lightsaber;
	private Item catapult;
	private Item tnt;
	private Item missile;
	private ArrayList<Item> items;
	
	
	private int totalDamage;
	private int totalMoney;
	private UFO ufo;
	
	/**
	 * constructor
	 */
	public GameModel(){
		fist = new Item("Fist", 1, 1, 1.1);
		rock = new Item("Rock", 5, 3, 1.1);
		slingshot = new Item("Slingshot", 20, 10, 1.1);
		baseballBat = new Item("Baseball Bat", 50, 20, 1.1);
		golfClub = new Item("Golf Club", 75, 30, 1.1);
		katana = new Item("Katana", 110, 40, 1.1);
		lightsaber = new Item("Lightsaber", 175, 50, 1.1);
		catapult = new Item("Catapult", 250, 60, 1.1);
		tnt = new Item("TNT", 400, 75, 1.1);
		missile = new Item("Missile", 750, 100, 1.1);
		
		items = new ArrayList<Item>();
		items.add(fist);
		items.add(rock);
		items.add(slingshot);
		items.add(baseballBat);
		items.add(golfClub);
		items.add(katana);
		items.add(lightsaber);
		items.add(catapult);
		items.add(tnt);
		items.add(missile);
		
		ufo = new UFO(1.3, 10);
		ufo.addObserver(this);
		
		totalMoney = 1;
		
		
	}
	
	/**
	 * calculates the total damage from all items owned
	 */
	private void updateTotalDamage(){
		totalDamage = 0;
		for (Item item : items){
			totalDamage += item.getTotalDamage();
		}
		updateObservers();
	}
	
	
	/**
	 * getter method for total damage
	 * @return totalDamage
	 */
	public int getTotalDamage(){
		return totalDamage;
	}
		
	/**
	 * updates observers
	 */
	private void updateObservers(){
		setChanged();
		notifyObservers();
	}
	
	/**
	 * gives the user more money.
	 * @param money
	 */
	public void giveMoney(int money){
		totalMoney =+ money;
	}
	
	/**
	 * if the user has enough money, removes "money" amount of money and returns true
	 * returns false if the user doesn't have enough money
	 * @param money
	 * @return
	 */
	private boolean removeMoney(int money){
		if (totalMoney >= money){
			totalMoney -= money;
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * buys fist
	 */
	public void buyFist(){
		if(removeMoney(fist.getPrice())){
			fist.buyItem();
			updateTotalDamage();
		}
	}
	
	/**
	 * buys rock
	 */
	public void buyRock(){
		if(removeMoney(rock.getPrice())){
			rock.buyItem();
			updateTotalDamage();
		}
	}

	/**
	 * buys slingshot
	 */
	public void buySlingshot(){
		if(removeMoney(slingshot.getPrice())){
			slingshot.buyItem();
			updateTotalDamage();
		}
	}
	
	/**
	 * buys baseball bat
	 */
	public void buyBaseballBat(){
		if(removeMoney(baseballBat.getPrice())){
			baseballBat.buyItem();
			updateTotalDamage();
		}
	}
	
	/**
	 * buys golfClub
	 */
	public void buyGolfClub(){
		if(removeMoney(golfClub.getPrice())){
			golfClub.buyItem();
			updateTotalDamage();
		}
	}
	
	/**
	 * buy katana
	 */
	public void buyKatana(){
		if(removeMoney(katana.getPrice())){
			katana.buyItem();
			updateTotalDamage();
		}
	}
	
	/**
	 * lightsaber
	 */
	public void buyLightsaber(){
		if(removeMoney(lightsaber.getPrice())){
			lightsaber.buyItem();
			updateTotalDamage();
		}
	}
	
	/**
	 * buys catapault
	 */
	public void buyCatapault(){
		if(removeMoney(catapult.getPrice())){
			catapult.buyItem();
			updateTotalDamage();
		}
	}
	
	/**
	 * buys tnt
	 */
	public void buyTNT(){
		if(removeMoney(tnt.getPrice())){
			tnt.buyItem();
			updateTotalDamage();
		}
	}
	
	/**
	 * buys missile
	 */
	public void buyMissile(){
		if(removeMoney(missile.getPrice())){
			missile.buyItem();
			updateTotalDamage();
		}
	}

	/**
	 * getter method for fist level
	 * @return fistLevel
	 */
	public int getFistLevel() {
		return fist.getLevel();
	}

	/**
	 * getter method for rock level
	 * @return rockLevel
	 */
	public int getRockLevel() {
		return rock.getLevel();
	}

	/**
	 * getter method for slingshot level
	 * @return slingshotLevel
	 */
	public int getSlingshotLevel() {
		return slingshot.getLevel();
	}

	/**
	 * getter method for bat level
	 * @return baseballBatLevel
	 */
	public int getBaseballBatLevel() {
		return baseballBat.getLevel();
	}

	/**
	 * getter method for golfclub level
	 * @return golfClubLevel
	 */
	public int getGolfClubLevel() {
		return golfClub.getLevel();
	}

	/**
	 * getter method for katana level
	 * @return katanaLevel
	 */
	public int getKatanaLevel() {
		return katana.getLevel();
	}

	/**
	 * getter method for lightsaber level
	 * @return lightsaberLevel
	 */
	public int getLightsaberLevel() {
		return lightsaber.getLevel();
	}

	/**
	 * getter method for catapault level
	 * @return catapaultLevel
	 */
	public int getCatapultLevel() {
		return catapult.getLevel();
	}

	/**
	 * getter method for tnt level
	 * @return tntLevel
	 */
	public int getTntLevel() {
		return tnt.getLevel();
	}

	/**
	 * getter method for missile level
	 * @return missileLevel
	 */
	public int getMissileLevel() {
		return missile.getLevel();
	}

	/**
	 * getter method for fist total damage
	 * @return fistTotalDamage
	 */
	public int getFistDamage() {
		return fist.getTotalDamage();
	}

	/**
	 * getter method for rock total damage
	 * @return rockTotalDamage
	 */
	public int getRockDamage() {
		return rock.getTotalDamage();
	}

	/**
	 * getter method for slingshot total damage
	 * @return slingshotTotalDamage
	 */
	public int getSlingshotDamage() {
		return slingshot.getTotalDamage();
	}

	/**
	 * getter method for baseballBat total damage
	 * @return baseballBatTotalDamage
	 */
	public int getBaseballBatDamage() {
		return baseballBat.getTotalDamage();
	}

	/**
	 * getter method for golfClub total damage
	 * @return golfClubTotalDamage
	 */
	public int getGolfClubDamage() {
		return golfClub.getTotalDamage();
	}

	/**
	 * getter method for katana total damage
	 * @return katanaTotalDamage
	 */
	public int getKatanaDamage() {
		return katana.getTotalDamage();
	}

	/**
	 * getter method for lightsaber total damage
	 * @return lightsaberTotalDamage
	 */
	public int getLightsaberDamage() {
		return lightsaber.getTotalDamage();
	}

	/**
	 * getter method for catapault total damage
	 * @return catapaultTotalDamage
	 */
	public int getCatapultDamage() {
		return catapult.getTotalDamage();
	}

	/**
	 * getter method for tnt total damage
	 * @return tntTotalDamage
	 */
	public int getTntDamage() {
		return tnt.getTotalDamage();
	}

	/**
	 * getter method for missile total damage
	 * @return missileTotalDamage
	 */
	public int getMissileDamage() {
		return missile.getTotalDamage();
	}
	
	/**
	 * getter method for total money
	 * @return totalMoney
	 */
	public int getTotalMoney() {
		return totalMoney;
	}

	/**
	 * getter method for next fist price
	 * @return fistTotalDamage
	 */
	public int getFistPrice() {
		return fist.getPrice();
	}

	/**
	 * getter method for next rock price
	 * @return rockPrice
	 */
	public int getRockPrice() {
		return rock.getPrice();
	}

	/**
	 * getter method for next slingshot price
	 * @return slingshotPrice
	 */
	public int getSlingshotPrice() {
		return slingshot.getPrice();
	}

	/**
	 * getter method for next baseballBat price
	 * @return baseballBatPrice
	 */
	public int getBaseballBatPrice() {
		return baseballBat.getPrice();
	}

	/**
	 * getter method for next golfClub price
	 * @return golfClubPrice
	 */
	public int getGolfClubPrice() {
		return golfClub.getPrice();
	}

	/**
	 * getter method for katana fist price
	 * @return katanaPrice
	 */
	public int getKatanaPrice() {
		return katana.getPrice();
	}

	/**
	 * getter method for next lightsaber price
	 * @return lightsaberPrice
	 */
	public int getLightsaberPrice() {
		return lightsaber.getPrice();
	}

	/**
	 * getter method for next catapault price
	 * @return catapaultPrice
	 */
	public int getCatapultPrice() {
		return catapult.getPrice();
	}

	/**
	 * getter method for next tnt price
	 * @return tntPrice
	 */
	public int getTntPrice() {
		return tnt.getPrice();
	}

	/**
	 * getter method for next missile price
	 * @return missilePrice
	 */
	public int getMissilePrice() {
		return missile.getPrice();
	}

	
	/**
	 * getter method for ufo's level
	 * @return ufoLevel
	 */
	public int getUfoLevel() {
		return ufo.getLevel();
	}

	/**
	 * getter method for ufo's maximum health
	 * @return ufoMaxHealth
	 */
	public int getUfoMaxHealth() {
		return ufo.getMaxHealth();
	}
	
	/**
	 * getter method for ufo's current health
	 * @return ufoCurrentHealth
	 */
	public int getUfoHealth() {
		return ufo.getHealth();
	}
	
	/**
	 * method to hit ufo
	 */
	public void hitUFO() {
		ufo.hitUFO(totalDamage);
	}

	/**
	 * updates observers
	 */
	@Override
	public void update(Observable o, Object arg) {
		totalMoney += ufo.getReward();
		updateObservers();
	}
	
	
}
