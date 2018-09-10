package inventory.stock.controller;

import inventory.stock.dao.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import inventory.stock.model.StockItem;

@Controller
public class StockController {

    @Autowired
    StockDao stockDao;

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }

    @RequestMapping("/getStock")
    @ResponseBody
    public Iterable<StockItem> getAllStock() {
        return stockDao.findAll();
    }

    @RequestMapping(value="/getStockById/stockId/{stockId}", method = RequestMethod.GET)
    public @ResponseBody Iterable<StockItem> getStockById(@PathVariable("stockId") int stockId) {
        return stockDao.findById(stockId);
    }

    @RequestMapping(value = "/addStock", method = RequestMethod.POST)
    @ResponseBody
    public String addStock(StockItem stock) {
        stockDao.save(stock);
        return home();
    }

//    @RequestMapping(value="/updateStockById/stockId/{stockId}", method = RequestMethod.GET) // need to change this to PUT
//    public @ResponseBody Iterable<StockItem> updateStockById(@PathVariable("stockId") int stockId) {
//        return stockDao.updateById(stockId);
//    }

    @RequestMapping(value="/deleteStockById/stockId/{stockId}", method = RequestMethod.GET) // need to change this to DELETE
    public @ResponseBody Iterable<StockItem> deleteStockById(@PathVariable("stockId") int stockId) {
        return stockDao.deleteById(stockId);
    }
}
