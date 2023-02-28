package app.gui;

import javax.swing.*;
import app.Mode;
import app.data.DataAccess;
import app.data.DataQuery;
import app.entities.Administrator;
import app.entities.Employee;
import app.entities.exceptions.UserNotExistException;
import app.gui.exceptions.LoginException;

import java.awt.*;
import java.sql.SQLException;

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
        setButtonConfiguration();

        setApplicationMode(null);
    }

    private void frameSetup() {

        for(Mode m: Mode.values()) {
            cmbModeSelection.addItem(m.toString());
        }

        controlsContainer.setSize(400, 250);
        this.add(controlsContainer);

        this.setTitle("User login frame");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(controlsContainer.getSize());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void setButtonConfiguration() {
        btnLogin.addActionListener(e -> { btnLogin_click(); });
        btnCancel.addActionListener(e -> { btnCancel_click(); });
    }

    private Mode applicationMode;
    public Mode getApplicationMode() {
        return applicationMode;
    }
    public void setApplicationMode(Mode applicationMode) {
        this.applicationMode = applicationMode;
    }

    private void btnCancel_click() {
        System.exit(0);
    }

    private void btnLogin_click() {

        Employee employee;
        try {
            employee = doEmployeeLogin(jtfUserId.getText(), jtfPassword.getText());

            if (employee == null) {
                lblOutput.setForeground(Color.red);
                lblOutput.setText("Wrong username or password");
                return;
            }

        } catch (LoginException ex) {
            lblOutput.setForeground(Color.red);
            lblOutput.setText("Login failed because of connection error");
            return;
        } catch(NumberFormatException ex) {
            lblOutput.setForeground(Color.red);
            lblOutput.setText("User Id input should be in integer format");
            return;
        }

        lblOutput.setForeground(Color.green);
        lblOutput.setText("Login successfull");
    }

    private Employee doEmployeeLogin(String loginIdString, String loginPasswordString)
            throws LoginException, NumberFormatException{

        // Id input should be int type, so it has to be checked
        int idInput = Integer.parseInt(loginIdString);

        // Here we have data and we need to get user from database
        DataAccess dataAccess = new DataAccess();
        DataQuery dataQuery = new DataQuery(dataAccess);

        // New employee instance
        Employee employee;
        try {
            employee = dataQuery.getEmployee(idInput, loginPasswordString);
        } catch (SQLException | ClassNotFoundException e) {
            throw new LoginException();
        } catch (UserNotExistException e) {
            return null;
        }

        return employee;
    }

    private Administrator doAdministratorLogin(String loginIdString, String loginPasswordString)
            throws LoginException {

        // Id input should be int type, so it has to be checked
        int idInput = Integer.parseInt(loginIdString);

        // Here we have data and we need to get user from database
        DataAccess dataAccess = new DataAccess();
        DataQuery dataQuery = new DataQuery(dataAccess);

        // New employee instance
        Administrator admin;
        try {
            admin = dataQuery.getAdministrator(idInput, loginPasswordString);
        } catch (SQLException | ClassNotFoundException e) {
            throw new LoginException();
        } catch (UserNotExistException e) {
            return null;
        }

        return admin;
    }
}
