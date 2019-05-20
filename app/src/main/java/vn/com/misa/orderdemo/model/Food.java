package vn.com.misa.orderdemo.model;

/**
 * class món ăn
 * @created_by tdcong
 * @date 5/20/2019
 */
public class Food {
    int idFood;
    String foodName;
    int Price;
    String Unit;
    int Color;
    int Icon;
    String Status;

    public Food(int idFood, String foodName, int price, String unit, int color, int icon, String status) {
        this.idFood = idFood;
        this.foodName = foodName;
        Price = price;
        Unit = unit;
        Color = color;
        Icon = icon;
        Status = status;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
