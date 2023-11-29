package main;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Currency {
	
	public static double exchangeRate(String sourceCurrency, String targetCurrency) throws IOException {
		int sourceIndex=CurrencyConverter.currencyList.indexOf(sourceCurrency);
		int targetIndex=CurrencyConverter.currencyList.indexOf(targetCurrency);
		double exchangeRate = 0.0;
		
		if(sourceIndex!=-1 && targetIndex!=-1) {
			exchangeRate = CurrencyConverter.currencyRate.get(targetIndex)/CurrencyConverter.currencyRate.get(sourceIndex);
		}else {
			System.out.println("Error: unsupported currency");
			System.out.println("Unfortunately, there are still many currencies unsupported in this version");
			System.exit(0);
		}

		return exchangeRate;
	}
	
	public static List<Double> allCurrencyRates(String sourceCurrency) {
//		if(currencyList.contains(sourceCurrency)) {
			double exchangeRate=CurrencyConverter.currencyRate.get(CurrencyConverter.currencyList.indexOf(sourceCurrency));
			List<Double> allCurrencyRates = CurrencyConverter.currencyRate.stream().map(rate -> rate / exchangeRate).collect(Collectors.toList());

			return allCurrencyRates;
//		}
	}
}

 