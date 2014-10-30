package radargraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;


public class RadarGraph extends JPanel {
	/**
	 * what is serialization ID?
	 */
	private static final long serialVersionUID = 1L;

	// graph[0] == xy of center     graph[0-5][0-1]
	//graph[i] == xy of endpoints of arm i (i = (1,5))
	//graph[6-55] == array of scales

	// outline[i][5] = xy of polygons   i=(0,2)    outline[0-2][0-1][0-4]

	private int[][] graph = new int[6][2];
	private int[][][] graphScale = new int[10][2][5];  // graphScale[0-9][0] = array of X points, graphScale[0-9][1]= array of Y points
	private int[][][] outline = new int[3][2][5];	//outline[0-2][0] = array of x points, outline[0-3][1] array of Y points

	public RadarGraph(){
		setBackground(Color.white);
		//this.getCords();
		System.out.println("Constructor of RadarGraph");
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		System.out.println("This is paintComponent");
		//getCords();
		drawWeb(g2d);
	}

	/*	OLD DRAW CODE
	 * private void drawWeb(Graphics2D g2d){
		Dimension x = this.getSize();
		double height = x.getHeight();
		double width = x.getWidth();

		int CenterX = (int)(width/2.0);
		int CenterY = (int)(height / 2.0);

		double r = 0.9 * height * 0.5;

		int[] endX = new int[5];
		int[] endY = new int[5];

		double angle = 0;

		double[][] axes = new double[3][5];
		//Random Numbers
		Random rand = new Random();
		for(int i=0; i<3; i++){
			axes[i][0] = rand.nextDouble();
			axes[i][1] = rand.nextDouble();
			axes[i][2] = rand.nextDouble();
			axes[i][3] = rand.nextDouble();
			axes[i][4] = rand.nextDouble();

			System.out.println(axes[i][0] + ", " + axes[i][1] + " ,"+axes[i][2] + ", " + axes[i][3] + " ," + axes[i][4]);
		}

		double[][] point = new double[5][2];
		int[] xPoints = new int[5];
		int[] yPoints = new int[5];
		for(int i=0; i<3; i++){
			angle = Math.PI*(2.0/5) - Math.PI*0.5;

			for(int j=0; j<5; j++){
				angle = j*Math.PI*(2.0/5) - Math.PI*0.5;
				point[j][0] = CenterX + r*axes[i][j]*Math.cos(angle);
				point[j][1] = CenterY + r*axes[i][j]*Math.sin(angle);
			}		

			for(int j=0; j<5; j++){
				xPoints[j] = (int)point[j][0];
				yPoints[j] = (int)point[j][1];
			}

			switch(i){
			case 0: g2d.setColor(Color.blue);break;
			case 1: g2d.setColor(Color.red);break;
			case 2: g2d.setColor(Color.yellow);break;
			}

			g2d.drawPolygon(xPoints, yPoints, 5);
			g2d.fillPolygon(xPoints, yPoints, 5);
		}




		//g2d.drawLine((int)point[4][0], (int)point[4][1], (int)point[0][0], (int)point[0][1]);



		for(int i = 0; i<5 ; i++){
			angle = i*Math.PI*(2.0/5) - Math.PI*0.5;
			endX[i]=CenterX + (int)( r*Math.cos(angle));
			endY[i]=CenterY + (int)( r*Math.sin(angle));
		}




		g2d.setColor(Color.black);
		int[][] newX = new int[10][5];
		int[][] newY = new int[10][5];
		for(int i=0; i<5; i++){
			g2d.drawLine(CenterX, CenterY, endX[i], endY[i]);

			for(int j=1; j<11; j++){
				newX[j-1][i] = ((endX[i]-CenterX)*j)/10 + CenterX;
				newY[j-1][i] = ((endY[i]-CenterY)*j)/10 + CenterY;
			}
		}

		for(int i=0; i<5; i++){

			for(int j=0; j<10; j++){
				if(i<4){
					g2d.drawLine(newX[j][i], newY[j][i], newX[j][i+1], newY[j][i+1]);
				}else{
					g2d.drawLine(newX[j][0], newY[j][0], newX[j][4], newY[j][4]);
				}

			}
		}


	}*/


