package main;

public class Currency {

	public static double exchangeRate(String sourceCurrency, String targetCurrency) {
		// Exchange rate to USD for the supported currencies 
		double USD = 1.0; 
		double EUR = 0.9232; 
		double GBP = 0.8036;
		double SEK = 10.6385;
		double exchangeRate = 0.0;
		
		 switch (targetCurrency) {
			 case "USD":
			     exchangeRate = USD;
			     break;
			 case "EUR":
				 exchangeRate = EUR;
			     break;
			 case "GBP":
				 exchangeRate = GBP;
			     break;
			 case "SEK":
				 exchangeRate = SEK;
			     break;
			 default:
			     System.out.println("Unsupported target currency");
			     exchangeRate = 0.0;
		 }
		 
		 switch (sourceCurrency) {
			 case "USD":
			     exchangeRate /= USD;
			     break;
			 case "EUR":
				 exchangeRate /= EUR;
			     break;
			 case "GBP":
				 exchangeRate /= GBP;
			     break;
			 case "SEK":
				 exchangeRate /= SEK;
			     break;
			 default:
			     System.out.println("Unsupported source currency");
			     exchangeRate = 0.0;
		 }
		 
		 return exchangeRate;
	}
	
}

