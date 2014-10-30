package exercise5.Ex4;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static CompDetails details = new CompDetails();

	public MainFrame(String s){
		super(s);
		setLayout(new BorderLayout());
		
		add(new ControlPanel(), BorderLayout.CENTER);
		add(details, BorderLayout.SOUTH);
			
	}
}
