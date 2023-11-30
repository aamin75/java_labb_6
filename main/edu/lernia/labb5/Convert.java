package edu.lernia.labb5;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {

	public static double convertToOne(String sourceCurrency, double sourceAmount, String targetCurrency) throws IOException {
		double exchangeRate= Currency.exchangeRate(sourceCurrency,targetCurrency);
		double targetAmount = 0.0;
		if (exchangeRate!= 0.0) {
			targetAmount = sourceAmount*exchangeRate;
		} else {
			System.out.println("Unfortunately, there are still many currencies unsupported in this version");
		}
		return targetAmount;
	}
	
	public static List<Double> convertToAll(String sourceCurrency, double sourceAmount) {
		
		List<Double> targetAmounts = Currency.allCurrencyRates(sourceCurrency).stream().map(rate -> rate * sourceAmount).collect(Collectors.toList());
		
		return targetAmounts;
		
	}
	
}
