package exercise5.Ex1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Controller {

	public static void main(String...argv){
		SwingUtilities.invokeLater(new Runnable(){
		
			@Override
			public void run() {
				JFrame frame = new MainFrame("Number Of KeyStrokes");
				frame.setSize(600,400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
			
		});
	}
}