/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author EMCS306
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

    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        
        usernameLabel = new JLabel();
        schedule = new CourseList();
        addCourseButton = new JButton();
        deleteCourseButton = new JButton();
        String u;
        GridBagConstraints gBC;
        
        //Set Layout
        setLayout(new GridBagLayout());
        
        PanelTester topWindow = null;
        topWindow = (PanelTester)((JFrame)SwingUtilities.getWindowAncestor(this));
        //MainWindow topWindow = null;
        //topWindow = (MainWindow)((JFrame)SwingUtilities.getWindowAncestor(this));
        u = topWindow.getUsername();
        
        //Row One
        usernameLabel.setText("Welcome " + u);
        gBC = new GridBagConstraints();
        gBC.gridheight = 1;
        gBC.gridwidth = 1;
        gBC.gridx = 3;
        gBC.gridy = 0;
        gBC.insets = new Insets(0,0,0,0);
        gBC.anchor = gBC.CENTER;
        gBC.fill = gBC.BOTH;
        add(usernameLabel, gBC);
        
        //Rows 2-4
        schedule.getAccessibleContext().setAccessibleName("Course Schedule");
        gBC = new GridBagConstraints();
        gBC.gridheight = 3;
        gBC.gridwidth = 5;
        gBC.gridx = 0;
        gBC.gridy = 1;
        gBC.ipadx = 20;
        gBC.insets = new Insets(0,0,0,0);
        gBC.anchor = gBC.CENTER;
        gBC.fill = gBC.BOTH;
        add(schedule, gBC);
        
        //Row 5
        addCourseButton.setText("Add Course");
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });
        gBC = new GridBagConstraints();
        gBC.gridheight = 1;
        gBC.gridwidth = 2;
        gBC.gridx = 0;
        gBC.gridy = 6;
        gBC.ipadx = 10;
        gBC.ipady = 3;
        gBC.insets = new Insets(0,0,0,0);
        gBC.anchor = gBC.CENTER;
        gBC.fill = gBC.BOTH;
        add(addCourseButton, gBC);
        
        deleteCourseButton.setText("Delete Course");
        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deleteCourseActionPerformed(evt);
            }
        });
        gBC = new GridBagConstraints();
        gBC.gridheight = 1;
        gBC.gridwidth = 2;
        gBC.gridx = 2;
        gBC.gridy = 6;
        gBC.ipadx = 10;
        gBC.ipady = 3;
        gBC.insets = new Insets(0,0,0,0);
        gBC.anchor = gBC.CENTER;
        gBC.fill = gBC.BOTH;
        add(deleteCourseButton, gBC);
        
        //Row 6 @TODO
        
        
        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        setLayout(new java.awt.GridBagLayout());
        getAccessibleContext().setAccessibleName("Student Panel Welcome");
    }      
    
    private void addCourseActionPerformed(ActionEvent evt) {
        
    }

    private void deleteCourseActionPerformed(ActionEvent evt) {
        
    }

                     
}
