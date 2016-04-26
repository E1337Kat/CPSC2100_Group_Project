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
public class StudentPanel_Info extends JPanel {

    // Variables declaration 
    private static StudentPanel_Info stu = null;
    
    private JLabel usernameLabel;
    private JPanel contentPanel;
        private JLabel courseTitleLabel;
            private JLabel courseTitle;
        private JLabel courseCRNLabel;
            private JLabel courseCRN;
        private JLabel courseDescLabel;
            private JLabel courseDesc;
        
    private JButton okButton;
    private JButton hiddenButton2;
    private JButton hiddenButton3;
    private JButton hiddenButton4;
    private SwingLink helpLink;
    private JButton backButton;
    // End of variables declaration
    
    /**
     * Creates new form StudentPanel_Welcome
     */
    private StudentPanel_Info() {
    }
    
    public static StudentPanel_Info getStudentInfoInstance(){
        if (stu == null) {
            stu = new StudentPanel_Info();
        }
        return stu;
    }
    
    /**
     * Public method to initialize components
     * calls initComponents
     */
    public void initMe() {
        initComponents();
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
     * Initializes and adds components to the panel.
     */
    private void initComponents() {
        this.removeAll();
        
        usernameLabel = new JLabel();
        contentPanel = new JPanel();
            courseTitleLabel = new JLabel();
                courseTitle = new JLabel();
            courseCRNLabel = new JLabel();
                courseCRN = new JLabel();
            courseDescLabel = new JLabel();
                courseDesc = new JLabel();
        okButton = new JButton();
        hiddenButton2 = new JButton();
        hiddenButton3 = new JButton();
        hiddenButton4 = new JButton();
        helpLink = new SwingLink("help", "http://java.sun.com");
        backButton = new JButton();
        Font welcomeFont;
        String welcomeText;
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        welcomeText = getWelcomeText();
        
        //<editor-fold defaultstate="collapsed" desc="gridBag">
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
        //contentPanel.getAccessibleContext().setAccessibleName("Course Schedule");
            contentPanel.setLayout(new GridBagLayout());
            
            courseTitleLabel.setText("Course Title: ");
                //gridbag
                gbc = new GridBagConstraints();
                gbc.gridheight = 1;
                gbc.gridwidth = 1;
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weighty = 0.4;
                gbc.weightx = 0.3;
                gbc.anchor = gbc.LINE_END;
            contentPanel.add(courseTitleLabel, gbc);
            
                courseTitle.setText(getCourseTitleText());
                    gbc = new GridBagConstraints();
                    gbc.gridheight = 1;
                    gbc.gridwidth = gbc.REMAINDER;
                    gbc.gridx = 1;
                    gbc.gridy = 0;
                    gbc.weighty = 0.4;
                    gbc.weightx = 0.5;
                    gbc.anchor = gbc.LINE_START;
                contentPanel.add(courseTitle, gbc);
                
            courseCRNLabel.setText("CRN: ");
                gbc = new GridBagConstraints();
                gbc.gridheight = 1;
                gbc.gridwidth = 1;
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.weighty = 0.4;
                gbc.weightx = 0.3;
                gbc.anchor = gbc.LINE_END;
            contentPanel.add(courseCRNLabel, gbc);
            
                courseCRN.setText(getCourseCRNText());
                    gbc = new GridBagConstraints();
                    gbc.gridheight = 1;
                    gbc.gridwidth = gbc.REMAINDER;
                    gbc.gridx = 1;
                    gbc.gridy = 1;
                    gbc.weighty = 0.4;
                    gbc.weightx = 0.5;
                    gbc.anchor = gbc.LINE_START;
                contentPanel.add(courseCRN, gbc);
                
            courseDescLabel.setText("Course Description: ");
                gbc = new GridBagConstraints();
                gbc.gridheight = 1;
                gbc.gridwidth = 1;
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.weighty = 0.4;
                gbc.weightx = 0.3;
                gbc.anchor = gbc.LINE_END;
            contentPanel.add(courseDescLabel, gbc);
            
                courseDesc.setText(getDescText());
                    gbc = new GridBagConstraints();
                    gbc.gridheight = 3;
                    gbc.gridwidth = 4;
                    gbc.gridx = 1;
                    gbc.gridy = 2;
                    gbc.weighty = 0.6;
                    gbc.weightx = 0.6;
                    gbc.fill = gbc.BOTH;
                    gbc.anchor = gbc.LINE_START;
                    gbc.insets = new Insets(0,0,0,10);
                
                contentPanel.add(courseDesc, gbc);
            
            JLabel hiddenLabel1 = new JLabel();
                gbc = new GridBagConstraints();
                gbc.gridheight = 2;
                gbc.gridwidth = 1;
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.weighty = 0.4;
                gbc.weightx = 0.3;
                gbc.anchor = gbc.CENTER;
                gbc.fill = gbc.BOTH;
            contentPanel.add(hiddenLabel1, gbc);
        
        
            gbc = new GridBagConstraints();
            gbc.gridheight = 3;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.BOTH;
        this.add(contentPanel, gbc);
        
        //Row 5 - empty label
        JLabel hiddenLabel2 = new JLabel();
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 6;
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.fill = gbc.BOTH;
        this.add(hiddenLabel2, gbc);
        
        //Row 6
        okButton.setText("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                okActionPerformed(evt);
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
        this.add(okButton, gbc);
        
        hiddenButton2.setText("");
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 2;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,10,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(hiddenButton2, gbc);
        
        
        hiddenButton3.setText("");
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 4;
            gbc.gridy = 5;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,5,10,10); //top, left, bottom, right
            gbc.anchor = gbc.LINE_START;
        this.add(hiddenButton3, gbc);
        
        
        //Row 7
        hiddenButton4.setText("");
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 0.5;
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.ipadx = 5;
            gbc.insets = new Insets(10,10,20,5); //top, left, bottom, right
            gbc.anchor = gbc.CENTER; 
        this.add(hiddenButton4, gbc);
        
        
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
        //getAccessibleContext().setAccessibleName("Student Panel Welcome");
        
        setOpaque(false);
        this.revalidate();
        this.repaint();
    }      
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void okActionPerformed(ActionEvent evt) {
        System.out.println("Log: Parent name: " + StudentPanel.class.getName());
        
        Container c = this.getParent();
        System.out.println("Log: Stu Welcome parent name: " + c.getName());
        CardLayout cl = (CardLayout) SwingUtilities.getAncestorNamed("cards", this).getLayout();
        cl.show(((StudentPanel)SwingUtilities.getAncestorNamed("GUIPackage.StudentPanel", this)).getCards(), StudentPanel.REGISTER);
        
        
    }

    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void backActionPerformed(ActionEvent evt) {
        System.out.println("Log: Parent name: " + StudentPanel.class.getName());
        
        Container c = this.getParent();
        System.out.println("Log: Stu Welcome parent name: " + c.getName());
        CardLayout cl = (CardLayout) SwingUtilities.getAncestorNamed("cards", this).getLayout();
        cl.show(((StudentPanel)SwingUtilities.getAncestorNamed("GUIPackage.StudentPanel", this)).getCards(), StudentPanel.WELCOME);
        
    }

    /**
     * creates the welcome/title text
     * @return title text with username
     */
    private String getWelcomeText() {
        return "Welcome " + getUsername();
    }

    private String getCourseTitleText() {
        return "CPSC 2100";
    }

    private String getCourseCRNText() {
        return "12345";
    }

    private String getDescText() {
        return "A class about boobs.";
    }
                     
}
