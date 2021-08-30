package account.system.dao;

import account.system.model.Vendor;
import java.util.ArrayList;

public interface VendorDAO {
    public Vendor getVendorByName(String vendorName);
    public ArrayList<String> getAllVendorNames();
}