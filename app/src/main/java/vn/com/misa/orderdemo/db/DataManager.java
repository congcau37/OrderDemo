package vn.com.misa.orderdemo.db;
import java.util.ArrayList;
import vn.com.misa.orderdemo.model.Food;

/**
 *
 * @created_by tdcong
 * @date 5/20/2019
 */
public interface DataManager {

    public interface SQLite {
        public ArrayList<Food> getFoodArrayList();
    }
}
