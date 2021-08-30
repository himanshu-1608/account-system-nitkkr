package account.system.dao;

import account.system.model.Vendor;
import java.util.ArrayList;

public class VendorService {
    public Vendor getVendorByName(String vendorName) {
        VendorDAO dao = VendorDAOFactory.getInstance();
        return dao.getVendorByName(vendorName);
    }
    
    public ArrayList<String> getAllVendorNames() {
        VendorDAO dao = VendorDAOFactory.getInstance();
        return dao.getAllVendorNames();
    }
}