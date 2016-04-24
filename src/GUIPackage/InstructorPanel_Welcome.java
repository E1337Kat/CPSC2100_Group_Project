/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Ellie Peterson
 */
public class InstructorPanel_Welcome extends JPanel {

    // Variables declaration 
    private JLabel usernameLabel;
    private CheckBoxTable schedule;
    private JButton printScheduleButton;
    private JButton hiddenButton1;
    private JButton modifyCourseButton;
    private JButton courseInfoButton;
    private SwingLink helpLink;
    private JButton logoutButton;
    // End of variables declaration
    
    /***********************************************************************
     * Public functions
     **********************************************************************/
    
    
    /**
     * Creates new form StudentPanel_Welcome
     */
    public InstructorPanel_Welcome() {
    }
    
    /**
     * Public method to initialize components
     * calls initComponents
     */
    public void initMe() {
        initComponents();
    }
    
    /***********************************************************************
     * Private functions
     **********************************************************************/
    
    /**
     * Initializes and adds components to the panel.
     */
    private void initComponents() {
        this.removeAll();
        
        usernameLabel = new JLabel();
        schedule = new CheckBoxTable();
        printScheduleButton = new JButton();
        hiddenButton1 = new JButton();
        modifyCourseButton = new JButton();
        courseInfoButton = new JButton();
        helpLink = new SwingLink("help", "http://java.sun.com");
        logoutButton = new JButton();
        Font welcomeFont;
        String welcomeText;
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        welcomeText = getWelcomeText();
        
        // <editor-fold defaultstate="collapsed" desc="gridBag placement">
        //Row One
        usernameLabel.setText(welcomeText);
        welcomeFont = usernameLabel.getFont();
            Map attributes = welcomeFont.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            attributes.put(TextAttribute.SIZE, 14);
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        usernameLabel.setFont(welcomeFont.deriveFont(attributes));
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(20,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(usernameLabel, gbc);
        
        //Rows 2-4
        schedule.getAccessibleContext().setAccessibleName("Course Schedule");
            gbc = new GridBagConstraints();
            gbc.gridheight = 3;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.BOTH;
        this.add(schedule, gbc);
        
        //Row 5 - empty label
        JLabel hiddenLabel1 = new JLabel();
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.fill = gbc.BOTH;
        this.add(hiddenLabel1, gbc);
        
        //Row 6
        printScheduleButton.setText("Print Schedule");
        printScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                printScheduleActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,10,10,5); //top, left, bottom, right
            gbc.anchor = gbc.LINE_END;
        this.add(printScheduleButton, gbc);
        
        hiddenButton1.setText("");
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 2;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,10,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        hiddenButton1.setVisible(false);
        this.add(hiddenButton1, gbc);
        
        
        modifyCourseButton.setText("Modify Course");
        modifyCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                modifyCourseActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 4;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,10,10); //top, left, bottom, right
            gbc.anchor = gbc.LINE_START;
        this.add(modifyCourseButton, gbc);
        
        
        //Row 7
        courseInfoButton.setText("Course Info");
        courseInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                courseInfoButtonActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,10,20,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER; 
        this.add(courseInfoButton, gbc);
        
        
        //Help Link postioning
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 2;
            gbc.gridy = 6;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,20,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        //helpLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(helpLink, gbc);
        
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 4;
            gbc.gridy = 6;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,20,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER; 
        this.add(logoutButton, gbc);
        //</editor-fold>
        
        setBorder(BorderFactory.createTitledBorder(new MatteBorder(null), "", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", 1, 14), new Color(255, 255, 255))); // NOI18N
        getAccessibleContext().setAccessibleName("Instructor Panel");
        
        setOpaque(false);
        this.revalidate();
        this.repaint();
    } 
    
    /**
     * Retrieves the username stored in the MainWindow object
     * @return The username provided in login
     */
    private String getUsername() {
        String u;
        PanelTester testWindow = null;
        MainWindow topWindow = null;
        
        if (SwingUtilities.getWindowAncestor(this).getClass().equals(MainWindow.class)) {
            
            topWindow = (MainWindow)((JFrame)SwingUtilities.getWindowAncestor(this));
            System.out.println("Log: Parent window = " + topWindow.getName());
            System.out.println("Log: Instructor username = " + topWindow.getUsername());
            u = topWindow.getUsername();
        } else if (SwingUtilities.getWindowAncestor(this).getClass().equals(PanelTester.class)) {
            
            testWindow = (PanelTester)((JFrame)SwingUtilities.getWindowAncestor(this));
            System.out.println("Log: Parent window = " + testWindow.getName());
            System.out.println("Log: Instructor username = " + testWindow.getUsername());
            u = testWindow.getUsername();
        } else {
            u = "";
        }
        
        return u;
    }
    
    /**
     * creates the welcome/title text
     * @return title text with username
     */
    private String getWelcomeText() {
        return "Welcome " + getUsername();
    }
    
    
    /***********************************************************************
     * ACTION LISTENERS SECTION
     **********************************************************************/

    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void printScheduleActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void modifyCourseActionPerformed(ActionEvent evt) {
        System.out.println("Log: Parent name: " + InstructorPanel.class.getName());
        
        Container c = this.getParent();
        System.out.println("Log: Inst Welcome parent name: " + c.getName());
        CardLayout cl = (CardLayout) SwingUtilities.getAncestorNamed("cards", this).getLayout();
        cl.show(((InstructorPanel)SwingUtilities.getAncestorNamed("GUIPackage.InstructorPanel", this)).getCards(), InstructorPanel.MODIFY);
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void courseInfoButtonActionPerformed(ActionEvent evt) {
        System.out.println("Log: Parent name: " + InstructorPanel.class.getName());
        
        Container c = this.getParent();
        System.out.println("Log: Inst Modify parent name: " + c.getName());
        CardLayout cl = (CardLayout) SwingUtilities.getAncestorNamed("cards", this).getLayout();
        cl.show(((InstructorPanel)SwingUtilities.getAncestorNamed("GUIPackage.InstructorPanel", this)).getCards(), InstructorPanel.INFO);
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void logoutButtonActionPerformed(ActionEvent evt) {
        
    }                

    protected void addData(Object[] o) {
        schedule.addData(o);
    }
}
