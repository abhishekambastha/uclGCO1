package exercise4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Score extends JPanel{

	/**
	 * 
	 */

	public static int score = 0;
	private static final long serialVersionUID = -6834663162927227083L;

	JLabel scoreLabel = new JLabel("Score For Now is " + score);
	JButton quitGame = new JButton("Quit");
	String[] levelChoice = {"easy", "medium", "hard"};
	JComboBox<String> level = new JComboBox<String>(levelChoice); 

	public Score(){

		scoreLabel.setText("Your Score: " + score);
		setLayout(new GridLayout(1,3));
		add(scoreLabel);
		add(level);
		add(quitGame);

		
		//Difficulty Level Adjustments
		level.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {

				switch(level.getSelectedIndex()){
				case 0: Controller.speed = 1000; break;
				case 1: Controller.speed = 500; break;
				case 2: Controller.speed = 100; break;
				}
				Controller.changeLevel();
			}

		});
		
		//Quit
		quitGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame j = new ExitFrame();
				
				j.setSize(300,100);
				j.setVisible(true);
//				System.exit(0);
			}
			
		});
		
	}

	public void update(boolean increase){
		score = (increase)? (score+1):(score);
		scoreLabel.setText("Your Score: " + score);
	}

}
