package Observer;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Controller {

	public static void main(String...argv){
		SwingUtilities.invokeLater(new Runnable(){
		
			@Override
			public void run() {
				JFrame frame = new MainFrame("SnapIT");
				frame.setSize(500, 700);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}	
		});
	}
}
