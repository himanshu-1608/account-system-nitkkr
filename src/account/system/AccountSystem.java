package account.system;

import account.system.ui.DesktopWindow;
import javax.swing.SwingUtilities;

public class AccountSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final DesktopWindow window = new DesktopWindow("Account System");
            window.initialize();
        });
    }
}