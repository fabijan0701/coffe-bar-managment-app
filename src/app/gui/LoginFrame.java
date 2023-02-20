package app.gui;

import javax.swing.*;
import app.Mode;

public class LoginFrame extends JFrame{
    private JLabel titleLabel;
    private JTextField jtfUserId;
    private JPasswordField jtfPassword;
    private JComboBox cmbModeSelection;
    private JPanel controlsContainer;
    private JButton btnLogin;
    private JButton btnCancel;
    private JLabel lblOutput;

    public LoginFrame() {
        frameSetup();
    }

    private void frameSetup() {

        for(Mode m: Mode.values()) {
            cmbModeSelection.addItem(m.toString());
        }

        controlsContainer.setSize(400, 250);
        this.add(controlsContainer);

        this.setTitle("User login frame");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(controlsContainer.getSize());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

}
