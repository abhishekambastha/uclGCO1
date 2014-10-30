package exercise4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ExitFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExitFrame(){
		super();
		setLayout(new GridLayout(0,1));
		JTextField name = new JTextField("Please Enter Your Name Here");
		JButton btn = new JButton("Save & Exit");
		add(name);
		add(btn);

		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean highest = false;
				boolean newfile = false;

				String[] results = null;

				if(!handleFile.readFile()){
					System.out.println("New File Created!!");
					newfile = true;
				}else{
					newfile=false;
					results = handleFile.getScores();
					for(int i=0; i<results.length; i++){
						if(Score.score>Integer.parseInt(results[i])){
							highest = true;
						}
					}
				}

				if(newfile||results.length <10 || highest){
					handleFile.writeAppend(name.getText(), Score.score);
				}

				if(handleFile.readFile()){
					System.out.println("Lets see");
				}
				System.exit(0);

			}

		});
	}

}
