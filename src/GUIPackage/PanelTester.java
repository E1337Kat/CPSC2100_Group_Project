/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author EllieKat
 */
public class PanelTester extends JFrame {
    
    
    // Variables declaration - do not modify  
    private InstructorPanel_Info testPane;
    private final String username = "Panel T. Ester";
    // End of variables declaration   
    
    public PanelTester () {
        initComponents();
    }
        @SuppressWarnings("unchecked")   
        
    public String getUsername() {
        
        return username;
    }
        
    private void initComponents() {

        testPane = new InstructorPanel_Info();
        testPane.setLayout(new GridBagLayout());
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        getContentPane().add(testPane, BorderLayout.CENTER);
        

        //initialize testpanes components
        add(testPane);
        testPane.initMe();
        revalidate();
        setSize(750, 600);
        
        Object[] objs = {"Granger", "Frank", "fag654", "fag654@fts.edu"};
        testPane.addData(objs);
        
        Object[] moreObjs = {"Kiddo", "Beatrice", "bok564", "bok@fts.edu"};
        testPane.addData(moreObjs);
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
