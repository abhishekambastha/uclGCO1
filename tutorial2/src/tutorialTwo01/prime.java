package tutorialTwo01;
import java.util.InputMismatchException;
import java.util.Scanner;

public class prime {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		double num = 0;
		boolean gotNumber = false;
		do{
			try{
				if(!gotNumber){
					num = scan.nextDouble();
					gotNumber = true;
				}
			}catch(InputMismatchException e){
				System.out.println("Please Enter a Valid number");
				@SuppressWarnings("unused")
				String a = scan.nextLine();
				
			}
		}while(!gotNumber);

		System.out.println(primeNumber((int)(Math.round(num))));
		scan.close();
	}

	public static boolean primeNumber(int num){
		boolean isPrime = true;
		if(num==1 || num==0){
			return false;
		}
		for(int i = 2; i<num; i++){
			if(num%i == 0){
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
}
