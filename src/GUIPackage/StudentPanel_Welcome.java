/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Ellie Peterson
 */
public class StudentPanel_Welcome extends JPanel {

    // Variables declaration 
    private JLabel usernameLabel;
    private JPanel schedule;
    private JButton registerButton;
    private JButton deleteCourseButton;
    private JButton printScheduleButton;
    private JButton feesButton;
    private SwingLink helpLink;
    private JButton logoutButton;
    // End of variables declaration
    
    /**
     * Creates new form StudentPanel_Welcome
     */
    public StudentPanel_Welcome() {
    }
    
    /**
     * Public method to initialize components
     * calls initComponents
     */
    public void initMe() {
        initComponents();
    }

    /**
     * Retrieves the username stored in the MainWindow object
     * @return The username provided in login
     */
    private String getUsername() {
        String u;
        PanelTester testWindow = null;
        MainWindow topWindow = null;
        
        if (SwingUtilities.getWindowAncestor(this).getClass().equals(MainWindow.class)) {
            
            topWindow = (MainWindow)((JFrame)SwingUtilities.getWindowAncestor(this));
            System.out.println("Log: Parent window = " + topWindow.getName());
            System.out.println("Log: Student username = " + topWindow.getUsername());
            u = topWindow.getUsername();
        } else if (SwingUtilities.getWindowAncestor(this).getClass().equals(PanelTester.class)) {
            
            testWindow = (PanelTester)((JFrame)SwingUtilities.getWindowAncestor(this));
            System.out.println("Log: Parent window = " + testWindow.getName());
            System.out.println("Log: Student username = " + testWindow.getUsername());
            u = testWindow.getUsername();
        } else {
            u = "";
        }
        
        return u;
    }
    
    /**
     * Initializes and adds components to the panel.
     */
    private void initComponents() {
        
        usernameLabel = new JLabel();
        schedule = new CheckBoxTable();
        registerButton = new JButton();
        deleteCourseButton = new JButton();
        printScheduleButton = new JButton();
        feesButton = new JButton();
        helpLink = new SwingLink("help", "http://java.sun.com");
        logoutButton = new JButton();
        Font welcomeFont;
        String welcomeText;
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        welcomeText = getWelcomeText();
        
        
        //Row One
        usernameLabel.setText(welcomeText);
        welcomeFont = usernameLabel.getFont();
            Map attributes = welcomeFont.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            attributes.put(TextAttribute.SIZE, 14);
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        usernameLabel.setFont(welcomeFont.deriveFont(attributes));
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(20,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(usernameLabel, gbc);
        
        //Rows 2-4
        schedule.getAccessibleContext().setAccessibleName("Course Schedule");
            gbc = new GridBagConstraints();
            gbc.gridheight = 3;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.BOTH;
        this.add(schedule, gbc);
        
        //Row 5 - empty label
        JLabel hiddenLabel1 = new JLabel();
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.fill = gbc.BOTH;
        this.add(hiddenLabel1, gbc);
        
        //Row 6
        registerButton.setText("Register New Courses");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,10,10,5); //top, left, bottom, right
            gbc.anchor = gbc.LINE_END;
        this.add(registerButton, gbc);
        
        deleteCourseButton.setText("Drop Delete Course");
        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteCourseActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 2;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,10,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(deleteCourseButton, gbc);
        
        
        printScheduleButton.setText("Print Schedule");
        printScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                printScheduleActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 4;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,10,10); //top, left, bottom, right
            gbc.anchor = gbc.LINE_START;
        this.add(printScheduleButton, gbc);
        
        
        //Row 7
        feesButton.setText("Fees Owed");
        feesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                feesButtonActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,10,20,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER; 
        this.add(feesButton, gbc);
        
        
        //Help Link postioning
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 2;
            gbc.gridy = 6;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,20,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        //helpLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(helpLink, gbc);
        
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 4;
            gbc.gridy = 6;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,20,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER; 
        this.add(logoutButton, gbc);
        
        setBorder(BorderFactory.createTitledBorder(new MatteBorder(null), "", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", 1, 14), new Color(255, 255, 255))); // NOI18N
        getAccessibleContext().setAccessibleName("Student Panel Welcome");
        
        setOpaque(false);
    }      
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void registerActionPerformed(ActionEvent evt) {
        System.out.println("Log: Parent name: " + StudentPanel.class.getName());
        
        Container c = this.getParent();
        System.out.println("Log: Stu Welcome parent name: " + c.getName());
        CardLayout cl = (CardLayout) SwingUtilities.getAncestorNamed("cards", this).getLayout();
        cl.show(((StudentPanel)SwingUtilities.getAncestorNamed("GUIPackage.StudentPanel", this)).getCards(), StudentPanel.REGISTER);
        
        
    }

    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void deleteCourseActionPerformed(ActionEvent evt) {
        //TODO: confirmation dialog, if yes, delete, else do nothing
    }

    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void printScheduleActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void feesButtonActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void logoutButtonActionPerformed(ActionEvent evt) {
        
    }

    /**
     * creates the welcome/title text
     * @return title text with username
     */
    private String getWelcomeText() {
        return "Welcome " + getUsername();
    }
                     
}
