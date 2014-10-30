package tutorial3;

public class ex2 {

	public static String[] remElement(String[] array, int index){
		String[] arr = new String[(array.length -1)];

		int count =0;

		for(int i=0; i<(array.length);i++ ){
			if(i != index){
				arr[count++] = array[i];
			}
		}
		
		return arr;
	}

	public static void main(String args[]){
		String arr[] = {"The" , "quick" , "brown", "fox" , "jumps",
				"over" , "the" , "lazy" , "dog" } ;

		arr = remElement(arr, 4);

		for(String val: arr){
			System.out.print(val + " ");
		}

	}
}
