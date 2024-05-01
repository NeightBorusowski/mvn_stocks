package edu.canisius.csc213.project2.quotes;

public class StockQuote {
    private String symbol;
    private double closePrice;
    private double highestPrice;
    private double lowestPrice;
    private int numTransactions;
    private double openPrice;
    private long timestamp;
    private double tradingVol;
    

    //public StockQuote(String string, double d, double e, double f, int i, double g, long timeMillis, int j) {
        //TODO Auto-generated constructor stub
    //}

    public StockQuote(String string, double d, double e, double f, int i, double g, long timeMillis, double h) {
        this.symbol = string;
        this.closePrice = d;
        this.highestPrice = e;
        this.lowestPrice = f;
        this.numTransactions = i;
        this.openPrice = g;
        this.timestamp = timeMillis;
        this.tradingVol = h;

    }

    public String prettyPrint() {
        return "Symbol: " + symbol +
        "\nClose Price: " + closePrice +
        "\nHighest Price: " + highestPrice + 
        "\nLowest Price: " + lowestPrice +
        "\nNumber of Transactions: " + numTransactions +
        "\nOpen Price: " + openPrice +
        "\nTrading Volume: " + tradingVol + "\n";
    }

    public Object getSymbol() {
        return symbol;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public double getLowestPrice() {
       return lowestPrice;
    }

    public Object getNumberOfTransactions() {
        return numTransactions;
    }

    public double getOpenPrice() {
     return openPrice;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public double getTradingVolume() {
       return tradingVol;
    }

}
