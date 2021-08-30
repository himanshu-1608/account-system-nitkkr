package account.system.dao;

public class VendorDAOFactory {
    public static VendorDAO vendorDAO = null;
    public static VendorDAO getInstance() {
        if(vendorDAO == null) {
            vendorDAO = new VendorDAOImpl();
        }
        return vendorDAO;
    }
}