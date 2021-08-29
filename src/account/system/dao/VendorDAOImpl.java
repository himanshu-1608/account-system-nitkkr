package account.system.dao;

import account.system.model.Vendor;
import java.sql.Connection;
import java.sql.ResultSet;

import account.system.utils.JDBCUtils;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendorDAOImpl implements VendorDAO {
    private static final String GET_VENDOR_BY_NAME_QUERY = "SELECT * FROM vendors WHERE vendorName=?";

    @Override
    public Vendor getVendorByName(String vendorName) {
        Vendor vendor = new Vendor();
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_VENDOR_BY_NAME_QUERY);
            preparedStatement.setString(1, vendorName);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            System.out.println("rs:"+rs);
            vendor.setVendorId(rs.getLong("vendorId"));
            vendor.setVendorName(rs.getString("vendorName"));
            vendor.setContractStartDate(rs.getDate("contractStartDate"));
            vendor.setServicePrice(rs.getFloat("servicePrice"));
        } catch (SQLException ex) {
            JDBCUtils.printSQLException(ex);
            vendor.setVendorId(new Long(-1));
            vendor.setVendorName("No Vendor Found");
        }
        return vendor;
    }
}