package tutorial2;

import java.util.Scanner;

public class ex6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Name ? :");
		String name = scan.nextLine();
		System.out.println("Age ? :");
		String age = scan.next();
		int ageInt = Integer.parseInt(age);
		if (ageInt < 15) {
			for (int i = 0; i < ageInt; i++) {
				System.out.println(name);
			}
		} else {
			StringBuffer buff = new StringBuffer(name);
			String reverse = buff.reverse().toString();
			System.out.println(reverse + " " + age);

		}
		scan.close();
	}
}