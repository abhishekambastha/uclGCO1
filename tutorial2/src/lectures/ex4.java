package lectures;

import java.util.Scanner;

public class ex4 {
	public static void main(String... args){
		int rows=0;
		int cols = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of rows :");
		rows = scan.nextInt();
		System.out.println("Enter no. of cols :");
		cols = scan.nextInt();
		
		System.out.println("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		for(int r=0; r< rows; r++){
			System.out.println("<tr>");
			for(int c=0; c< cols; c++){
				System.out.println("<td>&nbsp;</td>");
			}
			System.out.println("</tr>");
		}
		System.out.println("</table>");
		scan.close();
	}
}
