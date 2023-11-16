package main;

import java.util.Scanner;

public class CurrencyConverter {

	private static void convert(String sourceCurrency, double sourceAmount, String targetCurrency, double exchangeRate) {
		if (exchangeRate!= 0.0) {
			double targetAmount = sourceAmount*exchangeRate;
			System.out.println(sourceAmount+" "+sourceCurrency+" is equal to "+targetAmount+" "+targetCurrency);
		} else {
			System.out.println("Unfortunately, there are still many currencies unsupported in this version");
		}
			
	}
	
	private static String sourceCurrency() {
		Scanner inputSource = new Scanner(System.in);
		System.out.println("Welcome to the currency converter program");
		System.out.println("Supported currencies: USD, EUR, GBP, SEK");
		System.out.println("Enter the source currency:");
		String currFrom =inputSource.nextLine().toUpperCase();
//		inputSource.close();
		
		return currFrom;
	}

	private static double sourceAmount() {
		Scanner inputAmount = new Scanner(System.in);
		System.out.println("Enter the amount to be converted:");
		double sourceAmount =inputAmount.nextDouble();
		inputAmount.close();
		
		return sourceAmount;
	}
	
	private static String targetCurrency() {
		Scanner inputTarget = new Scanner(System.in);
		
		System.out.println("Enter the target currency:");
		String targetCurrency =inputTarget.nextLine().toUpperCase();
//		inputTarget.close();
		
		return targetCurrency;
	}
	
	public static void main(String[] args) {

		String sourceCurrency = sourceCurrency(); 
		String targetCurrency = targetCurrency();
		double sourceAmount= sourceAmount();
//		Currency currency = new Currency();
		convert(sourceCurrency,sourceAmount,targetCurrency,Currency.exchangeRate(sourceCurrency,targetCurrency));
		
	}


}
