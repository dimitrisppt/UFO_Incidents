package game.model;
import java.util.Observable;

/**
 * The class extends Observable and every time the user clicks the
 * sets the singleClick to field to true, calls setChanged and notifyObservers methods
 * Is used to determine actions when the user clicks the mouse.
 * 
 * @author Dimitris Papatheodoulou
 * 
 */
public class ClickModel extends Observable {
	
	// Declaring field.
	private boolean singleClick;
	
	/**
	 * Initialising singleClick to false.
	 */
	public ClickModel() {
	
		singleClick = false;
	}
	
	/**
	 * Sets singleClick to true, calls setChanged and 
	 * notifyObservers methods.
	 */
	public void singleClicked() {
		singleClick = true;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * @return singleClick
	 */
	public boolean getSingleClick() {
		return singleClick;
	}
	
	/**
	 * Sets singleClick back to false
	 */
	public void resetSingleClick() {
		singleClick = false;
	}
	

}
