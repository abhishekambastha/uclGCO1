import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ControlPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ControlPanel(){
		Dimension size = getPreferredSize();
		size.width = 200;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Hello"));
		
		JLabel name = new JLabel("Name");
		JTextField occupation = new JTextField();
		JButton btn = new JButton("Click");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		add(name, gc);
		
	}

}
