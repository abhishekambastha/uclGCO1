package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSeq {

	static Object[] arr = new Object[20];

	public static List<Integer> getSubList(int[] A,int n){
		List<Integer> answer = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();

		temp = answer;

		if(n==0){
			answer.add(A[0]);
			return answer;
		}

		for(int i=0; i<n; i++){
			temp = getSubList(A, i);

			if(A[n]> temp.get(temp.size()-1)){
				temp.add(A[n]);
			}

			if(answer.size()<temp.size()){
				answer = temp;
			}
		}

		return answer;

	}

	public static int getList(int[] A, int k){

		int[] temp = new int[k];
		for(int i =0; i<k; i++){
			temp[i]=1;
		}

		for(int i=1; i<k; i++){
			for(int j=0; j<i; j++){
				if(A[i]>A[j] && temp[i] < temp[j]+1){
					temp[i]= temp[j]+1;
				}
			}
		}

		int max =0;
		for(int i=0; i<k; i++){
			if(max < temp[i]){
				max = temp[i];
			}
		}
		return max;
	}

	public static void main(String[] args){
		int answer;
		int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		//		int[] A = {10, 22, 9, 33, 21, 50, 41, 60};

		answer = getList(A,A.length);

		for(int j=0; j<A.length; j++){
			int[] x = new int[A.length-j];
			for(int k=j;k<A.length;k++){
				x[k-j] = A[k];
			}
			if(x.length>1)
				System.out.println(getSubList(x, x.length-1));
		}
		//		List<Integer> ans = getSubList(A, A.length -1);
		System.out.println(answer);



	}

}
