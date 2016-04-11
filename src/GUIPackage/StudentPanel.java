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
    private final String MODPANE = "";
    private final String ADDPANE = "";
    private StudentPanel_AddDrop modifySchedule;
    private StudentPanel_Welcome studentWelcome;
    private int context;
    // End of variables declaration 
    
    /**
     * Creates new form Student
     * @throws IOException
     */
    public StudentPanel() throws IOException {
        setLayout(null);
    }

    /*StudentPanel(CardLayout cardLayout) throws IOException {
        setLayout(new CardLayout());
    }*/

    public void initMe() {
        initComponents();
    }
    
    public void switchPane() {
        Container child = getChildClass();
        if (child.getClass().equals(StudentPanel_Welcome.class)) {
            context = 0;
        } else if (child.getClass().equals(StudentPanel_AddDrop.class)) {
            context = 1;
        } 
        
        switch(context) {
            case 0:
                studentWelcome.setVisible(true);
                break;
            case 1:
                modifySchedule.setVisible(true);
                break;
            default:
                System.err.println("No window to show");
                break;
        }
    
        
    }
    
    private Container getChildClass() {
        return new StudentPanel_Welcome();
    }
    
    @SuppressWarnings("unchecked")                        
    private void initComponents() {

        studentWelcome = new StudentPanel_Welcome();
        modifySchedule = new StudentPanel_AddDrop();

        
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        
        //JPanel cards = new JPanel(new CardLayout());
        
        studentWelcome.setLayout(new java.awt.GridBagLayout());
        this.add(studentWelcome);
        studentWelcome.setVisible(true);

        
        modifySchedule.setLayout(new java.awt.GridBagLayout());
        this.add(modifySchedule);
        modifySchedule.setVisible(false);
        
        studentWelcome.initMe();
        modifySchedule.initMe();
        revalidate();
    }

                   
}
