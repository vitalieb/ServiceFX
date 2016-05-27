package servicecentermanagementfx.entities;

import java.awt.Image;
import java.util.Date;

public class RepairOrder extends Order {

    private ItemToBeRepaired item;
    private Image imageFromCCTV;
    private Image[] imagesFromCamera;
    private String defectDescription;
    private String inComplect;
    private boolean onlyDiagnostics;
    private String serialNumber;
    private String QRCode;
    private String numberOfSale;
    private Date dateOfSale;
    private boolean onWarranty;
    private double priceAtMomentOfSale;

    public RepairOrder(int orderNumber, ItemToBeRepaired item, Image imageFromCCTV, Image[] imagesFromCamera, String defectDescription, String inComplect, boolean onlyDiagnostics, String serialNumber, String QRCode, String numberOfSale, Date dateOfSale, boolean onWarranty, double priceAtMomentOfSale, Contractor contractor, String itemVisualAspect, UserRepairer repairer, StatusOfRepair statusOfRepair, Date informedOfStatusDate) {
        super(orderNumber, contractor, itemVisualAspect, repairer, statusOfRepair, informedOfStatusDate);
        this.item = item;
        this.imageFromCCTV = imageFromCCTV;
        this.imagesFromCamera = imagesFromCamera;
        this.defectDescription = defectDescription;
        this.inComplect = inComplect;
        this.onlyDiagnostics = onlyDiagnostics;
        this.serialNumber = serialNumber;
        this.QRCode = QRCode;
        this.numberOfSale = numberOfSale;
        this.dateOfSale = dateOfSale;
        this.onWarranty = onWarranty;
        this.priceAtMomentOfSale = priceAtMomentOfSale;
    }

    public ItemToBeRepaired getItem() {
        return item;
    }

    public void setItem(ItemToBeRepaired item) {
        this.item = item;
    }

    public Image getImageFromCCTV() {
        return imageFromCCTV;
    }

    public void setImageFromCCTV(Image imageFromCCTV) {
        this.imageFromCCTV = imageFromCCTV;
    }

    public Image[] getImagesFromCamera() {
        return imagesFromCamera;
    }

    public void setImagesFromCamera(Image[] imagesFromCamera) {
        this.imagesFromCamera = imagesFromCamera;
    }

    public String getDefectDescription() {
        return defectDescription;
    }

    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }

    public String getInComplect() {
        return inComplect;
    }

    public void setInComplect(String inComplect) {
        this.inComplect = inComplect;
    }

    public boolean isOnlyDiagnostics() {
        return onlyDiagnostics;
    }

    public void setOnlyDiagnostics(boolean onlyDiagnostics) {
        this.onlyDiagnostics = onlyDiagnostics;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public String getNumberOfSale() {
        return numberOfSale;
    }

    public void setNumberOfSale(String numberOfSale) {
        this.numberOfSale = numberOfSale;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public boolean isOnWarranty() {
        return onWarranty;
    }

    public void setOnWarranty(boolean onWarranty) {
        this.onWarranty = onWarranty;
    }

    public double getPriceAtMomentOfSale() {
        return priceAtMomentOfSale;
    }

    public void setPriceAtMomentOfSale(double priceAtMomentOfSale) {
        this.priceAtMomentOfSale = priceAtMomentOfSale;
    }

}
