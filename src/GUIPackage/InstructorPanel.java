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
 * @author EllieKat
 */
public class InstructorPanel extends JPanelwithBackground {

    /**
     * Creates new form InstructorPanel
     * @throws IOException
     */
    public InstructorPanel() throws IOException{
    }

    public void initMe() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        instructorWelcome = new javax.swing.JPanel();
        modifyCourse = new javax.swing.JPanel();

        setLayout(null);

        instructorWelcome.setOpaque(false);

        javax.swing.GroupLayout instructorWelcomeLayout = new javax.swing.GroupLayout(instructorWelcome);
        instructorWelcome.setLayout(instructorWelcomeLayout);
        instructorWelcomeLayout.setHorizontalGroup(
            instructorWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        instructorWelcomeLayout.setVerticalGroup(
            instructorWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(instructorWelcome);
        instructorWelcome.setBounds(0, 0, 0, 0);

        modifyCourse.setOpaque(false);

        javax.swing.GroupLayout modifyCourseLayout = new javax.swing.GroupLayout(modifyCourse);
        modifyCourse.setLayout(modifyCourseLayout);
        modifyCourseLayout.setHorizontalGroup(
            modifyCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        modifyCourseLayout.setVerticalGroup(
            modifyCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(modifyCourse);
        modifyCourse.setBounds(0, 0, 0, 0);
    }                       


    // Variables declaration - do not modify                     
    private javax.swing.JPanel instructorWelcome;
    private javax.swing.JPanel modifyCourse;
    // End of variables declaration                   
}
