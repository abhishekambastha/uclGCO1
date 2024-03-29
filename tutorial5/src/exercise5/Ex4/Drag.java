package exercise5.Ex4;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/*
 * @author: Abhishek
 * @params: parent compontnt
 * 
 *  dksfjlkdsjfljslfj
 * 
 */

public class Drag implements MouseMotionListener{

	
	@Override
	public void mouseDragged(MouseEvent e) {
		//		System.out.println(e.getLocationOnScreen());
		Point p = e.getLocationOnScreen();
		
		Point init = e.getComponent().getLocationOnScreen() ;
		Point fin = e.getComponent().getLocation();
		
		//Offset
		double x = init.getX() - fin.getX();
		double y  = init.getY() - fin.getY();
		p.setLocation(p.getX()-x-15, p.getY()-y-5);
	
		String componentLocation = "[" + p.getX() + "; " + p.getY() + "]";
		String componentName = e.getComponent().getClass() + "";
		componentName = componentName.substring(18);
		
		e.getComponent().setLocation(p);

		MainFrame.details.update("" + componentName + " is at " + componentLocation);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}


}
