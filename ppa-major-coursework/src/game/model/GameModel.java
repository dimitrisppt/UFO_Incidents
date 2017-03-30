package game.model;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

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
		
		ufo = new UFO(1.5, 10);
		ufo.addObserver(this);
		
		totalMoney = 1;
		
		
	}
	
	private void updateTotalDamage(){
		totalDamage = 0;
		for (Item item : items){
			totalDamage += item.getTotalDamage();
		}
		updateObservers();
	}
	
	
	public int getTotalDamage(){
		return totalDamage;
	}
		
	private void updateObservers(){
		setChanged();
		notifyObservers();
	}
	
	public void giveMoney(int money){
		totalMoney =+ money;
	}
	
	private boolean removeMoney(int money){
		if (totalMoney >= money){
			totalMoney -= money;
			return true;
		}else{
			return false;
		}
	}
	
	
	
	public void buyFist(){
		if(removeMoney(fist.getPrice())){
			fist.buyItem();
			updateTotalDamage();
		}
	}
	
	public void buyRock(){
		if(removeMoney(rock.getPrice())){
			rock.buyItem();
			updateTotalDamage();
		}
	}

	public void buySlingshot(){
		if(removeMoney(slingshot.getPrice())){
			slingshot.buyItem();
			updateTotalDamage();
		}
	}
	
	public void buyBaseballBat(){
		if(removeMoney(baseballBat.getPrice())){
			baseballBat.buyItem();
			updateTotalDamage();
		}
	}
	
	public void buyGolfClub(){
		if(removeMoney(golfClub.getPrice())){
			golfClub.buyItem();
			updateTotalDamage();
		}
	}
	
	public void buyKatana(){
		if(removeMoney(katana.getPrice())){
			katana.buyItem();
			updateTotalDamage();
		}
	}
	
	public void buyLightsaber(){
		if(removeMoney(lightsaber.getPrice())){
			lightsaber.buyItem();
			updateTotalDamage();
		}
	}
	
	public void buyCatapault(){
		if(removeMoney(catapult.getPrice())){
			catapult.buyItem();
			updateTotalDamage();
		}
	}
	
	public void buyTNT(){
		if(removeMoney(tnt.getPrice())){
			tnt.buyItem();
			updateTotalDamage();
		}
	}
	
	public void buyMissile(){
		if(removeMoney(missile.getPrice())){
			missile.buyItem();
			updateTotalDamage();
		}
	}

	public int getFistLevel() {
		return fist.getLevel();
	}

	public int getRockLevel() {
		return rock.getLevel();
	}

	public int getSlingshotLevel() {
		return slingshot.getLevel();
	}

	public int getBaseballBatLevel() {
		return baseballBat.getLevel();
	}

	public int getGolfClubLevel() {
		return golfClub.getLevel();
	}

	public int getKatanaLevel() {
		return katana.getLevel();
	}

	public int getLightsaberLevel() {
		return lightsaber.getLevel();
	}

	public int getCatapultLevel() {
		return catapult.getLevel();
	}

	public int getTntLevel() {
		return tnt.getLevel();
	}

	public int getMissileLevel() {
		return missile.getLevel();
	}


	public int getFistDamage() {
		return fist.getTotalDamage();
	}

	public int getRockDamage() {
		return rock.getTotalDamage();
	}

	public int getSlingshotDamage() {
		return slingshot.getTotalDamage();
	}

	public int getBaseballBatDamage() {
		return baseballBat.getTotalDamage();
	}

	public int getGolfClubDamage() {
		return golfClub.getTotalDamage();
	}

	public int getKatanaDamage() {
		return katana.getTotalDamage();
	}

	public int getLightsaberDamage() {
		return lightsaber.getTotalDamage();
	}

	public int getCatapultDamage() {
		return catapult.getTotalDamage();
	}

	public int getTntDamage() {
		return tnt.getTotalDamage();
	}

	public int getMissileDamage() {
		return missile.getTotalDamage();
	}
	
	public int getTotalMoney() {
		return totalMoney;
	}

	public int getFistPrice() {
		return fist.getPrice();
	}

	public int getRockPrice() {
		return rock.getPrice();
	}

	public int getSlingshotPrice() {
		return slingshot.getPrice();
	}

	public int getBaseballBatPrice() {
		return baseballBat.getPrice();
	}

	public int getGolfClubPrice() {
		return golfClub.getPrice();
	}

	public int getKatanaPrice() {
		return katana.getPrice();
	}

	public int getLightsaberPrice() {
		return lightsaber.getPrice();
	}

	public int getCatapultPrice() {
		return catapult.getPrice();
	}

	public int getTntPrice() {
		return tnt.getPrice();
	}

	public int getMissilePrice() {
		return missile.getPrice();
	}

	public int getUfoLevel() {
		return ufo.getLevel();
	}

	public int getUfoMaxHealth() {
		return ufo.getMaxHealth();
	}
	
	public int getUfoHealth() {
		return ufo.getHealth();
	}
	
	public void hitUFO() {
		ufo.hitUFO(totalDamage);
	}

	@Override
	public void update(Observable o, Object arg) {
		totalMoney += ufo.getReward();
		updateObservers();
	}
	
	
}
