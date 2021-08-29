package account.system.model;

import java.sql.Date;

public class Vendor {
    private Long vendorId;
    private String vendorName;
    private Date contractStartDate;
    private Float servicePrice;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
    
    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Float getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Float servicePrice) {
        this.servicePrice = servicePrice;
    }
}