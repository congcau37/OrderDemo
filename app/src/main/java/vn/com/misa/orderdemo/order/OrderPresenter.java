package vn.com.misa.orderdemo.order;

import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import vn.com.misa.orderdemo.model.Food;

/**
 * @param
 * @return
 * @created_by tdcong
 * @date 5/10/2019
 */
public class OrderPresenter implements OrderContract.IOrderPresenter {
    OrderContract.IOrderView iOrderView;
    IOrder iOrder;

    public OrderPresenter(IOrder iOrder, OrderContract.IOrderView iOrderView) {
        this.iOrder = iOrder;
        this.iOrderView = iOrderView;
    }

    /**
     * Hàm
     * @param
     * @return
     */
    @Override
    public void loadAllFood() {
        try {
            iOrder.getAllFood(new IOrder.IGetAllFoodCallBack() {
                @Override
                public void getAllFood(List<Food> foods) {
                    iOrderView.displayListOrder(foods);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
