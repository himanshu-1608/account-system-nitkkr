package account.system.dao;

import account.system.model.VendorBeneficiary;
import java.util.ArrayList;

public interface DbDAO {
    public VendorBeneficiary getVendorBeneficiaryByName(String name);
    public ArrayList<String> getAllVendorBeneficiaryNames();
}