package account.system.utils;

import account.system.model.VendorBeneficiary;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
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
                vb.setId(Long.parseLong(attributes[0]));
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
    
    public static String getDbFilePath() {
        String dbPersistentPath = "AccountSystemNITKKR/DB_FILE_PATH";
        File dbPersistentFile = new File(System.getProperty("user.home"), dbPersistentPath);
        if(!dbPersistentFile.getParentFile().exists()) {
            dbPersistentFile.getParentFile().mkdir();
        }
        if(!dbPersistentFile.exists()) {
            String inputDbPath = JOptionPane.showInputDialog(null,"Provide CSV File Path");
            try (FileWriter fw = new FileWriter(dbPersistentFile)) {
                fw.write(inputDbPath);
                fw.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Could Not Store Database Path\nError Code: FILE001","File Error", JOptionPane.ERROR_MESSAGE);
                dbPersistentFile.delete();
                System.exit(0);
            }
        }
        String dbCsvFilePath;
        try(Scanner reader = new Scanner(dbPersistentFile)) {
            dbCsvFilePath = reader.nextLine();
            reader.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Some Unexpected Error Occured\nError Code: FILE002","Internal Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            dbCsvFilePath = "";
        }
        return dbCsvFilePath;
    }
}

class VendorBeneficiaryComparator implements Comparator<VendorBeneficiary> {
    @Override
    public int compare(VendorBeneficiary o1, VendorBeneficiary o2) {
        return o1.getVendorBeneficiaryName().compareToIgnoreCase(o2.getVendorBeneficiaryName());
    }
}