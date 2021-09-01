package account.system.ui;

import account.system.dao.DbService;
import account.system.model.VendorBeneficiary;
import account.system.utils.DbUtils;
import account.system.utils.UiUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;

public class DesktopWindow extends JFrame {
    
    private final DbService dbService = new DbService();
    
    public DesktopWindow(String text) {
        super(text);
    }
    public void initialize() {
        dbService.initDb(dbService.getDbFilePath());
        ArrayList<String> vendorBeneficiaryList = dbService.getAllVendorBeneficiaryNames();
//        Border lblBorders = BorderFactory.createLineBorder(Color.pink);
        
        JLabel lblVendorBeneficiary = new JLabel("Vendor/Beneficiary");
        lblVendorBeneficiary.setBounds(20, 20, 200, 30);
        lblVendorBeneficiary.setFont(new Font("Helvetica",Font.PLAIN,18));
//        lblBeneficiary.setBorder(lblBorders);
        
        JComboBox dropdownBeneficiaries = new JComboBox(vendorBeneficiaryList.toArray());
        dropdownBeneficiaries.setBounds(220,20,400,30);
        
        JLabel lblIdentifier = new JLabel("Enter Other Identifier");
        lblIdentifier.setBounds(20, 60, 200, 30);
        lblIdentifier.setFont(new Font("Helvetica",Font.PLAIN,18));
//        lblIdentifier.setBorder(lblBorders);
        
        JTextField txtIdentifier = new JTextField(30);
        txtIdentifier.setBounds(220,60,400,30);
        txtIdentifier.setFont(new Font("Helvetica",Font.PLAIN,18));
        
        JButton btnSubmit = new JButton("Locate Details");
        btnSubmit.setBounds(20, 100, 200, 30);
        btnSubmit.setFont(new Font("Helvetica",Font.PLAIN,18));
        btnSubmit.addActionListener((ActionEvent ev) -> {
            int indexBeneficiary = dropdownBeneficiaries.getSelectedIndex();
            String vendorName = vendorBeneficiaryList.get(indexBeneficiary);
            VendorBeneficiary v = dbService.getVendorBeneficiaryByName(vendorName);
            JScrollPane sp = UiUtils.createTableFromVBData(v, new int[]{20,140,1000,55});
            add(sp);
        });
        
        add(lblVendorBeneficiary);
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
