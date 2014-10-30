/*
 * THE BLOGGING APP
 * Store in File !
 * Check for existing file
 * create new if no file present
 * date and time support
 */


package exercise3;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Controller {

	public static void main(String...args){

		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new MainFrame("Blogging Application");
				frame.setSize(800,600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		

	}
}
