package dynamicProgramming;

public class RodCutting {

	static int[] revenue;
	static int[] price;
	static int count = 0;
	static int firstCut;
	
	public static void main(String[] args){
		revenue = new int[11];
		price = new int[11];
		
		for(int i=0; i<11; i++){
			revenue[i] = -100;
		}
		
		price[1] = 1;
		price[2] = 5;
		price[3] = 8;
		price[4] = 9;
		price[5] = 10;
		price[6] = 17;
		price[7] = 17;
		price[8] = 20;
		price[9] = 24;
		price[10] = 30;
		
		int ans = cutRod(price, 9);
//		System.out.println(ans);
//		System.out.println(count);
		System.out.println("Optimal Length of first Cut is " + firstCut + " and revenue is " + ans);
	}
	
	public static int cutRod(int[] p, int n){
		if(revenue[n]>=0){
			return revenue[n];
		}
		
		if(n==0){
			return 0;
		}
		
		int q = -100;
		int temp = -129;
		for(int i=1; i<=n; i++){
			temp = q;
			q = max(q, p[i] + cutRod(p, n-i));
			if(temp != q){
				firstCut = i;
			}
			count++;
		}
		
		revenue[n] = q;
		return q;
	}
	
	public static int max(int a, int b){
		int res = (a>b)? a:b;
		return res;
	}
}
