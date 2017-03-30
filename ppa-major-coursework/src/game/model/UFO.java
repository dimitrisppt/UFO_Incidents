package game.model;


import java.util.Observable;

public class UFO extends Observable{
	private final int baseHealth;
	private int maxHealth;
	private int remainingHealth;
	private int level;
	private final double multiplier;
	private int reward;
	private boolean giveReward;
	
	public UFO(double multiplier, int baseHealth){
		level = 1;
		this.multiplier = multiplier;
		this.baseHealth = baseHealth;
		giveReward = false;
		updateStats();
		
	}
	
	private void updateStats(){
		maxHealth = (int) Math.floor(baseHealth * Math.pow(level, multiplier));
		remainingHealth = maxHealth;
		int divider = (int) Math.pow(2, (1+(level/10)));
		reward = (int) Math.floor((baseHealth * level)/(50+divider));
		if (reward == 0){
			reward++;
		}
	}
	
	public void hitUFO(int damage){
		remainingHealth -= damage;
		if(remainingHealth <= 0){
			
			levelUp();
		}
		updateObservers();
	}
	
	
	public int getMaxHealth(){
		return maxHealth;
	}
	
	public int getHealth(){
		return remainingHealth;
	}
	
	private void levelUp(){
		giveReward = true;
		level++;
		updateStats();
	}
	
	private void updateObservers(){
		setChanged();
		notifyObservers();
	}
	
	public int getReward(){
		if (giveReward){
			giveReward = false;
			return reward;
		}else{
			return 0;
		}
	}
	
	public int getLevel() {
		return level;
	}
	
}
