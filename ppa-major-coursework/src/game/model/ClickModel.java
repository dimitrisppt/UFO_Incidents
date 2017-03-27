package game.model;
import java.util.Observable;
import java.util.regex.Pattern;

public class ClickModel extends Observable {
	
	private boolean singleClick;
	
	public ClickModel() {
	
		singleClick = false;
		
		
	}
	
	
	public void singleClicked() {
		singleClick = true;
		setChanged();
		notifyObservers();
	}
	
	public boolean getSingleClick() {
		return singleClick;
	}
	
	public void resetSingleClick() {
		singleClick = false;
	}
	

}
