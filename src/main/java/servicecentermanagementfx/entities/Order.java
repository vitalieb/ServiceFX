package servicecentermanagementfx.entities;

import java.util.Date;

public class Order {

    private int orderNumber;
    private Date date;
    private Contractor contractor;
    private String itemVisualAspect;
    private UserRepairer repairer;
    private StatusOfRepair statusOfRepair;
    private Date informedOfStatusDate;

    public Order(int orderNumber,Contractor contractor, String itemVisualAspect, UserRepairer repairer, StatusOfRepair statusOfRepair,Date informedOfStatusDate) {
        this.orderNumber = orderNumber;
        this.date = new Date();
        this.contractor = contractor;
        this.itemVisualAspect = itemVisualAspect;
        this.repairer = repairer;
        this.statusOfRepair = statusOfRepair;
        this.informedOfStatusDate = informedOfStatusDate;
    }

    public StatusOfRepair getStatusOfRepair() {
        return statusOfRepair;
    }

    public void setStatusOfRepair(StatusOfRepair statusOfRepair) {
        this.statusOfRepair = statusOfRepair;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public String getItemVisualAspect() {
        return itemVisualAspect;
    }

    public void setItemVisualAspect(String itemVisualAspect) {
        this.itemVisualAspect = itemVisualAspect;
    }

    public UserRepairer getRepairer() {
        return repairer;
    }

    public void setRepairer(UserRepairer repairer) {
        this.repairer = repairer;
    }

    public Date getInformedOfStatusDate() {
        return informedOfStatusDate;
    }

    public void setInformedOfStatusDate(Date informedOfStatusDate) {
        this.informedOfStatusDate = informedOfStatusDate;
    }
    
}
