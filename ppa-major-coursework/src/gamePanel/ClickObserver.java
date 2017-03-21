package gamePanel;
import java.util.Observable;
import java.util.regex.Pattern;

public class ClickObserver extends Observable {
	
	private boolean singleClick;
	
	public ClickObserver() {
	
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
