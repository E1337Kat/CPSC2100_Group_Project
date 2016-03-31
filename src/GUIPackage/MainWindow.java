/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.AdminRegistry;
import Backend.InstructorRegistry;
import Backend.StudentRegistry;
import java.io.File;

import java.io.IOException;
import javax.swing.ImageIcon;


/**
 *
 * @author EMCS306
 */
public class MainWindow extends javax.swing.JFrame {

    public AdminRegistry adminReg = new AdminRegistry() ;
    public InstructorRegistry instructorReg = new InstructorRegistry() ;
    public StudentRegistry stuReg = new StudentRegistry() ;
    public ImageIcon img = new ImageIcon("."  + File.separator + "res" + File.separator + "poo.png");
    public String username;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        
        setIconImage(img.getImage());
        setTitle("University of FtS");
        initComponents();
    }

    
    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        
        checkPermissions();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    private void checkPermissions(){

        
        if ( adminReg.isAdmin(username) || stuReg.isStudent(username)  ) {

            try {
                studentPane = new StudentPanel();
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            jTabbedPane5.updateUI();
            jTabbedPane5.addTab("Student", studentPane);
            studentPane.getAccessibleContext().setAccessibleName("");
        }
        
        if ( adminReg.isAdmin(username) || instructorReg.isInstructor(username) ) {

            try {
                InstructorPane = new InstructorPanel();;
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            
            jTabbedPane5.updateUI();
            jTabbedPane5.addTab("Teacher", InstructorPane);
            InstructorPane.getAccessibleContext().setAccessibleName("");
            javax.swing.GroupLayout InstructorPaneLayout = new javax.swing.GroupLayout(InstructorPane);
        
        }
        
        if (adminReg.isAdmin(username)) {

            try {
                AdminPane = new GUIPackage.AdminPanel();
            } catch (IOException e1) {
                System.out.println("Exception thrown  :" + e1);
            }
            System.out.println("running");
            
            jTabbedPane5.updateUI();
            jTabbedPane5.addTab("Administrator", AdminPane);
            AdminPane.getAccessibleContext().setAccessibleName("");
        }
        
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
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel AdminPane;
    private javax.swing.JPanel InstructorPane;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JPanel studentPane;
    //private javax.swing.JPanel student_welcome;
    // End of variables declaration                   
}
