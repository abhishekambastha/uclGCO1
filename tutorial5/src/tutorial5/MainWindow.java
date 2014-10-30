package tutorial5;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	private DetailsPanel dPanel;
	public MainWindow(String title){
		super(title);
		
		setLayout(new BorderLayout());
		
		
		dPanel = new DetailsPanel();
		
		Container contain = getContentPane();
		contain.add(dPanel, BorderLayout.CENTER);
		
		
	}
}
