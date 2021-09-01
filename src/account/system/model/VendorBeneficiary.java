package account.system.model;

import java.util.Date;

public class VendorBeneficiary {
    private Long id;
    private String vendorBeneficiaryName;
    private Date policyDate;
    private Float amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorBeneficiaryName() {
        return vendorBeneficiaryName;
    }

    public void setVendorBeneficiaryName(String vendorBeneficiaryName) {
        this.vendorBeneficiaryName = vendorBeneficiaryName;
    }

    public Date getPolicyDate() {
        return policyDate;
    }

    public void setPolicyDate(Date policyDate) {
        this.policyDate = policyDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
    
}