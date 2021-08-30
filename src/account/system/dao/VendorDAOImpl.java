package account.system.dao;

import account.system.model.Vendor;
import java.sql.Connection;
import java.sql.ResultSet;

import account.system.utils.JDBCUtils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendorDAOImpl implements VendorDAO {
    private static final String GET_VENDOR_BY_NAME_QUERY = "SELECT * FROM vendors WHERE vendorName=?";
    private static final String GET_ALL_VENDOR_NAMES = "SELECT vendorName FROM vendors";
    
    @Override
    public Vendor getVendorByName(String vendorName) {
        Vendor vendor = new Vendor();
        try (
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_VENDOR_BY_NAME_QUERY);
            ) {
            preparedStatement.setString(1, vendorName);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            vendor.setVendorId(rs.getLong("vendorId"));
            vendor.setVendorName(rs.getString("vendorName"));
            vendor.setContractStartDate(rs.getDate("contractStartDate"));
            vendor.setServicePrice(rs.getFloat("servicePrice"));
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            JDBCUtils.printSQLException(ex);
            vendor.setVendorId(new Long(-1));
            vendor.setVendorName("No Vendor Found");
        }
        return vendor;
    }

    @Override
    public ArrayList<String> getAllVendorNames() {
        ArrayList<String> vendors = new ArrayList();
        try (
                Connection connection = JDBCUtils.getConnection();
                Statement statement = connection.createStatement();
            ) {
            ResultSet rs = statement.executeQuery(GET_ALL_VENDOR_NAMES);
            while(rs.next()) {
                vendors.add(rs.getString("vendorName"));
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            JDBCUtils.printSQLException(ex);
        }
        return vendors;
    }
}