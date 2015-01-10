import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControlPanel control = new ControlPanel();
	
	public MainFrame(String title){
		super(title);
		
		//Set Layout Manager
		setLayout(new BorderLayout());
				
		//Add swing components
		Container c = getContentPane();
		
		c.add(control);
		
	}
	

}
