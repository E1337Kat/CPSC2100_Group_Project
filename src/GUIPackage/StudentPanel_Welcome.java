/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.io.IOException;

/**
 *
 * @author EMCS306
 */
public class StudentPanel_Welcome extends JPanelwithBackground {

    /**
     * Creates new form StudentPanel_Welcome
     */
    public StudentPanel_Welcome() throws IOException {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Welcome Student ####", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        setLayout(null);
        getAccessibleContext().setAccessibleName("");
    }                


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
