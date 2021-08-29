package account.system;

import account.system.dao.VendorService;
import account.system.model.Vendor;

public class AccountSystem {

    public static void main(String[] args) {
        try {
            System.out.println("Hello World");
            Vendor v = new VendorService().getVendorByName("Vendor 2");
            System.out.println("Found a vendor with id: " + v.getContractStartDate());
            System.out.println("Operation Done");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }    
}