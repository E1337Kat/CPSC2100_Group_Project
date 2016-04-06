/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author EllieKat
 */
public class LoginWindow extends javax.swing.JFrame {

    public ImageIcon img = new ImageIcon("."  + File.separator + "res" + File.separator + "poo.png");
    /**
     * Creates new form LoginWindow
     */
    public LoginWindow() {
        setIconImage(img.getImage());
        setTitle("University of FtS");
        initComponents();
    }

    
    @SuppressWarnings("unchecked")                       
    private void initComponents() {

        
        //loginPane = new LoginFrame();
        
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPane)
        );

        pack();
    }                       

    public String getUsername() {
        return loginPane.getUsername();
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        // Set the Nimbus look and feel
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify  
    private LoginFrame loginPane;
    // End of variables declaration                   
}
