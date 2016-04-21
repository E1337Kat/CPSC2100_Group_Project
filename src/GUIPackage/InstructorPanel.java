/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author EMCS306
 */
public class InstructorPanel extends JPanelwithBackground {    
    
// Variables declaration - do not modify 
    private JPanel cards;
    public static final String WELCOME = "welcome";
    public static final String INFO = "info";
    public static final String MODIFY = "modify";
    private static InstructorPanel instPane = null;
    private InstructorPanel_Info instructorInfo;
    private InstructorPanel_Welcome instructorWelcome;
    private InstructorPanel_ModifyCourse instructorModify;
    private int context;
    // End of variables declaration 

    /**
     * Singleton method of getting the student panel
     * @return a single student panel
     */
    public static InstructorPanel getInstructorPanelInstance() {
        if (instPane == null) {
            try {
                instPane = new InstructorPanel();
            } catch (IOException ex) {
                System.err.println("Log: ERROR Exception at " + ex);
            }
        }
        return instPane;
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
                instructorWelcome.setVisible(false);
                instructorInfo.setVisible(true);
                
                System.out.println("log: Student Add/Drop displayed");
                break;
            case 1:
                instructorInfo.setVisible(false);
                instructorWelcome.setVisible(true);
                
                System.out.println("log: Student Welcome displayed");
                break;
            default:
                System.err.println("No window to show");
                break;
        }
        
        revalidate();
    
        
    }
    
    /*
    @Override
    public void actionPerformed(ActionEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, evt.getActionCommand());
    }
    */

    
    public JPanel getCards() {
        return cards;
    }
    /**
     * Creates new form Student
     * @throws IOException
     */
    private InstructorPanel() throws IOException {
        setName("GUIPackage.InstructorPanel");
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

        //setName("GUIPackage.InstructorPanel");
        getAccessibleContext().setAccessibleName("Instructor Panel");
        instructorWelcome = new InstructorPanel_Welcome();
        instructorInfo = new InstructorPanel_Info();
        instructorModify = new InstructorPanel_ModifyCourse();

        cards = new JPanel(new CardLayout());
        cards.setName("cards");
        
        instructorWelcome.setLayout(null);
        cards.add(instructorWelcome, WELCOME);
        instructorInfo.setLayout(null);
        cards.add(instructorInfo, INFO);
        instructorModify.setLayout(null);
        cards.add(instructorModify, MODIFY);
        //setBackground(new java.awt.Color(255, 255, 255));
        //setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cards.setOpaque(false);
        this.add(cards);
        //instructorWelcome.setLayout(null);
        //cards.add(instructorWelcome);
        instructorWelcome.initMe();
        instructorWelcome.setVisible(true);
        System.out.println("log: Instructor Welcome displayed");

        //instructorInfo.setLayout(new java.awt.GridBagLayout());
        //this.add(instructorInfo);
        instructorInfo.initMe();
        instructorInfo.setVisible(false);
        System.out.println("log: Instructor Info not displayed");
        
        
        instructorModify.initMe();
        instructorModify.setVisible(false);
        System.out.println("Log: Instructor Modify not displayed");
        
        //setOpaque(false);
        revalidate();
        repaint();
    }           
}
