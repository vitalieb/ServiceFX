/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecentermanagementfx;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import servicecentermanagementfx.datamodels.OrdersModel;
import servicecentermanagementfx.entities.CartridgeOrder;
import servicecentermanagementfx.entities.Contractor;
import servicecentermanagementfx.entities.ContractorCompany;
import servicecentermanagementfx.entities.ContractorPerson;
import servicecentermanagementfx.entities.Order;
import servicecentermanagementfx.entities.OrdersDatabase;
import servicecentermanagementfx.entities.RepairOrder;
import servicecentermanagementfx.entities.User;
import servicecentermanagementfx.entities.UsersDatabase;

/**
 *
 * @author Vitalie
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableView table;
    
    private final ObservableList<OrdersModel> data = FXCollections.observableArrayList();
//    private final ObservableList data =   

//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("La la la!");
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //############################################
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
        System.out.println("Current user: " + usersDatabaseList.get(0).getName());
        
        System.out.println(ordersListFromOrdersDatabase.toString());
        for (Order order1 : ordersListFromOrdersDatabase) {
            
            OrdersModel ordermodel = new OrdersModel("status", order1.getOrderNumber(), "data", order1.getContractor().getClass().getSimpleName(), "item", Boolean.TRUE);
            
            data.add(ordermodel);

//            System.out.println(order1.getOrderNumber() + "\t" + order1.getClass().getSimpleName() + "\t" + order1.getItemVisualAspect() + "\t" + order1.getContractor().getClass().getSimpleName() + "\t" + order1.getDate().toString());
        }

        //##################################333
        TableColumn status = new TableColumn("Status");
        status.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        TableColumn nr = new TableColumn("Nr.");
        nr.setCellValueFactory(
                new PropertyValueFactory<>("nr"));
        
        TableColumn date = new TableColumn("Date");
        date.setCellValueFactory(
                new PropertyValueFactory<>("date"));
        
        TableColumn contractor = new TableColumn("Contractor");
        contractor.setCellValueFactory(
                new PropertyValueFactory<>("contractor"));
        
        TableColumn item = new TableColumn("Item");
        item.setCellValueFactory(
                new PropertyValueFactory<>("item"));
        
        TableColumn called = new TableColumn("Called");
        called.setCellValueFactory(
                new PropertyValueFactory<>("called"));
        
        table.getColumns().addAll(status, nr, date, contractor, item, called);
        table.setItems(data);
//        table.setEditable(true);
    }
}
