import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class App {

	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				JFrame frame = new MainFrame("Bezier Curve App");
				frame.setSize(300,300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	
	
	
	}
}
