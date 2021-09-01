package account.system.utils;

import account.system.model.VendorBeneficiary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class DbUtils {
    private static final ArrayList<VendorBeneficiary> database = new ArrayList<>();
    public static void init(String dbPath) {
        String line;
        String splitBy = ",";
        try(BufferedReader dbReader = new BufferedReader(new FileReader(dbPath.concat("/PFMS.csv")))) {
            while ((line = dbReader.readLine()) != null) {
                if(line.equalsIgnoreCase("id,name,startDate,amount")) continue;
                String[] attributes = line.split(splitBy);
                VendorBeneficiary vb = new VendorBeneficiary();
                vb.setVendorBeneficiaryName(attributes[1]);
                vb.setPolicyDate(new SimpleDateFormat("dd-MM-yyyy").parse(attributes[2]));
                vb.setAmount(Float.parseFloat(attributes[3]));
                database.add(vb);
                Collections.sort(database, new VendorBeneficiaryComparator());
            }  
            dbReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null,"Could Not Read CSV File\nError Code: FILE003","Internal Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null,"Some Unexpected Error Occured\nError Code: FILE004","Internal Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static ArrayList<VendorBeneficiary> getDb() {
        return database;
    }
}

class VendorBeneficiaryComparator implements Comparator<VendorBeneficiary> {
    @Override
    public int compare(VendorBeneficiary o1, VendorBeneficiary o2) {
        return o1.getVendorBeneficiaryName().compareToIgnoreCase(o2.getVendorBeneficiaryName());
    }
}