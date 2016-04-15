/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Ellie Peterson
 */
public class StudentPanel_Welcome extends JPanel {

    // Variables declaration - do not modify  
    private JLabel usernameLabel;
    private JPanel schedule;
    private JButton addCourseButton;
    private JButton deleteCourseButton;
    private JButton printScheduleButton;
    private JButton logoutButton;
    // End of variables declaration
    
    /**
     * Creates new form StudentPanel_Welcome
     */
    public StudentPanel_Welcome() {
    }
    
    public void initMe() {
        initComponents();
    }

    
    
    private void initComponents() {
        
        
        
        usernameLabel = new JLabel();
        schedule = new CourseList();
        addCourseButton = new JButton();
        deleteCourseButton = new JButton();
        printScheduleButton = new JButton();
        logoutButton = new JButton();
        String u;
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        //PanelTester topWindow = null;
        //topWindow = (PanelTester)((JFrame)SwingUtilities.getWindowAncestor(this));
        MainWindow topWindow = null;
        topWindow = (MainWindow)((JFrame)SwingUtilities.getWindowAncestor(this));
        
        System.out.println("Log: Parent window = " + topWindow.getName());
        System.out.println("Log: Student username = " + topWindow.getUsername());
        u = topWindow.getUsername();
        
        //Row One
        usernameLabel.setText("Welcome " + u);
        gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 0;
        //gbc.weightx = 0.1;
        //gbc.weighty = 0.1;
        //gbc.ipadx = 0;
        //gbc.ipady = 0;
        gbc.insets = new Insets(20,10,10,10); //top, left, bottom, right
        gbc.anchor = gbc.CENTER;
        gbc.fill = gbc.BOTH;
        //gridBag.setConstraints(usernameLabel, gbc);
        this.add(usernameLabel, gbc);
        
        //Rows 2-4
        schedule.getAccessibleContext().setAccessibleName("Course Schedule");
        gbc = new GridBagConstraints();
        gbc.gridheight = 3;
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 1;
        //gbc.ipadx = 20;
        //gbc.ipady = 0;
        //gbc.weightx = 1;
        //gbc.weighty = 0;
        gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
        gbc.anchor = gbc.CENTER;
        gbc.fill = gbc.BOTH;
        //gridBag.setConstraints(schedule, gbc);
        this.add(schedule, gbc);
        
        //Row 5 - empty label
        JLabel hiddenLabel1 = new JLabel();
        gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 7;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
        gbc.fill = gbc.BOTH;
        this.add(hiddenLabel1, gbc);
        
        //Row 6
        addCourseButton.setText("Add Course");
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });
        gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 10;
        //gbc.ipady = 3;
        gbc.weightx = 0.5;
        //gbc.weighty = 0.5;
        gbc.insets = new Insets(10,10,10,5); //top, left, bottom, right
        gbc.anchor = gbc.CENTER;
        //gbc.fill = gbc.BOTH;
        //gridBag.setConstraints(addCourseButton, gbc);
        this.add(addCourseButton, gbc);
        
        deleteCourseButton.setText("Delete Course");
        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteCourseActionPerformed(evt);
            }
        });
        gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.ipadx = 10;
        //gbc.ipady = 3;
        gbc.weightx = 0.5;
        //gbc.weighty = 0.5;
        gbc.insets = new Insets(10,5,10,5); //top, left, bottom, right
        gbc.anchor = gbc.CENTER;
        //gbc.fill = gbc.BOTH;
        //gridBag.setConstraints(deleteCourseButton, gbc);
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
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.ipadx = 10;
        //gbc.ipady = 3;
        gbc.weightx = 0.5;
        //gbc.weighty = 0.5;
        gbc.insets = new Insets(10,5,10,0); //top, left, bottom, right
        gbc.anchor = gbc.CENTER;
        //gbc.fill = gbc.BOTH;
        //gridBag.setConstraints(printScheduleButton, gbc);
        this.add(printScheduleButton, gbc);
        
        
        JLabel hiddenLabel2 = new JLabel();
        gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.weightx = 0.6;
        gbc.insets = new Insets(10,0,10,0); //top, left, bottom, right
        gbc.fill = gbc.BOTH;
        this.add(hiddenLabel2, gbc);
        
        //Row 7
        JLabel hiddenLabel3 = new JLabel();
        gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.4;
        gbc.insets = new Insets(10,10,20,2); //top, left, bottom, right
        gbc.fill = gbc.BOTH;
        this.add(hiddenLabel3, gbc);
        
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 5;
        gbc.gridy = 6;
        gbc.ipadx = 10;
        //gbc.ipady = 3;
        gbc.weightx = 0.5;
        //gbc.weighty = 0.8;
        gbc.insets = new Insets(10,2,20,10); //top, left, bottom, right
        gbc.anchor = gbc.LINE_START; 
        //gbc.fill = gbc.BOTH;
        //gridBag.setConstraints(logoutButton, gbc);
        this.add(logoutButton, gbc);
        
        setBorder(BorderFactory.createTitledBorder(new MatteBorder(null), "", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", 1, 14), new Color(255, 255, 255))); // NOI18N
        getAccessibleContext().setAccessibleName("Student Panel Welcome");
        
        setOpaque(false);
    }      
    
    private void addCourseActionPerformed(ActionEvent evt) {
        
    }

    private void deleteCourseActionPerformed(ActionEvent evt) {
        
    }

    private void printScheduleActionPerformed(ActionEvent evt) {
        
    }
    
    private void logoutButtonActionPerformed(ActionEvent evt) {
        
    }
                     
}
