package account.system.dao;

import account.system.model.VendorBeneficiary;
import account.system.utils.DbUtils;
import java.util.ArrayList;

public class DbService {
    public VendorBeneficiary getVendorBeneficiaryByName(String name) {
        DbDAO dao = DbDAOFactory.getInstance();
        return dao.getVendorBeneficiaryByName(name);
    }
    
    public ArrayList<String> getAllVendorBeneficiaryNames() {
        DbDAO dao = DbDAOFactory.getInstance();
        return dao.getAllVendorBeneficiaryNames();
    }
    
    public void initDb(String dbPath) {
        DbUtils.init(dbPath);
    }
}