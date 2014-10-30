package exercise5.Ex3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JLabel msg= new JLabel("Nothing");

	public MainFrame(String s){
		super(s);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridx =0;
		gc.gridy =0;
		JButton btn = new JButton("Lets See");
		add(btn, gc);
		
		gc.gridx=0;
		gc.gridy=1;
		JSlider label=new JSlider();
		add(label,gc);
		
		gc.gridx=0;
		gc.gridy=2;
		msg.setFocusable(true);
		msg.setFocusTraversalKeysEnabled(true);
		add(msg, gc);
		
		btn.addFocusListener(new FocusListen());
		label.addFocusListener(new FocusListen());
		
		
	}
}