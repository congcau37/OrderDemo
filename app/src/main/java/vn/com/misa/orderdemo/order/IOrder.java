package vn.com.misa.orderdemo.order;

import java.util.ArrayList;
import java.util.List;

import vn.com.misa.orderdemo.model.Food;

/**
 *
 * @created_by tdcong
 * @date 5/20/2019
 */
public interface IOrder {

    interface IGetAllFoodCallBack{
        void getAllFood(List<Food> foods);
    }
    void getAllFood(IGetAllFoodCallBack callBack);
}
