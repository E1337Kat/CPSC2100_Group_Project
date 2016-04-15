/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.*;

import java.awt.*;
import java.io.*;
import javax.swing.*;


/**
 *
 * @author EMCS306
 */
public class MainWindow extends JFrame {

    
    // Variables declaration 
    private JTabbedPane cardTabbedPane;
    private AdminPanel adminPane;
    private InstructorPanel instructorPane;
    private StudentPanel studentPane;
    
    private AdminRegistry adminReg = null;
    private InstructorRegistry instructorReg = null;
    private StudentRegistry stuReg = null;
    
    private boolean AdminTabTrue = false;
    private boolean InstTabTrue = false;
    private boolean StuTabTrue = false;
    
    private final ImageIcon img = new ImageIcon("."  + File.separator + "res" + File.separator + "poo.png");
    private final String username;
    // End of variables declaration 
    
    /**
     * Creates new form MainWindow
     * @param u String for username of user... received for login
     */
    public MainWindow(String u) {
        username = u;
        adminReg = Singleton.getAdminRegInstance();
        instructorReg = Singleton.getInstructorRegInstance();
        stuReg = Singleton.getStuRegInstance();
        
        setIconImage(img.getImage());
        setTitle("University of FtS");
        initComponents();
    }

    /**
    *  Makes everything the way is should be
    */                    
    private void initComponents() {

        //GroupLayout layout = new GroupLayout(getContentPane());
        //getContentPane().setLayout(layout);
        //getContentPane().add(cardTabbedPane);
        GridBagConstraints gbc;
        
        cardTabbedPane = new JTabbedPane();
        System.out.println("Log: Tabbed pane initilized.");
        
        //setLayout(new FlowLayout());
        
        
        //cardTabbedPane.setLayout(null);
        checkPermissions();
        
        /*
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(cardTabbedPane)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(cardTabbedPane)
        );
        */
        
        /*
        gbc = new GridBagConstraints();
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = gbc.NORTHWEST;
        gbc.fill = gbc.BOTH;
        */
        
        
        
        
        getContentPane().add(cardTabbedPane, BorderLayout.CENTER);
        
        getAccessibleContext().setAccessibleName("Main Window");

        if (AdminTabTrue) {
            System.out.println("Log: Admin tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Administrator", adminPane);
            adminPane.initMe();
            //adminPane.setVisible(AdminTabTrue);
        }
        if (InstTabTrue) {
            System.out.println("Log: Instructor tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Teacher", instructorPane);
            instructorPane.initMe();
            //instructorPane.setVisible(InstTabTrue);
        }
        if (StuTabTrue) {
            System.out.println("Log: Student tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Student", studentPane);
            studentPane.initMe();
            System.out.println("Log: Student tab initialized");
            //studentPane.setVisible(StuTabTrue);
        }
        
        this.add(cardTabbedPane);
        
        revalidate();
        //repaint();
        setSize(750,600);
    }  
    
    /**
    *  Fetches the username for Database query
    *  @return the username of logged in student
    */
    public String getUsername() {
        return username;
    }
    
    /**
    *  Checks logged in users permissions and creates tabs appropriately
    */
    private void checkPermissions(){

        //Checks if student
        if ( adminReg.isAdmin(username) || stuReg.isStudent(username)  ) {

            this.StuTabTrue = true;
            studentPane = StudentPanel.getStudentPanelInstance();
            //cardTabbedPane.updateUI();
            //cardTabbedPane.addTab("Student", studentPane);
            System.out.println("Log: Student tab initialized");
            System.out.println("Log: I hate this program");
            studentPane.getAccessibleContext().setAccessibleName("Student Panel");
        }
        
        //checks if Instructor
        if ( adminReg.isAdmin(username) || instructorReg.isInstructor(username) ) {

            this.InstTabTrue = true;
            try {
                instructorPane = new InstructorPanel();
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            
            //cardTabbedPane.updateUI();
            //cardTabbedPane.addTab("Teacher", instructorPane);
            System.out.println("Log: Instructor tab added");
            instructorPane.getAccessibleContext().setAccessibleName("Instructor Panel");
            //javax.swing.GroupLayout InstructorPaneLayout = new javax.swing.GroupLayout(instructorPane);
        
        }
        
        //checks if Admin
        if (adminReg.isAdmin(username)) {

            this.AdminTabTrue = true;
            try {
                adminPane = new GUIPackage.AdminPanel();
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            //cardTabbedPane.updateUI();
            //cardTabbedPane.addTab("Administrator", adminPane);
            System.out.println("Log: Admin tab added");
            adminPane.getAccessibleContext().setAccessibleName("Admin Panel");
        }
        
    }            
}
