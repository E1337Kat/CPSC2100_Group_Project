/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author EMCS306
 */
public class StudentPanel extends JPanelwithBackground {    
    
// Variables declaration - do not modify 
    private static StudentPanel stuPane = null;
    private StudentPanel_AddDrop modifySchedule;
    private StudentPanel_Welcome studentWelcome;
    private int context;
    // End of variables declaration 

    /**
     * Singleton method of getting the student panel
     * @return a single student panel
     */
    public static StudentPanel getStudentPanelInstance() {
        if (stuPane == null) {
            try {
                stuPane = new StudentPanel();
            } catch (IOException ex) {
                System.err.println("Log: ERROR Exception at " + ex);
            }
        }
        return stuPane;
    }
    
    /**
     * public method to init the GUI
     */
    public void initMe() {
        initComponents();
    }
    
    /**
     * Switches between welcome and modify views
     */
    public void switchPane(Container child) {
        
        if (child.getClass().equals(StudentPanel_Welcome.class)) {
            context = 0;
        } else if (child.getClass().equals(StudentPanel_AddDrop.class)) {
            context = 1;
        } 
        
        switch(context) {
            case 0:
                studentWelcome.setVisible(false);
                modifySchedule.setVisible(true);
                
                System.out.println("log: Student Add/Drop displayed");
                break;
            case 1:
                modifySchedule.setVisible(false);
                studentWelcome.setVisible(true);
                
                System.out.println("log: Student Welcome displayed");
                break;
            default:
                System.err.println("No window to show");
                break;
        }
        
        revalidate();
    
        
    }
    
    /**
     * Creates new form Student
     * @throws IOException
     */
    private StudentPanel() throws IOException {
        setLayout(new GridBagLayout());
    }
    
    /**
     * Gets the child class of this panel
     * @return child container
     */
    private Container getChildClass() {
        return new StudentPanel_Welcome();
    }
    
    /**
     * Sets the look and displays the gui
     */                      
    private void initComponents() {

        studentWelcome = new StudentPanel_Welcome();
        modifySchedule = new StudentPanel_AddDrop();

        
        //setBackground(new java.awt.Color(255, 255, 255));
        //setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        
        studentWelcome.setLayout(null);
        this.add(studentWelcome);
        studentWelcome.initMe();
        studentWelcome.setVisible(true);
        System.out.println("log: Student Welcome displayed");

        modifySchedule.setLayout(new java.awt.GridBagLayout());
        this.add(modifySchedule);
        modifySchedule.initMe();
        modifySchedule.setVisible(false);
        System.out.println("log: Student Add/Drop not displayed");
        
        revalidate();
        repaint();
    }           
}
