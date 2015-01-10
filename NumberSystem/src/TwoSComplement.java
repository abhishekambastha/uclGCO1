
public class TwoSComplement {
	@SuppressWarnings("unused")
	public static void main(String...argc){
		int integer=0;
		char character=0;
		short shortNumber=0;
		byte isByte=0;
		long isLong=0;
		float isfloat=0;      
		

		System.out.println("Bytes in Long    :" + Long.SIZE/8);
		System.out.println("Bytes in Integer :" + Integer.SIZE/8);
		
		System.out.println("Bytes in Char    :" + Character.SIZE/8);
		System.out.println("Bytes in Short   :" + Short.SIZE/8);
		
		//Float and Double
		System.out.println("Bytes in Float   :" + Float.SIZE/8);
		System.out.println("Bytes in Double  :" + Double.SIZE/8);

		//Lets See
		integer = 0x0000F001;
//		integer = 0x00008001;
		System.out.println("Integer = " +integer);
		
		shortNumber = (short)integer;
		System.out.println("Short Number ="+ shortNumber);
		
		integer = 0x7FFFFFFF;
		System.out.println("Max Integer = " + integer);
		System.out.println("Max Integer +1 = " + (integer+1));
		
		//integer + 1 is same as the one below !
		integer = 0x80000000;
		System.out.println("The above result is same as 0x80000000  = " + integer);

		
		//Now floating points
		
		isfloat = 0x7FFFFFFF;
		System.out.println("Max Positive float :" + isfloat);
		integer = (int)isfloat;
		System.out.println(integer);
		
		//float is interseting !!
		isfloat = 0x0F000001;
		System.out.println(isfloat);
		
		isfloat=1.22225f;
		integer = (int)isfloat;
		System.out.println(isfloat);
	}

}
