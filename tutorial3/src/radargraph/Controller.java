package radargraph;

import java.awt.Dimension ;
import javax.swing.JFrame ;


public class Controller {

	public static void main(String[] args) throws Exception{
		
		System.out.println("Program Has Started, begining of main()");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				createAndShowGUI();
			}
		});
		System.out.println("end of main()");
	}
	
	public static void createAndShowGUI(){
		JFrame frame = new JFrame ( ) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(640 ,480));
		RadarGraph graph = new RadarGraph();
		frame.add(graph);
		System.out.println("This is after frame.add and before pack");
		frame.pack();
		//graph.check();
		//recalculation goes here
		System.out.println("This is after pack and before visible");
		graph.getCords();
		frame.setVisible(true);
		System.out.println("This is after visible");
	}
}
