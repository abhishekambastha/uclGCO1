package exercise2;

//import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7949915688548020664L;

	public MainFrame(String title) throws HeadlessException {
		super(title);

		Container contents = getContentPane();

		setLayout(new GridLayout(1,0));
		JPanel panel= new CurrencyPanel();
		contents.add(panel);

	}
}
