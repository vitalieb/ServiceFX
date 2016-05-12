package servicecentermanagementfx;

import java.awt.Image;
import java.util.ArrayList;
import servicecentermanagementfx.entities.CartridgeOrder;
import servicecentermanagementfx.entities.Contractor;
import servicecentermanagementfx.entities.ContractorCompany;
import servicecentermanagementfx.entities.ContractorPerson;
import servicecentermanagementfx.entities.Order;
import servicecentermanagementfx.entities.OrdersDatabase;
import servicecentermanagementfx.entities.RepairOrder;
import servicecentermanagementfx.entities.User;
import servicecentermanagementfx.entities.UsersDatabase;

public class ServiceCenterManagement {

    public static void main(String[] args) {
//        JFrame loginWindow = new LoginWindow();
//        loginWindow.setVisible(true);
        
        OrdersDatabase ordersDatabase = new OrdersDatabase();
        UsersDatabase usersDatabase = new UsersDatabase();
        ArrayList<User> usersDatabaseList = usersDatabase.getUsersDatabase();
        double priceAtMomentOfSale;
        priceAtMomentOfSale = 12;
        Image[] imagesFromCamera = {};

        Contractor person = new ContractorPerson("Ion", "Placinta", Boolean.FALSE, "069003120", "Orhei, s.Lucaseuca");
        RepairOrder order = new RepairOrder(ordersDatabase.getNextOrderNumber(), null, null, imagesFromCamera, null, null, true, null, null, null, null, true, priceAtMomentOfSale, person, "arata normal", null, null, null);

        ordersDatabase.addNewOrder(order);

        Contractor company = new ContractorCompany("Bevvis", "Bevvis S.R.L.", "1003606007719", "7400676", "Victoriabank fil.7 Orhei", "22256151515", Boolean.TRUE, "023527848", "Orhei, str. V. Lupu 21/22");
        CartridgeOrder cartridgeOrder = new CartridgeOrder(ordersDatabase.getNextOrderNumber(), null, null, company, "sigiliul deteriorat", null, null, null);

        ordersDatabase.addNewOrder(cartridgeOrder);

        ArrayList<Order> ordersListFromOrdersDatabase = ordersDatabase.getOrdersDatabase();
        System.out.println("Current user: "+usersDatabaseList.get(0).getName());
        for (Order order1 : ordersListFromOrdersDatabase) {
            System.out.println(order1.getOrderNumber() + "\t" + order1.getClass().getSimpleName() + "\t" + order1.getItemVisualAspect() + "\t" + order1.getContractor().getClass().getSimpleName() + "\t" + order1.getDate().toString());
        }
    }

}
