package exercise2;

import java.util.ArrayList;

public class Currency {

	ArrayList<String> currency = new ArrayList<String>();
	private double USD = 0;
	private double GBP = 0;
	private double YEN = 0;
	private double EU = 0;

	public Currency(){
		super();
		currency.add("USD");
		currency.add("GBP");
		currency.add("YEN");
		currency.add("EU");
	}

	public double getConversion(double value, String sourceCurrency, String destCurrency){
		switch(sourceCurrency){
		case "USD": USDConvert(value); break;
		case "GBP": GBPConvert(value); break;
		case "EU": EUConvert(value); break;
		case "YEN": YENConvert(value); break;
		}
		
		switch(destCurrency){
		case "USD": return USD;
		case "GBP": return GBP;
		case "EU": return EU;
		case "YEN":return YEN;
		}
		
		return 0;
	}

	public void USDConvert(double value){
		this.USD = value;
		this.GBP = value*0.62;
		this.EU = value*0.79;
		this.YEN = value*107.78;
	}

	public void GBPConvert(double value){
		this.GBP = value;
		this.USD = value*1.61;
		this.EU = value*1.27;
		this.YEN = value*173.78;
	}
	
	public void YENConvert(double value){
		this.YEN = value;
		this.USD = value*0.0093;
		this.EU = value*0.0073;
		this.GBP = value*0.0058;
	}
	
	public void EUConvert(double value){
		this.EU=value;
		this.USD = value*1.27;
		this.GBP = value*0.97;
		this.YEN = value*136.86;
	}
}
