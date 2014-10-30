/*
 * Currency Convertor
 * Store Results in A File!
 */


package exercise2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Controller {

	public static void main(String...args){

		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new MainFrame("Currency Converter");
				frame.setSize(300,200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
