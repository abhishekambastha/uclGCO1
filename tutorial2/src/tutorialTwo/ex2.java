package tutorialTwo;
import java.util.Scanner;

public class ex2 {
	public static int add(int fst, int snd){
		return (fst + snd);
	}
	
	public static int subract(int fst, int snd){
		return (fst - snd);
	}
	
	public static int multiply(int fst, int snd){
		return (fst * snd);
	}
	
	public static double divide(int fst, int snd){
		return (1.0*fst) / snd;
	}
	
	public static int fact(int a){
		if(a==1){
			return 1;
		} 
		else{
			return a*fact(a-1);
		}
	}
	
	public static void main(String args[]){
		
		int option = 0;
		int a,b = 0;
		
		System.out.println("Please Choose an Option (1-5)");
		System.out.println("1 : Addition");
		System.out.println("2 : Subraction");
		System.out.println("3 : Multiplication");
		System.out.println("4 : Division");
		System.out.println("5 : Factorial");
		System.out.println("6: Exit");
		
		Scanner scan = new Scanner(System.in);
		
		option = scan.nextInt();
		double result = 0;
		switch(option){
			case 1:
				System.out.println("Enter First Number ");
				a = scan.nextInt();
				System.out.println("Enter Second Number ");
				b = scan.nextInt();
				result = ex2.add(a, b);
				System.out.println("Result is " + result);
				break;
				
			case 2:
				System.out.println("Enter First Number ");
				a = scan.nextInt();
				System.out.println("Enter Second Number ");
				b = scan.nextInt();
				result = ex2.subract(a, b);
				System.out.println("Result is " + result);
				break;
				
			case 3:
				System.out.println("Enter First Number ");
				a = scan.nextInt();
				System.out.println("Enter Second Number ");
				b = scan.nextInt();
				result = ex2.multiply(a, b);
				System.out.println("Result is " + result);
				break;
				
			case 4:
				System.out.println("Enter First Number ");
				a = scan.nextInt();
				System.out.println("Enter Second Number ");
				b = scan.nextInt();
				result = ex2.divide(a, b);
				System.out.println("Result is " + result);
				break;	
			
			case 5:
				System.out.println("Enter Number :");
				a = scan.nextInt();
				result = ex2.fact(a);
				System.out.println("Result is :" + result);
				break;
			
			case 6:
				System.exit(0);
				break;
				
			default:
				break;
				}
		scan.close();
	}
}
