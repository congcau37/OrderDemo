package vn.com.misa.orderdemo.order;

import java.util.ArrayList;
import java.util.List;

import vn.com.misa.orderdemo.model.Food;

/**
 *
 * @created_by tdcong
 * @date 5/20/2019
 */
public interface OrderContract {

    interface IOrderView {

        void displayListOrder(List<Food> arrayList);
    }

    interface IOrderPresenter {
        void loadAllFood();
    }
}
