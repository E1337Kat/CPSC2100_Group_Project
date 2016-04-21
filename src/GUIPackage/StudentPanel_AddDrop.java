/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author ellie
 */
public class StudentPanel_AddDrop extends JPanel {

    // Variables declaration 
    private JLabel titleLabel;
    private CheckBoxTable catalog;
    private JTextField regField1;
    private JTextField regField2;
    private JTextField regField3;
    private JTextField regField4;
    private JTextField regField5;
    private JButton okButton;
    private JButton clearFieldsButton;
    private JButton addToSheetButton;
    private JButton courseInfoButton;
    private SwingLink helpLink;
    private JButton logoutButton;
    
    //private NumberFormat crnFormat;
    // End of variables declaration   
    
    /**
     * Creates new form StudentPanel_AddDrop
     */
    public StudentPanel_AddDrop() {
        
    }

    public void initMe() {
        initComponents();
    }
       
    private void initComponents() {
        
        NumberFormat crnFormat = NumberFormat.getInstance();
        if (crnFormat instanceof DecimalFormat) {
            ((DecimalFormat) crnFormat).setDecimalSeparatorAlwaysShown(false);
         }
        
        titleLabel = new JLabel();
        catalog = new CheckBoxTable();
        regField1 = new JFormattedTextField(crnFormat);
        regField2 = new JFormattedTextField(crnFormat);
        regField3 = new JFormattedTextField(crnFormat);
        regField4 = new JFormattedTextField(crnFormat);
        regField5 = new JFormattedTextField(crnFormat);
        okButton = new JButton();
        clearFieldsButton = new JButton();
        addToSheetButton = new JButton();
        courseInfoButton = new JButton();
        helpLink = new SwingLink("help", "http://java.sun.com");
        logoutButton = new JButton();
        
        
        Font titleFont;
        String titleText;
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        titleText = getTitleText();

        //Row One
        titleLabel.setText(titleText);
        titleFont = titleLabel.getFont();
            Map attributes = titleFont.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            attributes.put(TextAttribute.SIZE, 14);
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        titleLabel.setFont(titleFont.deriveFont(attributes));
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = gbc.REMAINDER;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(20,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(titleLabel, gbc);
        
        //Row Two - Six
        catalog.getAccessibleContext().setAccessibleName("Course Catalog");
            gbc = new GridBagConstraints();
            gbc.gridheight = 5;
            gbc.gridwidth = gbc.REMAINDER;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.BOTH;
        this.add(catalog, gbc);
        
        //Row 7
        //common gridbagconstraints 
        gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            gbc.gridy = 6;
            gbc.weightx = 0.3;
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.insets = new Insets(10,10,10,2); //top, left, bottom, right
        this.add(regField1, gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(10,2,10,2); //top, left, bottom, right
        this.add(regField2, gbc);
        
        gbc.gridx = 2;
        gbc.insets = new Insets(10,2,10,2); //top, left, bottom, right
        this.add(regField3, gbc);
        
        gbc.gridx = 3;
        gbc.insets = new Insets(10,2,10,2); //top, left, bottom, right
        this.add(regField4, gbc);
        
        gbc.gridx = 4;
        gbc.insets = new Insets(10,2,10,10); //top, left, bottom, right
        this.add(regField5, gbc);
        
        //Row 8
        //common gridbagconstraints
        gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridy = 7;
            gbc.weightx = 0.5;
        
        addToSheetButton.setText("Add to Worksheet");
        addToSheetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addToSheetActionPerformed(evt);
            }
        });
            gbc.gridx = 0;
            gbc.insets = new Insets(10,10,10,2); //top, left, bottom, right
            gbc.anchor = gbc.LINE_END;
        this.add(addToSheetButton, gbc);
        
        clearFieldsButton.setText("Clear Worksheet");
        clearFieldsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
            gbc.gridx = 2;
            gbc.insets = new Insets(10,2,10,2); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(clearFieldsButton, gbc);
        
        okButton.setText("");
        okButton.setVisible(false);
            gbc.gridx = 4;
            gbc.insets = new Insets(10,2,10,10); //top, left, bottom, right
            gbc.anchor = gbc.LINE_START;
        this.add(okButton, gbc);
        
        
        //Row 9
        //common gridbagconstraints
        gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridy = 8;
            gbc.weightx = 0.5;
            gbc.anchor = gbc.CENTER;
        
        courseInfoButton.setText("Course Info");
        courseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                courseInfoActionPerformed(evt);
            }
        });
            gbc.gridx = 0;
            gbc.insets = new Insets(10,10,20,2); //top, left, bottom, right
        this.add(courseInfoButton, gbc);
        
        //HelpLink stuff
            gbc.gridx = 2;
            gbc.insets = new Insets(10,2,20,2); //top, left, bottom, right
        this.add(helpLink, gbc);
        
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
            gbc.gridx = 4;
            gbc.insets = new Insets(10,2,20,10); //top, left, bottom, right
        this.add(logoutButton, gbc);
        
        
        setBorder(BorderFactory.createTitledBorder(new MatteBorder(null), "", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", 1, 14), new Color(255, 255, 255))); // NOI18N
        getAccessibleContext().setAccessibleName("Student Panel Welcome");
        
        setOpaque(false);
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

    
    private String getTitleText() {
        
        return "Get new classes " + getUsername();
    }

    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void addToSheetActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void clearActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void courseInfoActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void logoutActionPerformed(ActionEvent evt) {
        
    }

                    
}
