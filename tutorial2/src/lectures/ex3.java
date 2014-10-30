package lectures;

import java.util.Random;
public class ex3 {
	public static void main(String[] args) {
		Random aRandom = new Random();
		for(int i=0; i<6; i++){
			System.out.println("Lottery " + i +" is " + (aRandom.nextInt(49) +1));
		}
	}
}