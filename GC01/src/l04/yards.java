package l04;

public class yards {
	private long yards =0L;
	public long inch=0L;
	public long meter = 0L;
	public double cm = 100L;
	public long asu = 0L;


	public yards(long val){
		yards = val;
		inch = yards;
		meter = yards;
		cm = 0.010936133 * yards;
		asu = yards;
	}
	
	public yards(){
		
	}

}
