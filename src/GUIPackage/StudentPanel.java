/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.io.IOException;

/**
 *
 * @author EMCS306
 */
public class StudentPanel extends JPanelwithBackground {

    /**
     * Creates new form Student
     * @throws IOException
     */
    public StudentPanel() throws IOException{
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")                        
    private void initComponents() {

        studentWelcome = new javax.swing.JPanel();
        modifySchedule = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(null);

        studentWelcome.setOpaque(false);
        studentWelcome.setLayout(new java.awt.GridLayout(1, 0));
        add(studentWelcome);
        studentWelcome.setBounds(0, 0, 0, 0);

        modifySchedule.setOpaque(false);
        modifySchedule.setLayout(new java.awt.GridLayout(1, 0));
        add(modifySchedule);
        modifySchedule.setBounds(0, 0, 0, 0);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel modifySchedule;
    private javax.swing.JPanel studentWelcome;
    // End of variables declaration                   
}
