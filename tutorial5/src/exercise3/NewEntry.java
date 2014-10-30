package exercise3;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NewEntry extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewEntry() {
		setBorder(BorderFactory.createTitledBorder("New Entry"));
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.gridx =0;
		gc.gridy=0;

		JTextArea text = new JTextArea(12,60);
		add(text, gc);

		gc.gridx=0;
		gc.gridy=1;
		
		JButton btn = new JButton("Post This");
		add(btn, gc);
		
		
		
		btn.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yy");
				Date date = new Date();
				String dateAndTime =(dateFormat.format(date));
				if(!handleFile.readFile()){
					handleFile.writeNew(text.getText(), dateAndTime);
				}else{
					handleFile.writeAppend(text.getText(), dateAndTime);
				}
				
				OldEntry.update();
				
			}
			
		});
	}

}