package servicecentermanagementfx.datamodels;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class OrdersModel {
    private final SimpleStringProperty status;
    private final SimpleIntegerProperty nr;
    private final SimpleStringProperty date;
    private final SimpleStringProperty contractor;
    private final SimpleStringProperty item;
    private final SimpleBooleanProperty called;

    public OrdersModel(String status, Integer nr, String date, String contractor, String item, Boolean called) {
        this.status = new SimpleStringProperty(status);
        this.nr = new SimpleIntegerProperty(nr);
        this.date = new SimpleStringProperty(date);
        this.contractor = new SimpleStringProperty(contractor);
        this.item = new SimpleStringProperty(item);
        this.called = new SimpleBooleanProperty(called);
    }

    public boolean getCalled() {
        return called.get();
    }

    public void setCalled(Boolean call) {
        called.set(call);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String stat) {
        status.set(stat); 
    }

    public int getNr() {
        return nr.get();
    }

    public void setNr(int numar) {
        nr.set(numar);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String data) {
        date.set(data);
    }

    public String getContractor() {
        return contractor.get();
    }

    public void setContractor(String contractorul) {
        contractor.set(contractorul);
    }

    public String getItem() {
        return item.get();
    }

    public void setItem(String itemul) {
        item.set(itemul);
    }
    
    
}
