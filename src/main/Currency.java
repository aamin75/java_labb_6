package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Currency {
	
	static List<String> currencyList = new ArrayList<>(); //Arrays.asList("USD","EUR","GBP","SEK");
	static List<Double> currencyRate = new ArrayList<>(); //Arrays.asList(1.0,0.9232,0.8036,10.6385);

	public static double exchangeRate(String sourceCurrency, String targetCurrency) throws IOException {
		for (Map.Entry<String, Double> currency : ReadURL.sendHTTPGetRequest().entrySet()) { 
	    	currencyList.add(currency.getKey());
	    	currencyRate.add(currency.getValue()); 
	    } 

		int sourceIndex=currencyList.indexOf(sourceCurrency);
		int targetIndex=currencyList.indexOf(targetCurrency);
		double exchangeRate = 0.0;
		
		if(sourceIndex!=-1 && targetIndex!=-1) {
			exchangeRate = currencyRate.get(targetIndex)/currencyRate.get(sourceIndex);
		}else {
			System.out.println("Error: unsupported currency");
		}

		return exchangeRate;
	}
	
	public static List<Double> allCurrencyRates(String sourceCurrency) {
//		if(currencyList.contains(sourceCurrency)) {
			double exchangeRate=currencyRate.get(currencyList.indexOf(sourceCurrency));
			List<Double> allCurrencyRates = currencyRate.stream().map(rate -> rate / exchangeRate).collect(Collectors.toList());

			return allCurrencyRates;
//		}
	}
}

 