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
    private JTabbedPane CardTabbedPane;
    private AdminPanel adminPane;
    private InstructorPanel instructorPane;
    private StudentPanel studentPane;
    
    private AdminRegistry adminReg = null;
    private InstructorRegistry instructorReg = null;
    private StudentRegistry stuReg = null;
    
    private int AdminTabTrue = 0;
    private int InstTabTrue = 0;
    private int StuTabTrue = 0;
    
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

        CardTabbedPane = new JTabbedPane();
        
        checkPermissions();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(CardTabbedPane)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(CardTabbedPane)
        );
        
        getAccessibleContext().setAccessibleName("Main Window");

        if (AdminTabTrue != 0) {
            adminPane.initMe();
        }
        if (InstTabTrue != 0) {
            instructorPane.initMe();
        }
        if (StuTabTrue != 0) {
            studentPane.initMe();
        }
        revalidate();
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

            try {
                studentPane = new StudentPanel();
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            CardTabbedPane.updateUI();
            CardTabbedPane.addTab("Student", studentPane);
            studentPane.setVisible(true);
            studentPane.getAccessibleContext().setAccessibleName("Student Panel");
        }
        
        //checks if Instructor
        if ( adminReg.isAdmin(username) || instructorReg.isInstructor(username) ) {

            try {
                instructorPane = new InstructorPanel();
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            
            CardTabbedPane.updateUI();
            CardTabbedPane.addTab("Teacher", instructorPane);
            instructorPane.setVisible(true);
            instructorPane.getAccessibleContext().setAccessibleName("Instructor Panel");
            //javax.swing.GroupLayout InstructorPaneLayout = new javax.swing.GroupLayout(instructorPane);
        
        }
        
        //checks if Admin
        if (adminReg.isAdmin(username)) {

            try {
                adminPane = new GUIPackage.AdminPanel();
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            CardTabbedPane.updateUI();
            CardTabbedPane.addTab("Administrator", adminPane);
            adminPane.setVisible(true);
            adminPane.getAccessibleContext().setAccessibleName("Admin Panel");
        }
        
    }            
}
