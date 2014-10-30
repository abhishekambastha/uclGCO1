package barchart;
import javax.swing.JFrame;

public class Controller {
	public static void main(String... args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				gui();
			}
		});
	}
	
	public static void gui(){
		JFrame frame=new JFrame();
		frame.setSize(400,300);
		
		double[] values= new double[5];
		String[] names= new String[5];
		
		values[0] =1;
		names[0] = "Item 1";

		values[1] =2;
		names[1] = "Item 2";
		
		values[2] =4;
		names[2] = "Item 3";
		
		values[3] =6;
		names[3] = "Item 4";
		
		values[4] =3;
		names[4] = "Item 5";

		frame.getContentPane().add(new ChartPanel(values, names));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}