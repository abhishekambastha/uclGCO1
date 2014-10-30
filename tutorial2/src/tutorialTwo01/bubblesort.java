package tutorialTwo01;

public class bubblesort {
	public static void main(String[] args){
		int[] a = {8,7,6,5,4,3,2,1,1};
		sort(a);
		
	}
	
	public static void sort(int[] a){
		int len = a.length;
		for(int i=0; i<len; i++){
			for(int j=i+1; j<len; j++ ){
				if(a[i]>a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		for(int el : a){
			System.out.print(el + " ,");
		}
		
	}

}
