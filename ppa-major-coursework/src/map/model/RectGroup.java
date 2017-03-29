package map.model;
import java.awt.Rectangle;
import java.util.ArrayList;

public class RectGroup extends ArrayList<Rectangle> {
	StateGroup s;//group of states
	private int rectSizex;//x size of rectangle
	private int rectSizey;//y size of rectangle
	
	private Rectangle WA;
	private Rectangle OR; //create all Rectangles and input coordinates
	private Rectangle ID;
	private Rectangle MT;
	private Rectangle WY; 
	private Rectangle ND; 
	private Rectangle SD;
	private Rectangle NE; 
	private Rectangle MN; 
	private Rectangle IA;//10
	private Rectangle WI; 
	private Rectangle MI; 
	private Rectangle NY; 
	private Rectangle VT; 
	private Rectangle MA;
	private Rectangle NH;
	private Rectangle ME;
	private Rectangle IL; 
	private Rectangle IN;
	private Rectangle OH;//20
	private Rectangle PA;
	private Rectangle NJ; 
	private Rectangle CT;
	private Rectangle RI; 
	private Rectangle CA;
	private Rectangle NV;
	private Rectangle UT; 
	private Rectangle AZ;
	private Rectangle CO;
	private Rectangle NM; //30 
	private Rectangle KS; 
	private Rectangle OK; 
	private Rectangle TX;
	private Rectangle MO; 
	private Rectangle AR; 
	private Rectangle LA; 
	private Rectangle KY; 
	private Rectangle TN; 
	private Rectangle MS; 
	private Rectangle AL; //40
	private Rectangle GA; 
	private Rectangle SC;
	private Rectangle NC;
	private Rectangle VA;
	private Rectangle WV;
	private Rectangle DE; 
	private Rectangle MD; 
	private Rectangle FL; 
	private Rectangle AK;
	private Rectangle HI;//50
	private int w; //width of frame
	private int h;//height of frame

