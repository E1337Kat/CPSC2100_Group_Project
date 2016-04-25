/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.*;

import java.awt.*;
import java.io.*;
import javax.swing.*;


/**
 *
 * @author Ellie Peterson
 */
public class MainWindow extends JFrame {

    
    // Variables declaration 
    private JTabbedPane cardTabbedPane;
    private AdminPanel adminPane;
    private InstructorPanel instructorPane;
    private StudentPanel studentPane;
    
    protected UserRegistry userReg = null;
    protected CourseCatalog courseReg = null;
    
    private boolean AdminTabTrue = false;
    private boolean InstTabTrue = false;
    private boolean StuTabTrue = false;
    
    private final ImageIcon img = new ImageIcon("."  + File.separator + "res" + File.separator + "poo.png");
    private final String username;
    // End of variables declaration 
    
    /**
     * Creates new form MainWindow
     * @param u String for username of user... received for login
     */
    public MainWindow(String u) {
        username = u;
        userReg = UserRegistry.getUserRegistryInstance();
        courseReg = CourseCatalog.getCourseCatalogInstance();
        
        setIconImage(img.getImage());
        setTitle("University of FtS");
        initComponents();
    }

    /**
    *  Makes everything the way is should be
    */                    
    private void initComponents() {

        cardTabbedPane = new JTabbedPane();
        System.out.println("Log: Tabbed pane initilized.");
        
        checkPermissions();
        
        getContentPane().add(cardTabbedPane, BorderLayout.CENTER);
        getAccessibleContext().setAccessibleName("Main Window");

        if (AdminTabTrue) {
            System.out.println("Log: Admin tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Administrator", adminPane);
            adminPane.initMe();
            adminPane.setSize(1000,7500);
            System.out.println("Log: Admin tab initialized");
            //adminPane.setVisible(AdminTabTrue);
        }
        if (InstTabTrue) {
            System.out.println("Log: Instructor tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Teacher", instructorPane);
            instructorPane.initMe();
            instructorPane.setSize(1000,7500);
            System.out.println("Log: Instructor tab initialized");
            //instructorPane.setVisible(InstTabTrue);
        }
        if (StuTabTrue) {
            System.out.println("Log: Student tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Student", studentPane);
            studentPane.initMe();
            studentPane.setSize(1000,7500);
            System.out.println("Log: Student tab initialized");
            //studentPane.setVisible(StuTabTrue);
        }
        
        
        this.add(cardTabbedPane);
        
        revalidate();
        setSize(1280,800);
        
    }  
    
    /**
    *  Fetches the username for Database query
    *  @return the username of logged in student
    */
    public String getUsername() {
        return username;
    }
    
    /**
     * Establishes the font the system should use
     * @return Font object built from provided parameters
     */
    public static Font getArialicFont() {
        Font font;
        try {
            //create the font to use. Specify the size!
            font = Font.createFont(Font.TRUETYPE_FONT,
                new File( "."  +
                    File.separator +
                    "res" +
                    File.separator +
                    "Arialic_Hollow.ttf")).deriveFont(12f);
            GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                new File("."  +
                    File.separator +
                    "res" +
                    File.separator +
                    "Arialic_Hollow.ttf")));
        } catch (IOException|FontFormatException e) {
            throw new RuntimeException(e);
        }
        return font;
    }
    
    /**
    *  Checks logged in users permissions and creates tabs appropriately
    */
    private void checkPermissions(){

        //Checks if student
        if ( userReg.getUser(username).adminStatus() || userReg.getUser(username).studentStatus()  ) {

            this.StuTabTrue = true;
            studentPane = StudentPanel.getStudentPanelInstance();
            System.out.println("Log: Student tab initialized");
            System.out.println("Log: I hate this program");
            studentPane.getAccessibleContext().setAccessibleName("Student Panel");
        }
        
        //checks if Instructor
        if ( userReg.getUser(username).adminStatus() || userReg.getUser(username).instructorStatus() ) {

            this.InstTabTrue = true;
            instructorPane = InstructorPanel.getInstructorPanelInstance();
            System.out.println("Log: Instructor tab initialized");
            instructorPane.getAccessibleContext().setAccessibleName("Instructor Panel");
        
        }
        
        //checks if Admin
        if (userReg.getUser(username).adminStatus()) {

            this.AdminTabTrue = true;
            adminPane = AdminPanel.getAdminPanelInstance();
            System.out.println("Log: Admin tab added");
            adminPane.getAccessibleContext().setAccessibleName("Admin Panel");
        }
        
    }            
}
