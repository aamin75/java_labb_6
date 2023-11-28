package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

public class ReadURL {
	
	static Map<String, Double> sendHTTPGetRequest() throws IOException {
		String GET_URL = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_FFc5jZzCGr0JDgB7uaUmA7DxWtDgrZ3EsrRNTfcP";
		URL url = new URL(GET_URL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		int responseCode = httpURLConnection.getResponseCode();
		
		Map<String, Double> urlCurrencies = new HashMap<String, Double>(); 

		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader inStream = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine=inStream.readLine()) != null) {
				response.append(inputLine);
			} inStream.close();
			
			JSONObject obj = new JSONObject(response.toString());
			JSONObject subObj = obj.getJSONObject("data");
			Iterator<String> keys = subObj.keys();
			while(keys.hasNext()){
				String key = keys.next();
				Double value = subObj.getDouble(key);
			    urlCurrencies.put(key, value); 
			}
	    
		} else {
			System.out.println("GET Request failed");
		}
		return urlCurrencies;
	}

}
