/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.CardLayout;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author EMCS306
 */
public class StudentPanel extends JPanelwithBackground {    
    
// Variables declaration - do not modify                     
    private javax.swing.JPanel modifySchedule;
    private javax.swing.JPanel studentWelcome;
    private int context;
    // End of variables declaration 
    
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

        
        JPanel cards = new JPanel(new CardLayout());
        studentWelcome.setOpaque(false);
        studentWelcome.setLayout(new java.awt.GridLayout(1, 0));
        cards.add(studentWelcome, "welcome");
        studentWelcome.setBounds(0, 0, 0, 0);

        modifySchedule.setOpaque(false);
        modifySchedule.setLayout(new java.awt.GridLayout(1, 0));
        cards.add(modifySchedule, "modify");
        modifySchedule.setBounds(0, 0, 0, 0);
        
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "welcome");
    }

                   
}
