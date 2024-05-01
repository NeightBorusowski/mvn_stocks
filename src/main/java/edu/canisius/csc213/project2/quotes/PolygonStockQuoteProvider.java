package edu.canisius.csc213.project2.quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.canisius.csc213.project2.util.*;

public class PolygonStockQuoteProvider implements StockQuoteProvider{

    @Override
    public StockQuote getStockQuote(String stockQuoteEndpoint) throws IOException {
        String json = sendGetRequest(stockQuoteEndpoint);
        PolygonJsonReplyTranslator jft = new PolygonJsonReplyTranslator();
        return jft.translateJsonToFinancialInstrument(json);

    }

    public static String sendGetRequest(String endpointUrl) throws IOException{
        URL url = new URL(endpointUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set request method
        conn.setRequestMethod("GET");

        // Create a BufferedReader to read the content
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        // String to store the content
        StringBuilder content = new StringBuilder();
        String line;

        // Read each line of the content and append to the StringBuilder
        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append("\n"); // Add a newline for formatting (optional)
        }

        // Close the reader
        reader.close();

        
        return content.toString();

        
        
    }

    @Override
    public String getEndpointUrl(String symbolName, String date, String apiKey) {
         /*
     * The method is expected to return a well formed URL to contact a quote provider.
     * For example, if you provided:
     * 
     * symbol - AAPL
     * date   - 2023-01-09
     * key    - yourKey
     * 
     * It would reply with: 
     * https://api.polygon.io/v2/aggs/ticker/AAPL/range/1/day/2023-01-09/2023-01-09?apiKey=yourKey
     */
    
        Pattern pattern = Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d");
        Matcher matcher = pattern.matcher(date);
        if (!matcher.find()){
            throw new IllegalArgumentException();
        }
        return "https://api.polygon.io/v2/aggs/ticker/" + symbolName + "/range/1/day/" + date + "/" + date + "?apiKey=" + apiKey;
    

      //  String myURL;
        //myURL = "https://api.polygon.io/v2/aggs/ticker/" + symbolName +"/range/1/day/" + date +"/" + date +"?"+"apiKey="+apiKey;
    //return myURL;

        
    }


}
