package main;

import java.util.Scanner;

public class CurrencyConverter {

	private static String sourceCurrency() {
		Scanner inputSource = new Scanner(System.in);
		System.out.println("Welcome to the currency converter program");
		System.out.println("Supported currencies: "+Currency.currencyList);
		System.out.println("Enter the source currency:");
		String sourceCurrency =inputSource.nextLine().toUpperCase();
//		inputSource.close();
		
		return sourceCurrency;
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
		Convert.convertToOne(sourceCurrency,sourceAmount,targetCurrency);
		Convert.convertToAll(sourceCurrency,sourceAmount);
	}


}
