package exercise4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;


public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static GamePanel gpanel = new GamePanel();
	public static Score score = new Score();
	
	public MainFrame(String s) {
		super(s);
		setBackground(Color.white);
		Container contents = getContentPane();

		setLayout(new BorderLayout());
		
		contents.add(gpanel, BorderLayout.CENTER);
		contents.add(score, BorderLayout.NORTH);
		
	}

}
