package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;


import java.io.IOException;

public class PolygonJsonReplyTranslator {

    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
    ObjectMapper objmap = new ObjectMapper();


    JsonNode jsn = objmap.readTree(json);
    JsonNode rslts = jsn.get("results").get(0);

    String symbol = jsn.get("ticker").asText();
    double closePrice = rslts.get("c").asDouble();
    double highestPrice = rslts.get("h").asDouble();
    double lowestPrice = rslts.get("l").asDouble();
    int numTransactions = rslts.get("n").asInt();   
    double openPrice = rslts.get("o").asDouble();
    long timestamp = rslts.get("t").asLong();
    double tradingVol = rslts.get("v").asDouble();

    return new StockQuote(symbol, closePrice, highestPrice,
    lowestPrice, numTransactions, openPrice, timestamp, tradingVol);
    
        
    }
}
