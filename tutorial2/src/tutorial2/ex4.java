package tutorial2;

import java.util.Scanner;

public class ex4 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Your Name");
		String name = scan.nextLine();
		if (name.isEmpty()) {
			System.out.println("Fine, dont talk.");
		} else {
			System.out.println("Hey " + name + "!");
		}
		scan.close();
	}
}
