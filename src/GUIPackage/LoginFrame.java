/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.AdminRegistry;
import Backend.InstructorRegistry;
import Backend.StudentRegistry;
import static GUIPackage.MainClass.adminReg;
import static GUIPackage.MainClass.instructorReg;
import static GUIPackage.MainClass.stuReg;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;


/**
 *
 * @author EMCS306
 */
public class LoginFrame extends javax.swing.JFrame
        implements java.beans.Customizer {
    
    public AdminRegistry adminReg;
    public InstructorRegistry instructorReg;
    public StudentRegistry stuReg;
    private Object bean;
    public ImageIcon img = new ImageIcon("."  + File.separator + "res" + File.separator + "poo.png");

    /**
     * Creates new customizer Login 
     */
    public LoginFrame(
            AdminRegistry aR, 
            InstructorRegistry iR, 
            StudentRegistry sR) {
        adminReg = aR;
        instructorReg = iR;
        stuReg = sR;
        
        setIconImage(img.getImage());
        setTitle("University of FtS");
        initComponents();
    }
    
    @Override
    public void setObject(Object bean) {
        this.bean = bean;
    }

                             
    private void initComponents() {
        
               
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        java.awt.GridBagConstraints gridBagConstraints;

        loginLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());
        
        
        //Get and set font on border
        Font arialicFont = getArialicFont();
        //setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, arialicFont.deriveFont(20)));
        setFont(arialicFont);
        


        loginLabel.setText("Username:");
        loginLabel.setFont(arialicFont);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 100, 0, 0);
        add(loginLabel, gridBagConstraints);

        usernameTextField.setText("Username");
        usernameTextField.setEditable(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 3, 0, 0);
        add(usernameTextField, gridBagConstraints);

        passwordLabel.setText("Password:");
        passwordLabel.setFont(arialicFont);
        passwordLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 100, 0, 0);
        add(passwordLabel, gridBagConstraints);

        passwordTextField.setText("pass");
        passwordTextField.setEditable(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 3, 0, 129);
        add(passwordTextField, gridBagConstraints);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 100, 97, 0);
        add(loginButton, gridBagConstraints);

        registerButton.setText("Register");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 23, 97, 0);
        add(registerButton, gridBagConstraints);

    }         
    
    /*
    **Gets username
    */
    public String getUsername(){
        return usernameTextField.getText();
    }
    
    private boolean isValidUser() {
        if(adminReg.isAdmin(getUsername()) || instructorReg.isInstructor(getUsername()) || stuReg.isStudent(getUsername()) ) {
            return true;
        }
        else {
            return false;
        }
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        if (isValidUser()) {
            setVisible(false);
            MainWindow mainFrame = new MainWindow(getUsername(), adminReg, instructorReg, stuReg);
            mainFrame.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
            mainFrame.setSize(600, 400);
            mainFrame.setVisible(true);
            dispose();
            System.out.println("Code creates window");
       
            //mainFrame = new MainWindow(getUsername(), adminReg, instructorReg, stuReg);
            //mainFrame.setVisible(true);
        } else {
            System.out.println("invalid user");
        }
    }           
    
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


    // Variables declaration - do not modify    
    private MainWindow mainFrame;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration                   
}
