package tutorial3;

import java.util.Scanner;

public class ex1 {
	public static boolean isEven(int number){
		//boolean isEven = false;
		/*if(number%2==0){
		isEven = true;
	}else{
		isEven = false;
	}*/
		//isEven = (number%2==0);

		//return isEven;
		return (number%2==0);
	}

	public static void main(String... args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = scan.nextInt();
		System.out.println(isEven(num));
		scan.close();
	}
}
