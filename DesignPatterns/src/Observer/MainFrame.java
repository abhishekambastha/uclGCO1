package Observer;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean isTimeWarp = false;

	public MainFrame(String s){
		setLayout(new FlowLayout());
		JButton a = new JButton("a");
		JButton b = new JButton("b");
		JButton c = new JButton("c");
		
		add(a);
		add(b);
		add(c);
		
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(((JButton)e.getSource()).getText());
	}
}