	public RectGroup(StateGroup s, int w, int h){
		this.s = s;
		this.rectSizex = 25;
		this.rectSizey = 25;
		
		
		Rectangle WA = new Rectangle(w * 200/2000,h * 125/1236, rectSizex, rectSizey); //list of Rectangles
		Rectangle OR = new Rectangle(w * 150/2000,h * 250/1236, rectSizex, rectSizey); //create all Rectangles and input coordinates
		Rectangle ID = new Rectangle(w * 330/2000,h * 300/1236, rectSizex, rectSizey);
		Rectangle MT = new Rectangle(w * 500/2000,h * 200/1236, rectSizex, rectSizey); 
		Rectangle WY = new Rectangle(w * 550/2000,h * 360/1236, rectSizex, rectSizey); 
		Rectangle ND = new Rectangle(w * 800/2000,h * 200/1236, rectSizex, rectSizey); 
		Rectangle SD = new Rectangle(w * 800/2000,h * 340/1236, rectSizex, rectSizey); 
		Rectangle NE = new Rectangle(w * 825/2000,h * 475/1236, rectSizex, rectSizey); 
		Rectangle MN = new Rectangle(w * 975/2000,h * 250/1236, rectSizex, rectSizey); 
		Rectangle IA = new Rectangle(w * 1000/2000,h * 450/1236, rectSizex, rectSizey);//10
		Rectangle WI = new Rectangle(w * 1150/2000,h * 340/1236, rectSizex, rectSizey); 
		Rectangle MI = new Rectangle(w * 1300/2000,h * 350/1236, rectSizex, rectSizey);
		Rectangle NY = new Rectangle(w * 1600/2000,h * 325/1236, rectSizex, rectSizey); 
		Rectangle VT = new Rectangle(w * 1500/2000,h * 190/1236, rectSizex, rectSizey);
		Rectangle MA = new Rectangle(w * 1900/2000,h * 260/1236, rectSizex, rectSizey);
		Rectangle NH = new Rectangle(w * 1500/2000,h * 120/1236, rectSizex, rectSizey); 
		Rectangle ME = new Rectangle(w * 1775/2000,h * 175/1236, rectSizex, rectSizey); 
		Rectangle IL = new Rectangle(w * 1175/2000,h * 550/1236, rectSizex, rectSizey);
		Rectangle IN = new Rectangle(w * 1275/2000,h * 525/1236, rectSizex, rectSizey);
		Rectangle OH = new Rectangle(w * 1375/2000,h * 500/1236, rectSizex, rectSizey);//20
		Rectangle PA = new Rectangle(w * 1550/2000,h * 450/1236, rectSizex, rectSizey);
		Rectangle NJ = new Rectangle(w * 1900/2000,h * 475/1236, rectSizex, rectSizey);
		Rectangle CT = new Rectangle(w * 1900/2000,h * 405/1236, rectSizex, rectSizey);
		Rectangle RI = new Rectangle(w * 1900/2000,h * 335/1236, rectSizex, rectSizey); 
		Rectangle CA = new Rectangle(w * 100/2000,h * 550/1236, rectSizex, rectSizey); 
		Rectangle NV = new Rectangle(w * 250/2000,h * 520/1236, rectSizex, rectSizey);
		Rectangle UT = new Rectangle(w * 400/2000,h * 500/1236, rectSizex, rectSizey);
		Rectangle AZ = new Rectangle(w * 350/2000,h * 700/1236, rectSizex, rectSizey);
		Rectangle CO = new Rectangle(w * 600/2000,h * 550/1236, rectSizex, rectSizey); 
		Rectangle NM = new Rectangle(w * 575/2000,h * 725/1236, rectSizex, rectSizey);//30 
		Rectangle KS = new Rectangle(w * 850/2000,h * 575/1236, rectSizex, rectSizey);
		Rectangle OK = new Rectangle(w * 900/2000,h * 725/1236, rectSizex, rectSizey);
		Rectangle TX = new Rectangle(w * 825/2000,h * 900/1236, rectSizex, rectSizey);
		Rectangle MO = new Rectangle(w * 1050/2000,h * 600/1236, rectSizex, rectSizey); 
		Rectangle AR = new Rectangle(w * 1075/2000,h * 750/1236, rectSizex, rectSizey); 
		Rectangle LA = new Rectangle(w * 1060/2000,h * 900/1236, rectSizex, rectSizey);
		Rectangle KY = new Rectangle(w * 1350/2000,h * 600/1236, rectSizex, rectSizey);
		Rectangle TN = new Rectangle(w * 1300/2000,h * 700/1236, rectSizex, rectSizey);
		Rectangle MS = new Rectangle(w * 1175/2000,h * 900/1236, rectSizex, rectSizey); 
		Rectangle AL = new Rectangle(w * 1275/2000,h * 800/1236, rectSizex, rectSizey);//40
		Rectangle GA = new Rectangle(w * 1400/2000,h * 850/1236, rectSizex, rectSizey);
		Rectangle SC = new Rectangle(w * 1500/2000,h * 775/1236, rectSizex, rectSizey);
		Rectangle NC = new Rectangle(w * 1575/2000,h * 685/1236, rectSizex, rectSizey); 
		Rectangle VA = new Rectangle(w * 1575/2000,h * 600/1236, rectSizex, rectSizey); 
		Rectangle WV = new Rectangle(w * 1475/2000,h * 550/1236, rectSizex, rectSizey);
		Rectangle DE = new Rectangle(w * 1805/2000,h * 565/1236, rectSizex, rectSizey);
		Rectangle MD = new Rectangle(w * 1810/2000,h * 650/1236, rectSizex, rectSizey);
		Rectangle FL = new Rectangle(w * 1500/2000,h * 1000/1236, rectSizex, rectSizey);
		Rectangle AK = new Rectangle(w * 200/2000,h * 1000/1236, rectSizex, rectSizey); 
		Rectangle HI = new Rectangle(w * 575/2000,h * 1100/1236, rectSizex, rectSizey);//50
		
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
