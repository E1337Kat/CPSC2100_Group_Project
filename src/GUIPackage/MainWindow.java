/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;


/**
 *
 * @author Ellie Peterson
 */
public class MainWindow extends JFrame {

    
    // Variables declaration 
    //sub components of this
    private JTabbedPane cardTabbedPane;
    private AdminPanel adminPane;
    private InstructorPanel instructorPane;
    private StudentPanel studentPane;
    
    //Vars used by package
    protected UserRegistry userReg = null;
    protected CourseCatalog courseReg = null;
    
    //locally used vars
    private boolean AdminTabTrue = false;
    private boolean InstTabTrue = false;
    private boolean StuTabTrue = false;
    private static ImageIcon img;
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
        
        ClassLoader cl = getClass().getClassLoader();
        String fileName = File.separator + "res" + File.separator + "poo.png";
        InputStream ir = getClass().getResourceAsStream(fileName);
        
        //attempt to add an icon image
        try {
            ImageInputStream imageInput = ImageIO.createImageInputStream(ir);
            BufferedImage bufImage = ImageIO.read(imageInput);
            img = new ImageIcon(bufImage);
            setIconImage(img.getImage());
        } catch (IOException e) {
            System.err.println("Error: Could not read image from " + 
                    fileName + 
                    ".\n\tException: " + 
                    e);
            e.printStackTrace();
        }
        
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
        
        getContentPane().add(cardTabbedPane);
        
        
        this.add(cardTabbedPane);
        
        if (AdminTabTrue) {
            System.out.println("Log: Admin tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Administrator", adminPane);
            adminPane.initMe();
            adminPane.setSize(1000,600);
            System.out.println("Log: Admin tab initialized");
        }
        if (InstTabTrue) {
            System.out.println("Log: Instructor tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Teacher", instructorPane);
            instructorPane.initMe();
            instructorPane.setSize(1000,600);
            System.out.println("Log: Instructor tab initialized");
            
            //hide tab bar if needed
            if (!AdminTabTrue && !StuTabTrue) {
                cardTabbedPane.setUI(new BasicTabbedPaneUI() {
                    @Override
                    protected int calculateTabAreaHeight(int tab_placement, int run_count, int max_tab_height) {  
                        if (cardTabbedPane.getTabCount() > 1)
                            return super.calculateTabAreaHeight(tab_placement, run_count, max_tab_height);  
                        else  
                            return 0;  
                    }
                });
            }
        }
        if (StuTabTrue) {
            System.out.println("Log: Student tab to be made visible for: " + getUsername());
            cardTabbedPane.addTab("Student", studentPane);
            studentPane.initMe();
            studentPane.setSize(1000,600);
            System.out.println("Log: Student tab initialized");
            
            //hide tab bar if needed
            if (!AdminTabTrue && !InstTabTrue) {
                cardTabbedPane.setUI(new BasicTabbedPaneUI() {
                    @Override
                    protected int calculateTabAreaHeight(int tab_placement, int run_count, int max_tab_height) {  
                        if (cardTabbedPane.getTabCount() > 1)
                            return super.calculateTabAreaHeight(tab_placement, run_count, max_tab_height);  
                        else  
                            return 0;  
                    }
                });
            }
        }
        
        revalidate();
        repaint();
        setSize(1084,677);
        
    }  
    
    /**
    *  Fetches the username for Database query
    *  @return the username of logged in student
    */
    public String getUsername() {
        return username;
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
            //studentPane.getAccessibleContext().setAccessibleName("Student Panel");
        }
        
        //checks if Instructor
        if ( userReg.getUser(username).adminStatus() || userReg.getUser(username).instructorStatus() ) {

            this.InstTabTrue = true;
            instructorPane = InstructorPanel.getInstructorPanelInstance();
            System.out.println("Log: Instructor tab initialized");
            //instructorPane.getAccessibleContext().setAccessibleName("Instructor Panel");
        
        }
        
        //checks if Admin
        if (userReg.getUser(username).adminStatus()) {

            this.AdminTabTrue = true;
            adminPane = AdminPanel.getAdminPanelInstance();
            System.out.println("Log: Admin tab added");
            //adminPane.getAccessibleContext().setAccessibleName("Admin Panel");
        }
        
    }            
}
