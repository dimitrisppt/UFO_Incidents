package Gui;

import java.util.Observable;

public class WelcomeModel extends Observable{
	String from;
	String to;
	
	public String getfrom(){
		return from;
	}
	
	public String getTo(){
		return to;
	}
	
	public void setFrom(String from){
		this.from=from;
		updateObserver();	}
	
	public void setTo(String to){
		this.to=to; 
		updateObserver();
	}
	
	private void updateObserver(){
		setChanged();
		notifyObservers();
		
	}
}
