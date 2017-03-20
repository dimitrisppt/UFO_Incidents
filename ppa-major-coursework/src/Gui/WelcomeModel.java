package Gui;

import java.util.Observable;

public class WelcomeModel extends Observable{
	
	
	
	private void updateObserver(){
		setChanged();
		notifyObservers();
		System.out.println("welcomeModel");
	}
}
