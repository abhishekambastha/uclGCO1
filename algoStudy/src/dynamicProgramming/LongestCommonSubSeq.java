package dynamicProgramming;

public class LongestCommonSubSeq {

	static char[] second = {'A','B','C','B','D','A','B','Z'};
	static char [] first = {'B','D','C','A','B','A','Z'};
	static int [][] LCS = new int[first.length][second.length];

	public static void main(String args[]){

		LCS[0][0] = 0;
		for(int i =1; i<first.length ; i++){
			LCS[i][0] = 1;
		}

		for(int j =1; j<second.length ; j++){
			LCS[0][j] = 1;
		}

		for(int i=1;  i<first.length ; i++){
			for(int j=1; j<second.length; j++){
				if(first[i] == second[j]){
					LCS[i][j] = LCS[i-1][j-1] +1;
				}else{
					LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}


		//print LCS
		for(int i=0; i<first.length ;i++){
			for(int j=0; j<second.length; j++){
				System.out.print(LCS[i][j] + "\t");
			}
			System.out.println("\n");
		}

		int res = LCSrecursive(first,first.length-1,second,second.length-1);
		System.out.println("Answer from recursion = " + res);
		
	}

	public static int LCSrecursive(char[] x, int n, char[] y, int m){
		if(n==0 || m==0){ return 1;}
		
		//avoid calculating if done previously ! -- meomizing !! :D
		if(x[n]==y[m]){
			return LCSrecursive(x,n-1,y,m-1) + 1;
		}
		else{
			return max(LCSrecursive(x,n-1,y,m),LCSrecursive(x,n,y,m-1)); 
		}

	}

	public static int max(int first, int second){

		int ans = (first>second)? first:second;
		return ans;
	}
}
