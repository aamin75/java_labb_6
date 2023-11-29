package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class CurrencyConverter {

	public static List<String> currencyList = new ArrayList<>(); 
	public static List<Double> currencyRate = new ArrayList<>(); 
	
	private static String sourceCurrency() {
		String sourceCurrency = (String)JOptionPane.showInputDialog(null, "Select the source currency:", 
                "Source Currency", JOptionPane.QUESTION_MESSAGE, null, currencyList.toArray(), currencyList.get(8));
		
		if (sourceCurrency == null) {
			JOptionPane.showMessageDialog(null, "THANK YOU FOR USING CURRENCY CONVERTER PROGRAM","System Halted",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		
		return sourceCurrency;
	}

	private static double sourceAmount() {
		String obj = JOptionPane.showInputDialog("Enter the amount to be converted","0.0");
		if (obj == null) {
			JOptionPane.showMessageDialog(null, "THANK YOU FOR USING CURRENCY CONVERTER PROGRAM","System Halted",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		double sourceAmount = Double.parseDouble(obj);
		
		return sourceAmount;
	}
	
	private static String targetCurrency() {
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
		Convert.convertToOne(sourceCurrency,sourceAmount,targetCurrency);
		System.out.println();
		int conversionSelect = JOptionPane.showConfirmDialog(null, 
                "Do you want to proceed?", "Select an Option...",JOptionPane.YES_NO_OPTION);

		if (conversionSelect == 0) {
			Convert.convertToAll(sourceCurrency,sourceAmount);
		}
		JOptionPane.showMessageDialog(null, "THANK YOU FOR USING CURRENCY CONVERTER PROGRAM","Currency Converter",JOptionPane.PLAIN_MESSAGE);
		
		
	}

}
