package account.system.dao;

import account.system.model.Vendor;

public interface VendorDAO {
    public Vendor getVendorByName(String vendorName);
}