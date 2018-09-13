package inventory.stock.controller;

import inventory.stock.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import inventory.stock.model.StockItem;
import java.util.Optional;


@RestController
public class StockController {

    @Autowired
    StockDao stockDao;

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/getStock")
    @ResponseBody
    public Iterable<StockItem> getAllStock() {
        return stockDao.findAll();
    }

    @GetMapping("/getStockById/stockId/{stockId}")
    @ResponseBody
    public StockItem getStockById(@PathVariable int stockId) {
        Optional<StockItem> stockItemOptional = stockDao.findById(stockId);

        if (!stockItemOptional.isPresent()) {

        }
        return stockItemOptional.get();
    }

    @PostMapping("/addStock")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public StockItem addStock( StockItem stock) {
       return stockDao.save(stock);
    }

    @PutMapping("/updateStockById/{stockId}")
    @ResponseStatus(HttpStatus.OK)
    public StockItem updateStock(@RequestBody StockItem stockItem, @PathVariable int stockId) {

        return stockDao.findById(stockId)
                .map(sItem -> {
                    stockItem.setStockName(stockItem.getStockName());
                    stockItem.setStockCode(stockItem.getStockCode());
                    stockItem.setStockCost(stockItem.getStockCost());
                    stockItem.setStockQty(stockItem.getStockQty());
                    return stockDao.save(sItem);
                })
                .orElseGet(() -> {
                    stockItem.setStockId(stockId);
                    return stockDao.save(stockItem);
                });
    }

    @DeleteMapping("/deleteStockById/stockId/{stockId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStockById(@PathVariable("stockId") int stockId) {
        stockDao.deleteById(stockId);
    }
}
