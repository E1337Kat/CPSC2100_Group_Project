/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.*;

import java.io.File;
import java.io.IOException;
import javax.swing.*;


/**
 *
 * @author EMCS306
 */
public class MainWindow extends javax.swing.JFrame {

    public AdminRegistry adminReg;
    public InstructorRegistry instructorReg;
    public StudentRegistry stuReg;
    public ImageIcon img = new ImageIcon("."  + File.separator + "res" + File.separator + "poo.png");
    public String username;
    /**
     * Creates new form MainWindow
     */
    public MainWindow(String u, 
            AdminRegistry aR, 
            InstructorRegistry iR, 
            StudentRegistry sR) {
        username = u;
        adminReg = aR;
        instructorReg = iR;
        stuReg = sR;
        
        setIconImage(img.getImage());
        setTitle("University of FtS");
        initComponents();
    }

    
    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        
        checkPermissions();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        
        getAccessibleContext().setAccessibleName("Main Window");

        setSize(750,600);
    }  
    
    public String getUsername() {
        return username;
    }
    
    private void checkPermissions(){

        //Checks if student
        if ( adminReg.isAdmin(username) || stuReg.isStudent(username)  ) {

            try {
                studentPane = new StudentPanel();
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            jTabbedPane5.updateUI();
            jTabbedPane5.addTab("Student", studentPane);
            studentPane.setVisible(true);
            studentPane.getAccessibleContext().setAccessibleName("Student Panel");
        }
        
        //checks if Instructor
        if ( adminReg.isAdmin(username) || instructorReg.isInstructor(username) ) {

            try {
                instructorPane = new InstructorPanel();;
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            
            jTabbedPane5.updateUI();
            jTabbedPane5.addTab("Teacher", instructorPane);
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
            jTabbedPane5.updateUI();
            jTabbedPane5.addTab("Administrator", adminPane);
            adminPane.setVisible(true);
            adminPane.getAccessibleContext().setAccessibleName("Admin Panel");
        }
        
    }
    
    

    // Variables declaration 
    private javax.swing.JPanel adminPane;
    private javax.swing.JPanel instructorPane;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JPanel studentPane;
    // End of variables declaration                   
}
