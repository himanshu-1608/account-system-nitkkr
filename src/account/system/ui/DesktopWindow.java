package account.system.ui;

import account.system.dao.VendorService;
import account.system.model.Vendor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class DesktopWindow extends JFrame {
    
    private final VendorService vendorService = new VendorService();
    
    public DesktopWindow(String text) {
        super(text);
    }
    public void initialize() {
        ArrayList<String> vendorList = vendorService.getAllVendorNames();
        
//        Border lblBorders = BorderFactory.createLineBorder(Color.pink);
        
        JLabel lblBeneficiary = new JLabel("Vendor Beneficiary");
        lblBeneficiary.setBounds(20, 20, 200, 30);
        lblBeneficiary.setFont(new Font("Helvetica",Font.PLAIN,18));
//        lblBeneficiary.setBorder(lblBorders);
        
        JComboBox dropdownBeneficiaries = new JComboBox(vendorList.toArray());
        dropdownBeneficiaries.setBounds(220,20,400,30);
        
        JLabel lblIdentifier = new JLabel("Enter Other Identifier");
        lblIdentifier.setBounds(20, 60, 200, 30);
        lblIdentifier.setFont(new Font("Helvetica",Font.PLAIN,18));
//        lblIdentifier.setBorder(lblBorders);
        
        JTextField txtIdentifier = new JTextField(30);
        txtIdentifier.setBounds(220,60,400,30);
        txtIdentifier.setFont(new Font("Helvetica",Font.PLAIN,18));
        
        JButton btnSubmit = new JButton("Find Vendor Details");
        btnSubmit.setBounds(20, 100, 200, 30);
        btnSubmit.setFont(new Font("Helvetica",Font.PLAIN,18));
        btnSubmit.addActionListener((ActionEvent ev) -> {
            int indexBeneficiary = dropdownBeneficiaries.getSelectedIndex();
            String vendorName = vendorList.get(indexBeneficiary);
            Vendor v = vendorService.getVendorByName(vendorName);
            System.out.println("Service Start Date: " + v.getContractStartDate());
        });
        
        add(lblBeneficiary);
        add(dropdownBeneficiaries);
        add(lblIdentifier);
        add(txtIdentifier);
        add(btnSubmit);
        
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
