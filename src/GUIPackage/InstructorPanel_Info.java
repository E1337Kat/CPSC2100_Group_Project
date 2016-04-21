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
public class InstructorPanel_Info extends JPanel {

    // Variables declaration 
    private JLabel usernameLabel;
    private CheckBoxTable classList;
    private JButton emailAllButton;
    private JButton emailStudentButton;
    private JButton printRollButton;
    private JButton hiddenButton1;
    private SwingLink helpLink;
    private JButton backButton;
    // End of variables declaration
    
    /***********************************************************************
     * Public functions
     **********************************************************************/
    
    
    /**
     * Creates new form StudentPanel_Welcome
     */
    public InstructorPanel_Info() {
    }
    
    /**
     * Public method to initialize components
     * calls initComponents
     */
    public void initMe() {
        initComponents();
    }
    
    public void addData(Object[] objs) {
        classList.addData(objs);
    }
    
    /***********************************************************************
     * Private functions
     **********************************************************************/
    
    /**
     * Initializes and adds components to the panel.
     */
    private void initComponents() {
        
        usernameLabel = new JLabel();
        emailAllButton = new JButton();
        emailStudentButton = new JButton();
        printRollButton = new JButton();
        hiddenButton1 = new JButton();
        helpLink = new SwingLink("help", "http://java.sun.com");
        backButton = new JButton();
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
        String[] cols = {"Last", "First", "ID", "Email"};
        classList = new CheckBoxTable(cols, cols.length);
        classList.getAccessibleContext().setAccessibleName("Class List");
            gbc = new GridBagConstraints();
            gbc.gridheight = 3;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.BOTH;
        this.add(classList, gbc);
        classList.setOpaque(false);
        
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
        emailAllButton.setText("Email All");
        emailAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                emailAllActionPerformed(evt);
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
        this.add(emailAllButton, gbc);
        
        emailStudentButton.setText("Email Student(s)");
        emailStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                emailStudentActionPerformed(evt);
            }
        });
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 2;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,10,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(emailStudentButton, gbc);
        
        
        printRollButton.setText("Print Roll");
        printRollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                printRollActionPerformed(evt);
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
        this.add(printRollButton, gbc);
        
        
        //Row 7
        hiddenButton1.setText("");
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,10,20,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER; 
        hiddenButton1.setVisible(false);
        this.add(hiddenButton1, gbc);
        
        
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
        
        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                backActionPerformed(evt);
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
        this.add(backButton, gbc);
        //</editor-fold>
        
        setBorder(BorderFactory.createTitledBorder(new MatteBorder(null), "", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", 1, 14), new Color(255, 255, 255))); // NOI18N
        getAccessibleContext().setAccessibleName("Instructor Panel Info");
        
        setOpaque(false);
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
            System.out.println("Log: Student username = " + topWindow.getUsername());
            u = topWindow.getUsername();
        } else if (SwingUtilities.getWindowAncestor(this).getClass().equals(PanelTester.class)) {
            
            testWindow = (PanelTester)((JFrame)SwingUtilities.getWindowAncestor(this));
            System.out.println("Log: Parent window = " + testWindow.getName());
            System.out.println("Log: Student username = " + testWindow.getUsername());
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
    private void emailAllActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void printRollActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void emailStudentActionPerformed(ActionEvent evt) {
        //TODO: confirmation dialog, if yes, delete, else do nothing
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void backActionPerformed(ActionEvent evt) {
        System.out.println("Log: Parent name: " + InstructorPanel.class.getName());
        
        Container c = this.getParent();
        System.out.println("Log: Inst Modify parent name: " + c.getName());
        CardLayout cl = (CardLayout) SwingUtilities.getAncestorNamed("cards", this).getLayout();
        cl.show(((InstructorPanel)SwingUtilities.getAncestorNamed("GUIPackage.InstructorPanel", this)).getCards(), InstructorPanel.WELCOME);
    }                
}
