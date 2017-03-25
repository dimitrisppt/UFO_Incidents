package map.view;

public class State { //a state

	int xCoord; //x coordinate for alien icon
	int yCoord; //y coordinate for alien icon
	int sightings = 1; //no of sightings for each state (initialise to 0, after testing layout)
	String name;
	
	State(int xCoord, int yCoord, String name){ //state constructor
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.name = name;
	}
	
	public void incSightings(int s){ //increment sightings
		sightings ++;
	}
	
	public int getSightings(){ //return number of sightings
		return sightings;
	}
	
	public int getX(){ //return x coordinates
		return xCoord;
	}
	
	public int getY(){ //return y coordinates
		return yCoord;
	}
	
	public String getName(){ //return x coordinates
		return name;
	}
}
