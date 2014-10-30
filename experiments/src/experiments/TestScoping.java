package experiments;

public class TestScoping {
	private int i = 10;
	
	public void firstMethod(){
		int i = 4;
		int j =5;
		this.i = i+j;
		//secondMethod(7);
	}
	
	public void secondMethod(int i){
		int j = 8;
		this.i = i+j;
	}
	
	public static void main(String args[]){
		TestScoping chck = new TestScoping();
		System.out.println("Objs i = " + chck.i);
		chck.firstMethod();
		System.out.println("After 1st Method = " + chck.i);
		chck.secondMethod(7);
		System.out.println("After 2nd Method = " + chck.i);
		int i = 0;
		while(i<10){
			System.out.println(i + " squared is " + (i*i));
			i++; }
	}
}
