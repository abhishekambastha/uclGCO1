package tutorialTwo;
import java.util.Scanner;

public class ex4 {

	public static void main(String a[]){
		final String[] UNITS = {"B", "KB", "MB", "GB"};

		double initialValue = 0.0;


		System.out.println("Enter Value");
		Scanner scan = new Scanner(System.in);

		initialValue = scan.nextDouble();
		scan.close();

		double val = initialValue;

		for(int i =0; i<4; i++){
			if(val/1024 != 0){
				val = val / 1024.0D;
				System.out.print(val + " ");
				System.out.print(UNITS[i]);
				System.out.println("");
			}
		}
	}


}
