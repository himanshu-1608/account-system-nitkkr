package account.system.utils;

import account.system.model.VendorBeneficiary;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class UiUtils {
    public static JScrollPane createTableFromVBData(VendorBeneficiary vb, int[] bounds) {
        String vbData[][]={{
            vb.getId().toString(),
            vb.getVendorBeneficiaryName(),
            new SimpleDateFormat("dd-MM-yyyy").format(vb.getPolicyDate()),
            vb.getAmount().toString()
        }};
        String headers[]={"ID", "NAME", "POLICY DATE", "AMOUNT"};
        JTable vbDetails = new JTable(vbData,headers);
        vbDetails.setRowHeight(22);
        vbDetails.getTableHeader().setFont(new Font(null, Font.BOLD, 20));
        vbDetails.setFont(new Font("Helvetica", Font.PLAIN, 20));

        JScrollPane sp = new JScrollPane(vbDetails);
        sp.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        return sp;
    }
}
