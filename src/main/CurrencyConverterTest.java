package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Currency.*;

public class CurrencyConverterTest {

	@Test
	@DisplayName("Test supported currency")
	public void testSupportedCurrncey() {
//		Currency currency = new Currency();
		double expectedRate = Currency.exchangeRate("SEK","EUR");
		double actualRate = 0.08677915119612727358180194576303;
        assertEquals(expectedRate, actualRate);
	}
	
	@Test
	@DisplayName("Test unsupported currency")
	public void testUnsupportedCurrncey() {
//		Currency currency = new Currency();
		double expectedRate = Currency.exchangeRate("SEK","NOK");
		double actualRate = 0.0;
        assertEquals(expectedRate, actualRate);
	}

}
 