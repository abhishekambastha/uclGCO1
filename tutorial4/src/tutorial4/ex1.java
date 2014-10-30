package tutorial4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class ex1 {

	public static void main(String...args){
		Random rand = new Random();
		ArrayList<Integer> a = new ArrayList<Integer>();

		int sum =0;

		for(int i=0; i<10; i++){
			a.add(rand.nextInt(10));
		}

		for(int i : a){
			System.out.print(i + ", ");
			if(i%2==0){
				sum += i;
			}
		}

		//remove odd elements and add to the back.!
		ArrayList<Integer> aOdd = new ArrayList<Integer>();
		for(int i=0; i<a.size(); i++){
			if(1.0* a.get(i) %2 !=0 ){
				aOdd.add(a.get(i));
				a.remove(i--);
			}
		}
		a.addAll(aOdd);
		Integer[] array = a.toArray(new Integer[0]);

		System.out.println("\nSum of even members of List = " + sum);

		System.out.println(Arrays.toString(array));

		//System.out.println();
	}
}
