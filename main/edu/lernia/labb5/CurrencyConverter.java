package edu.lernia.labb5;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

interface PrintSingleCurrency {
	void print(Double sourceAmount, Double targetAmount, String sourceCurrency, String targetCurrency);
}

public class CurrencyConverter {

	public static List<String> currencyList = new ArrayList<>(); 
	public static List<Double> currencyRate = new ArrayList<>(); 
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	static void funcSinglePrint(PrintSingleCurrency p,Double d1, Double d2, String s1, String s2) {
		p.print(d1, d2, s1, s2);
	}
	
	static String sourceCurrency() {
		String sourceCurrency = (String)JOptionPane.showInputDialog(null, "Select the source currency:", 
                "Source Currency", JOptionPane.QUESTION_MESSAGE, null, currencyList.toArray(), currencyList.get(8));
		
		if (sourceCurrency == null) {
			JOptionPane.showMessageDialog(null, "THANK YOU FOR USING CURRENCY CONVERTER PROGRAM","System Halted",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		
		return sourceCurrency;
	}

	static double sourceAmount() {
		String obj = JOptionPane.showInputDialog("Enter the amount to be converted","0.0");
		if (obj == null) {
			JOptionPane.showMessageDialog(null, "THANK YOU FOR USING CURRENCY CONVERTER PROGRAM","System Halted",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		double sourceAmount = Double.parseDouble(obj);
		
		return sourceAmount;
	}
	
	static String targetCurrency() {
		String targetCurrency = (String)JOptionPane.showInputDialog(null, "Select the target currency:", 
                "Target Currency", JOptionPane.QUESTION_MESSAGE, null, currencyList.toArray(), currencyList.get(27));
		
		if (targetCurrency == null) {
			JOptionPane.showMessageDialog(null, "THANK YOU FOR USING CURRENCY CONVERTER PROGRAM","System Halted",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		
		return targetCurrency;
	}
	
	public static void main(String[] args) throws IOException{

		JOptionPane.showMessageDialog(null, "Welcome to the currency converter program","Currency Converter",JOptionPane.PLAIN_MESSAGE);

		for (Map.Entry<String, Double> currency : ReadURL.sendHTTPGetRequest().entrySet()) { 
	    	currencyList.add(currency.getKey());
	    	currencyRate.add(currency.getValue()); 
	    } 
		
		String sourceCurrency = sourceCurrency(); 
		String targetCurrency = targetCurrency();
		double sourceAmount= sourceAmount();
		double targetAmount = Convert.convertToOne(sourceCurrency,sourceAmount,targetCurrency);
		funcSinglePrint((d1,d2,s1,s2)-> System.out.println(d1+" "+s1+" is equal to "+df.format(d2)+" "+s2),sourceAmount, targetAmount, sourceCurrency, targetCurrency);
		System.out.println();
		int conversionSelect = JOptionPane.showConfirmDialog(null, 
                "Do you want to proceed?", "Select an Option...",JOptionPane.YES_NO_OPTION);

		if (conversionSelect == 0) {
			List<Double> targetAmounts =  Convert.convertToAll(sourceCurrency,sourceAmount);
			for(int i=0; i < targetAmounts.size(); i++) {
				funcSinglePrint((d1,d2,s1,s2)-> System.out.println(d1+" "+s1+" is equal to "+df.format(d2)+" "+s2),sourceAmount, targetAmounts.get(i), sourceCurrency, CurrencyConverter.currencyList.get(i));
			}
		}
		JOptionPane.showMessageDialog(null, "THANK YOU FOR USING CURRENCY CONVERTER PROGRAM","Currency Converter",JOptionPane.PLAIN_MESSAGE);
		
		
	}

}
