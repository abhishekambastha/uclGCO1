package tutorialTwo;

public class ex3 {
	
	public static void main(String a[]){
		
		int numbers[] = new int[20];
		numbers[0] = 1;
		
		for(int i=1; i<20; i++){
			numbers[i] = 2 * numbers[i-1];
		}
		
		float avg[] = new float[20];
		avg[0] = numbers[0];
		avg[19] = numbers[19];
		
		for(int i=1; i<19; i++){
			avg[i] = (numbers[i-1] + numbers[i+1])/(2.0f);
		}
		
		System.out.println("Numbers   ");
		for(int e : numbers){
			System.out.print(e + "\t");
		}
		
		System.out.println("\n Means ");
		for(float e : avg){
			System.out.print(e + "\t");
		}
		
	}

}
