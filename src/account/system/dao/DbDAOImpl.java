package account.system.dao;

import account.system.model.VendorBeneficiary;

import account.system.utils.DbUtils;
import java.util.ArrayList;

public class DbDAOImpl implements DbDAO {
    
    @Override
    public VendorBeneficiary getVendorBeneficiaryByName(String name) {
        ArrayList<VendorBeneficiary> database = DbUtils.getDb();
        VendorBeneficiary requiredVb = new VendorBeneficiary();
        database.forEach((vb) -> {
            if(vb.getVendorBeneficiaryName().equals(name)) {
                requiredVb.setId(vb.getId());
                requiredVb.setVendorBeneficiaryName(vb.getVendorBeneficiaryName());
                requiredVb.setPolicyDate(vb.getPolicyDate());
                requiredVb.setAmount(vb.getAmount());
            }
        });
        return requiredVb;
    }

    @Override
    public ArrayList<String> getAllVendorBeneficiaryNames() {
        ArrayList<VendorBeneficiary> database = DbUtils.getDb();
        ArrayList<String> vbNames = new ArrayList<>();
        database.forEach(vb->{
            vbNames.add(vb.getVendorBeneficiaryName());
        });
        return vbNames;
    }
}