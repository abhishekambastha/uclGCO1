package exercise5.Ex3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Controller {

	public static void main(String...argv){
		SwingUtilities.invokeLater(new Runnable(){
		
			@Override
			public void run() {
				JFrame frame = new MainFrame("Focus?");
				frame.setSize(300,400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
			
		});
	}
}
