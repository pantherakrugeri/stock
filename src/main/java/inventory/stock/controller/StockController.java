package inventory.stock.controller;

import inventory.stock.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public StockItem getStockById(@PathVariable int stockId) {
        Optional<StockItem> stockItemOptional = stockDao.findById(stockId);

        if (!stockItemOptional.isPresent()) {

        }
        return stockItemOptional.get();
    }

    @PostMapping("/addStock")
    public void addStock( StockItem stock) {
        stockDao.save(stock);
    }

    @PutMapping("/updateStockById/{stockId}")
    StockItem updateStock(@RequestBody StockItem stockItem, @PathVariable int stockId) {

        return stockDao.findById(stockId)
                .map(sItem -> {
                    stockItem.setStockName(stockItem.getStockName());
                    stockItem.setStockCode(stockItem.getStockCode());
                    return stockDao.save(sItem);
                })
                .orElseGet(() -> {
                    stockItem.setStockId(stockId);
                    return stockDao.save(stockItem);
                });
    }

    @DeleteMapping("/deleteStockById/stockId/{stockId}")
    public @ResponseBody Iterable<StockItem> deleteStockById(@PathVariable("stockId") int stockId) {
        return stockDao.deleteById(stockId);
    }
}
