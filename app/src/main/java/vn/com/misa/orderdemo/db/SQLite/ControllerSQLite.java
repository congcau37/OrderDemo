package vn.com.misa.orderdemo.db.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import vn.com.misa.orderdemo.db.DataManager;
import vn.com.misa.orderdemo.model.Food;

/**
 *
 * @created_by tdcong
 * @date 5/20/2019
 */
public class ControllerSQLite extends DBOpenHeplper implements DataManager.SQLite {

    public ControllerSQLite(Context context) {
        super(context);
    }

    @Override
        public ArrayList<Food> getFoodArrayList() {
        ArrayList<Food> food = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * from food", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int foodID = cursor.getInt(cursor.getColumnIndex("FoodID"));
                String foodName = cursor.getString(cursor.getColumnIndex("FoodName"));
                int Price = cursor.getInt(cursor.getColumnIndex("Price"));
                String Unit = cursor.getString(cursor.getColumnIndex("Unit"));
                int Color = cursor.getInt(cursor.getColumnIndex("Color"));
                int Icon = cursor.getInt(cursor.getColumnIndex("Icon"));
                String Status = cursor.getString(cursor.getColumnIndex("Status"));
                food.add(new Food(foodID, foodName, Price, Unit, Color, Icon, Status));
                cursor.moveToNext();
            }

            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return food;
    }
}
