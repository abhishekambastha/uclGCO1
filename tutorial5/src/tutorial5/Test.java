package tutorial5;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test {
	public static void main(String...args){

		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				JFrame frame = new MainWindow("Test App");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(300, 150);
				frame.setVisible(true);
			}
		});
	}
}
