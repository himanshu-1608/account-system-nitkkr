package account.system;

import account.system.dao.VendorService;
import account.system.model.Vendor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

public class AccountSystem {
    public static VendorService vendorService;
    
    static {
        vendorService = new VendorService();
    }
    
    public static void main(String[] args) {
//        try {
//            Vendor v = vendorService.getVendorByName("Vendor 2");
//            System.out.println("Found a vendor with start date: " + v.getContractStartDate());
//            ArrayList<String> vendors = vendorService.getAllVendorNames();
//            vendors.forEach(vendorName -> System.out.println(vendorName));
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
        
//        JFrame jframe = new JFrame();
//        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jframe.setVisible(true);
    }
}