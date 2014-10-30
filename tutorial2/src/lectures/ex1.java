package lectures;
import java.util.Scanner;

public class ex1 {
	public static void main(String[] args){
		System.out.println("1. Speed unit Conversion");
		System.out.println("2. Length Conversion");
		System.out.println("3. Base Numbers");
		System.out.println("4. Mass Conversions");
		Scanner scan1 = new Scanner(System.in);
		int opt = scan1.nextInt();
		
		switch(opt){
		case 1: speed(); break;
		case 2: len(); break;
		case 3: base(); break;
		case 4: mass(); break;
		default: break;
		}
		
		scan1.close();
	}

	public static void len(){
		Scanner scan = new Scanner(System.in);
		String value;
		String unit;

		double meters=0;
		double yards=0;
		double inches=0;
		double cm=0;
		double asu=0;

		System.out.println("Enter Length (meters, inches, yards, cm or asu)");
		value = scan.next();
		unit = scan.next();
		double val = Double.parseDouble(value);
		scan.close();
		unit = unit.toLowerCase();

		if(unit.equals("meters")){
			meters = val;
			yards = 1.0936133 * meters;
			inches = 39.3700787 * meters;
			cm = 100 * meters;
			asu = 6.68458712 * Math.pow(10, -12)* meters ; 
		}else if(unit.equals("yards")){
			yards = val;
			meters = 0.9144* yards;
			inches = 36*yards;
			cm = 100 * meters;
			asu = 6.68458712 * Math.pow(10, -12)* meters ;
		}else if(unit.equals("inches")){
			inches = val;
			meters = 0.0254 * inches;
			yards = 1.0936133 * meters;
			cm = 100 * meters;
			asu = 6.68458712 * Math.pow(10, -12)* meters ; 
		}else if(unit.equals("cm")){
			cm = val;
			meters = 0.01 * cm;
			yards = 1.0936133 * meters;
			inches = 39.3700787 * meters;

			asu = 6.68458712 * Math.pow(10, -12)* meters ; 
		}else if(unit.equals("asu")){
			asu = val;
			meters = 149597870700D*asu;
			yards = 1.0936133 * meters;
			inches = 39.3700787 * meters;
			cm = 100 * meters; 
		}
		System.out.println(meters + " meters");
		System.out.println(cm + " cm");
		System.out.println(yards + " yards");
		System.out.println(inches + " inches");
		System.out.println(asu + " asu");
	}
	public static void speed(){
		int opt = 0;
		double kms =0;
		double mils = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Speed in 1. km/h \n 2. miles/h ");
		opt = scan.nextInt();
		if(opt == 1){
			System.out.println("Enter Speed in km/h");
			kms = scan.nextDouble();
			mils = 0.62 * kms;
			System.out.println("Speed in miles/h is " + mils + "miles/h");
		}else{
			System.out.println("Enter Speed in miles/h");
			mils = scan.nextDouble();
			kms = 1.6 * mils;
			System.out.println("Speed in km/h is " + kms + "km/h");

		}
		scan.close();
	}

	public static void base(){
		int opt;
		System.out.println("Enter 1 for binary to decimal or 2 for decimal to binary");
		Scanner scan=new Scanner(System.in);
		opt = scan.nextInt();

		double valBinary=0;
		double valDecimal=0;
		if(opt ==1){
			System.out.println("Enter Binary Number :");
			int binary = scan.nextInt();
			int power = 0;
			while(binary != 0){
				int temp = binary%10;
				valDecimal += temp * Math.pow(2, power);
				binary = binary/10;
				power++;
			}
			System.out.println("Decimal Form is " + valDecimal);

		}else if(opt ==2){
			System.out.println("Enter Decimals Number :");
			int dec = scan.nextInt();
			int power = 0;
			while(dec!=0){
				valBinary += Math.pow(10, power) * (dec%2);
				power++;
				dec = dec/2;
			}
			
			System.out.println("Binary Form is " + (int)valBinary);

		}
		scan.close();
	}

	public static void mass(){
		System.out.println("1. kg to pounds");
		System.out.println("2. pounds to kg");
		double kg =0;
		double pounds = 0;
		
		Scanner scan = new Scanner(System.in);
		int opt = scan.nextInt();
		if(opt ==1 ){
			kg = scan.nextDouble();
			pounds = 2.204 * kg;
			System.out.println("Mass in pounds = " + pounds);
		}else{
			pounds = scan.nextDouble();
			kg = 0.454 * pounds;
			System.out.println("Mass in Kgs " + kg);
		}
		scan.close();
	}
}

