package testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class MainClass {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.getContentPane().add(new CurveApplet());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}

class CurveApplet extends JPanel {
	public CurveApplet() {
		super(new BorderLayout());
		pane = new CurvePane();
		add(pane,"Center");

		MouseHandler handler = new MouseHandler();
		pane.addMouseListener(handler);
		pane.addMouseMotionListener(handler);
	}

	class CurvePane extends JComponent {
		public CurvePane() {

			cubicCurve = new CubicCurve2D.Double(
					startC.x, startC.y, 
					controlStart.x, controlStart.y,
					controlEnd.x, controlEnd.y,
					endC.x, endC.y);
		}

		public void paint(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;

			cubicCurve.ctrlx1 = ctrlCubic1.getCenter().x;
			cubicCurve.ctrly1 = ctrlCubic1.getCenter().y;
			cubicCurve.ctrlx2 = ctrlCubic2.getCenter().x;
			cubicCurve.ctrly2 = ctrlCubic2.getCenter().y;

			g2D.setPaint(Color.BLUE);

			g2D.draw(cubicCurve);

			g2D.setPaint(Color.RED);

			ctrlCubic1.draw(g2D);
			ctrlCubic2.draw(g2D);

			Line2D.Double tangent = new Line2D.Double(startC, ctrlCubic1.getCenter());

			tangent = new Line2D.Double(startC, ctrlCubic1.getCenter());
			g2D.draw(tangent);
			tangent = new Line2D.Double(endC, ctrlCubic2.getCenter());
			g2D.draw(tangent);

		}
	}



	Point2D.Double startC = new Point2D.Double(0, 400); 
	Point2D.Double endC = new Point2D.Double(400, 0); 
	Point2D.Double controlStart = new Point2D.Double(10, 10);
	Point2D.Double controlEnd = new Point2D.Double(390, 390); 


	Marker ctrlCubic1 = new Marker(controlStart);
	Marker ctrlCubic2 = new Marker(controlEnd);


	CubicCurve2D.Double cubicCurve; 

	CurvePane pane = new CurvePane();

	class Marker {

		Ellipse2D.Double circle; 
		Point2D.Double center; 
		static final double radius = 3;
		
		public Marker(Point2D.Double control) {
			center = control; 
			circle = new Ellipse2D.Double(control.x - radius, control.y - radius, 2.0 * radius,
					2.0 * radius);
		}
		
		public void draw(Graphics2D g2D) {
			g2D.draw(circle);
		}

		Point2D.Double getCenter() {
			return center;
		}
		
		public boolean contains(double x, double y) {
			return circle.contains(x, y);
		}
		
		public void setLocation(double x, double y) {
			center.x = x; 
			center.y = y; 
			circle.x = x - radius; 
			circle.y = y - radius; 
		}
	}

	class MouseHandler extends MouseInputAdapter {

		Marker selected = null;

		public void mousePressed(MouseEvent e) {
			if (ctrlCubic1.contains(e.getX(), e.getY()))
				selected = ctrlCubic1;
			else if (ctrlCubic2.contains(e.getX(), e.getY()))
				selected = ctrlCubic2;
		}

		public void mouseReleased(MouseEvent e) {
			selected = null;
		}

		public void mouseDragged(MouseEvent e) {
			if (selected != null) {
				selected.setLocation(e.getX(), e.getY());
				pane.repaint(); 
			}
		}
	}
}

