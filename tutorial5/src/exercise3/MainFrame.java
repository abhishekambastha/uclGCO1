package exercise3;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(String s) {
		super(s);
		Container contents = getContentPane();

		setLayout(new GridLayout(2,0));
		
		
		JPanel newPanel = new NewEntry();
		contents.add(newPanel);
		
		
		JPanel oldPanel= new OldEntry();
		contents.add(oldPanel);
		if(handleFile.readFile()){
			OldEntry.update();
		}
		
	}

}