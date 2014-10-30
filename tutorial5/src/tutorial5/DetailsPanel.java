package tutorial5;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DetailsPanel extends JPanel {

	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 100;
		size.height = 1;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Panel"));
		
		JLabel name = new JLabel("Name :");
		JLabel age = new JLabel("Age :");
		
		JTextField nameField = new JTextField(10);
		JTextField ageField = new JTextField(10);
		
		JButton addButton = new JButton("add");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbag = new GridBagConstraints();
		
		gbag.weightx = 0.5;
		gbag.weighty = 0.5;
		
		gbag.anchor = GridBagConstraints.LINE_END;
		gbag.gridx = 0;
		gbag.gridy = 0;
		
		add(name, gbag);
		
		gbag.gridx = 0;
		gbag.gridy = 1;
		add(age, gbag);
		
		gbag.anchor = GridBagConstraints.LINE_START;
		gbag.gridx = 1;
		gbag.gridy = 0;
		add(nameField, gbag);
		
		gbag.gridx = 1;
		gbag.gridy = 1;
		add(ageField, gbag);
		
		gbag.gridx = 1;
		gbag.gridy = 2;
		add(addButton, gbag);
		
//		System.out.println();

		System.out.println("hello");
	}

	public DetailsPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public DetailsPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public DetailsPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}