	private void drawWeb(Graphics2D g2d){

		//fill polygons (Values to be mapped)
		for(int i=0; i<3; i++){
			switch(i){
			case 0: g2d.setColor(Color.blue);break;
			case 1: g2d.setColor(Color.red);break;
			case 2: g2d.setColor(Color.yellow);break;
			}

			//	g2d.drawPolygon(outline[i][0], outline[i][1], 5);
			g2d.fillPolygon(outline[i][0], outline[i][1], 5);
		}

		g2d.setColor(Color.black);
		
		//Draw the arms
		for(int i=1; i<6; i++){
			g2d.drawLine(graph[0][0], graph[0][1], graph[i][0], graph[i][1]);
		}
		
		String[] labels ={"axis1","axis2","axis3","axis4","axis5"};
		int[] marginX = new int[5];
		int[] marginY = new int[5];
		marginX[0]= 0;		marginY[0]= -8;
		marginX[1]= 10;		marginY[1]= 0;
		marginX[2]= 6;		marginY[2]= 9;
		marginX[3]= -40;	marginY[3]= 9;
		marginX[4]= -50;	marginY[4]= 0;
		for(int i=1; i<6; i++){
			if(true){
			g2d.drawString(labels[i-1], graph[i][0] + marginX[i-1], graph[i][1]+marginY[i-1]);
			}
		}
		
		//	draw the scales
		for(int i=0; i<10; i++){
			g2d.drawPolygon(graphScale[i][0], graphScale[i][1], 5);
		}

		//draw polygons
		for(int i=0; i<3; i++){
			switch(i){
			case 0: g2d.setColor(Color.blue);break;
			case 1: g2d.setColor(Color.red);break;
			case 2: g2d.setColor(Color.yellow);break;
			}
			g2d.drawPolygon(outline[i][0], outline[i][1], 5);
		}

	}

	void check(){
		//System.out.println("Hey !");
	}

	public void getCords(){
		Dimension x = this.getSize();
		double height = x.getHeight();
		double width = x.getWidth();

		int CenterX = (int)(width/2.0);
		int CenterY = (int)(height / 2.0);

		graph[0][0] = CenterX;
		graph[0][1] = CenterY;

		double r = 0.9 * height * 0.5;     //arm length

		//end points of the arms
		int[] endX = new int[5];
		int[] endY = new int[5];

		double angle = 0;
		for(int i = 0; i<5 ; i++){
			angle = i*Math.PI*(2.0/5) - Math.PI*0.5;
			endX[i]=CenterX + (int)( r*Math.cos(angle));
			endY[i]=CenterY + (int)( r*Math.sin(angle));

			graph[i+1][0] = endX[i];
			graph[i+1][1] = endY[i];
		}

		/* ----------End Points initialised ---------- */


		// Random Values to be mapped on the arms

		double[][] axes = new double[3][5];
		Random rand = new Random();

		for(int i=0; i<3; i++){
			axes[i][0] = rand.nextDouble();
			axes[i][1] = rand.nextDouble();
			axes[i][2] = rand.nextDouble();
			axes[i][3] = rand.nextDouble();
			axes[i][4] = rand.nextDouble();
		}

		for(int i=0; i<3; i++){

			angle = Math.PI*(2.0/5) - Math.PI*0.5;

			for(int j=0; j<5; j++){
				angle = j*Math.PI*(2.0/5) - Math.PI*0.5;
				outline[i][0][j] = (int)(CenterX + r*axes[i][j]*Math.cos(angle));
				outline[i][1][j] = (int)(CenterY + r*axes[i][j]*Math.sin(angle));
			}		
		}

		//For the Scales !!
		for(int i=1; i<11; i++){
			for(int j=0; j<5; j++){
				graphScale[i-1][0][j] = ((endX[j]-CenterX)*i)/10 + CenterX;
				graphScale[i-1][1][j] = ((endY[j]-CenterY)*i)/10 + CenterY;
			}
		}
	}

}
