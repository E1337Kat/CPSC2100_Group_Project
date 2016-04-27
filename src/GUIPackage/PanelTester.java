/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ellie Peterson
 */
public class PanelTester extends JFrame {
    
    
    // Variables declaration - do not modify 
    
    public UserRegistry userReg = UserRegistry.getUserRegistryInstance();
    private CourseCatalog courseReg = CourseCatalog.getCourseCatalogInstance();
    private StudentPanel testPane;
    private final String username = "studentusername";
    // End of variables declaration   
    private boolean StuTabTrue = false;
    
    public PanelTester () {
        userReg = UserRegistry.getUserRegistryInstance();
        courseReg = CourseCatalog.getCourseCatalogInstance();
        initComponents();
    }
        
    public String getUsername() {
        
        return username;
    }
        
    private void initComponents() {

        //testPane = StudentPanel.getStudentPanelInstance();
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        
        

        //initialize testpanes components
        
        if ( userReg.getUser(username).adminStatus() || userReg.getUser(username).studentStatus()  ) {

            this.StuTabTrue = true;
            testPane = StudentPanel.getStudentPanelInstance();
            System.out.println("Log: Student tab initialized");
            System.out.println("Log: I hate this program");
            //studentPane.getAccessibleContext().setAccessibleName("Student Panel");
        }
        
        testPane.setLayout(new GridBagLayout());
        getContentPane().add(testPane);
        
        if (StuTabTrue) {
            System.out.println("Log: Student test panel to be made visible for: " + getUsername());
            
            add(testPane);
            testPane.initMe();
            testPane.setSize(1000, 600);
            System.out.println("Log: Student tab initialized");
            //studentPane.setVisible(StuTabTrue);
        }
        
        revalidate();
        repaint();
        setSize(1084, 677);
    }     
    
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PanelTester pane = new PanelTester();
                pane.setVisible(true);
            }
        });
        
    }
}
