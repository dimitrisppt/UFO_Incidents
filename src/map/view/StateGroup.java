package map.view;
import java.util.ArrayList;

public class StateGroup extends ArrayList<State>{ //a list of states
	State WA = new State(200, 125, "WA"); //list of states
	State OR = new State(150, 250, "OR"); //create all states and input coordinates
	State ID = new State(330, 300, "ID");
	State MT = new State(500, 200, "MT"); 
	State WY = new State(550, 360, "WY"); 
	State ND = new State(800, 200, "ND"); 
	State SD = new State(800, 340, "SD"); 
	State NE = new State(825, 475, "NE"); 
	State MN = new State(975, 250, "MN"); 
	State IA = new State(1000, 450, "IA");//10
	State WI = new State(1150, 340, "WI"); 
	State MI = new State(1300, 350, "MI");
	State NY = new State(1600, 325, "NY"); 
	State VT = new State(1500, 190, "VT");
	State MA = new State(1900, 260, "MA");
	State NH = new State(1500, 120, "NH"); 
	State ME = new State(1775, 175, "ME"); 
	State IL = new State(1175, 550, "IL");
	State IN = new State(1275, 525, "IN");
	State OH = new State(1375, 500, "OH");//20
	State PA = new State(1550, 450, "PA");
	State NJ = new State(1900, 475, "NJ");
	State CT = new State(1900, 405, "CT");
	State RI = new State(1900, 335, "RI"); 
	State CA = new State(100, 550, "CA"); 
	State NV = new State(250, 520, "NV");
	State UT = new State(400, 500, "UT");
	State AZ = new State(350, 700, "AZ");
	State CO = new State(600, 550, "CO"); 
	State NM = new State(575, 725, "NM");//30 
	State KS = new State(850, 575, "KS");
	State OK = new State(900, 725, "OK");
	State TX = new State(825, 900, "TX");
	State MO = new State(1050, 600, "MO"); 
	State AR = new State(1075, 750, "AR"); 
	State LA = new State(1060, 900, "LA");
	State KY = new State(1350, 600, "KY");
	State TN = new State(1300, 700, "TN");
	State MS = new State(1175, 900, "MS"); 
	State AL = new State(1275, 800, "AL");//40
	State GA = new State(1400, 850, "GA");
	State SC = new State(1500, 775, "SC");
	State NC = new State(1575, 685, "NC"); 
	State VA = new State(1575, 600, "VA"); 
	State WV = new State(1475, 550, "WV");
	State DE = new State(1805, 565, "DE");
	State MD = new State(1810, 650, "MD");
	State FL = new State(1500, 1000, "FL");
	State AK = new State(200, 1000, "AK"); 
	State HI = new State(575, 1100, "HI");//50
	
	
	StateGroup(){	//add states to list
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
