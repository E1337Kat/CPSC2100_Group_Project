/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.io.IOException;

/**
 *
 * @author EllieKat
 */
public class AdminPanel extends JPanelwithBackground {

    /**
     * Creates new form AdminPanel
     * @throws IOException
     */
    public AdminPanel() throws IOException{
        initComponents();
    }

    
    @SuppressWarnings("unchecked")                        
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }                       


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
