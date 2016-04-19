/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;



/**
 *
 * @author EMCS306
 */
public class LoginFrame extends JFrame
        implements java.beans.Customizer {
    
    

    // Variables declaration - do not modify    
    private MainWindow mainFrame;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordTextField;
    private JTextField usernameTextField;
    private final AdminRegistry adminReg;
    private final InstructorRegistry instructorReg;
    private final StudentRegistry stuReg;
    private Object bean;
    public ImageIcon img = new ImageIcon("."  + File.separator + "res" + File.separator + "poo.png");
    // End of variables declaration 
    
    /**
     * Creates new customizer Login 
     */
    public LoginFrame() {
        adminReg = Singleton.getAdminRegInstance();
        instructorReg = Singleton.getInstructorRegInstance();
        stuReg = Singleton.getStuRegInstance();
        
        //setIconImage(img.getImage());
        //setTitle("University of FtS");
        initComponents();
    }
    
    @Override
    public void setObject(Object bean) {
        this.bean = bean;
    }

                             
    private void initComponents() {
        
               
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        GridBagConstraints gBC;

        loginLabel = new JLabel();
        usernameTextField = new JTextField();
        passwordLabel = new JLabel();
        passwordTextField = new JPasswordField();
        loginButton = new JButton();
        registerButton = new JButton();

        setLayout(new GridBagLayout());
        
        
        Font arialicFont = getArialicFont();
        setFont(arialicFont);
        


        loginLabel.setText("Username:");
        gBC = new GridBagConstraints();
        gBC.gridx = 0;
        gBC.gridy = 0;
        gBC.gridwidth = 2;
        gBC.anchor = GridBagConstraints.NORTHWEST;
        gBC.insets = new Insets(90, 100, 0, 0);
        add(loginLabel, gBC);

        usernameTextField.setText("Username");
        usernameTextField.setEditable(true);
        gBC = new GridBagConstraints();
        gBC.gridx = 3;
        gBC.gridy = 0;
        gBC.gridwidth = 2;
        gBC.gridheight = 2;
        gBC.ipadx = 94;
        gBC.anchor = GridBagConstraints.NORTHWEST;
        gBC.insets = new Insets(90, 3, 0, 0);
        add(usernameTextField, gBC);

        passwordLabel.setText("Password:");
        passwordLabel.setToolTipText("");
        gBC = new GridBagConstraints();
        gBC.gridx = 0;
        gBC.gridy = 2;
        gBC.anchor = GridBagConstraints.NORTHWEST;
        gBC.insets = new Insets(20, 100, 0, 0);
        add(passwordLabel, gBC);

        passwordTextField.setText("pass");
        passwordTextField.setEditable(true);
        gBC = new GridBagConstraints();
        gBC.gridx = 3;
        gBC.gridy = 2;
        gBC.gridwidth = 3;
        gBC.gridheight = 2;
        gBC.ipadx = 105;
        gBC.anchor = GridBagConstraints.NORTHWEST;
        gBC.insets = new Insets(20, 3, 0, 129);
        add(passwordTextField, gBC);

        loginButton.setText("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        gBC = new GridBagConstraints();
        gBC.gridx = 0;
        gBC.gridy = 4;
        gBC.gridwidth = 3;
        gBC.anchor = GridBagConstraints.NORTHWEST;
        gBC.insets = new Insets(30, 100, 97, 0);
        add(loginButton, gBC);

        registerButton.setText("Register");
        gBC = new GridBagConstraints();
        gBC.gridx = 3;
        gBC.gridy = 4;
        gBC.anchor = GridBagConstraints.NORTHWEST;
        gBC.insets = new Insets(30, 23, 97, 0);
        add(registerButton, gBC);

    }         
    
    /**
    *  Gets username
    *  @return The username typed into username field
    */
    public String getUsername(){
        return usernameTextField.getText();
    }
    
    /**
     * Checks the registries to see if the username entered is a valid username
     * @return true on valid username, false elsewhere
     */
    private boolean isValidUser() {
        if(adminReg.isAdmin(getUsername()) || instructorReg.isInstructor(getUsername()) || stuReg.isStudent(getUsername()) ) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * handing function for the login button
     * @param evt idk, lol
     */
    private void loginActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        if (isValidUser()) {
            setVisible(false);
            System.out.println("Log: Login username = " + getUsername());
            MainWindow mainORSWindow = new MainWindow(getUsername());
            mainORSWindow.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
            //mainFrame.setSize(600, 400);
            mainORSWindow.setVisible(true);
            dispose();
            System.out.println("Log: Code creates window");
        } else {
            System.out.println("Log: Invalid user");
        }
    }           
    
    /**
     * Establishes the font the system should use
     * @return Font object built from provided parameters
     */
    public Font getArialicFont() {
        Font font;
        try {
            //create the font to use. Specify the size!
            font = Font.createFont(Font.TRUETYPE_FONT,
                new File( "."  +
                    File.separator +
                    "res" +
                    File.separator +
                    "Arialic_Hollow.ttf")).deriveFont(12f);
            GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                new File("."  +
                    File.separator +
                    "res" +
                    File.separator +
                    "Arialic_Hollow.ttf")));
        } catch (IOException|FontFormatException e) {
            throw new RuntimeException(e);
        }
        return font;
    }                  
}
