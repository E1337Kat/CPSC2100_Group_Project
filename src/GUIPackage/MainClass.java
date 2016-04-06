/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.AdminRegistry;
import Backend.InstructorRegistry;
import Backend.StudentRegistry;
import java.awt.Window;
import javax.swing.*;

/**
 *
 * @author ellie
 */
public class MainClass {
    public static final AdminRegistry adminReg = new AdminRegistry() ;
    public static final InstructorRegistry instructorReg = new InstructorRegistry() ;
    public static final StudentRegistry stuReg = new StudentRegistry() ;
    
    
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
                LoginFrame loginFrame = new LoginFrame(adminReg, instructorReg, stuReg);
                
                loginFrame.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
                loginFrame.pack();
                
                loginFrame.setVisible(true);
            }
        });
    }
}
