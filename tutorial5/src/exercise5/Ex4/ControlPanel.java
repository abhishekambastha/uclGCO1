package exercise5.Ex4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControlPanel(){
		super();
		
		
		JButton btn1 = new JButton("btn1");
		JLabel btn2 = new JLabel("A Label");

		this.getLocation();
		
		btn1.setSize(2,2);
		btn2.setSize(2,2);
		
		Insets insets = this.getInsets();
		Dimension size = btn1.getPreferredSize();
		btn1.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
		size = btn2.getPreferredSize();
		btn2.setBounds(25 + insets.left, 55 + insets.top, size.width, size.height);
		
		add(btn2);
		add(btn1);
		
		setLayout(new BorderLayout());
		
		
		btn2.addMouseMotionListener(new Drag());
		btn1.addMouseMotionListener(new Drag());

		
	}
	
}