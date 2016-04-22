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
public class AdminPanel extends JPanelwithBackground {    
    
// Variables declaration 
    public static final String WELCOME = "welcome";
    //public static final String REGISTER = "Register";
    public static final String INFO = "modify";
    
    private JPanel cards;
    private static AdminPanel adminPane = null;
    private AdminPanel_Welcome welcomeAdmin;
    private AdminPanel_AddDropCourse modCourse;
    private AdminPanel_AddDropInstructor modInstructor;
    private AdminPanel_AddDropStudent modStudent;
    // End of variables declaration 

    /**
     * Singleton method of getting the admin panel
     * @return a single admin panel
     */
    public static AdminPanel getAdminPanelInstance() {
        if (adminPane == null) {
            try {
                adminPane = new AdminPanel();
            } catch (IOException ex) {
                System.err.println("Log: ERROR Exception at " + ex);
            }
        }
        return adminPane;
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
     * Creates new form Admin
     * @throws IOException
     */
    private AdminPanel() throws IOException {
        setName("GUIPackage.AdminPanel");
        setLayout(new GridBagLayout());
    }
    
    /**
     * Sets the look and displays the gui
     */                      
    private void initComponents() {

        getAccessibleContext().setAccessibleName("Admin Panel");
        welcomeAdmin = new AdminPanel_Welcome();
	modCourse = new AdminPanel_AddDropCourse();
	modInstructor = new AdminPanel_AddDropInstructor();
	modStudent = new AdminPanel_AddDropStudent();

        cards = new JPanel(new CardLayout());
        cards.setName("cards");
       
        welcomeAdmin.setLayout(null);
        cards.add(welcomeAdmin, WELCOME);
        modCourse.setLayout(null);
        cards.add(modCourse, INFO);
        modInstructor.setLayout(null);
        cards.add(modInstructor, INFO);
	modStudent.setLayout(null);
	cards.add(modStudent, INFO);
        
        cards.setOpaque(false);
        this.add(cards);
        
        welcomeAdmin.initMe();
        welcomeAdmin.setVisible(true);
        System.out.println("Log: Admin Welcome displayed");

        modCourse.initMe();
        modCourse.setVisible(false);
        System.out.println("Log: Admin add/drop course not displayed");
        
        modInstructor.initMe();
        modInstructor.setVisible(false);
        System.out.println("Log: Admin add/drop instructor not displayed");
        
	modStudent.initMe();
        modStudent.setVisible(false);
        System.out.println("Log: Admin add/drop student not displayed");
		
        revalidate();
        repaint();
    }           
}
