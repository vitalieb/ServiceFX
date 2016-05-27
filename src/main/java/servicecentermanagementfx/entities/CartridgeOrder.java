package servicecentermanagementfx.entities;

import java.util.Date;

public class CartridgeOrder extends Order {

    Cartridge cartridge;
    String workToBeDone;

    public CartridgeOrder(int orderNumber, Cartridge cartridge, String workToBeDone, Contractor contractor, String itemVisualAspect, UserRepairer repairer, StatusOfRepair statusOfRepair, Date informedOfStatusDate) {
        super(orderNumber, contractor, itemVisualAspect, repairer, statusOfRepair, informedOfStatusDate);
        this.cartridge = cartridge;
        this.workToBeDone = workToBeDone;
    }

}
