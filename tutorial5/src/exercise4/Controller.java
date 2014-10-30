/*i * WHACK A MOLE GAME
 * 
 * store results in file 
 * add parameters for difficulty levels
 * 
 * increase speed with time!
 */
package exercise4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Controller{

	static int speedFromDiff = 1000;
	static int speed = speedFromDiff;
	static Timer gameTimer = new Timer(speed, MainFrame.gpanel);

	public static void main(String...args){

		JFrame frame = new MainFrame("WHACK A MOLE!!");
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				frame.setSize(600,620);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	
		int reviseSpeedInterval = 10000;


		gameTimer.start();

		Timer timer = new Timer(reviseSpeedInterval, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				speed =  (int)((int)speed/1.2);
				gameTimer.setDelay(speed);
				System.out.println("Speed Now is = " + speed);
			}});
		timer.start();
	}

	public static void changeLevel(){
		gameTimer.setDelay(speed);
	}



}