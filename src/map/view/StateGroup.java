package map.view;
import java.util.ArrayList;

import api.ripley.Incident;
import model.IncidentsFetcher;

public class StateGroup extends ArrayList<State>{ //a list of states
	
	private IncidentsFetcher fetcher;
	private State WA; //list of states
	private State OR; //create all states and input coordinates
	private State ID;
	private State MT;
	private State WY;
	private State ND;
	private State SD;
	private State NE;
	private State MN;
	private State IA;//10
	private State WI; 
	private State MI;
	private State NY; 
	private State VT;
	private State MA;
	private State NH;
	private State ME;
	private State IL;
	private State IN;
	private State OH;//20
	private State PA;
	private State NJ;
	private State CT;
	private State RI; 
	private State CA;
	private State NV;
	private State UT;
	private State AZ;
	private State CO; 
	private State NM;//30 
	private State KS;
	private State OK;
	private State TX;
	private State MO;
	private State AR;
	private State LA;
	private State KY;
	private State TN;
	private State MS; 
	private State AL;//40
	private State GA;
	private State SC;
	private State NC;
	private State VA;
	private State WV;
	private State DE;
	private State MD;
	private State FL;
	private State AK;
	private State HI;//50
	
	private int minSightings = 1000; //minimum number of sightings out of all states
	
	private void updateSightings(){
		int minSightings = 0;
		for (int i = 0;i < this.size(); i++){
			if(this.get(i).getSightings() < minSightings){
				minSightings = this.get(i).getSightings();
			}
		}
	}
	
	StateGroup(IncidentsFetcher fetcher){	//add states to list
		this.fetcher = fetcher;
		updateSightings();
		
		WA = new State(200, 125, "WA", fetcher, minSightings); //list of states
		OR = new State(150, 250, "OR", fetcher, minSightings); //create all states and input coordinates
		ID = new State(330, 300, "ID", fetcher, minSightings);
		MT = new State(500, 200, "MT", fetcher, minSightings); 
		WY = new State(550, 360, "WY", fetcher, minSightings); 
		ND = new State(800, 200, "ND", fetcher, minSightings); 
		SD = new State(800, 340, "SD", fetcher, minSightings); 
		NE = new State(825, 475, "NE", fetcher, minSightings); 
		MN = new State(975, 250, "MN", fetcher, minSightings); 
		IA = new State(1000, 450, "IA", fetcher, minSightings);//10
		WI = new State(1150, 340, "WI", fetcher, minSightings); 
		MI = new State(1300, 350, "MI", fetcher, minSightings);
		NY = new State(1600, 325, "NY", fetcher, minSightings); 
		VT = new State(1500, 190, "VT", fetcher, minSightings);
		MA = new State(1900, 260, "MA", fetcher, minSightings);
		NH = new State(1500, 120, "NH", fetcher, minSightings); 
		ME = new State(1775, 175, "ME", fetcher, minSightings); 
		IL = new State(1175, 550, "IL", fetcher, minSightings);
		IN = new State(1275, 525, "IN", fetcher, minSightings);
		OH = new State(1375, 500, "OH", fetcher, minSightings);//20
		PA = new State(1550, 450, "PA", fetcher, minSightings);
		NJ = new State(1900, 475, "NJ", fetcher, minSightings);
		CT = new State(1900, 405, "CT", fetcher, minSightings);
		RI = new State(1900, 335, "RI", fetcher, minSightings); 
		CA = new State(100, 550, "CA", fetcher, minSightings); 
		NV = new State(250, 520, "NV", fetcher, minSightings);
		UT = new State(400, 500, "UT", fetcher, minSightings);
		AZ = new State(350, 700, "AZ", fetcher, minSightings);
		CO = new State(600, 550, "CO", fetcher, minSightings); 
		NM = new State(575, 725, "NM", fetcher, minSightings);//30 
		KS = new State(850, 575, "KS", fetcher, minSightings);
		OK = new State(900, 725, "OK", fetcher, minSightings);
		TX = new State(825, 900, "TX", fetcher, minSightings);
		MO = new State(1050, 600, "MO", fetcher, minSightings); 
		AR = new State(1075, 750, "AR", fetcher, minSightings); 
		LA = new State(1060, 900, "LA", fetcher, minSightings);
		KY = new State(1350, 600, "KY", fetcher, minSightings);
		TN = new State(1300, 700, "TN", fetcher, minSightings);
		MS = new State(1175, 900, "MS", fetcher, minSightings); 
		AL = new State(1275, 800, "AL", fetcher, minSightings);//40
		GA = new State(1400, 850, "GA", fetcher, minSightings);
		SC = new State(1500, 775, "SC", fetcher, minSightings);
		NC = new State(1575, 685, "NC", fetcher, minSightings); 
		VA = new State(1575, 600, "VA", fetcher, minSightings); 
		WV = new State(1475, 550, "WV", fetcher, minSightings);
		DE = new State(1805, 565, "DE", fetcher, minSightings);
		MD = new State(1810, 650, "MD", fetcher, minSightings);
		FL = new State(1500, 1000, "FL", fetcher, minSightings);
		AK = new State(200, 1000, "AK", fetcher, minSightings); 
		HI = new State(575, 1100, "HI", fetcher, minSightings);//50
		
		this.add(WA);
		this.add(OR);
		this.add(ID);
		this.add(MT);
		this.add(WY);
		this.add(ND);
		this.add(SD);
		this.add(NE);
		this.add(MN);
		this.add(IA);//10
		this.add(WI);
		this.add(MI);
		this.add(NY);
		this.add(VT);
		this.add(MA);
		this.add(NH);
		this.add(ME);
		this.add(IL);
		this.add(IN);
		this.add(OH);//20
		this.add(PA);
		this.add(NJ);
		this.add(CT);
		this.add(RI);
		this.add(CA);
		this.add(NV);
		this.add(UT);
		this.add(AZ);
		this.add(CO);
		this.add(NM);//30
		this.add(KS);
		this.add(OK);
		this.add(TX);
		this.add(MO);
		this.add(AR);
		this.add(LA);
		this.add(KY);
		this.add(TN);
		this.add(MS);
		this.add(AL);//40
		this.add(GA);
		this.add(SC);
		this.add(NC);
		this.add(VA);
		this.add(WV);
		this.add(DE);
		this.add(MD);
		this.add(FL);
		this.add(AK);
		this.add(HI);//50
	}
	
	
	
}
