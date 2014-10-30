package helloWorld;

import java.util.Scanner;
public class Hello {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int val = 0;
		boolean isNumber = false;
		while(isNumber == false){
			try{
				System.out.println("Enter a value");
				double value = Double.parseDouble(input.next());
				val = (int)(Math.round(value));
				isNumber = true;
			}

			catch(NumberFormatException e){
				System.out.println("Invalid Number try again !");
			}
		}
		if (isPrime(val)){
			System.out.println(val + "is a prime number");
		}
		else{
			System.out.println(val + "is not a prime number");
		}
		input.close();
	}
	//Method to check prime;
	public static boolean isPrime(int value){
		int j=2;
		boolean isPrime=true;
		while (j<=value/2){
			if(value % j !=0){//if remainder is not equal to 0 then it's a prime;
				isPrime=false;
				break;
			}else{
				j++;
			}
		}
		return isPrime;
	}
}