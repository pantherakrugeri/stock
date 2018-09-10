package inventory.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;
    private String stockCode;
    private String stockName;
    private int stockCost;
    private int StockQty;

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockCost() {
        return stockCost;
    }

    public void setStockCost(int stockCost) {
        this.stockCost = stockCost;
    }

    public int getStockQty() {
        return StockQty;
    }

    public void setStockQty(int stockQty) {
        StockQty = stockQty;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "stockId=" + stockId +
                ", stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockCost=" + stockCost +
                ", StockQty=" + StockQty +
                '}';
    }
}
