package map.view;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UfoListener implements MouseListener {
	private RectGroup r;
	private StateGroup s;
	
	public UfoListener(RectGroup r, StateGroup s){
		this.r = r;
		this.s = s;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point mousePoint = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		System.out.println(x);
		System.out.println(y);
		
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i).contains(x,y)) {
				System.out.println("ALEIN PRESSED:" + s.get(i).getName()); //print name of state clicked
				
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
