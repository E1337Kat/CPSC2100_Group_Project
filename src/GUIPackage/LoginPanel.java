/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;


/**
 *
 * @author EMCS306
 */
public class LoginPanel extends javax.swing.JPanel 
        implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer Login 
     */
    public LoginPanel() {
        /*try {
            //create the font to use. Specify the size!
            Font arialicFont = Font.createFont(Font.TRUETYPE_FONT, 
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
        }*/
        initComponents();
    }
    
    @Override
    public void setObject(Object bean) {
        this.bean = bean;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        Font arialicFont;
        try {
            //create the font to use. Specify the size!
            arialicFont = Font.createFont(Font.TRUETYPE_FONT,
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
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, arialicFont.deriveFont(20)));
    jPanel1.setFont(arialicFont);
    jPanel1.setLayout(new java.awt.GridBagLayout());

    jLabel1.setText("Username:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(90, 100, 0, 0);
    jPanel1.add(jLabel1, gridBagConstraints);

    jTextField1.setText("username");
    jTextField1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField1ActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.ipadx = 94;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(90, 3, 0, 0);
    jPanel1.add(jTextField1, gridBagConstraints);

    jLabel2.setText("Password:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(20, 100, 0, 0);
    jPanel1.add(jLabel2, gridBagConstraints);

    jPasswordField1.setText("jPasswordField1");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.ipadx = 105;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(20, 3, 0, 129);
    jPanel1.add(jPasswordField1, gridBagConstraints);

    jButton1.setText("Login");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(30, 100, 97, 0);
    jPanel1.add(jButton1, gridBagConstraints);

    jButton2.setText("Register");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(30, 23, 97, 0);
    jPanel1.add(jButton2, gridBagConstraints);

    add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}