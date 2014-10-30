package exercise5.Ex1;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int counter=0;

	public MainFrame(String s){
		super(s);
		
		setLayout(new GridLayout(2,0));
		JTextField text = new JTextField();
		JLabel count = new JLabel();
		text.addKeyListener(new KeyListener(){

			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				count.setText("Number of KeyStrokes this far = " + ++counter);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		add(text);
		add(count);
	}
}
