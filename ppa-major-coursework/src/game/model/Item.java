package game.model;

public class Item {

	private final String name;
	private final int baseCost;
	private int level;
	private final int baseDamage;
	private final double multiplier;
	private int cost;
	private int damage;
	
	public Item(String name, int baseCost, int baseDamage, double multiplier){
		this.name = name;
		this.baseCost = baseCost;
		this.baseDamage = baseDamage;
		this.multiplier = multiplier;
		updateInfo();
	}
	
	//updates the cost of the next purchase for item and the total damage based on number of item owned
	private void updateInfo(){
		//Price = BaseCost x Multiplier^NumberOwned
		cost = (int) Math.floor(baseCost * Math.pow(multiplier, level));
		damage = baseDamage*level;
	}
	
	public int getTotalDamage(){
		return damage;
	}
	
	public int getBaseDamage(){
		return baseDamage;
	}
	
	public int getPrice(){
		return cost;
	}
	
	public void buyItem(){
		level++;
		updateInfo();
	}
	
	public int getLevel(){
		return level;
	}
	
	
}
