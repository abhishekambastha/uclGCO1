package tutorial2;

import java.util.Date;

/**
 * <dl>
 * <dt>Purpose:
 * <dd>First Program
 * 
 * <dt>Description:
 * <dd>Prints Hello World!
 * </dl>
 * 
 * 
 * @author abhishek
 * @version $Date: 26th September, 2014 14:51 $
 *
 */

public class ex2 {

	public static void main(String args[]) {
		ex2 date = new ex2();
		System.out.println("Hello World!");
		date.printDate();
	}

	public void printDate() {
		Date a = new Date();
		System.out.println(a);
	}

}