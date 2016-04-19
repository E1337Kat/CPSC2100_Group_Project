/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.*;
import java.io.File;
import javax.swing.*;

/**
 * @description This class is the primary starting point for the system. 
 * @author Ellie Peterson
 */
public class MainClass {
    static final String LOOKANDFEEL = "System";
    private static final ImageIcon img = new ImageIcon("."  + File.separator + "res" + File.separator + "poo.png");
    private static final String UNI_NAME = "University of FtS";

    /*
    * Start of Main thread
    */
    public static void main(String args[]) {
        Singleton.getInstance();
        
        /* Set Look and Feel of program to system look and feel if possible*/
        initLookAndFeel();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setIconImage(img.getImage());
                loginFrame.setTitle(UNI_NAME);
                
                loginFrame.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
                loginFrame.pack();
                
                loginFrame.setVisible(true);
            }
        });
    }
    
    /*
    * Requests system look and feel, and if unavailable, sets to metal(System independent)
    */
    private static void initLookAndFeel() {
        String lookAndFeel = null;
        
        if (LOOKANDFEEL != null) {
            if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName(); 
            } else { //default to java LaF
                System.err.println("Unexpected value of LOOKANDFEEL specified: "
                        + LOOKANDFEEL );
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }
            try {
                
                UIManager.setLookAndFeel(lookAndFeel);
                
            } catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                                   + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } 
            
            catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel ("
                                   + lookAndFeel
                                   + ") on this platform.");
                System.err.println("Using the default look and feel.");
            } 
            
            catch (Exception e) {
                System.err.println("Couldn't get specified look and feel ("
                                   + lookAndFeel
                                   + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }
}
