package main;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

interface PrintSingleCurrency {
	void print(Double sourceAmount, Double targetAmount, String sourceCurrency, String targetCurrency);
}

public class Convert {

	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	static void funcSinglePrint(PrintSingleCurrency p,Double d1, Double d2, String s1, String s2) {
		p.print(d1, d2, s1, s2);
	}
	
	public static void convertToOne(String sourceCurrency, double sourceAmount, String targetCurrency) throws IOException {
		double exchangeRate= Currency.exchangeRate(sourceCurrency,targetCurrency);
		if (exchangeRate!= 0.0) {
			double targetAmount = sourceAmount*exchangeRate;
			funcSinglePrint((d1,d2,s1,s2)-> System.out.println(d1+" "+s1+" is equal to "+df.format(d2)+" "+s2),sourceAmount, targetAmount, sourceCurrency, targetCurrency);
		} else {
			System.out.println("Unfortunately, there are still many currencies unsupported in this version");
		}
	}
	
	public static void convertToAll(String sourceCurrency, double sourceAmount) {
		
		List<Double> targetAmounts = Currency.allCurrencyRates(sourceCurrency).stream().map(rate -> rate * sourceAmount).collect(Collectors.toList());
//		List<Double> sortedTargetAmounts = targetAmounts.stream().sorted().toList();
//		Collections.sort(targetAmounts,Collections.reverseOrder());
		
		for(int i=0; i < targetAmounts.size(); i++) {
			funcSinglePrint((d1,d2,s1,s2)-> System.out.println(d1+" "+s1+" is equal to "+df.format(d2)+" "+s2),sourceAmount, targetAmounts.get(i), sourceCurrency, CurrencyConverter.currencyList.get(i));
		}
		
	}
	
}
