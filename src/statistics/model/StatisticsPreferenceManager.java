package statistics.model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StatisticsPreferenceManager {

	private List<String> preferenceList;
	private final static String FILE_PATH = "src/StatisticsPreferences.txt";
	private int firstPref;
	private int secondPref;
	private int thirdPref;
	private int fourthPref;
	
	public StatisticsPreferenceManager(){
		readFiles();
	}
	
	private void readFiles(){
		Path path = Paths.get(FILE_PATH);
		try {
			preferenceList = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		firstPref = Integer.parseInt(preferenceList.get(0));
		secondPref = Integer.parseInt(preferenceList.get(1));
		thirdPref = Integer.parseInt(preferenceList.get(2));
		fourthPref = Integer.parseInt(preferenceList.get(3));
		
	}
	
	public void replacePreferance(int panelNumber, int newPreferance){
		preferenceList.remove(panelNumber);
		preferenceList.add(panelNumber, new Integer(newPreferance).toString());
		Path path = Paths.get(FILE_PATH);
	    try {
			Files.write(path, preferenceList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	
	public int getFirstPreference(){
		return firstPref;
	}
	
	public int getSecondPreference(){
		return secondPref;
	}
	
	public int getThirdPreference(){
		return thirdPref;
	}
	
	public int getFourthPreference(){
		return fourthPref;
	}
	
	
}