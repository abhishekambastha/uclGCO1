package tutorial2;

import java.util.Scanner;

public class ex3 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("What is your First and second name");
		String name = scan.nextLine();
		System.out.println("Hi " + name + "!");
		scan.close();

	}
}