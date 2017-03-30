package game.model;

/**
 * class to represent an item in the UFO game
 * @author Aakash
 *
 */
public class Item {

	private final String name;
	private final int baseCost;
	private int level;
	private final int baseDamage;
	private final double multiplier;
	private int cost;
	private int damage;
	
	/**
	 * constructor. sets name, base cost, base damage and multiplier.
	 * @param name
	 * @param baseCost
	 * @param baseDamage
	 * @param multiplier
	 */
	public Item(String name, int baseCost, int baseDamage, double multiplier){
		this.name = name;
		this.baseCost = baseCost;
		this.baseDamage = baseDamage;
		this.multiplier = multiplier;
		updateInfo();
	}
	
	/**
	 * updates the cost of the next purchase for item and the total damage based on number of item owned
	 */
	private void updateInfo(){
		//Price = BaseCost x Multiplier^NumberOwned
		cost = (int) Math.floor(baseCost * Math.pow(multiplier, level));
		damage = baseDamage*level;
	}
	
	/**
	 * getter method for totalDamage
	 * @return damage
	 */
	public int getTotalDamage(){
		return damage;
	}
	
	/**
	 * getter method for base damage
	 * @return baseDamage
	 */
	public int getBaseDamage(){
		return baseDamage;
	}
	
	/**
	 * getter method for price
	 * @return cost
	 */
	public int getPrice(){
		return cost;
	}
	
	/**
	 * method to buy item and updates cost and damage
	 */
	public void buyItem(){
		level++;
		updateInfo();
	}
	
	/**
	 * getter method for level of the item
	 * @return level
	 */
	public int getLevel(){
		return level;
	}
	
	
}
