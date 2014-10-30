package exercise4;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel[][] label = new JLabel[4][];
	boolean[][] scoreIncrease = new boolean[4][4];

	public GamePanel() {
		super();
		setBackground(Color.BLACK);
		setLayout(new GridLayout(4,4));

		ImageIcon grass = createImageIcon("grass.png", "kuch bhi");

		for(int i=0;i<4;i++){
			label[i] = new JLabel[4];
			for(int j=0; j<4; j++){
				label[i][j] = new JLabel();
				label[i][j] = new JLabel(grass);
				label[i][j].setBorder(BorderFactory.createLineBorder(Color.getHSBColor(50, 300, 100), 2));
				add(label[i][j]);
			}
		}
	}


	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	protected void paintPane(){
		ImageIcon mole = createImageIcon("mole.png", "kuch bhi");
		ImageIcon grass = createImageIcon("grass.png", "kuch bhi");

		for(int i=0;i<4;i++){
			for(int j=0; j<4; j++){
				label[i][j].setIcon(grass);
				scoreIncrease[i][j] = false;
			}
		}

		Random rand = new Random();
		int x = rand.nextInt(4);
		int y = rand.nextInt(4);
		label[x][y].setIcon(mole);
		scoreIncrease[x][y] = true;
		label[x][y].addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				MainFrame.score.update(scoreIncrease[x][y]);
				scoreIncrease[x][y] = false;
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		paintPane();
	}

}