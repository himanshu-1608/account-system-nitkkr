package account.system.dao;

import account.system.model.Vendor;

public class VendorService {
    public Vendor getVendorByName(String vendorName) {
        VendorDAO dao = VendorDAOFactory.getInstance();
        return dao.getVendorByName(vendorName);
    }
}