package account.system.dao;

public class VendorDAOFactory {
    public static VendorDAO getInstance() {
        return new VendorDAOImpl();
    }
}