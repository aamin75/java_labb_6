package edu.lernia.labb5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;


public class CurrencyConverterTest {

	@Test
	@DisplayName("Test HTTP GET request return not null Map")
	void testURLMap() throws IOException {
		Map<String, Double> urlCurrency = ReadURL.sendHTTPGetRequest();
		assertNotNull(urlCurrency);
	}
	
	@Test
	@DisplayName("Test HTTP return Map has a currency")
	void testMapHasACurrency() throws IOException {
		Map<String, Double> urlCurrency = ReadURL.sendHTTPGetRequest();
		assertTrue(urlCurrency.containsKey("SEK"));
	}
	
	@Test
	@DisplayName("Test HTTP return Map has an exchange rate")
	void testMapHasAnExchangeRate() throws IOException {
		Map<String, Double> urlCurrency = ReadURL.sendHTTPGetRequest();
		assertTrue(urlCurrency.get("SEK") != 0.0);
	}
	
	@Test
	@DisplayName("Test entering source amount")
	void testEnteringSourceAmount() {
		double sourceAmount = CurrencyConverter.sourceAmount(); 
		assertNotNull(sourceAmount);
	}

}
 