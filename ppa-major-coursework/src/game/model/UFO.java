package game.model;


import java.util.Observable;

/**
 * class to model a ufo in the UFO game
 * @author Aakash
 *
 */
public class UFO extends Observable{
	private final int baseHealth;
	private int maxHealth;
	private int remainingHealth;
	private int level;
	private final double multiplier;
	private int reward;
	private boolean giveReward;
	
	/**
	 * constructor.
	 * @param multiplier
	 * @param baseHealth
	 */
	public UFO(double multiplier, int baseHealth){
		level = 1;
		this.multiplier = multiplier;
		this.baseHealth = baseHealth;
		giveReward = false;
		updateStats();
		
	}
	
	/**
	 * updates all the ufo's stats when leveling up
	 */
	private void updateStats(){
		maxHealth = (int) Math.floor(baseHealth * Math.pow(level, multiplier));
		remainingHealth = maxHealth;
		int divider = (int) Math.pow(2, (1+(level/10)));
		reward = (int) Math.floor((baseHealth * level)/(50+divider));
		if (reward == 0){
			reward++;
		}
	}
	
	/**
	 * hits the ufo with "damage" damage and if dead levels the ufo up
	 * @param damage
	 */
	public void hitUFO(int damage){
		remainingHealth -= damage;
		if(remainingHealth <= 0){
			
			levelUp();
		}
		updateObservers();
	}
	
	/**
	 * getter method for max health
	 * @return maxHealth
	 */
	public int getMaxHealth(){
		return maxHealth;
	}
	
	/**
	 * getter method for remaining health
	 * @return remainingHealth
	 */
	public int getHealth(){
		return remainingHealth;
	}
	
	/**
	 * levels the ufo up and calls updateStats method
	 */
	private void levelUp(){
		//give reward is a flag to give the player a reward when the ufo dies
		// look at the method getReward() for more info
		giveReward = true;
		level++;
		updateStats();
	}
	
	/**
	 * updates observers
	 */
	private void updateObservers(){
		setChanged();
		notifyObservers();
	}
	
	/**
	 * if the giveReward flag is true returns the reward
	 * otherwise return 0
	 * @return reward
	 */
	public int getReward(){
		if (giveReward){
			giveReward = false;
			return reward;
		}else{
			return 0;
		}
	}
	
	/**
	 * getter method for ufo's level
	 * @return level
	 */
	public int getLevel() {
		return level;
	}
	
}
