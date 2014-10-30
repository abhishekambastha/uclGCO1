package lectures;

import java.util.Scanner;

public class ex2 {
	public static void main(String... args){
		String currency;
		String value;
		
		double YEN = 0;
		double USD = 0;
		double GBP = 0;
		double EUR = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter the value and currency separated by a space :");
		System.out.println("Supported Currencies are YEN, GBP, USD,EUR");
		
		value = scan.next();
		currency = scan.next();
		currency = currency.toUpperCase();
		
		if(currency.equals("YEN")){
			YEN = Double.parseDouble(value);
			USD = 0.0091 *  YEN ;
			GBP = 0.0056 * YEN;
			EUR = 0.0073 * YEN;
		}else if(currency.equals("USD")){
			USD = Double.parseDouble(value);
			YEN = 109.44 * USD;
			GBP = 0.62 * USD;
			EUR = 0.79 * USD;
		}else if(currency.equals("GBP")){
			GBP = Double.parseDouble(value);
			USD = 1.62 * GBP;
			EUR = 1.29 * GBP;
			YEN = 177.72 * GBP;
		}else if(currency.equals("EUR")){
			EUR = Double.parseDouble(value);
			USD = 1.26 * EUR;
			YEN = 138.01  * EUR;
			GBP =  0.78 * EUR;
		}
		
		System.out.println("Value in Pounds : " + GBP + "GBP");
		System.out.println("Value in Euros  : " + EUR + "EUR");
		System.out.println("Value in YEN    : " + YEN + "YEN");
		System.out.println("Value in US Doll: " + USD + "USD");
		
		scan.close();
	}
}
