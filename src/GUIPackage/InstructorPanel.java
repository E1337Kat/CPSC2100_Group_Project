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
 * @author Ellie Peterson
 */
public class InstructorPanel extends JPanelwithBackground {    
    
// Variables declaration 
    public static final String WELCOME = "welcome";
    public static final String INFO = "info";
    public static final String MODIFY = "modify";
    
    private JPanel cards;
    private static InstructorPanel instPane = null;
    private InstructorPanel_Info instructorInfo;
    private InstructorPanel_Welcome instructorWelcome;
    private InstructorPanel_ModifyCourse instructorModify;
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
     * Gets card holder
     * @return Panel that is card holder
     */
    public JPanel getCards() {
        return cards;
    }
    
    protected void addData(Object[] o, int context) {
        switch (context) {
            case 0:
                instructorWelcome.addData(o);
                break;
            case 1:
                instructorInfo.addData(o);
                break;
            default:
                throw new UnsupportedOperationException("Error: Context for " + this.getName() + ".addData(Object[], int) must be 0 or 1");
        }    
        ;
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
     * Sets the look and displays the gui
     */                      
    private void initComponents() {
        this.removeAll();

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

        cards.setOpaque(false);
        this.add(cards);
        
        //init and show instructor welcome
        instructorWelcome.initMe();
        instructorWelcome.setVisible(true);
        System.out.println("log: Instructor Welcome displayed");

        //init and do not show instructor info
        instructorInfo.initMe();
        instructorInfo.setVisible(false);
        System.out.println("log: Instructor Info not displayed");
        
        //init and do not show modify
        instructorModify.initMe();
        instructorModify.setVisible(false);
        System.out.println("Log: Instructor Modify not displayed");
        
        
        this.revalidate();
        this.repaint();
    }           
}
