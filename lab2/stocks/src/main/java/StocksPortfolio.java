import java.util.ArrayList;

public class StocksPortfolio {
    private ArrayList<Stock> stocks = new ArrayList<>();
    private IStockMarket stockmarket;

    public StocksPortfolio(IStockMarket stockMarket){
        this.stockmarket = stockMarket;
    }

    public void addStock (Stock s){
        stocks.add(s);
    }

    public double getTotalValue(){
        double result = 0;
        for (Stock s : stocks){
            result += stockmarket.getPrice(s.getLabel()) * s.getQuantity();
        }
        return result;
    }

}
