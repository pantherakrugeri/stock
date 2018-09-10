package inventory.stock.dao;

import org.springframework.data.repository.CrudRepository;
import inventory.stock.model.StockItem;

import java.util.List;

public interface StockDao extends CrudRepository<StockItem, Integer> {
    List<StockItem> findById(int stockId);
    List<StockItem> deleteById(int stockId);
    //List<StockItem> updateById(int stockId);
}
