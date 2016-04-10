/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import javax.swing.*;

/**
 *
 * @author EllieKat
 */
public class PanelTester extends JFrame {
    
    
    // Variables declaration - do not modify  
    private StudentPanel_Welcome testPane;
    private String username = "fucker";
    // End of variables declaration   
    
    public PanelTester () {
        initComponents();
    }
        @SuppressWarnings("unchecked")   
        
    public String getUsername() {
        
        return username;
    }
        
    private void initComponents() {

        testPane = new StudentPanel_Welcome();
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(testPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(testPane)
        );
        

        //initialize testpanes components
        testPane.initMe();
        add(testPane);
        revalidate();
        pack();
    }     
    
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
                new PanelTester().setVisible(true);
            }
        });
    }
}
