/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Ellie Peterson
 */
public class InstructorPanel_ModifyCourse extends JPanel {

    // Variables declaration 
    private JLabel titleLabel;
    
    private JPanel contentPanel;
        private JLabel courseTitleLabel;
            private JLabel courseTitle;
        private JLabel courseCRNLabel;
            private JLabel courseCRN;
        private JLabel courseDescLabel;
        private JTextArea courseDescArea;
    
    private JButton hiddenButton1;
    private JButton cancelButton;
    private JButton saveButton;
    private JButton hiddenButton2;
    private SwingLink helpLink;
    private JButton backButton;
    // End of variables declaration   
    
    /***********************************************************************
     * Public functions
     * <editor-fold defaultstate="expanded" desc="Public">
     **********************************************************************/
    
    /**
     * Creates new form InsructorPanel_ModifyCourse
     */
    public InstructorPanel_ModifyCourse() {
        
    }

    /**
     * initilizes components
     */
    public void initMe() {
        initComponents();
    }
    
    //</editor-fold>
    /***********************************************************************
     * Private functions
     * <editor-fold defaultstate="expanded" desc="Private">
     **********************************************************************/
    
    /**
     * init components
     */
    private void initComponents() {
        this.removeAll();
        
        titleLabel = new JLabel();
        contentPanel = new JPanel();
            courseTitleLabel = new JLabel();
                courseTitle = new JLabel();
            courseCRNLabel = new JLabel();
                courseCRN = new JLabel();
            courseDescLabel = new JLabel();
                courseDescArea = new JTextArea(100,200);
        hiddenButton1 = new JButton();
        cancelButton = new JButton();
        saveButton = new JButton();
        hiddenButton2 = new JButton();
        helpLink = new SwingLink("help", "http://java.sun.com");
        backButton = new JButton();
        
        
        Font titleFont;
        String titleText;
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc;
        
        //Set Layout
        this.setLayout(gridBag);
        
        titleText = getTitleText();

        // <editor-fold defaultstate="collapsed" desc="gridBag placement">
        //Row One
        titleLabel.setText(titleText);
        titleFont = titleLabel.getFont();
            Map attributes = titleFont.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            attributes.put(TextAttribute.SIZE, 14);
            attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        titleLabel.setFont(titleFont.deriveFont(attributes));
            gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = gbc.REMAINDER;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(20,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(titleLabel, gbc);
        
        //Row Two - Six
        contentPanel.getAccessibleContext().setAccessibleName("Content");
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
            
                courseDescArea.setText(getDescText());
                courseDescArea.setLineWrap(true);
                JScrollPane scrollPane = new JScrollPane(courseDescArea);
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
                scrollPane.setPreferredSize(new Dimension(100, 100));
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                contentPanel.add(scrollPane, gbc);
            
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
            
            //GridBag of content Panel for main panel   
            gbc = new GridBagConstraints();
            gbc.gridheight = 5;
            gbc.gridwidth = gbc.REMAINDER;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10,10,10,10); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.BOTH;
        this.add(contentPanel, gbc);
        contentPanel.setOpaque(false);
        
        //Row 7
        //common gridbagconstraints 
        gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            gbc.gridy = 6;
            gbc.weightx = 0.3;
            gbc.anchor = gbc.CENTER;
            gbc.fill = gbc.HORIZONTAL;
        
        
        //Row 8
        //common gridbagconstraints
        gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridy = 7;
            gbc.weightx = 0.5;
        
        saveButton.setText("Save Changes");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
            gbc.gridx = 0;
            gbc.insets = new Insets(10,10,10,2); //top, left, bottom, right
            gbc.anchor = gbc.LINE_END;
        this.add(saveButton, gbc);
        
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
            gbc.gridx = 2;
            gbc.insets = new Insets(10,2,10,2); //top, left, bottom, right
            gbc.anchor = gbc.CENTER;
        this.add(cancelButton, gbc);
        
        hiddenButton1.setText("");
        hiddenButton1.setVisible(false);
            gbc.gridx = 4;
            gbc.insets = new Insets(10,2,10,10); //top, left, bottom, right
            gbc.anchor = gbc.LINE_START;
        this.add(hiddenButton1, gbc);
        
        
        //Row 9
        //common gridbagconstraints
        gbc = new GridBagConstraints();
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridy = 8;
            gbc.weightx = 0.5;
            gbc.anchor = gbc.CENTER;
        
        hiddenButton2.setText("");
            gbc.gridx = 0;
            gbc.insets = new Insets(10,10,20,2); //top, left, bottom, right
        hiddenButton2.setVisible(false);
        this.add(hiddenButton2, gbc);
        
        //HelpLink stuff
            gbc.gridx = 2;
            gbc.insets = new Insets(10,2,20,2); //top, left, bottom, right
        this.add(helpLink, gbc);
        
        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
            gbc.gridx = 4;
            gbc.insets = new Insets(10,2,20,10); //top, left, bottom, right
        this.add(backButton, gbc);
        //</editor-fold>
        
        setBorder(BorderFactory.createTitledBorder(new MatteBorder(null), "", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", 1, 14), new Color(255, 255, 255))); // NOI18N
        getAccessibleContext().setAccessibleName("Student Panel Welcome");
        
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
     * Gets text to display to user
     * @return string containing title
     */
    private String getTitleText() {
        
        return "Get new classes " + getUsername();
    }

    /**
     * gets course title from db
     * @return string of course title
     */
    private String getCourseTitleText() {
        return "boobs";
    }

    /**
     * gets course CRN from db
     * @return string of course CRN
     */
    private String getCourseCRNText() {
        return "boobs";
    }

    /**
     * gets current course description
     * @return string of course description
     */
    private String getDescText() {
        return "boobs";
    }
    
    /***********************************************************************
     * ACTION LISTENERS SECTION
     **********************************************************************/
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void saveActionPerformed(ActionEvent evt) {
        
    }
    
    /**
     * Action event for button press
     * @param evt idk lol
     */
    private void cancelActionPerformed(ActionEvent evt) {
        System.out.println("Log: Parent name: " + InstructorPanel.class.getName());
        
        Container c = this.getParent();
        System.out.println("Log: Inst Modify parent name: " + c.getName());
        CardLayout cl = (CardLayout) SwingUtilities.getAncestorNamed("cards", this).getLayout();
        cl.show(((InstructorPanel)SwingUtilities.getAncestorNamed("GUIPackage.InstructorPanel", this)).getCards(), InstructorPanel.WELCOME);
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
    
    //</editor-fold>
}
