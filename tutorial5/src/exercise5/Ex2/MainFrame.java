package exercise5.Ex2;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(String s){
		super(s);
		setLayout(new BorderLayout());

		String[] options={"opt1","opt2","opt3"};

		JComboBox<String> jbox = new JComboBox<String>(options);
		jbox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = jbox.getSelectedIndex();
				String msg = options[index];
				if(e.getStateChange()==1){
					JOptionPane.showMessageDialog(null, msg);
				}

			}

		});

		add(jbox, BorderLayout.CENTER);
	}
}
