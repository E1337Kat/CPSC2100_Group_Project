/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Ellie Peterson
 */
public class StudentPanel extends JPanelwithBackground {    
    
// Variables declaration 
    public static final String WELCOME = "welcome";
    public static final String REGISTER = "Register";
    public static final String INFO = "modify";
    
    private JPanel cards;
    private static StudentPanel stuPane = null;
    private StudentPanel_Register registerCourses;
    private StudentPanel_Welcome studentWelcome;
    private StudentPanel_Info courseInfo;
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
     * gets card holder
     * @return Jpanel that is card holder
     */
    public JPanel getCards() {
        return cards;
    }
    
    /**
     * Creates new form Student
     * @throws IOException
     */
    private StudentPanel() throws IOException {
        setName("GUIPackage.StudentPanel");
        setLayout(new GridBagLayout());
    }
    
    /**
     * Sets the look and displays the gui
     */                      
    private void initComponents() {

        this.removeAll();
        
        
        
        getAccessibleContext().setAccessibleName("Student Panel");
        studentWelcome = StudentPanel_Welcome.getStudentWelcomeInstance();
        registerCourses = StudentPanel_Register.getStudentRegInstance();
        courseInfo = StudentPanel_Info.getStudentInfoInstance();

        cards = new JPanel(new CardLayout());
        cards.setName("cards");
        
        cards.addAncestorListener(new AncestorListener(){
            @Override
            public void ancestorAdded(AncestorEvent event) {
                studentWelcome.repopulateTable();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                
            }
            
        });
       
        studentWelcome.setLayout(null);
        cards.add(studentWelcome, WELCOME);
        registerCourses.setLayout(null);
        cards.add(registerCourses, REGISTER);
        courseInfo.setLayout(null);
        cards.add(courseInfo, INFO);
        
        cards.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
            gbc.ipadx = 10;
            gbc.ipady = 10;
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.BOTH;
        this.add(cards, gbc);
        
        studentWelcome.initMe();
        studentWelcome.setVisible(true);
        System.out.println("Log: Student Welcome displayed");

        registerCourses.initMe();
        registerCourses.setVisible(false);
        System.out.println("Log: Student Register not displayed");
        
        courseInfo.initMe();
        courseInfo.setVisible(false);
        System.out.println("Log: Student Info not displayed");
        
        this.revalidate();
        this.repaint();
    }           
}
