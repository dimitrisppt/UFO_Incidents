package statistics.model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * class to manage the prefered positions for each of the statistics in the statistics panel
 * @author Aakash
 *
 */
public class StatisticsPreferenceManager {

	private List<String> preferenceList;
	private final static String FILE_PATH = "src/StatisticsPreferences.txt";
	private int firstPref;
	private int secondPref;
	private int thirdPref;
	private int fourthPref;
	
	/**
	 * Constructor
	 */
	public StatisticsPreferenceManager(){
		readFiles();
	}
	
	/**
	 * reads files and puts each line in a list
	 * sets preference variables based on what's in the  list
	 *
	 */
	private void readFiles(){
		//put file contents in a list
		Path path = Paths.get(FILE_PATH);
		try {
			preferenceList = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set pref variables
		firstPref = Integer.parseInt(preferenceList.get(0));
		secondPref = Integer.parseInt(preferenceList.get(1));
		thirdPref = Integer.parseInt(preferenceList.get(2));
		fourthPref = Integer.parseInt(preferenceList.get(3));
		
	}
	
	/**
	 * replaces the "panelNumber" line in the file with "newPreferance"
	 * @param panelNumber
	 * @param newPreferance
	 */
	public void replacePreferance(int panelNumber, int newPreference){
		//removes panelNumber line from the list
		preferenceList.remove(panelNumber);
		//adds newPreference to the panelNumber index
		preferenceList.add(panelNumber, new Integer(newPreference).toString());
		
		//writes the preference list to the file
		Path path = Paths.get(FILE_PATH);
	    try {
			Files.write(path, preferenceList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	/**
	 * getter method for first preference 
	 * @return firstPref
	 */
	public int getFirstPreference(){
		return firstPref;
	}
	
	/**
	 * getter method for second preference 
	 * @return secondPref
	 */
	public int getSecondPreference(){
		return secondPref;
	}
	
	/**
	 * getter method for third preference 
	 * @return thirdPref
	 */
	public int getThirdPreference(){
		return thirdPref;
	}
	
	/**
	 * getter method for fourth preference 
	 * @return fourthPref
	 */
	public int getFourthPreference(){
		return fourthPref;
	}
	
	
}