package servicecentermanagementfx.entities;

import java.util.ArrayList;

public class OrdersDatabase {

    private ArrayList<Order> ordersDatabase = new ArrayList<>();

    public void addNewOrder(Order order) {
        this.ordersDatabase.add(order);
    }

    public ArrayList<Order> getOrdersDatabase() {
        return ordersDatabase;
    }
    
    public int getNextOrderNumber(){
        int nextOrderNumber = 0;
        nextOrderNumber = this.ordersDatabase.size()+1;
        return nextOrderNumber;
    }

}
