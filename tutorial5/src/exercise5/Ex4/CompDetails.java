package exercise5.Ex4;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompDetails extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel resultC = new JLabel("Lets see");
	
	public CompDetails(){
		add(resultC);
	}

	public void update(String s){
		resultC.setText(s);
	}
}
