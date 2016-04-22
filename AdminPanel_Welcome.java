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
public class AdminPanel_Welcome extends JPanel {

    // Variables declaration 
    private JLabel adminLabel;
    private AdminWelcomePanel admSubPanel;
    private JButton Syslog;
	// ^ ??? what who when where
    private JButton logoutButton;
    // End of variables declaration
    
    /**
     * Creates new form AdminPanel_Welcome
     */
    public AdminPanel_Welcome() {
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
            System.out.println("Log: Admin username = " + topWindow.getUsername());
            u = topWindow.getUsername();
        } else if (SwingUtilities.getWindowAncestor(this).getClass().equals(PanelTester.class)) {
            
            testWindow = (PanelTester)((JFrame)SwingUtilities.getWindowAncestor(this));
            System.out.println("Log: Parent window = " + testWindow.getName());
            System.out.println("Log: Admin username = " + testWindow.getUsername());
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
        
	adminLabel = new JLabel();
	Syslog = new JButton();
	logoutButton = new JButton();
	admSubPanel = new AdminWelcomePanel();

        Font welcomeFont;
        String welcomeText;
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        welcomeText = getWelcomeText();
        
        
        //Row One
        adminLabel.setText(welcomeText);
        welcomeFont = adminLabel.getFont();
            Map attributes = welcomeFont.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            attributes.put(TextAttribute.SIZE, 14);
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        adminLabel.setFont(welcomeFont.deriveFont(attributes));
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(20,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(adminLabel, gbc);
        
        //Rows 2-4
		
        admSubPanel.getAccessibleContext().setAccessibleName("Admin Sub Panel");
            gbc = new GridBagConstraints();
            gbc.gridheight = 3;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.BOTH;
        this.add(admSubPanel, gbc);
		        
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
		/*
        addCourseButton.setText("Register New Courses");
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addCourseActionPerformed(evt);
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
        this.add(addCourseButton, gbc);*/
        /*
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
        */
        /*
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
        */
        /*
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
        */
        /*
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
        */
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
    private void addCourseActionPerformed(ActionEvent evt) {
        PanelTester testPanel = null;
        AdminPanel_Welcome parentPanel = null;
        
        if (SwingUtilities.getAncestorNamed("AdminPanel", this) != null) {
            
        }
        
        
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
