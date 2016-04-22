/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.lang.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Jacob Motley
 */
public class AdminWelcomePanel extends JPanel{
    
// Variables declaration
	private JButton studentsGoTo;
	private JButton instructorsGoTo;
	private JButton coursesGoTo;
    
	private JLabel studentsDesc;
	private JLabel instructorDesc;
	private JLabel coursesDesc;
	//desc = description
	
    //End of variables declaration 
    
    /**
     * Creates new AdminWelcomePanel
     */
    public AdminWelcomePanel() {
	initComponents();
    }
    /**
     * initializes components
     */
	private void initComponents(){
        java.awt.GridBagConstraints gridBagConstraints;

        studentsGoTo = new JButton();
        instructorsGoTo = new JButton();
        coursesGoTo = new JButton();
        studentsDesc = new JLabel();
        instructorDesc = new JLabel();
        coursesDesc = new JLabel();

        setLayout(new java.awt.GridBagLayout());

        studentsGoTo.setText("Students");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 80, 0, 0);

        instructorsGoTo.setText("Instructors");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 80, 0, 0);

        coursesGoTo.setText("Courses");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 80, 77, 0);

        coursesDesc.setText("Add/Drop Courses");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 40, 0, 70);

        studentsDesc.setText("Add/Drop Students");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 40, 0, 70);

        instructorDesc.setText("Add/Drop Instructors");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 40, 0, 70);
        
        
    }
}
